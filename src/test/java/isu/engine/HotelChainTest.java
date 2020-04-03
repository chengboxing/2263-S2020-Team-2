package isu.engine;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class HotelChainTest {

    private HotelChain fixture;
    private Tile tile1;
    private Tile tile2;
    private List<Tile> tiles;

    public HotelChainTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        fixture = new HotelChain("Test", HotelChainCategory.CHEAP, "Pink");
        tile1 = new Tile(1, 1);
        tile2 = new Tile(1, 2);
        tiles = new ArrayList<>();
    }

    @After
    public void tearDown() {
    }

    /**
     * Test getName method.
     */
    @Test
    public void testGetName() {
        assertEquals("Test", fixture.getName());
    }

    /**
     * Test getCategory method.
     */
    @Test
    public void testGetCategory() {
        assertEquals(HotelChainCategory.CHEAP, fixture.getCategory());
    }

    /**
     * Test getColor method.
     */
    @Test
    public void testGetColor() {
        assertEquals("Pink", fixture.getColor());
    }

    /**
     * Test size method.
     */
    @Test
    public void testSize() {
        fixture.addTile(tile1);

        assertEquals(1, fixture.size());
    }

    /**
     * Test getStockPrice method.
     */
    @Test
    public void testGetStockPrice() {
        fixture.addTile(tile1);
        fixture.addTile(tile2);

        assertEquals(200, fixture.getStockPrice());
    }

    /**
     * Test getFirstBonus method.
     */
    @Test
    public void testGetFirstBonus() {
        fixture.addTile(tile1);
        fixture.addTile(tile2);

        assertEquals(2000, fixture.getFirstBonus());
    }

    /**
     * Test getSecondBonus method.
     */
    @Test
    public void testGetSecondBonus() {
        fixture.addTile(tile1);
        fixture.addTile(tile2);

        assertEquals(1000, fixture.getSecondBonus());
    }

    /**
     * Test isActive method.
     */
    @Test
    public void testIsActive() {
        fixture.addTile(tile1);
        fixture.addTile(tile2);

        assertTrue(fixture.isActive());
    }

    /**
     * Test addTiles method.
     */
    @Test
    public void testAddTiles() {
        tiles.add(tile1);
        tiles.add(tile2);
        fixture.addTiles(tiles);

        assertEquals(2, fixture.size());
    }

    /**
     * Test getTiles method.
     */
    @Test
    public void testGetTiles() {
        tiles.add(tile1);
        tiles.add(tile2);
        fixture.addTiles(tiles);

        assertEquals(tile1, fixture.getTiles().get(0));
        assertEquals(tile2, fixture.getTiles().get(1));
    }

    /**
     * Test getTile method.
     */
    @Test
    public void testGetTile() {

    }
}
