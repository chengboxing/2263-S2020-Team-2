package isu.engine;


import isu.engine.manager.TurnManager;
import isu.util.CircularlyLinkedList;
import jdk.jfr.internal.PlatformEventType;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;



public class GameEngineTest {
    private GameEngine fixture;
    private Player fixturePlayer_0;
    private Player fixturePlayer_1;
    private TurnManager t;
    private List<Player> playerOrder;

    public GameEngineTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {

        fixture = new GameEngine();
        fixturePlayer_0 = new Player("test_0");
        fixturePlayer_1 = new Player("test_1");
        playerOrder = new ArrayList<>();
        t = new TurnManager(playerOrder);
    }

    @After
    public void tearDown() {
    }

    /*
     * Test getHotelChains() method.
     * */
    @Test
    public void testGetHotelChains(){
        assertNotNull(fixture.getHotelChains());
    }
    /*
     * Test getBank() method.
     * */
    @Test
    public void testGetBank(){
        assertNotNull(fixture.getBank());
    }
    /*
     * Test getPlayers() method.
     * */
    @Test
    public void testGetPlayers(){
        fixture.addPlayer("test_0");
        assertNotNull(fixture.getPlayers());
    }
    /*
     * Test getBoard() method.
     * */
    @Test
    public void testGetBoard(){
        assertNotNull(fixture.getBoard());
    }
    /*
     * Test getTilePile() method.
     * */
    @Test
    public void testGetTilePile(){
        assertNotNull(fixture.getTilePile());
    }
    /*
     * Test getTurnManager() method.
     * */
    @Test
    public void testGetTurnManager(){
        assertNotNull(fixture.getTurnManager());
    }
    /*
     * Test setTurnManager() method.
     * */
    @Test
    public void testSetTurnManager(){
        fixture.setTurnManager(t);
        assertEquals(t, fixture.getTurnManager());
    }
    /*
     * Test getMergeManager() method.
     * */
    @Test
    public void testGetMergeManager(){
        assertNotNull(fixture.getMergeManager());
    }
    /*
     * Test addPlayer() method.
     * */
    @Test
    public void testAddPlayer(){
        fixture.addPlayer("test_0");
        assertNotNull(fixture.getPlayers());
    }
    /*
     * Test updateGameName() method.
     * */
    @Test
    public void testUpdateGameName(){
        fixture.updateGameName("test");
        assertEquals("test", fixture.getGameName());
    }
    /*
     * Test getCurrentPlayer() method.
     * */
    @Test
    public void testGetCurrentPlayer(){
//        fixture.addPlayer("test_0");
//        fixture.addPlayer("test_1");
//        fixture.initGame();
//
//        assertSame(fixture.getCurrentPlayer(), fixture.getPlayers().get(0));
//        fixture.endGame();
    }
    /*
     * Test canPlayTile() method.
     * */
    @Test
    public void testCanPlayTile(){
//        fixture.addPlayer("test_0");
//        fixture.addPlayer("test_1");
//        fixture.initGame();
//
//        assertTrue(fixture.canPlayTile(0));
//        fixture.endGame();
    }
    /*
     * Test a whole game.
     * */
    @Test
    public void testWholeGame(){
    }
}

