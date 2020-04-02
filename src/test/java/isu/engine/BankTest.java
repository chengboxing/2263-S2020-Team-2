package isu.engine;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class BankTest {
    private Bank fixture;
    private Player fixturePlayer;
    private Tile tile1;
    private Tile tile2;

    public BankTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        fixture = new Bank(GameEngine.GAME_ENGINE.getHotelChains(), GameEngine.MAX_STOCK_COUNT);
        fixturePlayer = new Player("test");
        tile1 = new Tile(1,2);
        tile2 = new Tile(2,3);
    }

    @After
    public void tearDown() {
    }

    /**
     * Test buyStocks methods.
     */
    @Test
    public void testBuyStocks() {

        GameEngine.GAME_ENGINE.getHotelChains()[0].addTile(tile1);
        GameEngine.GAME_ENGINE.getHotelChains()[0].addTile(tile2);
        fixturePlayer.addMoney(2000);
        fixture.buyStock(GameEngine.GAME_ENGINE.getHotelChains()[0], fixturePlayer, 2);

        assertEquals(2, fixturePlayer.getStocks(GameEngine.GAME_ENGINE.getHotelChains()[0]));
        assertEquals(1600, fixturePlayer.getMoney());

    }
    /**
     * Test buyStocks methods.
     */
    @Test
    public void testSellStocks(){
        GameEngine.GAME_ENGINE.getHotelChains()[0].addTile(tile1);
        GameEngine.GAME_ENGINE.getHotelChains()[0].addTile(tile2);
        fixturePlayer.addStocks(GameEngine.GAME_ENGINE.getHotelChains()[0], 3);
        fixturePlayer.addMoney(2000);

        fixture.sellStocks(GameEngine.GAME_ENGINE.getHotelChains()[0], fixturePlayer, 2);

        assertEquals(1, fixturePlayer.getStocks(GameEngine.GAME_ENGINE.getHotelChains()[0]));
        assertEquals(2400, fixturePlayer.getMoney());
    }
    /**
     * Test payBonus methods.
     */
    @Test
    public void testPayBonus_0(){

    }
}
