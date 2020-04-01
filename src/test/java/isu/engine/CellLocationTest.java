package isu.engine;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class CellLocationTest {
    private CellLocation fixture;

    public CellLocationTest(){
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        fixture = new CellLocation(2,3);
    }

    @After
    public void tearDown() {
    }

    /**
     * Test getRowIndex method
     *
     * */
    @Test
    public void testGetRowIndex() {

        assertTrue(fixture.getRowIndex() == 2);
    }

    /**
     * Test getColumnIndex method
     *
     * */
    @Test
    public void testGetColumnIndex(){

        assertTrue(fixture.getColumnIndex() == 3);
    }
    /**
     * Test getColumnIndex method
     *
     * */
    @Test
    public void testGetRowChar(){

        assertEquals('C', fixture.getRowChar());
    }
    /**
     * Test getTileLabel method
     *
     * */
    @Test
    public void testGetTileLabel(){

        assertEquals("4C", fixture.getTileLabel());
    }
}
