package isu.engine;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import java.lang.reflect.Method;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;


public class PlayerTest {

    private Player fixture;
    private TilePile tilePile;
    private GameEngine gameEngine;

    public PlayerTest(){
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
        fixture = new Player("test");
        tilePile = new TilePile();
    }

    @After
    public void tearDown() {
    }

    /*
    *
    * Testing setMoney() method.
    *
    * */
    @Test
    public void testSetMoney(){
        fixture.setMoney(5000);
        assertEquals(5000, fixture.getMoney());
    }
    /*
     *
     * Testing addMoney() method.
     *
     * */
    @Test
    public void testAddMoney(){

        fixture.setMoney(1000);
        fixture.addMoney(500);
        assertEquals(1500, fixture.getMoney());
    }
    /*
     *
     * Testing setName() method.
     *
     * */
    @Test
    public void testSetName(){
        fixture.setName("Tim");
        assertNotSame("test", "Tim");
    }
    /*
     * Testing illegalArgumentException for addMoney() method.
     *
     * */
    @Test (expected = IllegalArgumentException.class)
    public void testAddMoneyIllegalArgumentException() throws IllegalArgumentException{
        fixture.addMoney(-500);
    }
    /*
     *
     * Testing pullMoney() method.
     *
     * */
    @Test
    public void testPullMoney(){
        fixture.setMoney(1000);
        fixture.pullMoney(500);
        assertEquals(500, fixture.getMoney());
    }
    /*
     * Testing illegalArgumentException for pullMoney() method.
     *
     * */
    @Test (expected = IllegalArgumentException.class)
    public void testPullMoneyIllegalArgumentException() throws IllegalArgumentException{
        fixture.pullMoney(10000);
    }
    /*
     *
     * Testing tileCount() method.
     *
     * */
    @Test
    public void testTileCount() throws Exception {
        fixture.addTile(tilePile);
        fixture.addTile(tilePile);

        Class<Player> class1 = Player.class;
        Method tileCount = class1.getDeclaredMethod("tileCount", null);
        tileCount.setAccessible(true);
        int invoke = (int) tileCount.invoke(fixture, null);

        assertEquals(2, invoke);
    }
    /*
     *
     * Testing pullTile() method.
     *
     * */
    @Test
    public void testPullTile(){
        fixture.addTile(tilePile);
        fixture.addTile(tilePile);

        Tile tile_0 = fixture.getTile(0);
        Tile tile_1 = fixture.pullTile(0);
        assertEquals(tile_0, tile_1);
        assertEquals(1, fixture.getTiles().size());
    }

    /*
     *
     * Testing getTile() method.
     *
     * */
    @Test
    public void testGetTile(){
        fixture.addTile(tilePile);
        fixture.addTile(tilePile);

        assertNotNull(fixture.getTile(0));
        assertNotNull(fixture.getTile(1));
    }
    /*
     *
     * Testing addTile() method.
     *
     * */
    @Test
    public void testAddTile(){
        fixture.addTile(tilePile);
        fixture.addTile(tilePile);
        assertEquals(2, fixture.getTiles().size());
    }
    /*
     *
     * Testing addStocks() method.
     *
     * */
    @Test
    public void testAddStocks(){
        fixture.addStocks(gameEngine.getHotelChains()[0], 5);
        assertEquals(5, fixture.getStocks(gameEngine.getHotelChains()[0]));
    }
    /*
     *
     * Testing removeStocks() method.
     *
     * */
    @Test
    public void testRemoveStocks(){
        fixture.addStocks(gameEngine.getHotelChains()[0], 5);
        fixture.removeStocks(gameEngine.getHotelChains()[0], 3);
        assertEquals(2, fixture.getStocks(gameEngine.getHotelChains()[0]));
    }
    /*
     *
     * Testing setStocks() method.
     *
     * */
    @Test
    public void testSetStocks(){
        fixture.setStocks(gameEngine.getHotelChains()[0], 10);
        assertEquals(10, fixture.getStocks(gameEngine.getHotelChains()[0]));
    }

}
