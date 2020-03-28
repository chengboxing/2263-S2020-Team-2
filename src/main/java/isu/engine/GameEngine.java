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
        tilePile = new TilePile();
        priceChart = new PriceChart();
        stocks = new StockSet();
        //not done yet


    }

    public static Bank getBank() {
        return bank;
    }

    public static List<Player> getPlayers() {
        return players;
    }

    public Board getBoard() {
        return board;
    }

    public HotelChain[] getChains() {
        return chains;
    }

    public TilePile getTilePile() {
        return tilePile;
    }

    public PriceChart getPriceChart() {
        return priceChart;
    }

    public StockSet getStocks() {
        return stocks;
    }

    public void startNewChain(){}
}
