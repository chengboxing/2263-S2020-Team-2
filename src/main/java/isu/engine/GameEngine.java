package isu.engine;

import java.util.List;

public class GameEngine {

    final static int MAX_PLAYERS = 2;

    private static Bank bank;
    private static List<Player> players;
    private Board board;
    private HotelChain[] chains;
    private TilePile tilePile;
    private PriceChart priceChart;
    private StockSet stocks;

    public GameEngine(){
        bank = new Bank();
        board = new Board();
        chains = HotelChain.getHotelChains();
        //not done yet


    }

    public static Bank getBank() {
        return bank;
    }

    public static List<Player> getPlayers() {
        return players;
    }
}
