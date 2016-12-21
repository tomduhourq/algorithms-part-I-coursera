package week02.collections;

import java.util.Iterator;

/**
 * Implementation with Iterator for a fixed array
 */
public class ArrayStackWithIterator<Item> implements Iterable<Item> {

    private Item[] items;
    private int pointer = 0;

    @Override
    public Iterator<Item> iterator() {
        return new ReverseArrayIterator();
    }

    private class ReverseArrayIterator implements Iterator<Item> {

        private int innerPointer = pointer;

        @Override
        public boolean hasNext() {
            return innerPointer > 0;
        }

        @Override
        public Item next() {
            return items[--innerPointer];
        }
    }
}
