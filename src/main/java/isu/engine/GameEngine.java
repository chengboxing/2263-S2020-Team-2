package isu.engine;

import isu.engine.manager.TurnManager;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GameEngine {

    public static final GameEngine GAME_ENGINE = new GameEngine();

    public final static int MAX_PLAYERS = 2;
    public final static int TILES_PER_PLAYER = 6;
    public final static int MAX_STOCK_COUNT = 25;



    private HotelChain[] hotelChains;
    private TilePile tilePile;
    private Bank bank;
    private List<Player> players;
    private Board board;

    private TurnManager turnManager;




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

        turnManager = new TurnManager(players);


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

    /***************************************************************************************/

    public void addPlayer(String name){
        players.add(new Player(name));
    }


    public void updateGameName(String gameName){

    }

//    public void updatePlayer(int index, String name){
//        players.get(index).setName(name);
//    }


    /*
     *
     * This method will initiate the game and it will do three things:
     * 1. pick a new tile for each player
     * 2. place tile on the board
     * 3. identify who goes first based on distance from 1A
     *
     */
    public void initGame(){}

    public Player getCurrentPlayer(){
        return turnManager.getCurrentPlayer();
    }


    /**
     *
     * This method allows the current player to play one of their tiles.
     *
     */
    public void playTile(){}



    public Tile getLastPlayedTile(){return null;}

    public boolean isTileNextToChain(){return false;}

    public boolean isTileNextToTile(){return false;}

    public boolean isTileNextToTwoChains(){return false;}

    public List<HotelChain> getChainsNextToTile(){return null;}

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
