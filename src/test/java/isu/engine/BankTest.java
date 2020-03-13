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
        fixture = new Bank();
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

        HotelChain.getHotelChains()[0].addTile(tile1);
        HotelChain.getHotelChains()[0].addTile(tile2);
        fixturePlayer.addMoney(2000);
        fixture.buyStock(HotelChain.getHotelChains()[0], fixturePlayer, 2);

        assertEquals(2, fixturePlayer.getStocks(HotelChain.getHotelChains()[0].getName()));
        assertEquals(1600, fixturePlayer.getMoney());

    }
    /**
     * Test buyStocks methods.
     */
    @Test
    public void testSellStocks(){
        HotelChain.getHotelChains()[0].addTile(tile1);
        HotelChain.getHotelChains()[0].addTile(tile2);
        fixturePlayer.addStocks(HotelChain.getHotelChains()[0].getName(), 3);
        fixturePlayer.addMoney(2000);

        fixture.sellStocks(HotelChain.getHotelChains()[0], fixturePlayer, 2);

        assertEquals(1, fixturePlayer.getStocks(HotelChain.getHotelChains()[0].getName()));
        assertEquals(2400, fixturePlayer.getMoney());
    }
    /**
     * Test payBonus methods.
     */
    @Test
    public void testPayBonus_0(){

    }
}
