package isu.engine;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;


public class PlayerTest {

    private Player fixture;
    private Tile tile1;
    private Tile tile2;
    private List<Tile> tiles;
    private TilePile tilePile;

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
        fixture = new Player("test");
        tile1 = new Tile(1,1);
        tile2 = new Tile(1,2);
        tiles = new ArrayList<>();
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
    public void testTileCount(){
    }
    /*
     *
     * Testing setTiles() method.
     *
     * */
    @Test
    public void testSetTiles(){

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
     * Testing playTiles() method.
     *
     * */
    @Test
    public void testPlayTiles(){

    }
    /*
     *
     * Testing addStocks() method.
     *
     * */
    @Test
    public void testAddStocks(){
        fixture.addStocks(GameEngine.GAME_ENGINE.getHotelChains()[0], 5);
        assertEquals(5, fixture.getStocks(GameEngine.GAME_ENGINE.getHotelChains()[0]));
    }
    /*
     *
     * Testing removeStocks() method.
     *
     * */
    @Test
    public void testRemoveStocks(){
        fixture.addStocks(GameEngine.GAME_ENGINE.getHotelChains()[0], 5);
        fixture.removeStocks(GameEngine.GAME_ENGINE.getHotelChains()[0], 3);
        assertEquals(2, fixture.getStocks(GameEngine.GAME_ENGINE.getHotelChains()[0]));
    }
    /*
     *
     * Testing setStocks() method.
     *
     * */
    @Test
    public void testSetStocks(){
        fixture.setStocks(GameEngine.GAME_ENGINE.getHotelChains()[0], 10);
        assertEquals(10, fixture.getStocks(GameEngine.GAME_ENGINE.getHotelChains()[0]));
    }
}
