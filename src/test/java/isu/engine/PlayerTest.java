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
     * Testing setName(String name) method.
     *
     * */
    @Test
    public void testSetName(){
        fixture.setName("Tim");
        assertNotSame("test", "Tim");
    }
    /*
     *
     * Testing getName() method.
     *
     * */
    @Test
    public void testGetName(){
        fixture.setName("aaa");
        assertSame("aaa", fixture.getName());
    }
    /*
     *
     * Testing getMoney() method.
     *
     * */
    @Test
    public void testGetMoney(){
        fixture.setMoney(1000);
        assertEquals(1000, fixture.getMoney());
    }
    /*
    *
    * Testing setMoney(int money) method.
    *
    * */
    @Test
    public void testSetMoney(){
        fixture.setMoney(5000);
        assertEquals(5000, fixture.getMoney());
    }
    /*
     *
     * Testing addMoney(int cash) method.
     *
     * */
    @Test
    public void testAddMoney(){

        fixture.setMoney(1000);
        fixture.addMoney(500);
        assertEquals(1500, fixture.getMoney());
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
     * Testing pullMoney(int cash) method.
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
        Method tileCount = class1.getDeclaredMethod("tileCount");
        tileCount.setAccessible(true);
        int invoke = (int) tileCount.invoke(fixture);

        assertEquals(2, invoke);
    }
    /*
     *
     * Testing addTiles(TilePile tilePile, int tileCount) method.
     *
     * */
    @Test
    public void testAddTiles(){
        fixture.addTiles(tilePile, 5);

        assertEquals(5, fixture.getTiles().size());
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
     * Testing getTile(int index) method.
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
     * Testing addTile(TilePile tilePile) method.
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
     * Testing getTiles() method.
     *
     * */
    @Test
    public void testGetTiles(){
        fixture.addTile(tilePile);
        fixture.addTile(tilePile);
        fixture.addTile(tilePile);

        assertEquals(3, fixture.getTiles().size());
    }
    /*
     *
     * Testing addStocks(HotelChain chain, int numStocks) method.
     *
     * */
    @Test
    public void testAddStocks(){
        fixture.addStocks(gameEngine.getHotelChains()[0], 5);
        assertEquals(5, fixture.getStocks(gameEngine.getHotelChains()[0]));
    }
    /*
     *
     * Testing removeStocks(HotelChain chain, int numStocks) method.
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
     * Testing setStocks(HotelChain chain, int numStocks) method.
     *
     * */
    @Test
    public void testSetStocks(){
        fixture.setStocks(gameEngine.getHotelChains()[0], 10);
        assertEquals(10, fixture.getStocks(gameEngine.getHotelChains()[0]));
    }
    /*
     *
     * Testing getStocks(HotelChain chain) method.
     *
     * */
    @Test
    public void testGetStocks(){
        fixture.addStocks(gameEngine.getHotelChains()[0], 3);

        assertEquals(3, fixture.getStocks(gameEngine.getHotelChains()[0]));
    }
}
