package isu.engine;

import java.util.HashMap;
import java.util.List;

public class StockSet {

    private HashMap<String, Integer> stocks;

    public StockSet(){
        stocks = new HashMap<>();
        for (int i = 0; i < 7; i++) {
            stocks.put(HotelChain.getHotelChains()[i].getName(), 25);
        }
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
