package week02.collections;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * This stack implements the Iterable interface to hide implementation details.
 * An Iterable is a structure that provides some way of iterating over it, generally
 * with an Iterator object.
 */
public class StackWithIterator<Item> implements Iterable<Item> {

    private Node first = null;

    private class Node {
        Item item;
        Node next;
    }

    @Override
    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Item> {

        private Node current = first;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Item next() {
            if(!hasNext()) {
                throw new NoSuchElementException("No next item!");
            }
            Item item = current.item;
            current = current.next;
            return item;
        }
    }
}
