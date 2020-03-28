package isu.engine;

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
    private StockSet stocks;



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
        bank = new Bank();
        board = new Board();
        stocks = new StockSet(hotelChains, MAX_STOCK_COUNT);
        players = new ArrayList<>();
        for(int i = 0; i < MAX_PLAYERS; i++){
            players.add(new Player(""));
        }


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
    

    public StockSet getStocks() {
        return stocks;
    }

    public void startNewChain(){}
}
