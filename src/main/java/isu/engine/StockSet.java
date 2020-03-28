package isu.engine;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StockSet {

    private Map<HotelChain, Integer> stocks;

    public StockSet(HotelChain[] chains, int stockCount){
        stocks = new HashMap<>();
        for(HotelChain chain : chains){
            stocks.put(chain, stockCount);
        }
    }

    public int addStocks(HotelChain chain, int numStocks){
        stocks.replace(chain, stocks.get(chain) + numStocks);
        return stocks.get(chain);
    }

    public int removeStocks(HotelChain chain, int numStocks){
        stocks.replace(chain, stocks.get(chain) - numStocks);
        return stocks.get(chain);
    }

    public int setStocks(HotelChain chain, int numStocks){
        stocks.replace(chain, numStocks);
        return numStocks;
    }

    public int getStocks(HotelChain chain){
        return stocks.get(chain);
    }
}
