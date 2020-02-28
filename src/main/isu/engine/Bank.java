package isu.engine;

public class Bank {

    public static final int MONEY_TOTAL = 226000;

    private StockSet stocks;
    private int money;

    public Bank(){
        stocks = new StockSet();
        money = MONEY_TOTAL;
    }

    public void payBonus(int cashAmount, Player player){

    }

    public void sellStock(Stock stock, Player player){

    }

    public Stock buyStock(HotelChain chain, Player player){
        return null;
    }
}
