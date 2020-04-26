package isu.engine;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class BoardCellTest {

    private Tile tile1;
    private Tile tile2;
    private BoardCell fixture;

    public BoardCellTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        tile1 = new Tile(1,1);
        tile2 = null;
        fixture = new BoardCell(1,1);
    }

    @After
    public void tearDown() {
    }

    /**
     * Test getTile() method.
     */
    @Test
    public void testGetTile() {
        fixture.setTile(tile1);
        assertEquals(tile1, fixture.getTile());
    }
    /**
     * Test setTile(Tile tile) method.
     */
    @Test
    public void testSetTile() {
        fixture.setTile(tile1);
        assertEquals(tile1, fixture.getTile());
    }
    /**
     * Test isOccupied() method.
     */
    @Test
    public void testIsOccupied_0() {
        assertFalse(fixture.isOccupied());
    }
    /**
     * Test isOccupied() method.
     */
    @Test
    public void testIsOccupied_1() {
        fixture.setTile(tile1);
        assertTrue(fixture.isOccupied());
    }
    /**
     * Test disable() method.
     */
    @Test
    public void testDisable() {
        fixture.disable();
        assertFalse(fixture.isEnabled());
    }
    /**
     * Test isEnabled() method.
     */
    @Test
    public void testIsEnabled() {
        assertTrue(fixture.isEnabled());
    }
    /**
     * Test isDisabled() method.
     */
    @Test
    public void testIsDisabled_0() {
        assertFalse(fixture.isDisabled());
    }
    /**
     * Test isDisabled() method.
     */
    @Test
    public void testIsDisabled_1() {
        fixture.disable();
        assertTrue(fixture.isDisabled());
    }
    /*
     * Testing illegalArgumentException for setTile() method.
     *
     * */
    @Test (expected = IllegalArgumentException.class)
    public void testSetTile1IllegalArgumentException() throws IllegalArgumentException{
        fixture.setTile(tile2);
    }
    /*
     * Testing illegalArgumentException for setTile() method.
     *
     * */
    @Test (expected = IllegalArgumentException.class)
    public void testSetTile2IllegalArgumentException() throws IllegalArgumentException{
        Tile tile3 = new Tile(2,2);
        fixture.setTile(tile3);
    }
}
