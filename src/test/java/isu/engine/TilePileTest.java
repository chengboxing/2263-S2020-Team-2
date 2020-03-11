package isu.engine;


import isu.engine.TilePile;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;



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
        assertTrue(fixture.size() == 108);
    }
    /*
    *
    * Test of size after calling getRandomTile() method.
    *
    * */
    @Test
    public void testSize_1(){
        for(int i  = 0; i < 7; i++){
            fixture.getRandomTile();
        }
        assertFalse("Size incorrect after calling getRandomIndex()", fixture.size() == 100 );
    }


}

