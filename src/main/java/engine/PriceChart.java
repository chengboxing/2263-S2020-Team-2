package java.engine;

public class PriceChart {

    public static int getStockPrice(HotelChainCategory  chainCategory, int chainSize){
        int price;

        if (chainSize < 2){
            price = 0;
        } else if (chainSize <= 5){
            price = 100 * chainSize;
        } else if (chainSize <= 10){
            price = 600;
        } else if (chainSize <= 20){
            price = 700;
        } else if (chainSize <= 30){
            price = 800;
        } else if (chainSize <= 40){
            price = 900;
        } else {
            price = 1000;
        }

        if (chainCategory == HotelChainCategory.AVERAGE){
            price += 100;
        } else if (chainCategory == HotelChainCategory.EXPENSIVE){
            price += 200;
        }

        return price;
    }

    public static int getFirstBonus(HotelChainCategory chainCategory, int chainSize){
        return getStockPrice(chainCategory, chainSize) * 10;
    }

    public static int getSecondBonus(HotelChainCategory chainCategory, int chainSize){
        return getStockPrice(chainCategory, chainSize) * 5;
    }



}
