package assignment2;

import java.util.Iterator;
import java.util.NoSuchElementException;

/** Iterator does not provide a concurrent implementation. */
public class Deque<Item> implements Iterable<Item> {

    private Node first;
    private Node last;
    private int size;

    public Deque() {
        this.first = null;
        this.last = null;
        this.size = 0;
    }

    public boolean isEmpty()  {
        return size == 0;
    }

    public int size()     {
        return size;
    }

    public void addFirst(Item item)  {
        validateNull(item);
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
        if (oldFirst != null) {
            oldFirst.prev = first;
        }
        if (last == null) {
            last = first;
        }
        size++;
    }

    public void addLast(Item item) {
        validateNull(item);
        Node oldLast = last;
        last = new Node();
        last.item = item;
        last.prev = oldLast;
        if (oldLast != null) {
            oldLast.next = last;
        }
        if (first == null) {
            first = last;
        }
        size++;
    }

    public Item removeFirst()  {
        validateEmpty();
        Item item = first.item;
        first.item = null;
        first = first.next;
        size--;
        if (isEmpty()) {
            last = null;
        }
        return item;
    }

    public Item removeLast()  {
        validateEmpty();
        Item item = last.item;
        last.item = null;
        last = last.prev;
        if (last != null) {
            last.next = null;
        }
        size--;
        if (isEmpty()) {
            first = null;
        }
        return item;
    }

    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    /** Helper methods. */
    private void validateNull(Item item) {
        if (item == null) {
            throw new NullPointerException("Cannot add null element.");
        }
    }

    private void validateEmpty() {
        if (isEmpty()) {
            throw new NoSuchElementException("Attempting to remove an element from an empty Deque.");
        }
    }

//    private void resizeDoubleCheck() {
//        if (isFull()) {
//            resize(2 * items.length);
//        }
//    }
//
//    private void resizeHalfCheck() {
//        int size = last - first;
//        if (size > 0 && size == items.length / 4) {
//            resize(items.length / 2);
//        }
//    }
//
//    private boolean isFull() {
//        return (first <= 0 && items[first] != null) ||
//               (last >= items.length - 1 && items[last] != null);
//    }
//
//    /**
//     * Resizes the items array, by adding the same (almost)
//     * places to the front and back until reaching the capacity.
//     */
//    private void resize(int newCapacity) {
//        int halfCapacity = newCapacity / 2;
//        Item[] temp = (Item[]) new Object[newCapacity];
//        for (int i = 0; i < items.length; i++) {
//            temp[i + halfCapacity] = items[i];
//        }
//        first = first + halfCapacity;
//        last = last + halfCapacity;
//        items = temp;
//    }

    /** Inner classes. */
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

        @Override
        public void remove() {
            throw new UnsupportedOperationException("Cannot remove from this iterator.");
        }
    }

    private class Node {
        Item item;
        Node next;
        Node prev;
    }

    public static void main(String[] args){}
}
