package isu.engine;

import java.util.ArrayList;
import java.util.List;

public class HotelChain {

    //american-red, continental-blue, festival-green, imperial-yellow, luxor-purple, tower-brown, worldwide-orange

    private static HotelChain[] hotelChains = new HotelChain[]{
            new HotelChain("Tower", HotelChainCategory.CHEAP, "brown" ),
            new HotelChain("Luxor", HotelChainCategory.CHEAP, "purple"),
            new HotelChain("American", HotelChainCategory.AVERAGE, "red"),
            new HotelChain("WorldWide", HotelChainCategory.AVERAGE, "orange"),
            new HotelChain("Festival", HotelChainCategory.AVERAGE, "green"),
            new HotelChain("Imperial", HotelChainCategory.EXPENSIVE, "yellow"),
            new HotelChain("Continental", HotelChainCategory.EXPENSIVE, "blue")
    };

    public static HotelChain[] getHotelChains() {
        return hotelChains;
    }

    private String name;
    private HotelChainCategory category;
    private String color;
    private List<Tile> tiles;



    private HotelChain(String name, HotelChainCategory category, String color) {
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

    public void addTile(Tile tile){
        tile.setChain(this);
        tiles.add(tile);
    }

    public void addTiles(List<Tile> tiles){
        for(Tile tile: tiles){
            addTile(tile);
        }
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
}
