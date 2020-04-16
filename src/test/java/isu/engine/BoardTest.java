package isu.engine;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.rules.ExpectedException;

import java.util.ArrayList;

public class BoardTest {
    private Board fixture;
    private Tile tile1;
    private Tile tile2;
    private Tile tile3;
    private Tile tile4;

    public BoardTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        fixture = new Board();
        tile1 = new Tile(1, 1);
        tile2 = new Tile(2, 1);
        tile3 = new Tile(2, 2);
        tile4 = new Tile(1,2);
    }

    @After
    public void tearDown() {
    }

    /**
     * Test getCell() method which take in two integers.
     */
    @Test
    public void testGetCell_0() {
        assertNotNull(fixture.getCell(1,2));
    }
    /**
     * Test getCell() method which take in two integers.
     */
    @Test
    public void testGetCell_1(){
        assertNull(fixture.getCell(-1, 2));
    }
    /**
     * Test getCell() method which take in char for letter and integer .
     */
    @Test
    public void testGetCell_2() {
        assertEquals(fixture.getCell(0,0), fixture.getCell('A', 0));
    }
    /**
     * Test getCell() method which take in a String.
     */
    @Test
    public void testGetCell_3() {
        System.out.println(fixture.getCell('A', 0));
        //System.out.println(fixture.getCell("A1"));

        //assertEquals(fixture.getCell('A', 0), fixture.getCell("A0"));
    }
    /**
     * Test placeTile() method.
     */
    @Test
    public void testPlaceTile() {

        fixture.placeTile(tile1);

    }
    /**
     * Test getEmptyCells() method.
     */
    @Test
    public void testGetEmptyCells() {
        assertEquals(108, fixture.getEmptyCells().size());
        fixture.placeTile(tile1);
        assertEquals(107, fixture.getEmptyCells().size());
    }
    /**
     * Test getOccupiedCells() method.
     */
    @Test
    public void testGetOccupiedCells() {
        assertEquals(0, fixture.getOccupiedCells().size());
        fixture.placeTile(tile1);
        assertEquals(1, fixture.getOccupiedCells().size());
    }
    /**
     * Test getNeighboringTiles() method.
     */
    @Test
        public void testGetNeighboringTiles() {
        fixture.placeTile(tile1);
        assertEquals(0, fixture.getNeighboringTiles(tile1).size());

        fixture.placeTile(new Tile(1, 0));
        fixture.placeTile(new Tile(2, 1));
        assertEquals(2, fixture.getNeighboringTiles(tile1).size());

    }
    /**
     * Test getNeighboringChains() method.
     */
    @Test
    public void testGetNeighboringChains() {
        assertEquals(0, fixture.getNeighboringTiles(tile1).size());
        ArrayList<Tile> tiles = new ArrayList<>();
        tiles.add(tile2);
        tiles.add(tile3);

        GameEngine.GAME_ENGINE.getHotelChains()[0].addTiles(tiles);
        fixture.placeTile(tile1);
        fixture.placeTile(tile2);

        assertEquals(1, fixture.getNeighboringChains(tile1).size());

    }
    /**
     * Test canPlayTile() method.
     */
    @Test
    public void testCanPlayTile_0() {
        ArrayList<Tile> tiles = new ArrayList<>();
        tiles.add(tile2);
        tiles.add(tile3);

        GameEngine.GAME_ENGINE.getHotelChains()[0].addTiles(tiles);
        fixture.placeTile(tile1);
        fixture.placeTile(tile2);

        assertTrue(fixture.canPlayTile(tile1));
    }
    /**
     * Test canPlayTile() method.
     */
    @Test
    public void testCanPlayTile_1() {
    }
    /*
     * Testing illegalArgumentException for getCell() method.
     *
     * */
    @Test (expected = ArrayIndexOutOfBoundsException.class)
    public void testGetCellArrayIndexOutOfBoundsException() throws ArrayIndexOutOfBoundsException{
        fixture.getCell('A', -1);
    }
}
