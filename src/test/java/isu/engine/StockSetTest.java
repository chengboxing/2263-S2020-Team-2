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
        fixture = new StockSet(GameEngine.GAME_ENGINE.getHotelChains(), GameEngine.MAX_STOCK_COUNT);
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
            assertEquals(25, fixture.getStocks(GameEngine.GAME_ENGINE.getHotelChains()[i]));
        }
    }
    /*
     * Testing illegalArgumentException for getStocks() method.
     *
     * */
    @Test (expected = ArrayIndexOutOfBoundsException.class)
    public void testGetStocksIllegalArgumentException() throws ArrayIndexOutOfBoundsException{
        fixture.getStocks(GameEngine.GAME_ENGINE.getHotelChains()[7]);
    }
    /*
     * Testing removeStocks method.
     *
     * */
    @Test
    public void testRemoveStocks(){

        fixture.setStocks(GameEngine.GAME_ENGINE.getHotelChains()[0], 15);
        assertEquals(10, fixture.removeStocks(GameEngine.GAME_ENGINE.getHotelChains()[0], 5));
    }
    /*
     * Testing illegalArgumentException for removeStocks() method.
     *
     * */
    @Test (expected = IllegalArgumentException.class)
    public void testRemoveStocksIllegalArgumentException() throws IllegalArgumentException{
        fixture.removeStocks(GameEngine.GAME_ENGINE.getHotelChains()[0], 30);
    }

    /*
     * Testing addStocks method.
     *
     * */
    @Test
    public void testAddStocks(){

        fixture.setStocks(GameEngine.GAME_ENGINE.getHotelChains()[0], 15);
        assertEquals(20, fixture.addStocks(GameEngine.GAME_ENGINE.getHotelChains()[0], 5));
    }
    /*
     * Testing illegalArgumentException for addStocks() method.
     *
     * */
    @Test (expected = IllegalArgumentException.class)
    public void testAddStocksIllegalArgumentException() throws IllegalArgumentException{
        fixture.addStocks(GameEngine.GAME_ENGINE.getHotelChains()[0], 25);
    }

    /*
     * Testing setStocks method.
     *
     * */
    @Test
    public void testSetStocks(){

        assertEquals(15, fixture.setStocks(GameEngine.GAME_ENGINE.getHotelChains()[0], 15));
    }
    /*
     * Testing illegalArgumentException for setStocks() method.
     *
     * */
    @Test (expected = IllegalArgumentException.class)
    public void testSetStocksIllegalArgumentException() throws IllegalArgumentException{
        fixture.setStocks(GameEngine.GAME_ENGINE.getHotelChains()[0], 26);
    }

}
