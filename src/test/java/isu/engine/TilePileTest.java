package isu.engine;


import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import java.lang.reflect.Method;


public class TilePileTest {
    private TilePile fixture;

    public TilePileTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        fixture = new TilePile();
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of size for the TilePile list.
     */
    @Test
    public void testSize_0() {
        assertEquals(108, fixture.size());
    }
    /*
    *
    * Test of size after calling getRandomTile() method.
    *
    * */
    @Test
    public void testSize_1(){
        for(int i  = 0; i < 7; i++){
            fixture.pullRandomTile();
        }
        assertNotEquals("Size incorrect after calling getRandomIndex()", 100, fixture.size());
    }
    /**
     * Test getRandomIndex() method
     */
    @Test
    public void testGetRandomIndex() throws Exception {
        Class<TilePile> class1 = TilePile.class;
        Method getRandomIndex = class1.getDeclaredMethod("getRandomIndex");
        getRandomIndex.setAccessible(true);
        int invoke = (int) getRandomIndex.invoke(fixture);

        assertTrue(invoke >= 0 && invoke < fixture.size());
    }
    /**
     * Test pullRandomTile() method
     */
    @Test
    public void testPullRandomTile(){
        fixture.pullRandomTile();
        fixture.pullRandomTile();

        assertEquals(106, fixture.size());
    }
}

