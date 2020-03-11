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
    public void testIllegalArgumentException() throws IllegalArgumentException{
        PriceChart.getFirstBonus(HotelChainCategory.CHEAP, -5);
    }




}
