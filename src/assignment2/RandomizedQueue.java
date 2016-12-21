package assignment2;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by tom on 12/20/16.
 */
public class RandomizedQueue<Item> implements Iterable<Item> {

    private Item[] items;

    public RandomizedQueue()  {}               // construct an empty randomized queue

    public boolean isEmpty()  {
        return false;
    }               // is the queue empty?

    public int size()    {
        return 0;
    }                    // return the number of items on the queue

    public void enqueue(Item item)  {}         // add the item

    public Item dequeue() {
        return null;
    }              // remove and return a random item

    public Item sample() {
        return null;
    }                    // return (but do not remove) a random item

    public Iterator<Item> iterator() {
        return null;
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

    public static void main(String[] args) {}  // unit testing
}