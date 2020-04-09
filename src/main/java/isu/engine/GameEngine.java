package isu.engine;

import isu.engine.manager.GameStartManager;
import isu.engine.manager.MergeManager;
import isu.engine.manager.PhaseManager;
import isu.engine.manager.TurnManager;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GameEngine {

    public static final GameEngine GAME_ENGINE = new GameEngine();

    public final static int MAX_PLAYERS = 2;
    public final static int TILES_PER_PLAYER = 6;
    public final static int MAX_STOCK_COUNT = 25;
    public final static int SAFE_CHAIN_SIZE = 11;



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
    private Tile lastPlayedTile;


    private GameEngine(){
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

    public GameStartManager getStartManager(){return gameStartManager;}

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


    public void initGame(){
        gameStartManager.start();
    }

    public Player getCurrentPlayer(){
        return turnManager.getCurrentPlayer();
    }

    public boolean canPlayTile(Player player, int tileIndex){
        return board.canPlayTile(player.getTile(tileIndex));
    }


    /**
     *
     * This method allows the current player to play one of their tiles.
     *
     */
    public void playTile(Player player, int tileIndex){
        lastPlayedTile = player.pullTile(tileIndex);
        board.placeTile(lastPlayedTile);
    }

    public Tile getLastPlayedTile(){return lastPlayedTile;}

    public boolean isTileNextToChain(){return false;}

    public boolean isTileNextToTile(){return false;}

    public boolean isTileNextToTwoChains(){return false;}

    public List<HotelChain> getChainsNextToTile(Tile tile){return board.getNeighboringChains(tile);}

    private void attachTileToChain(){}

    public List<HotelChain> getInactiveChains(){return null;}

    public List<HotelChain> getActiveChains(){return null;}

    public void createTileChain(HotelChain chain){}

    public void mergeTileChains(HotelChain chain){}

    public void sellStocks(Player player, HotelChain chain){}

    public void tradeStocks(Player player, HotelChain tradeChain, HotelChain receiveChain){}

    public void purchaseStocks(List<HotelChain> chains, List<Integer> stockCount){}

    public Player nextTurn(){
        return turnManager.nextTurn();
    }

    public boolean isGameOver(){return false;}

    public Player getWinner(){return null;}


}
