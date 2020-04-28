package isu.engine.manager;

import static org.junit.Assert.*;

import isu.engine.GameEngine;
import isu.engine.Tile;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import java.lang.reflect.Method;
import java.lang.reflect.Field;

public class PhaseManagerTest {
    private GameEngine gameEngine;
    private PhaseManager fixture;
    private Tile tile1;
    private Tile tile2;

    public PhaseManagerTest() {
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
        fixture = new PhaseManager(gameEngine);
        tile1 = new Tile(1,1);
        tile2 = new Tile(1,7);
    }

    @After
    public void tearDown() {
    }

    /**
     * Test doTilePhase() method
     */
    @Test
    public void testDoTilePhase() throws Exception {
        fixture.doTilePhase();

        Class<PhaseManager> class1 = PhaseManager.class;
        Field currentPhase = class1.getDeclaredField("currentPhase");
        currentPhase.setAccessible(true);

        assertSame(currentPhase.get(fixture), PhaseName.TILE);
    }
    /**
     * Test doMergePhase(Tile t) method,
     * when the condition cannot merge
     */
    @Test
    public void testDoMergePhase_0() throws Exception {
        for (int i = 0; i < 5; i++){
            gameEngine.getHotelChains()[0].addTile(new Tile(i,0));
        }
        for (int j = 0; j < 3; j++){
            gameEngine.getHotelChains()[1].addTile(new Tile(j,2));
        }

        fixture.doMergePhase(tile2);

        Class<PhaseManager> class1 = PhaseManager.class;
        Field currentPhase = class1.getDeclaredField("currentPhase");
        currentPhase.setAccessible(true);

        assertSame(currentPhase.get(fixture), PhaseName.MERGE);

    }
    /**
     * Test doMergePhase(Tile t) method,
     * when the condition can merge
     */
    @Test
    public void testDoMergePhase_1() throws Exception {
        for (int i = 0; i < 5; i++){
            gameEngine.getHotelChains()[0].addTile(new Tile(i,0));
        }
        for (int j = 0; j < 3; j++){
            gameEngine.getHotelChains()[1].addTile(new Tile(j,2));
        }

        fixture.doMergePhase(tile1);

        Class<PhaseManager> class1 = PhaseManager.class;
        Field currentPhase = class1.getDeclaredField("currentPhase");
        currentPhase.setAccessible(true);

        assertSame(currentPhase.get(fixture), PhaseName.PURCHASE);

    }
    /**
     * Test doPurchasePhase() method
     */
    @Test
    public void testDoPurchasePhase() throws Exception {
        fixture.doPurchasePhase();

        Class<PhaseManager> class1 = PhaseManager.class;
        Field currentPhase = class1.getDeclaredField("currentPhase");
        currentPhase.setAccessible(true);

        assertSame(currentPhase.get(fixture), PhaseName.PURCHASE);
    }
    /**
     * Test doEndPhase() method
     */
    @Test
    public void testDoEndPhase() throws Exception {
        fixture.doEndPhase();

        Class<PhaseManager> class1 = PhaseManager.class;
        Field currentPhase = class1.getDeclaredField("currentPhase");
        currentPhase.setAccessible(true);

        assertSame(currentPhase.get(fixture), PhaseName.END);
    }
}
