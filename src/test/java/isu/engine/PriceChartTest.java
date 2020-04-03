package isu.engine;

import isu.engine.PriceChart;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

public class PriceChartTest {


    public PriceChartTest(){
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        ExpectedException thrown= ExpectedException.none();
    }

    @After
    public void tearDown() {
    }


    /*
    * Testing the price chart.
    *
    * */
    @Test
    public void testGetStockPrice_0(){
        assertEquals(300, PriceChart.getStockPrice(HotelChainCategory.CHEAP, 3));
    }

    /*
     * Testing the price chart.
     *
     * */
    @Test
    public void testGetStockPrice_1(){
        assertNotEquals(600, PriceChart.getStockPrice(HotelChainCategory.EXPENSIVE, 10));
    }

    /*
     * Testing the price chart.
     *
     * */
    @Test
    public void testGetStockPrice_2(){
        assertNotEquals(500, PriceChart.getStockPrice(HotelChainCategory.AVERAGE, 5));
    }
    /*
     * Testing the price chart.
     *
     * */
    @Test
    public void testGetStockPrice_3(){
        assertEquals(0, PriceChart.getStockPrice(HotelChainCategory.CHEAP, 1));
    }
    /*
     * Testing the price chart.
     *
     * */
    @Test
    public void testGetStockPrice_4(){
        assertEquals(700, PriceChart.getStockPrice(HotelChainCategory.CHEAP, 15));
    }
    /*
     * Testing the price chart.
     *
     * */
    @Test
    public void testGetStockPrice_5(){
        assertEquals(800, PriceChart.getStockPrice(HotelChainCategory.CHEAP, 25));
    }
    /*
     * Testing the price chart.
     *
     * */
    @Test
    public void testGetStockPrice_6(){
        assertEquals(900, PriceChart.getStockPrice(HotelChainCategory.CHEAP, 35));
    }
    /*
     * Testing the price chart.
     *
     * */
    @Test
    public void testGetStockPrice_7(){
        assertEquals(1000, PriceChart.getStockPrice(HotelChainCategory.CHEAP, 45));
    }
    /*
     * Testing first bonus price.
     *
     * */
    @Test
    public void testGetFirstBonus(){
        assertEquals(6000, PriceChart.getFirstBonus(HotelChainCategory.AVERAGE, 5));
    }
    /*
     * Testing second bonus price.
     *
     * */
    @Test
    public void testGetSecondBonus(){
        assertEquals(4000, PriceChart.getSecondBonus(HotelChainCategory.EXPENSIVE, 10));
    }
    /*
    *
    * Testing illegalArgumentException for getFirstBonus() method.
    *
    * */
    @Test (expected = IllegalArgumentException.class)
    public void testGetFirstBonusIllegalArgumentException() throws IllegalArgumentException{
        PriceChart.getFirstBonus(HotelChainCategory.CHEAP, -5);
    }

    /*
     *
     * Testing illegalArgumentException for getSecondBonus() method.
     *
     * */
    @Test (expected = IllegalArgumentException.class)
    public void testGetSecondBonusIllegalArgumentException() throws IllegalArgumentException{
        PriceChart.getSecondBonus(HotelChainCategory.CHEAP, -5);
    }

    /*
     *
     * Testing illegalArgumentException for getStockPrice() method.
     *
     * */
    @Test (expected = IllegalArgumentException.class)
    public void testGetStockPriceIllegalArgumentException() throws IllegalArgumentException{
        PriceChart.getStockPrice(HotelChainCategory.CHEAP, -5);
    }

}
