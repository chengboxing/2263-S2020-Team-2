package isu.engine;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class TileTest {
    private Tile fixture;

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
        fixture.setChain(GameEngine.GAME_ENGINE.getHotelChains()[0]);
        assertSame(fixture.getChain(), GameEngine.GAME_ENGINE.getHotelChains()[0]);
    }

    /**
     * Test setChain() method
     */
    @Test
    public void testSetChain() {
        fixture.setChain(GameEngine.GAME_ENGINE.getHotelChains()[0]);
        assertSame(fixture.getChain(), GameEngine.GAME_ENGINE.getHotelChains()[0]);
    }

    /**
     * Test getColor() method
     */
    @Test
    public void testGetColor() {
        fixture.setChain(GameEngine.GAME_ENGINE.getHotelChains()[0]);
        assertEquals("brown", fixture.getColor());
    }
}
