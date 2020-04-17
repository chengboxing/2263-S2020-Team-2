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
    private GameEngine gameEngine;

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
        gameEngine = new GameEngine();
        fixture = new StockSet(gameEngine.getHotelChains(), GameEngine.MAX_STOCK_COUNT);
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
            assertEquals(25, fixture.getStocks(gameEngine.getHotelChains()[i]));
        }
    }
    /*
     * Testing illegalArgumentException for getStocks() method.
     *
     * */
    @Test (expected = ArrayIndexOutOfBoundsException.class)
    public void testGetStocksIllegalArgumentException() throws ArrayIndexOutOfBoundsException{
        fixture.getStocks(gameEngine.getHotelChains()[7]);
    }
    /*
     * Testing removeStocks method.
     *
     * */
    @Test
    public void testRemoveStocks(){

        fixture.setStocks(gameEngine.getHotelChains()[0], 15);
        assertEquals(10, fixture.removeStocks(gameEngine.getHotelChains()[0], 5));
    }
    /*
     * Testing illegalArgumentException for removeStocks() method.
     *
     * */
    @Test (expected = IllegalArgumentException.class)
    public void testRemoveStocksIllegalArgumentException() throws IllegalArgumentException{
        fixture.removeStocks(gameEngine.getHotelChains()[0], 30);
    }

    /*
     * Testing addStocks method.
     *
     * */
    @Test
    public void testAddStocks(){

        fixture.setStocks(gameEngine.getHotelChains()[0], 15);
        assertEquals(20, fixture.addStocks(gameEngine.getHotelChains()[0], 5));
    }
    /*
     * Testing illegalArgumentException for addStocks() method.
     *
     * */
    @Test (expected = IllegalArgumentException.class)
    public void testAddStocksIllegalArgumentException() throws IllegalArgumentException{
        fixture.addStocks(gameEngine.getHotelChains()[0], 25);
    }

    /*
     * Testing setStocks method.
     *
     * */
    @Test
    public void testSetStocks(){

        assertEquals(15, fixture.setStocks(gameEngine.getHotelChains()[0], 15));
    }
    /*
     * Testing illegalArgumentException for setStocks() method.
     *
     * */
    @Test (expected = IllegalArgumentException.class)
    public void testSetStocksIllegalArgumentException() throws IllegalArgumentException{
        fixture.setStocks(gameEngine.getHotelChains()[0], 26);
    }

}
