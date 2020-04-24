package isu.engine;

import isu.engine.manager.*;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class GameEngine {

//    public static final GameEngine GAME_ENGINE = new GameEngine();

    public static final Color BROWN = new Color(153, 102, 0);
    public static final Color PURPLE = new Color(102, 0, 153);
    public final static int MAX_PLAYERS = 2;
    public final static int TILES_PER_PLAYER = 6;
    public final static int MAX_STOCK_COUNT = 25;
    public final static int SAFE_CHAIN_SIZE = 11;
    public final static int MAX_CHAIN_SIZE = 41;
    public final static int INITIAL_PLAYER_CASH = 6000;



    private HotelChain[] hotelChains;
    private TilePile tilePile;
    private Bank bank;
    private List<Player> players;
    private Board board;
    private int currentPlayerIndex;

//    private TurnManager turnManager;
    private PhaseManager phaseManager;
    private MergeManager mergeManager;
    private String name;
    private GameStartManager gameStartManager;
    private GameEndManager gameEndManager;
    private Tile lastPlayedTile;


    public GameEngine(){
        hotelChains = new HotelChain[]{
                new HotelChain("Tower", HotelChainCategory.CHEAP, BROWN ),
                new HotelChain("Luxor", HotelChainCategory.CHEAP, PURPLE),
                new HotelChain("American", HotelChainCategory.AVERAGE, Color.RED),
                new HotelChain("WorldWide", HotelChainCategory.AVERAGE, Color.ORANGE),
                new HotelChain("Festival", HotelChainCategory.AVERAGE, Color.GREEN),
                new HotelChain("Imperial", HotelChainCategory.EXPENSIVE, Color.YELLOW),
                new HotelChain("Continental", HotelChainCategory.EXPENSIVE, Color.BLUE)
        };
        tilePile = new TilePile();
        bank = new Bank(hotelChains, MAX_STOCK_COUNT);
        board = new Board();
        players = new ArrayList<>();

        gameStartManager = new GameStartManager(this);
        gameEndManager = new GameEndManager(this);
        phaseManager = new PhaseManager(this);
        mergeManager = new MergeManager(this);

    }

    public HotelChain[] getHotelChains() {
        return hotelChains;
    }

    public Bank getBank() {
        return bank;
    }

    public List<Player> getPlayers() {
        return Collections.unmodifiableList(players);
    }

    public Board getBoard() {
        return board;
    }

    public TilePile getTilePile() {
        return tilePile;
    }

    public MergeManager getMergeManager(){
        return mergeManager;
    }

    /***************************************************************************************/

    public void addPlayer(String name){
        players.add(new Player(name));
    }


    public void updateGameName(String name){
        this.name = name;
    }

    public String getGameName(){ return this.name; }

    private void initCurrentPlayerIndex(){
        Random random = new Random();
        currentPlayerIndex = random.nextInt(players.size());
    }

    public void initGame() {
        gameStartManager.start();
        initCurrentPlayerIndex();
    }

    public Player getCurrentPlayer(){
        return players.get(currentPlayerIndex);
    }

    public boolean canPlayTile(int tileIndex){
        Player player = getCurrentPlayer();
        return board.canPlayTile(player.getTile(tileIndex));
    }


    /**
     *
     * This method allows the current player to play one of their tiles.
     *
     */
    public void playTile(int tileIndex){
        Player player = getCurrentPlayer();
        lastPlayedTile = player.pullTile(tileIndex);
        board.placeTile(lastPlayedTile);
        player.addTile(tilePile);
    }

    public Tile getLastPlayedTile(){
        return lastPlayedTile;
    }

    public boolean isTileNextToChain(Tile tile){
        return board.getNeighboringChains(tile).size() > 0;
    }

    public boolean isTileNextToTile(Tile tile){
        return board.getNeighboringTiles(tile).size() > 0;

    }

    public boolean isTileNextToTwoChains(Tile tile){
        return board.getNeighboringChains(tile).size() >= 2;
    }

    public List<HotelChain> getChainsNextToTile(Tile tile) {
        return board.getNeighboringChains(tile);
    }

    private void attachTileToChain(HotelChain chain, Tile tile){
        chain.addTile(tile);
    }

    public List<HotelChain> getInactiveChains(){
        List<HotelChain> chains = new ArrayList<>();
        for(HotelChain chain: hotelChains){
            if(!chain.isActive()){
                chains.add(chain);
            }
        }
        return chains;
    }

    public List<HotelChain> getActiveChains(){
        List<HotelChain> chains = new ArrayList<>();
        for(HotelChain chain: hotelChains){
            if(chain.isActive()){
                chains.add(chain);
            }
        }
        return chains;
    }

    public boolean canCreateTileChain(HotelChain chain, Tile tile){
        if(chain.isActive()) return false;
        if(isTileNextToChain(tile)) return false;
        if(!isTileNextToTile(tile)) return false;
        return true;
    }

    public void createTileChain(HotelChain chain, Tile tile){
        bank.giveFreeStockToPlayer(getCurrentPlayer(), chain);
        board.createTileChain(chain, tile);
    }

    public void mergeTileChains(HotelChain chain, Tile tile){
        mergeManager.checkMerge(tile);
    }

    public void sellStocks(HotelChain chain, int stockCount){
        Player player = getCurrentPlayer();
        bank.buyStocksFromPlayer(player, chain, stockCount);
    }

    public void tradeStocks(HotelChain majorChain, HotelChain minorChain, int minorStockCount){
        Player player = getCurrentPlayer();
        bank.tradeStocksWithPlayer(player, majorChain, minorChain, minorStockCount);
    }

    public void purchaseStocks(List<HotelChain> chains, List<Integer> stockCounts){
        Player player = getCurrentPlayer();
        for(int i = 0; i < chains.size(); i++){
            HotelChain chain = chains.get(i);
            int count = stockCounts.get(i);
            bank.sellStocksToPlayer(player, chain, count);
        }
    }

    public Player nextTurn(){
        currentPlayerIndex = (currentPlayerIndex+1) % players.size();
        return getCurrentPlayer();
    }

    public void endGame(){

        gameEndManager.endGame();
    }

    public Player getWinner(){

        return gameEndManager.getWinner();
    }

    public boolean hasChainReachedMaxSize(){
        for(HotelChain chain: getHotelChains()){
            if(chain.isReachedMaxSize()){
                return true;
            }
        }
        return false;
    }

    public boolean isGameReadyToFinish(){
        return gameEndManager.isGameReadyToFinish();
    }


}
