package isu.engine;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class BankTest {
    private Bank fixture;
    private Player fixturePlayer1;
    private Player fixturePlayer2;
    private Player fixturePlayer3;
    private Player fixturePlayer4;
    private List<Player> players;
    private GameEngine gameEngine;

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
        gameEngine = new GameEngine();
        fixture = new Bank(gameEngine.getHotelChains(), GameEngine.MAX_STOCK_COUNT);
        fixturePlayer1 = new Player("test_1");
        fixturePlayer2 = new Player("test_2");
        fixturePlayer3 = new Player("test_3");
        fixturePlayer4 = new Player("test_4");
        players = new ArrayList<>();
    }

    @After
    public void tearDown() {
    }

    /**
     * Test getStockCount(HotelChain chain) method
     */
    @Test
    public void testGetStockCount(){

        assertEquals(25, fixture.getStockCount(gameEngine.getHotelChains()[1]));

        fixture.sellStocksToPlayer(fixturePlayer1, gameEngine.getHotelChains()[1], 3);

        assertEquals(22, fixture.getStockCount(gameEngine.getHotelChains()[1]));
    }
    /**
     * Test buyStocksFromPlayer(Player player, HotelChain chain, int numStocks) methods.
     */
    @Test
    public void testBuyStocksFromPlayer() {
        players.add(fixturePlayer1);
        players.add(fixturePlayer2);

        gameEngine.getHotelChains()[1].addTile(new Tile(0, 1));
        gameEngine.getHotelChains()[1].addTile(new Tile(0, 2));
        gameEngine.getHotelChains()[1].addTile(new Tile(0, 3));

        fixturePlayer1.addStocks(gameEngine.getHotelChains()[1], 6);
        fixture.buyStocksFromPlayer(fixturePlayer1, gameEngine.getHotelChains()[1], 2);

        assertEquals(4, fixturePlayer1.getStocks(gameEngine.getHotelChains()[1]));
        assertEquals(3, gameEngine.getHotelChains()[1].size());
        assertEquals(6600, fixturePlayer1.getMoney());

//        gameEngine.getHotelChains()[1].clearTiles();
    }
    /**
     * Test sellStocksToPlayer(Player player, HotelChain chain, int numStocks) methods.
     */
    @Test
    public void testSellStocksToPlayer(){

        gameEngine.getHotelChains()[0].addTile(new Tile(0, 1));
        gameEngine.getHotelChains()[0].addTile(new Tile(0, 2));
        gameEngine.getHotelChains()[0].addTile(new Tile(0, 3));

        fixture.sellStocksToPlayer(fixturePlayer1, gameEngine.getHotelChains()[0], 3);

        assertEquals(3, fixturePlayer1.getStocks(gameEngine.getHotelChains()[0]));
        assertEquals(3, gameEngine.getHotelChains()[0].size());
        assertEquals(5100, fixturePlayer1.getMoney());

//        gameEngine.getHotelChains()[0].clearTiles();
    }
    /**
     * Test payBonus methods for one major stockholder.
     */
    @Test
    public void testPayBonus_1(){

        players.add(fixturePlayer1);
        players.add(fixturePlayer2);

        gameEngine.getHotelChains()[2].addTile(new Tile(0, 1));
        gameEngine.getHotelChains()[2].addTile(new Tile(0, 2));

        fixturePlayer1.addStocks(gameEngine.getHotelChains()[2], 0);
        fixturePlayer2.addStocks(gameEngine.getHotelChains()[2], 1);

        fixture.payBonus(gameEngine.getHotelChains()[2], players);

        assertEquals(6000, fixturePlayer1.getMoney());
        assertEquals(10500, fixturePlayer2.getMoney());

//        gameEngine.getHotelChains()[2].clearTiles();
    }
