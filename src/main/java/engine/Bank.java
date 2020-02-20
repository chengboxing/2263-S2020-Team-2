package java.engine;

public class Bank {

    public static final int MONEY_TOTAL = 226000;

    private StockSet stocks;
    private int money;

    public Bank(){
        stocks = new StockSet();
        money = MONEY_TOTAL;
    }

    public void payBonus(int cashAmount, Wallet playerWallet){

    }

    public void sellStock(Stock stock, Wallet playerWallet){

    }

    public Stock buyStock(HotelChain chain, Wallet playerWallet){
        return null;
    }
}
