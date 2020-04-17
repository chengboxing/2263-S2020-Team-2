package isu.engine;

import java.util.ArrayList;
import java.util.List;

public class HotelChain {

    private String name;
    private HotelChainCategory category;
    private String color;
    private List<Tile> tiles;

    public HotelChain(String name, HotelChainCategory category, String color) {
        this.name = name;
        this.category = category;
        this.color = color;

        tiles = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public HotelChainCategory getCategory() {
        return category;
    }

    public String getColor() {
        return color;
    }

    public int size(){
        return tiles.size();
    }

    public Tile getTile(int index){
        return tiles.get(index);
    }

    public List<Tile> getTiles(){
        return tiles;
    }

    public boolean isChainSafe(){
        return size() >= GameEngine.SAFE_CHAIN_SIZE;
    }

    public void addTile(Tile tile){
        tile.setChain(this);
        tiles.add(tile);
    }

    public void addTiles(List<Tile> tiles){
        for(Tile tile: tiles){
            tile.setChain(this);
            addTile(tile);
        }
    }

    public void clearTiles(){
        tiles.clear();
    }

    public int getStockPrice(){
        return PriceChart.getStockPrice(category, size());
    }

    public int getFirstBonus(){
        return PriceChart.getFirstBonus(category, size());
    }

    public int getSecondBonus(){
        return PriceChart.getSecondBonus(category, size());
    }

    public boolean isActive(){
        return size() > 0;
    }

    public boolean isReachedMaxSize(){
        return size() >= GameEngine.MAX_CHAIN_SIZE;
    }
}
