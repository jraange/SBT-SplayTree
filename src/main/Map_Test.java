package main;

import junit.framework.TestCase;

// Tests!!!

public class Map_Test extends TestCase {
    public void testJust() {
        checkJust(2, 1, 1);
        checkJust(0, 1, 1);
        checkJust(-1, -1, -1);
        checkJust(23123213, 1, 1);
    }

    public void checkJust(Integer K, Integer V, Integer A) {
        SplayMap<Integer, Integer> st1 = new SplayMap<Integer, Integer>();
        st1.put(K, V);
        assertTrue(st1.get(K) == A);
    }
     public void testSize(){
         SplayMap<Integer, Integer> st1 = new SplayMap<Integer, Integer>();
         assertTrue(st1.size()==0);
         st1.put(1,3);
         st1.put(2,3);
         assertTrue(st1.size()==2);
     }

    public void testRemove() {
        SplayMap<Integer, Integer> st1 = new SplayMap<Integer, Integer>();
        st1.put(1, 2);
        st1.put(2, 1);
        assertTrue(st1.size() == 2);
        st1.remove(1);
        assertTrue(st1.size() == 1);
    }


    public void testClear() {
        SplayMap<Integer, Integer> st1 = new SplayMap<Integer, Integer>();
        st1.put(1, 2);
        st1.put(2, 3);
        st1.put(3, 4);
        assertTrue(st1.size() == 3);
        st1.clear();
        assertTrue(st1.size() == 0);
    }

    public void testIsEmpty() {
        SplayMap<Integer, Integer> st1 = new SplayMap<Integer, Integer>();
        assertTrue(st1.isEmpty());
        st1.put(1, 2);
        assertTrue(!st1.isEmpty());
    }


    //Test left turn - line of decreas elements
    public void testLeft() {
        SplayMap<Integer, Integer> st1 = new SplayMap<Integer, Integer>();
        st1.put(1, 5);
        st1.put(2, 4);
        st1.put(3, 3);
        st1.put(4, 2);
        st1.put(5, 1);
        assertTrue(st1.size() == 5);
        assertTrue(st1.get(4) == 2);
    }

    // Same for right turn
    public void testRight() {
        SplayMap<Integer, Integer> st1 = new SplayMap<Integer, Integer>();
        st1.put(1, 1);
        st1.put(2, 2);
        st1.put(3, 3);
        st1.put(4, 4);
        st1.put(5, 5);
        assertTrue(st1.size() == 5);
        assertTrue(st1.get(4) == 4);
    }
    // Ok, try to duplicate some key

    public void testDupl() {
        SplayMap<Integer, Integer> st1 = new SplayMap<Integer, Integer>();
        st1.put(5, 7);
        st1.put(5, 8);
        assertTrue(st1.get(5) == 8);
    }

    // Test duplicate value. Its may be problem for Splay tree)
    public void testDuplValue() {
        SplayMap<Integer, Integer> st1 = new SplayMap<Integer, Integer>();
        st1.put(7, 5);
        st1.put(6, 5);
        st1.put(2, 5);
        st1.put(3, 5);
        st1.put(4, 5);
        assertTrue(st1.size() == 5);
        assertTrue(st1.get(2) == 5);
    }
}
