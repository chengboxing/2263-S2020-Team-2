package isu.engine;

import isu.engine.manager.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GameEngine {

//    public static final GameEngine GAME_ENGINE = new GameEngine();

    public final static int MAX_PLAYERS = 2;
    public final static int TILES_PER_PLAYER = 6;
    public final static int MAX_STOCK_COUNT = 25;
    public final static int SAFE_CHAIN_SIZE = 11;
    public final static int MAX_CHAIN_SIZE = 41;



    private HotelChain[] hotelChains;
    private TilePile tilePile;
    private Bank bank;
    private List<Player> players;
    private Board board;

    private TurnManager turnManager;
    private PhaseManager phaseManager;
    private MergeManager mergeManager;
    private String name;
    private GameStartManager gameStartManager;
    private GameEndManager gameEndManager;
    private Tile lastPlayedTile;


    public GameEngine(){
        hotelChains = new HotelChain[]{
                new HotelChain("Tower", HotelChainCategory.CHEAP, "brown" ),
                new HotelChain("Luxor", HotelChainCategory.CHEAP, "purple"),
                new HotelChain("American", HotelChainCategory.AVERAGE, "red"),
                new HotelChain("WorldWide", HotelChainCategory.AVERAGE, "orange"),
                new HotelChain("Festival", HotelChainCategory.AVERAGE, "green"),
                new HotelChain("Imperial", HotelChainCategory.EXPENSIVE, "yellow"),
                new HotelChain("Continental", HotelChainCategory.EXPENSIVE, "blue")
        };
        tilePile = new TilePile();
        bank = new Bank(hotelChains, MAX_STOCK_COUNT);
        board = new Board();
        players = new ArrayList<>();

        gameStartManager = new GameStartManager(this);
        gameEndManager = new GameEndManager(this);
        phaseManager = new PhaseManager();
        mergeManager = new MergeManager();

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

    public TurnManager getTurnManager() { return turnManager;}

    public void setTurnManager(TurnManager t){
        this.turnManager = t;
    }

//    public GameStartManager getStartManager(){return gameStartManager;}

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

    public void initGame(){
        gameStartManager.start();
    }

    public Player getCurrentPlayer(){
        return turnManager.getCurrentPlayer();
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
    }

    public Tile getLastPlayedTile(){
        return lastPlayedTile;
    }

    public boolean isTileNextToChain(){return false;}

    public boolean isTileNextToTile(){
        return false;
    }

    public boolean isTileNextToTwoChains(){

        return false;
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

    public void createTileChain(HotelChain chain, Tile tile){

    }

    public void mergeTileChains(HotelChain chain){}

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

        return turnManager.nextTurn();
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
