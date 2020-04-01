package isu.engine;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.rules.ExpectedException;

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
     * Testing illegalArgumentException for getStocks() method.
     *
     * */
    @Test (expected = IllegalArgumentException.class)
    public void testGetStocksIllegalArgumentException() throws IllegalArgumentException{
        fixture.getStocks(HotelChain.getHotelChains()[7].getName());
    }
    /*
     * Testing removeStocks method.
     *
     * */
    @Test
    public void testRemoveStocks(){

        assertEquals(20, fixture.removeStocks(HotelChain.getHotelChains()[0].getName(), 5));
    }
    /*
     * Testing illegalArgumentException for removeStocks() method.
     *
     * */
    @Test (expected = IllegalArgumentException.class)
    public void testRemoveStocksIllegalArgumentException() throws IllegalArgumentException{
        fixture.removeStocks(HotelChain.getHotelChains()[0].getName(), 26);
    }

    /*
     * Testing addStocks method.
     *
     * */
    @Test
    public void testAddStocks(){

        fixture.removeStocks(HotelChain.getHotelChains()[0].getName(), 5);
        fixture.addStocks(HotelChain.getHotelChains()[0].getName(), 3);
        assertEquals(23, fixture.getStocks(HotelChain.getHotelChains()[0].getName()));

    }
    /*
     * Testing illegalArgumentException for addStocks() method.
     *
     * */
    @Test (expected = IllegalArgumentException.class)
    public void testAddStocksIllegalArgumentException() throws IllegalArgumentException{
        fixture.addStocks(HotelChain.getHotelChains()[0].getName(), 25);
    }

    /*
     * Testing setStocks method.
     *
     * */
    @Test
    public void testSetStocks(){

        fixture.setStocks(HotelChain.getHotelChains()[0].getName(), 10);
        assertEquals(10, fixture.getStocks(HotelChain.getHotelChains()[0].getName()));

    }
    /*
     * Testing illegalArgumentException for setStocks() method.
     *
     * */
    @Test (expected = IllegalArgumentException.class)
    public void testSetStocksIllegalArgumentException() throws IllegalArgumentException{
        fixture.setStocks(HotelChain.getHotelChains()[0].getName(), 26);
    }

}
