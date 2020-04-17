package isu.engine;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class TileTest {
    private Tile fixture;
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
        gameEngine = new GameEngine();
        fixture = new Tile(1,2);
    }

    @After
    public void tearDown() {
    }

    /**
     * Test getChain() method
     */
    @Test
    public void testGetChain() {
        fixture.setChain(gameEngine.getHotelChains()[0]);
        assertSame(fixture.getChain(), gameEngine.getHotelChains()[0]);
    }

    /**
     * Test setChain() method
     */
    @Test
    public void testSetChain() {
        fixture.setChain(gameEngine.getHotelChains()[0]);
        assertSame(fixture.getChain(), gameEngine.getHotelChains()[0]);
    }

    /**
     * Test getColor() method
     */
    @Test
    public void testGetColor() {
        fixture.setChain(gameEngine.getHotelChains()[0]);
        assertEquals("brown", fixture.getColor());
    }
}
