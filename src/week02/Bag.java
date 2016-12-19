package week02;

import java.util.Iterator;

/**
 * A generic collection that doesn't hold any particular
 * order of elements.
 *
 * My particular implementation uses a node class as a stack,
 * which is really fast in terms of adding the element, as we don't
 * care about order.
 */
public class Bag<T> implements Iterable<T> {

    private Node first;
    private int size;

    private class Node {
        T item;
        Node next;
    }

    public Bag() {
        this.first = null;
        this.size = 0;
    }

    public void add(T item) {
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
        size++;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return size;
    }


    @Override
    public Iterator<T> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<T> {

        private Node current = first;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public T next() {
            T item = current.item;
            current.item = null;
            current = current.next;
            return item;
        }
    }
}
