package isu.engine.manager;

import static org.junit.Assert.*;
import java.util.ArrayList;
import isu.engine.HotelChain;
import isu.engine.Tile;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;

import isu.engine.GameEngine;

public class MergeManagerTest {

    private GameEngine gameEngine;
    private MergeManager fixture;
    private Tile tile1;
    private Tile tile2;

    public MergeManagerTest() {
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
        fixture = new MergeManager(gameEngine);
        tile1 = new Tile(1,1);
        tile2 = new Tile(1,7);
    }

    @After
    public void tearDown() {
    }

    /**
     * Test checkMerge(Tile t) method,
     * when mergingChains's size is equal to 0
     */
    @Test
    public void testCheckMerge_0() {

        for (int i = 0; i < 5; i++){
            gameEngine.getHotelChains()[0].addTile(new Tile(i,0));
        }
        for (int j = 0; j < 3; j++){
            gameEngine.getHotelChains()[1].addTile(new Tile(j,2));
        }

        assertFalse(fixture.checkMerge(tile2));
    }
    /**
     * Test checkMerge(Tile t) method,
     * when mergingChains's size is equal to 1
     */
    @Test
    public void testCheckMerge_1() {
        for (int i = 0; i < 5; i++){
            gameEngine.getHotelChains()[0].addTile(new Tile(i,0));
        }

        assertFalse(fixture.checkMerge(tile1));
        assertEquals(6, gameEngine.getHotelChains()[0].size());
        // When tile1 is (1,0) or (0,1), the test will be wrong, because (1-1, 0-1) = (0,-1), (0-1,1-1) = (-1,0)
    }
    /**
     * Test checkMerge(Tile t) method,
     * when mergingChains's size is larger than 2 or equal to 2
     */
    @Test
    public void testCheckMerge_2() {
        for (int i = 0; i < 5; i++){
            gameEngine.getHotelChains()[0].addTile(new Tile(i,0));
        }
        for (int j = 0; j < 3; j++){
            gameEngine.getHotelChains()[1].addTile(new Tile(j,2));
        }

        assertTrue(fixture.checkMerge(tile1));
        assertEquals(9, gameEngine.getHotelChains()[0].size());
        assertEquals(0, gameEngine.getHotelChains()[1].size());
        // Add a test for player.getMoney
    }
    /**
     * Test merge() method
     */
    @Test
    public void testMerge() throws Exception{
        for (int i = 0; i < 5; i++){
            gameEngine.getHotelChains()[0].addTile(new Tile(i,0));
        }
        for (int j = 0; j < 3; j++){
            gameEngine.getHotelChains()[1].addTile(new Tile(j,2));
        }

//        Class<MergeManager> class1 = MergeManager.class;
//        Method findMergingChains = class1.getDeclaredMethod("findMergingChains", Tile.class);
//        findMergingChains.setAccessible(true);
//        findMergingChains.invoke(fixture, tile1);
//
//        Field mergingChains = class1.getDeclaredField("mergingChains");
//        mergingChains.setAccessible(true);
//
//        Class<MergeManager> class2 = MergeManager.class;
//        Method findSurvivingChain = class2.getDeclaredMethod("findSurvivingChain", ArrayList.class);
//        findSurvivingChain.setAccessible(true);
//        findSurvivingChain.invoke(fixture, mergingChains.get(fixture));

//        fixture.merge();
//        assertEquals(9, gameEngine.getHotelChains()[0].size());
    }
    /**
     * Test findMergingChains(Tile t) method
     */
    @Test
    public void testFindMergingChains() throws Exception{
        for (int i = 0; i < 5; i++){
            gameEngine.getHotelChains()[0].addTile(new Tile(i,0));
        }
        for (int j = 0; j < 3; j++){
            gameEngine.getHotelChains()[1].addTile(new Tile(j,2));
        }

        Class<MergeManager> class1 = MergeManager.class;
        Method findMergingChains = class1.getDeclaredMethod("findMergingChains", Tile.class);
        findMergingChains.setAccessible(true);
        findMergingChains.invoke(fixture, tile1);

        Field mergingChains = class1.getDeclaredField("mergingChains");
        mergingChains.setAccessible(true);

        ArrayList<HotelChain> testMergingChains = new ArrayList<>();

        testMergingChains.add(gameEngine.getHotelChains()[0]);
        testMergingChains.add(gameEngine.getHotelChains()[1]);

        assertEquals(testMergingChains, mergingChains.get(fixture));
    }
    /**
     * Test findSurvivingChain(ArrayList<HotelChain> chains) method,
     * when one chain's size is 5 and another chain's size is 3
     */
    @Test
    public void testFindSurvivingChain_0() throws Exception{

        for (int i = 0; i < 5; i++){
            gameEngine.getHotelChains()[0].addTile(new Tile(i,0));
        }
        for (int j = 0; j < 3; j++){
            gameEngine.getHotelChains()[1].addTile(new Tile(j,2));
        }

        Class<MergeManager> class1 = MergeManager.class;
        Method findMergingChains = class1.getDeclaredMethod("findMergingChains", Tile.class);
        findMergingChains.setAccessible(true);
        findMergingChains.invoke(fixture, tile1);

        Field mergingChains = class1.getDeclaredField("mergingChains");
        mergingChains.setAccessible(true);

        Class<MergeManager> class2 = MergeManager.class;
        Method findSurvivingChain = class2.getDeclaredMethod("findSurvivingChain", ArrayList.class);
        findSurvivingChain.setAccessible(true);
        findSurvivingChain.invoke(fixture, mergingChains.get(fixture));

        Field survivingChain = class1.getDeclaredField("survivingChain");
        survivingChain.setAccessible(true);

        assertNotNull(survivingChain.get(fixture));
    }
    /**
     * Test findSurvivingChain(ArrayList<HotelChain> chains) method,
     * when one chain's size is 5 and another chain's size is also 5
     */
    @Test
    public void testFindSurvivingChain_1() throws Exception{
        for (int i = 0; i < 5; i++){
            gameEngine.getHotelChains()[0].addTile(new Tile(i,0));
        }
        for (int j = 0; j < 5; j++){
            gameEngine.getHotelChains()[1].addTile(new Tile(j,2));
        }

        Class<MergeManager> class1 = MergeManager.class;
        Method findMergingChains = class1.getDeclaredMethod("findMergingChains", Tile.class);
        findMergingChains.setAccessible(true);
        findMergingChains.invoke(fixture, tile1);

        Field mergingChains = class1.getDeclaredField("mergingChains");
        mergingChains.setAccessible(true);

        Class<MergeManager> class2 = MergeManager.class;
        Method findSurvivingChain = class2.getDeclaredMethod("findSurvivingChain", ArrayList.class);
        findSurvivingChain.setAccessible(true);
        findSurvivingChain.invoke(fixture, mergingChains.get(fixture));

        Field survivingChain = class1.getDeclaredField("survivingChain");
        survivingChain.setAccessible(true);

        assertNull(survivingChain.get(fixture));
    }
}
