package assignment2;

import edu.princeton.cs.algs4.StdRandom;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by tom on 12/20/16.
 */
public class RandomizedQueue<Item> implements Iterable<Item> {

    private Item[] items;
    private int size;

    public RandomizedQueue()  {
        this.items = (Item[]) new Object[1];
        this.size = 0;
    }

    public boolean isEmpty()  {
        return size == 0;
    }

    public int size()    {
        return size;
    }

    public void enqueue(Item item)  {
        validateNull(item);
        items[size++] = item;
        resizeDoubleCheck();
    }

    public Item dequeue() {
        validateEmpty();
        int random = StdRandom.uniform(size);
        Item item = items[random];
        items[random] = items[size - 1];
        items[--size] = null;
        resizeHalfCheck();
        return item;
    }

    public Item sample() {
        validateEmpty();
        resizeHalfCheck();
        return items[StdRandom.uniform(size)];
    }

    public Iterator<Item> iterator() {
        return new RandomizedQueueIterator();
    }        // return an independent iterator over items in random order

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

    private void resizeDoubleCheck() {
        if (isFull()) {
            resize(2 * items.length);
        }
    }

    private void resizeHalfCheck() {
        if (size > 0 && size == items.length / 4) {
            resize(items.length / 2);
        }
    }

    private boolean isFull() {
        return size == items.length;
    }

    /**
     * Resizes the items array
     */
    private void resize(int newCapacity) {
        Item[] temp = (Item[]) new Object[newCapacity];
        for (int i = 0; i < items.length; i++) {
            temp[i] = items[i];
        }
        items = temp;
    }

    private class RandomizedQueueIterator implements Iterator<Item> {

        private int i = size;
        private int[] order;

        public RandomizedQueueIterator()
        {
            order = new int[i];
            for (int j = 0; j < i; ++j) {
                order[j] = j;
            }
            StdRandom.shuffle(order);
        }

        public boolean hasNext() { return i > 0; }
        public void remove() { throw new java.lang.UnsupportedOperationException(); }

        public Item next() {
            if (!hasNext()) {
                throw new java.util.NoSuchElementException();
            }
            return items[order[--i]];
        }
    }

    public static void main(String[] args) {}
}