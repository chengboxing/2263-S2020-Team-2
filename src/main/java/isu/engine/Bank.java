package isu.engine;

import com.sun.net.httpserver.Filter;

import javax.print.DocFlavor;
import java.util.*;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Handler;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Bank {

    private StockSet stocks;

    public Bank(){
        stocks = new StockSet();
    }

    public void payBonus(HotelChain chain, List<Player> players){

        List<Player> stockHolders = new ArrayList<Player>();

        for (int i = 0; i < players.size(); i++){
            if (players.get(i).getStocks(chain.getName()) != 0){
                stockHolders.add(players.get(i));
            }
        }

        if (stockHolders.size() == 1){
            //pay player both bonuses
            stockHolders.get(0).addMoney(chain.getFirstBonus() + chain.getSecondBonus());

        } else if (stockHolders.size() != 0) {
            int largest = 0;
            for (int i = 0; i < stockHolders.size(); i++){
                if (stockHolders.get(i).getStocks(chain.getName()) > largest){
                    largest = stockHolders.get(i).getStocks(chain.getName());
                }
            }

            List<Player> majorStockHolders = new ArrayList<Player>();
            for (int i = 0; i < stockHolders.size(); i++){
                if (stockHolders.get(i).getStocks(chain.getName()) == largest){
                    majorStockHolders.add(stockHolders.get(i));
                }
            }

            int secondLargest = 0;
            for (int i = 0; i < stockHolders.size(); i++){
                if (stockHolders.get(i).getStocks(chain.getName()) > secondLargest && stockHolders.get(i).getStocks(chain.getName()) < largest){
                    secondLargest = stockHolders.get(i).getStocks(chain.getName());
                }
            }

            List<Player> minorStockHolders = new ArrayList<Player>();
            for (int i = 0; i < stockHolders.size(); i++){
                if (stockHolders.get(i).getStocks(chain.getName()) == secondLargest){
                    minorStockHolders.add(stockHolders.get(i));
                }
            }

            for (int i = 0; i < majorStockHolders.size(); i++){
                majorStockHolders.get(i).addMoney(chain.getFirstBonus() / majorStockHolders.size());
            }



        }
    }

    public void sellStocks(HotelChain chain, Player player, int numStocks){

        player.removeStocks(chain.getName(), numStocks);
        stocks.addStocks(chain.getName(), numStocks);

        player.addMoney(PriceChart.getStockPrice(chain.getCategory(), chain.size()) * numStocks);

    }

    public void buyStock(HotelChain chain, Player player, int numStocks){

        player.addStocks(chain.getName(), numStocks);
        stocks.removeStocks(chain.getName(), numStocks);

        player.pullMoney(PriceChart.getStockPrice(chain.getCategory(), chain.size()) * numStocks);
    }
}