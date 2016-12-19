package assignment2;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {

    private int first;
    private int last;
    private Item[] items;

    public Deque() {
        this.items = (Item[]) new Object[2];
        this.first = 0;
        this.last = 0;
    }

    // construct an empty deque
    public boolean isEmpty()  {
        return first == 0;
    }
    public int size()     {
        return items.length;
    }
    public void addFirst(Item item)  {
        validateNull(item);
    }        // add the item to the front
    public void addLast(Item item) {
        validateNull(item);
    }          // add the item to the end
    public Item removeFirst()  {
        validateEmpty();
        return null;
    }              // remove and return the item from the front
    public Item removeLast()  {
        validateEmpty();
        return null;
    }               // remove and return the item from the end
    public Iterator<Item> iterator() {
        return new ArrayIterator();
    }        // return an iterator over items in order from front to end



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

    /** Inner classes. */
    private class ArrayIterator implements Iterator<Item> {

        private int pointer = first;

        @Override
        public boolean hasNext() {
            return pointer > 0;
        }

        @Override
        public Item next() {
            if(!hasNext()) {
                throw new NoSuchElementException("No next item!");
            }
            return items[pointer];
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException("Cannot remove from this iterator.");
        }
    }



    public static void main(String[] args){}   // unit testing
}
