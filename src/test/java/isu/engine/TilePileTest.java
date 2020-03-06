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
     * Test of peek method, of class LinkedDeque.
     */
    @Test
    public void testPeekLast() {
        assertTrue(fixture.size() == 108);

        //assertNull("PeekLast not returning null for an empty deque", fixture.peekLast());
    }

}

