package isu.engine;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StockSet {

    private Map<HotelChain, Integer> stocks;

    public StockSet() {
        stocks = new HashMap<>();
    }

    public StockSet(HotelChain[] chains, int stockCount){
        stocks = new HashMap<>();
        for(HotelChain chain : chains){
            stocks.put(chain, stockCount);
        }
    }

    public int addStocks(HotelChain chain, int numStocks){
        int newStocks = getStocks(chain) + numStocks;
        if(newStocks < 0|| newStocks > GameEngine.MAX_STOCK_COUNT){
            throw new IllegalArgumentException("number of stocks too low/high");
        }
        stocks.put(chain, newStocks);
        return newStocks;
    }

    public int removeStocks(HotelChain chain, int numStocks){
        int newStocks = getStocks(chain) - numStocks;
        if(newStocks < 0|| newStocks > GameEngine.MAX_STOCK_COUNT){
            throw new IllegalArgumentException("number of stocks too low/high");
        }
        stocks.put(chain, newStocks);
        return newStocks;
    }

    public int setStocks(HotelChain chain, int numStocks){
        if(numStocks < 0|| numStocks > GameEngine.MAX_STOCK_COUNT){
            throw new IllegalArgumentException("number of stocks too low/high");
        }
        stocks.put(chain, numStocks);
        return numStocks;
    }

    public int getStocks(HotelChain chain){

        return stocks.getOrDefault(chain, 0);
    }
}
