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
    public void testPriceChart_1(){
        assertEquals(500, PriceChart.getStockPrice(HotelChainCategory.CHEAP, 5));
    }



}
