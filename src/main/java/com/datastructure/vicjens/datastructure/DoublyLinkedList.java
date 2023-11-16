package com.datastructure.vicjens.datastructure;

import org.jetbrains.annotations.NotNull;

import java.util.Collection;
import java.util.Iterator;

public class DoublyLinkedList<T>  implements Iterable<T>{
    private DoublyLinkedListNode<T> head;
    private DoublyLinkedListNode<T> tail;
    private int count = 0;

    public DoublyLinkedListNode<T> getHead() {
        return head;
    }

    private void setHead(DoublyLinkedListNode<T> head) {
        this.head = head;
    }

    public DoublyLinkedListNode<T> getTail() {
        return tail;
    }

    private void setTail(DoublyLinkedListNode<T> tail) {
        this.tail = tail;
    }

    public void addHead(T value) {
        addHead(new DoublyLinkedListNode<T>(value));
    }

    public void addHead(DoublyLinkedListNode<T> node) {
        DoublyLinkedListNode<T> temp = head;
        head = node;
        head.setNext(temp);

        if (count == 0) {
            tail = head;
        } else {
            temp.setPrevious(head);
        }

        count++;
    }


    public void addTail(T value) {
        addTail(new DoublyLinkedListNode<T>(value));
    }

    public void addTail(DoublyLinkedListNode<T> node) {
        if (count == 0) {
            head = node;
        } else {
            tail.setNext(node);
            node.setPrevious(tail);
        }

        tail = node;
        count++;
    }

    public void removeHead() {
        if (count != 0) {
            // Before: Head -> 3 <-> 5
            // After:  Head -------> 5

            // Head -> 3 -> null
            // Head ------> null
            head = head.getNext();

            count--;

            if (count == 0) {
                tail = null;
            } else {
                // 5.Previous was 3, now null
                head.setPrevious(null);
            }
        }
    }

    /**
     * Removes the last node from the list
     */
    public void removeTail() {
        if (count != 0) {
            if (count == 1) {
                head = null;
                tail = null;
            } else {
                // Before: Head --> 3 --> 5 --> 7
                //         Tail = 7
                // After:  Head --> 3 --> 5 --> null
                //         Tail = 5
                // Null out 5's Next pointer
                tail.getPrevious().setNext(null);
                tail = tail.getPrevious();
            }

            count--;
        }
    }
    public int getCount() {
        return count;
    }

    public void add(T item) {
        addHead(item);
    }

    public DoublyLinkedListNode<T> find(T item) {
        DoublyLinkedListNode<T> current = head;
        while (current != null) {
            if (current.getValue().equals(item)) {
                return current;
            }
            current = current.getNext();
        }
        return null;
    }

    public boolean contains(T item) {
        return find(item) != null;
    }

    public void copyTo(T[] array, int arrayIndex) {
        DoublyLinkedListNode<T> current = head;
        while (current != null) {
            array[arrayIndex++] = current.getValue();
            current = current.getNext();
        }
    }

    public boolean isReadOnly() {
        return false;
    }

    public boolean remove(T item) {
        DoublyLinkedListNode<T> found = find(item);
        if (found == null) {
            return false;
        }

        DoublyLinkedListNode<T> previous = found.getPrevious();
        DoublyLinkedListNode<T> next = found.getNext();

        if (previous == null) {
            // we're removing the head node
            head = next;
            if (head != null) {
                head.setPrevious(null);
            }
        } else {
            previous.setNext(next);
        }

        if (next == null) {
            // we're removing the tail
            tail = previous;
            if (tail != null) {
                tail.setNext(null);
            }
        } else {
            next.setPrevious(previous);
        }

        count--;

        return true;
    }
    @NotNull
    public Iterator<T> iterator() {
        return new DoublyLinkedListIterator();
    }

    public Iterator<T> getReverseIterator() {
        return new ReverseDoublyLinkedListIterator();
    }

    private class DoublyLinkedListIterator implements Iterator<T> {
        private DoublyLinkedListNode<T> current = head;

        public boolean hasNext() {
            return current != null;
        }

        public T next() {
            T value = current.getValue();
            current = current.getNext();
            return value;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
    private class ReverseDoublyLinkedListIterator implements Iterator<T> {

        private DoublyLinkedListNode<T> current = tail;

        public boolean hasNext() {
            return current != null;
        }

        public T next() {
            T value = current.getValue();
            current = current.getPrevious();
            return value;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

        public Iterator<T> iterator() {
            return this;
        }
    }

    public void Clear() {
        head = null;
        tail = null;
        count = 0;
    }

    public boolean GetHead(T[] value) {
        if (count > 0) {
            value[0] = head.getValue();
            return true;
        }

        value[0] = null;
        return false;
    }

    public boolean GetTail(T[] value) {
        if (count > 0) {
            value[0] = tail.getValue();
            return true;
        }

        value[0] = null;
        return false;
    }




}
