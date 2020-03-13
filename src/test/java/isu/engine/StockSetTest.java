package isu.engine;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class StockSetTest {
    private StockSet fixture;

    public StockSetTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        fixture = new StockSet();
    }

    @After
    public void tearDown() {
    }

    /*
     * Testing getStock method.
     *
     * */
    @Test
    public void testGetStocks() {

        for (int i = 0; i < 7; i++){
        assertEquals(25, fixture.getStocks(HotelChain.getHotelChains()[i].getName()));
        }

    }
    /*
     * Testing removeStocks method.
     *
     * */
    public void testRemoveStocks(){

        assertEquals(20, fixture.removeStocks(HotelChain.getHotelChains()[0].getName(), 5));
    }
    /*
     * Testing addStocks method.
     *
     * */
    public void testAddStocks(){

        fixture.removeStocks(HotelChain.getHotelChains()[0].getName(), 5);

        assertEquals(23, fixture.addStocks(HotelChain.getHotelChains()[0].getName(), 3));

    }
    /*
     * Testing setStocks method.
     *
     * */
    public void testSetStocks(){

        assertEquals(10, fixture.setStocks(HotelChain.getHotelChains()[0].getName(), 10));

    }
}
