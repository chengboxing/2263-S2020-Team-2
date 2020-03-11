package isu.engine;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;


public class PlayerTest {

    private Player fixture;


    public PlayerTest(){
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        fixture = new Player(null);
    }

    @After
    public void tearDown() {
    }

    /*
    *
    * Testing setTiles() method.
    *
    * */
    @Test
    public void testSetTiles(){
        TilePile tilePile = new TilePile();
        fixture.setTiles(6, tilePile);
        assertEquals(6, fixture.getTiles().size());
    }
    /*
    *
    * Testing playTile() method.
    *
    * */
    @Test
    public void testPlayTile(){

    }


}
