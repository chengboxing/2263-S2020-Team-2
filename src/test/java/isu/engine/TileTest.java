package isu.engine;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;

public class TileTest {
    private Tile tile1;
    private GameEngine gameEngine;

    public TileTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        tile1 = new Tile(1,2);
        gameEngine = new GameEngine();
    }

    @After
    public void tearDown() {
    }

    /**
     * Test getChain() method
     */
    @Test
    public void testGetChain() {

        gameEngine.getHotelChains()[0].addTile(tile1);
        assertEquals(gameEngine.getHotelChains()[0], tile1.getChain());
    }

    /**
     * Test setChain(HotelChain chain) method
     */
    @Test
    public void testSetChain() {

        gameEngine.getHotelChains()[0].addTile(tile1);
        assertEquals(gameEngine.getHotelChains()[0], tile1.getChain());

        tile1.setChain(gameEngine.getHotelChains()[1]);
        assertEquals(gameEngine.getHotelChains()[1], tile1.getChain());
    }

    /**
     * Test getColor() method
     */
    @Test
    public void testGetColor() {
        assertSame(tile1.getColor(), Color.GRAY);

        gameEngine.getHotelChains()[0].addTile(tile1);
        assertSame(tile1.getColor(), GameEngine.BROWN);

        tile1.setChain(gameEngine.getHotelChains()[1]);
        assertSame(tile1.getColor(), GameEngine.PURPLE);

        tile1.setChain(gameEngine.getHotelChains()[4]);
        assertSame(tile1.getColor(), Color.GREEN);
    }
}
