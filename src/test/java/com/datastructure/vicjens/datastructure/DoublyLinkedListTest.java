package com.datastructure.vicjens.datastructure;

import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class DoublyLinkedListTest {
    @Test
    public void initializeEmptyTest() {
        DoublyLinkedList<Integer> ints = new DoublyLinkedList<>();
        assertEquals(0, ints.getCount());
    }

    @Test
    public void addHeadTest() {
        DoublyLinkedList<Integer> ints = new DoublyLinkedList<>();
        for (int i = 1; i <= 5; i++) {
            ints.addHead(i);
            assertEquals(i, ints.getCount());
        }

        int expected = 5;
        for (int x : ints) {
            assertEquals(expected--, x);
        }
    }

    @Test
    public void addTailTest() {
        DoublyLinkedList<Integer> ints = new DoublyLinkedList<>();
        for (int i = 1; i <= 5; i++) {
            ints.addTail(i);
            assertEquals(i, ints.getCount());
        }

        int expected = 1;
        for (int x : ints) {
            assertEquals(expected++, x);
        }
    }

    @Test
    public void removeTest() {
        DoublyLinkedList<Integer> delete1to10 = create(1, 10);
        assertEquals(10, delete1to10.getCount());

        for (int i = 1; i <= 10; i++) {
            assertTrue(delete1to10.remove(i));
            assertFalse(delete1to10.remove(i));
        }

        assertEquals(0, delete1to10.getCount());

        DoublyLinkedList<Integer> delete10to1 = create(1, 10);
        assertEquals(10, delete10to1.getCount());

        for (int i = 10; i >= 1; i--) {
            assertTrue(delete10to1.remove(i));
            assertFalse(delete10to1.remove(i));
        }

        assertEquals(0, delete10to1.getCount());
    }

    @Test
    public void containsTest() {
        DoublyLinkedList<Integer> ints = create(1, 10);
        for (int i = 1; i <= 10; i++) {
            assertTrue(ints.contains(i));
        }

        assertFalse(ints.contains(0));
        assertFalse(ints.contains(11));
    }

    @Test
    public void reverseIteratorTest() {
        DoublyLinkedList<Integer> ints = create(1, 10);
        int expected = 10;
        Iterable<Integer> iterable = ints::getReverseIterator;
        for (int actual : iterable) {
            assertEquals(expected--, actual);
        }
    }

    private DoublyLinkedList<Integer> create(int start, int end) {
        DoublyLinkedList<Integer> ints = new DoublyLinkedList<>();
        for (int i = start; i <= end; i++) {
            ints.addTail(i);
        }

        return ints;
    }
}