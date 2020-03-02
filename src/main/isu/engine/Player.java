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
    private HashMap<String, List<Stock>> stocks;

    public Player(String name) {
        this.name = name;
        tiles = new ArrayList<>();
        stocks = new HashMap<>();
    }


    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public void addMoney(int cash) {
        money += cash;
    }

    public void pullMoney(int cash) {
        money -= cash;
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

    
}