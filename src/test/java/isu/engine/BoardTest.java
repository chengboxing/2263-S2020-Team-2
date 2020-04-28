package isu.engine;

import isu.engine.manager.MergeManager;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.rules.ExpectedException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class BoardTest {
    private Board fixture;
    private Tile tile1;
    private Tile tile2;
    private Tile tile3;
    private Tile tile4;
    private GameEngine gameEngine;

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
        gameEngine = new GameEngine();
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
    @Test (expected = IllegalArgumentException.class)
    public void testGetCell_1() throws IllegalArgumentException{
        fixture.getCell(-1, 2);
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
        assertSame(fixture.getCell('A', 11), fixture.getCell("A11"));
        assertSame(fixture.getCell('A', 1), fixture.getCell("A1"));
    }
    /**
     * Test placeTile() method.
     */
    @Test
    public void testPlaceTile() {

        for (int i = 0; i < 5; i++){
            for (int j = 0; j < 6; j++){
                fixture.placeTile(new Tile(i,j));
            }
        }
        assertEquals(78, fixture.getEmptyCells().size());

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
     * Test getOccupiedCells() method,
     * when tile's number is 1
     */
    @Test
    public void testGetOccupiedCells_0() {
        assertEquals(0, fixture.getOccupiedCells().size());
        fixture.placeTile(tile1);
        assertEquals(1, fixture.getOccupiedCells().size());
    }
    /**
     * Test getOccupiedCells() method,
     * when tiles' number is larger than 1
     */
    @Test
    public void testGetOccupiedCells_1() {
        for (int i = 0; i < 5; i++){
            for (int j = 0; j < 6; j++){
                fixture.placeTile(new Tile(i,j));
            }
        }
        assertEquals(30, fixture.getOccupiedCells().size());
    }
    /**
     * Test getNeighboringTiles() method,
     * Test tile1's neighboring tiles
     */
    @Test
        public void testGetNeighboringTiles() {

        fixture.placeTile(tile1);
        assertEquals(0, fixture.getNeighboringTiles(tile1).size());
        fixture.placeTile(tile2);
        fixture.placeTile(tile4);

        assertEquals(2, fixture.getNeighboringTiles(tile1).size());
        assertEquals(tile2, fixture.getNeighboringTiles(tile1).get(0));
        assertEquals(tile4, fixture.getNeighboringTiles(tile1).get(1));
    }
    /**
     * Test getNeighboringChains() method.,
     * When the tile1's neighboring chain has 1
     */
    @Test
    public void testGetNeighboringChains() {

        assertEquals(0, fixture.getNeighboringChains(tile1).size());

        gameEngine.getHotelChains()[0].addTile(tile2);
        gameEngine.getHotelChains()[0].addTile(tile3);
        fixture.placeTile(tile2);
        fixture.placeTile(tile3);

        assertEquals(1, fixture.getNeighboringChains(tile1).size());
    }
    /**
     * Test canPlayTile() method,
     * when there is no safe chain
     */
    @Test
    public void testCanPlayTile_0() {
        ArrayList<Tile> tiles = new ArrayList<>();
        tiles.add(tile2);
        tiles.add(tile3);
        gameEngine.getHotelChains()[0].addTiles(tiles);
        fixture.placeTile(tile2);
        fixture.placeTile(tile3);

        assertTrue(fixture.canPlayTile(tile1));
    }
    /**
     * Test canPlayTile() method,
     * when there are two safe chains
     */
    @Test
    public void testCanPlayTile_1() {
        ArrayList<Tile> firstTiles = new ArrayList<>();
        for (int a = 0; a < 11; a++){
            firstTiles.add(new Tile(0,a));
        }
        for (int i = 0; i < 11; i++){
            fixture.placeTile(firstTiles.get(i));
        }
        gameEngine.getHotelChains()[0].addTiles(firstTiles);

        ArrayList<Tile> secondTiles = new ArrayList<>();
        for (int a = 0; a < 11; a++){
            secondTiles.add(new Tile(2,a));
        }
        for (int i = 0; i < 11; i++){
            fixture.placeTile(secondTiles.get(i));
        }
        gameEngine.getHotelChains()[1].addTiles(secondTiles);

        assertFalse(fixture.canPlayTile(tile1));
    }
    /*
     * Testing illegalArgumentException for getCell() method.
     *
     * */
    @Test (expected = ArrayIndexOutOfBoundsException.class)
    public void testGetCellArrayIndexOutOfBoundsException() throws ArrayIndexOutOfBoundsException{
        fixture.getCell('A', -1);
    }
    /**
     * Test createTileChain(HotelChain chain, Tile tile) method,
     *When I just place tiles and not set chain for these tiles
     */
    @Test
    public void testCreateTileChain_0(){

        fixture.placeTile(tile2);
        fixture.placeTile(tile3);

        assertNull(tile2.getChain());
        assertNull(tile3.getChain());
    }
    /**
     * Test createTileChain(HotelChain chain, Tile tile) method,
     *When I just place tiles and set chain for these tiles
     */
    @Test
    public void testCreateTileChain_1(){
        fixture.placeTile(tile2);
        fixture.placeTile(tile3);

        fixture.createTileChain(gameEngine.getHotelChains()[0], tile2);
        fixture.createTileChain(gameEngine.getHotelChains()[0], tile3);

        assertNotNull(tile2.getChain());
        assertNotNull(tile3.getChain());
    }
    /**
     * Test tryAddTile(List<Tile> tiles, int ri, int ci) method,
     * When I have placed a tile(1,1) and use this method to get this tile
     */
    @Test
    public void testTryAddTile_0() throws Exception{
        ArrayList<Tile> tiles = new ArrayList<>();
        fixture.placeTile(tile1);

        Class<Board> class1 = Board.class;
        Method tryAddTile = class1.getDeclaredMethod("tryAddTile", List.class, int.class, int.class);
        tryAddTile.setAccessible(true);
        tryAddTile.invoke(fixture, tiles, 1,1);

        assertEquals(1, tiles.size());
    }
    /**
     * Test tryAddTile(List<Tile> tiles, int ri, int ci) method,
     * When I have placed a tile(1,1), but I use this method to get other tile
     */
    @Test
    public void testTryAddTile_1() throws Exception{
        ArrayList<Tile> tiles = new ArrayList<>();
        fixture.placeTile(tile1);

        Class<Board> class1 = Board.class;
        Method tryAddTile = class1.getDeclaredMethod("tryAddTile", List.class, int.class, int.class);
        tryAddTile.setAccessible(true);
        tryAddTile.invoke(fixture, tiles, 0,1);

        assertEquals(0, tiles.size());
    }
}
