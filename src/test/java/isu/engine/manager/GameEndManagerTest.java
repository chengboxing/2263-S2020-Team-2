package isu.engine.manager;

import static org.junit.Assert.*;

import isu.engine.GameEngine;
import isu.engine.Tile;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class GameEndManagerTest {
    private GameEngine gameEngine;
    private GameEndManager fixture;

    public GameEndManagerTest() {
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
        fixture = new GameEndManager(gameEngine);
    }

    @After
    public void tearDown() {
    }

    /**
     * Test endGame() method
     */
    @Test
    public void testEndGame() {

    }
    /**
     * Test getWinner() method
     */
    @Test
    public void testGetWinner() {
        gameEngine.addPlayer("test_1");
        gameEngine.addPlayer("test_2");

        gameEngine.getPlayers().get(0).addMoney(3000);
        gameEngine.getPlayers().get(1).addMoney(1000);

        assertSame(gameEngine.getPlayers().get(0), fixture.getWinner());
    }
    /**
     * Test isGameReadyToFinish() method,
     * When there is just one chain exist on the board, this chain is safe
     */
    @Test
    public void testIsGameReadyToFinish_0() {

        for (int i = 0; i < 5; i++){
            for (int j = 0; j < 5; j++){
                gameEngine.getHotelChains()[0].addTile(new Tile(i, j));
            }
        }

        assertTrue(fixture.isGameReadyToFinish());
    }
    /**
     * Test isGameReadyToFinish() method,
     * There are two chains, one is safe and another one is not safe
     */
    @Test
    public void testIsGameReadyToFinish_1() {

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                gameEngine.getHotelChains()[0].addTile(new Tile(i, j));
            }
        }

        assertTrue(fixture.isGameReadyToFinish());

        for (int i = 0; i < 3; i++){
            for (int j = 6; j < 9; j++){
                gameEngine.getHotelChains()[1].addTile(new Tile(i, j));
            }
        }

        assertFalse(fixture.isGameReadyToFinish());
    }
    /**
     * Test isGameReadyToFinish() method,
     * There are two chains, one is not safe and another one's size is 45.
     */
    @Test
    public void testIsGameReadyToFinish_2() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                gameEngine.getHotelChains()[0].addTile(new Tile(i, j));
            }
        }

        assertFalse(fixture.isGameReadyToFinish());

        for (int i = 0; i < 9; i++){
            for (int j = 5; j < 10; j++){
                gameEngine.getHotelChains()[1].addTile(new Tile(i, j));
            }
        }

        assertTrue(fixture.isGameReadyToFinish());
    }
    /**
     * Test isGameReadyToFinish() method,
     * There are two chains, one is safe and another one is also safe
     */
    @Test
    public void testIsGameReadyToFinish_3() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 3; j++) {
                gameEngine.getHotelChains()[0].addTile(new Tile(i, j));
            }
        }
        assertTrue(fixture.isGameReadyToFinish());

        for (int i = 0; i < 4; i++) {
            for (int j = 5; j < 8; j++) {
                gameEngine.getHotelChains()[0].addTile(new Tile(i, j));
            }
        }
        assertTrue(fixture.isGameReadyToFinish());
    }
}
