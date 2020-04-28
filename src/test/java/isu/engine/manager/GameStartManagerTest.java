package isu.engine.manager;

import static org.junit.Assert.*;
import java.lang.reflect.Method;
import isu.engine.GameEngine;
import isu.engine.Player;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.rules.ExpectedException;


public class GameStartManagerTest {

    private GameEngine gameEngine;
    private GameStartManager fixture;

    public GameStartManagerTest() {
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
        fixture = new GameStartManager(gameEngine);

    }

    @After
    public void tearDown() {
    }

    /**
     * Test setInitTiles() method
     */
    @Test
    public void testSetInitTiles() throws Exception{
        gameEngine.addPlayer("test_1");
        gameEngine.addPlayer("test_2");

        Class<GameStartManager> class1 = GameStartManager.class;
        Method setInitTiles = class1.getDeclaredMethod("setInitTiles");
        setInitTiles.setAccessible(true);
        setInitTiles.invoke(fixture);

        assertEquals(2, gameEngine.getPlayers().size());
        assertEquals(7, gameEngine.getPlayers().get(0).getTiles().size());
        assertEquals(7, gameEngine.getPlayers().get(1).getTiles().size());

    }
    /**
     * Test placeFirstTiles() method
     */
    @Test
    public void testPlaceFirstTiles() throws Exception{
        gameEngine.addPlayer("test_1");
        gameEngine.addPlayer("test_2");

        Class<GameStartManager> class1 = GameStartManager.class;
        Method setInitTiles = class1.getDeclaredMethod("setInitTiles");
        setInitTiles.setAccessible(true);
        setInitTiles.invoke(fixture);

        Class<GameStartManager> class2 = GameStartManager.class;
        Method placeFirstTiles = class2.getDeclaredMethod("placeFirstTiles");
        placeFirstTiles.setAccessible(true);
        placeFirstTiles.invoke(fixture);

        assertEquals(6, gameEngine.getPlayers().get(0).getTiles().size());
        assertEquals(6, gameEngine.getPlayers().get(1).getTiles().size());
        assertEquals(94, gameEngine.getTilePile().size());
        assertEquals(106, gameEngine.getBoard().getEmptyCells().size());
    }
    /**
     * Test start() method
     */
    @Test
    public void testStart() {
        gameEngine.addPlayer("test_1");
        gameEngine.addPlayer("test_2");

        fixture.start();

        assertEquals(6, gameEngine.getPlayers().get(0).getTiles().size());
        assertEquals(6, gameEngine.getPlayers().get(1).getTiles().size());
        assertEquals(94, gameEngine.getTilePile().size());
        assertEquals(106, gameEngine.getBoard().getEmptyCells().size());
    }
}
