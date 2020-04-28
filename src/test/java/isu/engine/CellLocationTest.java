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

        assertEquals(2, fixture.getRowIndex());
    }

    /**
     * Test getColumnIndex method
     *
     * */
    @Test
    public void testGetColumnIndex(){

        assertEquals(3, fixture.getColumnIndex());
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
     * Test getLabel method
     *
     * */
    @Test
    public void testGetLabel(){

        assertEquals("4C", fixture.getLabel());
    }
}
