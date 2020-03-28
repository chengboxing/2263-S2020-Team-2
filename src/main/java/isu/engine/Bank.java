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

    public Bank(HotelChain[] chains, int stockCount){
        stocks = new StockSet(chains, stockCount);
    }

    public void payBonus(HotelChain chain, List<Player> players){

        List<Player> stockHolders = new ArrayList<Player>();

        for(Player player: players){
            if(player.getStocks(chain) != 0){
                stockHolders.add(player);
            }
        }


        if (stockHolders.size() == 1){
            //pay player both bonuses
            stockHolders.get(0).addMoney(chain.getFirstBonus() + chain.getSecondBonus());

        } else if (stockHolders.size() != 0) {
            int largest = 0;

            for(Player player: stockHolders){
                largest = Math.max(player.getStocks(chain), largest);
            }


            List<Player> majorStockHolders = new ArrayList<Player>();
            for(Player player: stockHolders){
                if(player.getStocks(chain) == largest){
                    majorStockHolders.add(player);
                }
            }

            int secondLargest = 0;

            for(Player player: stockHolders){
                int stocks = player.getStocks(chain);
                if(stocks < largest){
                    secondLargest = Math.max(stocks, secondLargest);
                }
            }



            List<Player> minorStockHolders = new ArrayList<Player>();

            for(Player player: stockHolders){
                if(player.getStocks(chain) == secondLargest){
                    minorStockHolders.add(player);
                }

            }

            if(stockHolders.size() == 2){
                if(majorStockHolders.size() != 0 && minorStockHolders.size() != 0) {
                    for (int i = 0; i < majorStockHolders.size(); i++) {
                        majorStockHolders.get(i).addMoney(chain.getFirstBonus());
                    }
                    for (int i = 0; i < minorStockHolders.size(); i++) {
                        minorStockHolders.get(i).addMoney(chain.getSecondBonus());
                    }
                }
                else if (majorStockHolders.size() == minorStockHolders.size()){
                    majorStockHolders.get(0).addMoney((chain.getFirstBonus() + chain.getSecondBonus()) / 2);
                    minorStockHolders.get(0).addMoney((chain.getFirstBonus() + chain.getSecondBonus()) / 2);
                }

            }
            if(stockHolders.size() >= 3){
                // case 1: 1 major stockHolder, several minor stockholders
                if (majorStockHolders.size() == 1 && minorStockHolders.size() >= 2){
                    majorStockHolders.get(0).addMoney(chain.getFirstBonus());
                    for (int i = 0; i< minorStockHolders.size(); i++){
                        minorStockHolders.get(i).addMoney(chain.getSecondBonus() / minorStockHolders.size());
                    }
                }
                // case 2: several major stockholders, 1 minor stockholders
                else if (majorStockHolders.size() >= 2 && minorStockHolders.size() == 1){
                    minorStockHolders.get(0).addMoney(chain.getSecondBonus());
                    for (int i = 0; i < majorStockHolders.size(); i++){
                        minorStockHolders.get(i).addMoney(chain.getFirstBonus() / majorStockHolders.size());
                    }
                }

                // case 3: several major stockholders, several minor stockholders
                else if (majorStockHolders.size() >= 2 && minorStockHolders.size() >= 2){
                    for (int i = 0; i < majorStockHolders.size(); i++){
                        majorStockHolders.get(i).addMoney(chain.getFirstBonus() / majorStockHolders.size());
                    }
                    for (int i = 0; i < minorStockHolders.size(); i++){
                        minorStockHolders.get(i).addMoney(chain.getSecondBonus() / minorStockHolders.size());
                    }
                }
                // case 4: 0 minor stockholders(everyone is major stockholders)
                else if (minorStockHolders.size() == 0){
                    for (int i = 0; i < majorStockHolders.size(); i++){
                        majorStockHolders.get(i).addMoney((chain.getFirstBonus() + chain.getSecondBonus()) / majorStockHolders.size());
                    }
                }
            }
        }
    }

    public void sellStocks(HotelChain chain, Player player, int numStocks){

        player.removeStocks(chain, numStocks);
        stocks.addStocks(chain, numStocks);

        player.addMoney(PriceChart.getStockPrice(chain.getCategory(), chain.size()) * numStocks);

    }

    public void buyStock(HotelChain chain, Player player, int numStocks){

        player.addStocks(chain, numStocks);
        stocks.removeStocks(chain, numStocks);

        player.pullMoney(PriceChart.getStockPrice(chain.getCategory(), chain.size()) * numStocks);
    }
}