//    /**
//     * Test payBonus methods for two persons, one major stockholder and one minor stockholder
//     */
//    @Test
//    public void testPayBonus_2(){
//
//        players.add(fixturePlayer1);
//        players.add(fixturePlayer2);
//
//        gameEngine.getHotelChains()[0].addTile(new Tile(0, 1));
//        gameEngine.getHotelChains()[0].addTile(new Tile(0, 2));
//
//        fixturePlayer1.addStocks(gameEngine.getHotelChains()[0], 2);
//        fixturePlayer2.addStocks(gameEngine.getHotelChains()[0], 1);
//
//        fixture.payBonus(gameEngine.getHotelChains()[0], players);
//
//        assertEquals(8000, fixturePlayer1.getMoney());
//        assertEquals(7000, fixturePlayer2.getMoney());
//
////        gameEngine.getHotelChains()[0].clearTiles();
//    }
//    /**
//     * Test payBonus methods for two players who have same stocks
//     */
//    @Test
//    public void testPayBonus_3(){
//        players.add(fixturePlayer1);
//        players.add(fixturePlayer2);
//
//        fixturePlayer1.addStocks(gameEngine.getHotelChains()[0], 3);
//        fixturePlayer2.addStocks(gameEngine.getHotelChains()[0], 3);
//
//        gameEngine.getHotelChains()[0].addTile(new Tile(0, 1));
//        gameEngine.getHotelChains()[0].addTile(new Tile(0, 2));
//        fixture.payBonus(gameEngine.getHotelChains()[0], players);
//
//        assertEquals(7500,fixturePlayer1.getMoney());
//        assertEquals(7500, fixturePlayer2.getMoney());
//
////        gameEngine.getHotelChains()[0].clearTiles();
//    }
//    /**
//     * Test payBonus methods for Three players, one major stockholder, one minor stockholder and one third stockholder
//     */
//    @Test
//    public void testPayBonus_4(){
//        players.add(fixturePlayer1);
//        players.add(fixturePlayer2);
//        players.add(fixturePlayer3);
//
//        fixturePlayer1.addStocks(gameEngine.getHotelChains()[0], 3);
//        fixturePlayer2.addStocks(gameEngine.getHotelChains()[0], 2);
//        fixturePlayer3.addStocks(gameEngine.getHotelChains()[0], 1);
//
//        gameEngine.getHotelChains()[0].addTile(new Tile(0, 1));
//        gameEngine.getHotelChains()[0].addTile(new Tile(0, 2));
//        fixture.payBonus(gameEngine.getHotelChains()[0], players);
//
//        assertEquals(8000,fixturePlayer1.getMoney());
//        assertEquals(7000, fixturePlayer2.getMoney());
//        assertEquals(6000, fixturePlayer3.getMoney());
//
////        gameEngine.getHotelChains()[0].clearTiles();
//    }
//    /**
//     * Test payBonus methods for Three players, two major stockholders and one minor stockholder
//     */
//    @Test
//    public void testPayBonus_5(){
//        players.add(fixturePlayer1);
//        players.add(fixturePlayer2);
//        players.add(fixturePlayer3);
//
//        fixturePlayer1.addStocks(gameEngine.getHotelChains()[0], 3);
//        fixturePlayer2.addStocks(gameEngine.getHotelChains()[0], 3);
//        fixturePlayer3.addStocks(gameEngine.getHotelChains()[0], 1);
//
//        gameEngine.getHotelChains()[0].addTile(new Tile(0, 1));
//        gameEngine.getHotelChains()[0].addTile(new Tile(0, 2));
//        fixture.payBonus(gameEngine.getHotelChains()[0], players);
//
//        assertEquals(7000,fixturePlayer1.getMoney());
//        assertEquals(7000, fixturePlayer2.getMoney());
//        assertEquals(7000, fixturePlayer3.getMoney());
//
////        gameEngine.getHotelChains()[0].clearTiles();
//    }
//    /**
//     * Test payBonus methods for Three players, one major stockholder and two minor stockholders
//     */
//    @Test
//    public void testPayBonus_6(){
//        players.add(fixturePlayer1);
//        players.add(fixturePlayer2);
//        players.add(fixturePlayer3);
//
//        fixturePlayer1.addStocks(gameEngine.getHotelChains()[0], 3);
//        fixturePlayer2.addStocks(gameEngine.getHotelChains()[0], 1);
//        fixturePlayer3.addStocks(gameEngine.getHotelChains()[0], 1);
//
//        gameEngine.getHotelChains()[0].addTile(new Tile(0, 1));
//        gameEngine.getHotelChains()[0].addTile(new Tile(0, 2));
//        fixture.payBonus(gameEngine.getHotelChains()[0], players);
//
//        assertEquals(8000,fixturePlayer1.getMoney());
//        assertEquals(6500, fixturePlayer2.getMoney());
//        assertEquals(6500, fixturePlayer3.getMoney());
//
////        gameEngine.getHotelChains()[0].clearTiles();
//    }
//    /**
//     * Test payBonus methods for three players, three major stockholders
//     */
//    @Test
//    public void testPayBonus_7(){
//        players.add(fixturePlayer1);
//        players.add(fixturePlayer2);
//        players.add(fixturePlayer3);
//
//        fixturePlayer1.addStocks(gameEngine.getHotelChains()[0], 2);
//        fixturePlayer2.addStocks(gameEngine.getHotelChains()[0], 2);
//        fixturePlayer3.addStocks(gameEngine.getHotelChains()[0], 2);
//
//        gameEngine.getHotelChains()[0].addTile(new Tile(0, 1));
//        gameEngine.getHotelChains()[0].addTile(new Tile(0, 2));
//        fixture.payBonus(gameEngine.getHotelChains()[0], players);
//
//        assertEquals(7000,fixturePlayer1.getMoney());
//        assertEquals(7000, fixturePlayer2.getMoney());
//        assertEquals(7000, fixturePlayer3.getMoney());
//
////        gameEngine.getHotelChains()[0].clearTiles();
//    }
//    /**
//     * Test payBonus methods for four players, two major stockholders and two minor stockholders
//     */
//    @Test
//    public void testPayBonus_8(){
//        players.add(fixturePlayer1);
//        players.add(fixturePlayer2);
//        players.add(fixturePlayer3);
//        players.add(fixturePlayer4);
//
//        fixturePlayer1.addStocks(gameEngine.getHotelChains()[0], 3);
//        fixturePlayer2.addStocks(gameEngine.getHotelChains()[0], 3);
//        fixturePlayer3.addStocks(gameEngine.getHotelChains()[0], 1);
//        fixturePlayer4.addStocks(gameEngine.getHotelChains()[0], 1);
//
//        gameEngine.getHotelChains()[0].addTile(new Tile(0, 1));
//        gameEngine.getHotelChains()[0].addTile(new Tile(0, 2));
//        fixture.payBonus(gameEngine.getHotelChains()[0], players);
//
//        assertEquals(7000,fixturePlayer1.getMoney());
//        assertEquals(7000, fixturePlayer2.getMoney());
//        assertEquals(6500, fixturePlayer3.getMoney());
//        assertEquals(6500, fixturePlayer4.getMoney());
//
////        gameEngine.getHotelChains()[0].clearTiles();
//    }
//    /**
//     * Test payBonus methods for four players, one major stockholder and three minor stockholders
//     */
//    @Test
//    public void testPayBonus_9(){
//        players.add(fixturePlayer1);
//        players.add(fixturePlayer2);
//        players.add(fixturePlayer3);
//        players.add(fixturePlayer4);
//
//        fixturePlayer1.addStocks(gameEngine.getHotelChains()[0], 3);
//        fixturePlayer2.addStocks(gameEngine.getHotelChains()[0], 1);
//        fixturePlayer3.addStocks(gameEngine.getHotelChains()[0], 1);
//        fixturePlayer4.addStocks(gameEngine.getHotelChains()[0], 1);
//
//        gameEngine.getHotelChains()[0].addTile(new Tile(0, 1));
//        gameEngine.getHotelChains()[0].addTile(new Tile(0, 2));
//        fixture.payBonus(gameEngine.getHotelChains()[0], players);
//
//        assertEquals(8000,fixturePlayer1.getMoney());
//        assertEquals(6333, fixturePlayer2.getMoney());
//        assertEquals(6333, fixturePlayer3.getMoney());
//        assertEquals(6333, fixturePlayer4.getMoney());
//
////        gameEngine.getHotelChains()[0].clearTiles();
//    }
//    /**
//     * Test payBonus methods for four players, one major stockholder and three minor stockholders
//     */
//    @Test
//    public void testPayBonus_10(){
//        players.add(fixturePlayer1);
//        players.add(fixturePlayer2);
//        players.add(fixturePlayer3);
//        players.add(fixturePlayer4);
//
//        fixturePlayer1.addStocks(gameEngine.getHotelChains()[0], 3);
//        fixturePlayer2.addStocks(gameEngine.getHotelChains()[0], 3);
//        fixturePlayer3.addStocks(gameEngine.getHotelChains()[0], 3);
//        fixturePlayer4.addStocks(gameEngine.getHotelChains()[0], 1);
//
//        gameEngine.getHotelChains()[0].addTile(new Tile(0, 1));
//        gameEngine.getHotelChains()[0].addTile(new Tile(0, 2));
//        fixture.payBonus(gameEngine.getHotelChains()[0], players);
//
//        assertEquals(6666,fixturePlayer1.getMoney());
//        assertEquals(6666, fixturePlayer2.getMoney());
//        assertEquals(6666, fixturePlayer3.getMoney());
//        assertEquals(7000, fixturePlayer4.getMoney());
//
////        gameEngine.getHotelChains()[0].clearTiles();
//    }
//    /**
//     * Test payBonus methods for four players, one major stockholder and one minor stockholders
//     */
//    @Test
//    public void testPayBonus_11(){
//        players.add(fixturePlayer1);
//        players.add(fixturePlayer2);
//        players.add(fixturePlayer3);
//        players.add(fixturePlayer4);
//
//        fixturePlayer1.addStocks(gameEngine.getHotelChains()[0], 4);
//        fixturePlayer2.addStocks(gameEngine.getHotelChains()[0], 3);
//        fixturePlayer3.addStocks(gameEngine.getHotelChains()[0], 2);
//        fixturePlayer4.addStocks(gameEngine.getHotelChains()[0], 1);
//
//        gameEngine.getHotelChains()[0].addTile(new Tile(0, 1));
//        gameEngine.getHotelChains()[0].addTile(new Tile(0, 2));
//        fixture.payBonus(gameEngine.getHotelChains()[0], players);
//
//        assertEquals(8000,fixturePlayer1.getMoney());
//        assertEquals(7000, fixturePlayer2.getMoney());
//        assertEquals(6000, fixturePlayer3.getMoney());
//        assertEquals(6000, fixturePlayer4.getMoney());
//
////        gameEngine.getHotelChains()[0].clearTiles();
//    }
//    /**
//     * Test giveFreeStockToPlayer(Player player, HotelChain chain) method
//     */
//    @Test
//    public void testGiveFreeStockToPlayer(){
//
//        gameEngine.getHotelChains()[0].addTile(new Tile(0, 1));
//        gameEngine.getHotelChains()[0].addTile(new Tile(0, 2));
//
//        fixture.giveFreeStockToPlayer(fixturePlayer1, gameEngine.getHotelChains()[0]);
//
//        assertEquals(1, fixturePlayer1.getStocks(gameEngine.getHotelChains()[0]));
//        assertEquals(24, fixture.getStockCount(gameEngine.getHotelChains()[0]));
//    }
//    /**
//     * Test tradeStocksWithPlayer(Player player, HotelChain majorChain,
//     *                                       HotelChain minorChain, int minorStockCount) method
//     */
//    @Test
//    public void testTradeStocksWithPlayer(){
//
//        gameEngine.getHotelChains()[0].addTile(new Tile(1,1));
//        gameEngine.getHotelChains()[0].addTile(new Tile(1,2));
//        gameEngine.getHotelChains()[0].addTile(new Tile(1,3));
//
//        gameEngine.getHotelChains()[0].addTile(new Tile(3,2));
//        gameEngine.getHotelChains()[0].addTile(new Tile(3,3));
//
//        fixture.tradeStocksWithPlayer(fixturePlayer1, gameEngine.getHotelChains()[0],
//                gameEngine.getHotelChains()[1], 0);
//
//        fixture.tradeStocksWithPlayer(fixturePlayer1, gameEngine.getHotelChains()[0],
//                gameEngine.getHotelChains()[1], 3);
//    }
}
