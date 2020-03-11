package isu.util;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class CircularlyLinkedListTest {
    private CircularlyLinkedList<Integer> fixture;

    public CircularlyLinkedListTest() {

    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        fixture = (CircularlyLinkedList<Integer>) new CircularlyLinkedList();
    }

    @After
    public void tearDown() {
    }

    /*
    *
    * Tests the getFirst() method.
    * */
    @Test
    public void testGetFirst(){
        fixture.addFirst(6);
        fixture.addFirst(8);

        assertTrue(fixture.getFirst() == 8);
    }
    /*
    *
    * Tests the getLast() method & size() method.
    *
    * */
    @Test
    public void testGetLast(){
        fixture.addFirst(1);
        fixture.addFirst(2);
        fixture.addFirst(3);
        fixture.addFirst(4);

        assertFalse("Size is incorrect", fixture.isEmpty());
        assertTrue(fixture.getLast() == 1);
    }
    /*
    *
    * Tests the size() method.
    *
    * */
    @Test
    public void testGetSize_0(){
        fixture.addFirst(7);
        fixture.addLast(4);
        fixture.insert(2, 0);
        fixture.removeFirst();

        assertTrue(fixture.size() == 2);
    }
    /*
     *
     * Tests the size() method.
     *
     * */
    @Test
    public void testGetSize_1(){
        fixture.addFirst(null);

        assertFalse("size increases when null is added", fixture.size() == 1);
    }


}
