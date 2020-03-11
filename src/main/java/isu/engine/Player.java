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
    private HashMap<String, Integer> stocks;

    public Player(String name) {
        this.name = name;
        tiles = new ArrayList<>();
        stocks = new HashMap<>();
        for (int i = 0; i < 7; i++) {
            stocks.put(HotelChain.getHotelChains()[i].getName(), 0);
        }
    }


    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public void addMoney(int cash) {
        if(cash <= 0) {
            throw new IllegalArgumentException("Cannot add 0 or negative amount of money.");
        }
        money += cash;
    }

    public void pullMoney(int cash)  {
        money -= cash;
    }

    private int tileListSize(){
        return tiles.size();
    }

    public List<Tile> getTiles(){
        int index = tileListSize();
        return tiles;
    }

    public void setTiles(int tileCount, TilePile tilePile) {
        for (int i = 0; i < tileCount; i++) {
            tiles.add(tilePile.getRandomTile());
        }
    }

    public void addTile(TilePile tilePile){
        tiles.add(tilePile.getRandomTile());
    }

    public Tile playTile(int tileIndex) {
       Tile tile = tiles.get(tileIndex);
       tiles.remove(tileIndex);
       return tile;
    }

    public int addStocks(String chainName, int numStocks){
        stocks.replace(chainName, stocks.get(chainName) + numStocks);
        return stocks.get(chainName);
    }

    public int removeStocks(String chainName, int numStocks){
        stocks.replace(chainName, stocks.get(chainName) - numStocks);
        return stocks.get(chainName);
    }

    public int setStocks(String chainName, int numStocks){
        stocks.replace(chainName, numStocks);
        return numStocks;
    }

    public int getStocks(String chainName){
        return stocks.get(chainName);
    }
}