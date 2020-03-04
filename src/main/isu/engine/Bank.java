package isu.engine;

import com.sun.net.httpserver.Filter;

import java.util.HashMap;
import java.util.List;
import java.util.logging.Handler;

public class Bank {

    private StockSet stocks;

    public Bank(){
        stocks = new StockSet();
    }

    public void payBonus(HotelChain chain, List<Player> players){
        PriceChart bonus = new PriceChart();

        /*if (){
            playerWallet.addMoney(chain.getFirstBonus());
        }
        else if (){
            playerWallet.addMoney(chain.getSecondBonus());
        }*/
    }

    public void sellStocks(HotelChain chain, Player player, int numStocks){

        player.removeStocks(chain.getName(), numStocks);
        stocks.addStocks(chain.getName(), numStocks);

        player.addMoney(PriceChart.getStockPrice(chain.getCategory(), chain.size()) * numStocks); // add player's money

    }

    public void buyStock(HotelChain chain, Player player, int numStocks){

        player.addStocks(chain.getName(), numStocks);
        stocks.removeStocks(chain.getName(), numStocks);

        player.pullMoney(PriceChart.getStockPrice(chain.getCategory(), chain.size()) * numStocks);
    }
}