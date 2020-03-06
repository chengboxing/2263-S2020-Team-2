package isu.engine;

import isu.engine.PriceChart;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class PriceChartTest {

   // private PriceChart fixture;

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

    }

    @After
    public void tearDown() {
    }


    /*
    * Testing the price chart.
    *
    * */
    @Test
    public void testPriceChart_GetStockPrice_1(){
        assertEquals(500, PriceChart.getStockPrice(HotelChainCategory.CHEAP, 5));
    }

    /*
     * Testing the price chart.
     *
     * */
    @Test
    public void testPriceChart_GetStockPrice_2(){
        assertEquals(600, PriceChart.getStockPrice(HotelChainCategory.CHEAP, 10));
    }

    /*
     * Testing the price chart.
     *
     * */
    @Test
    public void testPriceChart_GetStockPrice_3(){
        assertNotEquals(500, PriceChart.getStockPrice(HotelChainCategory.AVERAGE, 5));
    }




}
