package isu.engine;

import java.util.*;

/**
 *
 *
 * **/
public class Player {

    private String name;
    private int money;
    private List<Tile> tiles;
    private StockSet stocks;

    public Player(String name) {
        this.name = name;
        tiles = new ArrayList<>();
        stocks = new StockSet(GameEngine.GAME_ENGINE.getHotelChains(), 0);
    }

    public void setName(String name){
        this.name = name;
    }


    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public void addMoney(int cash) {
        if (cash < 0) {
            throw new IllegalArgumentException("Cannot add negative amount of money.");
        }
        money += cash;
    }

    public void pullMoney(int cash) {
        if (cash > money) {
            throw new IllegalArgumentException("not enough funds");
        }
        money -= cash;
    }

    private int tileCount() {
        return tiles.size();
    }

    public List<Tile> getTiles() {
        return Collections.unmodifiableList(tiles);
    }

    private void setTiles(TilePile tilePile, int tileCount) {
        for (int i = 0; i < tileCount; i++) {
            tiles.add(tilePile.getRandomTile());
        }
    }

    public void addTile(TilePile tilePile) {
        tiles.add(tilePile.getRandomTile());
    }

    public Tile playTile(int tileIndex) {
        Tile tile = tiles.get(tileIndex);
        tiles.remove(tileIndex);
        return tile;
    }


    public int addStocks(HotelChain chain, int numStocks){
        return stocks.addStocks(chain, numStocks);
    }

    public int removeStocks(HotelChain chain, int numStocks){
        return stocks.removeStocks(chain, numStocks);
    }

    public int setStocks(HotelChain chain, int numStocks){
        return stocks.setStocks(chain, numStocks);
    }

    public int getStocks(HotelChain chain){
        return stocks.getStocks(chain);
    }
}

