package isu.engine.manager;

import static org.junit.Assert.*;
import isu.engine.BoardCell;
import isu.engine.Player;
import isu.engine.Tile;
import isu.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;

public class TurnManagerTest {

    private TurnManager fixture;
    private TurnManager fixture_1;
    private Player fixturePlayer_0;
    private Player fixturePlayer_1;

    public TurnManagerTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        fixturePlayer_0 = new Player("Test_0");
        fixturePlayer_1 = new Player("Test_1");
        ArrayList<Player> fixturePlayers = new ArrayList<Player>();
        fixturePlayers.add(fixturePlayer_0);
        fixturePlayers.add(fixturePlayer_1);
        fixture = new TurnManager(fixturePlayers);
        TurnManager fixture_1 = new TurnManager(fixture.getPlayerOrder(), fixture.getCurrentPlayer());
    }

    @After
    public void tearDown() {
    }
    /**
     * Test getCurrentPlayer() method.
     */
    @Test
    public void testGetCurrentPlayer(){
        assertEquals(fixturePlayer_0, fixture.getCurrentPlayer());
    }
    /**
     * Test getCurrentPlayer() method.
     */
    @Test
    public void testGetPlayerOrder(){
        assertEquals(fixturePlayer_0, fixture.getPlayerOrder().get(0));
        assertEquals(fixturePlayer_1, fixture.getPlayerOrder().get(1));
    }
    /**
     * Test setCurrentPlayer() method.
     */
    @Test
    public void testSetCurrentPlayer(){
        fixture.setCurrentPlayer(fixturePlayer_1);
        assertEquals(fixturePlayer_1, fixture.getCurrentPlayer());
    }
    /**
     * Test nextTurn() method.
     */
    @Test
    public void testNextTurn(){
        assertEquals(fixturePlayer_1, fixture.nextTurn());
    }
    /**
     * Test TurnManager() method.
     */
    @Test
    public void test(){
    }
}