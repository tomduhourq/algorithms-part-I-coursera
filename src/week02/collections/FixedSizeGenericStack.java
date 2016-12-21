package week02.collections;

/**
 * Uses the same idea of generics but over a fixed size
 * array of Items
 */
public class FixedSizeGenericStack<Item> {

    private Item[] items;
    private int n = 0;

    public FixedSizeGenericStack(int capacity) {
        items = (Item[]) new Object[capacity];
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public void push(Item item) {
        items[n++] = item;
    }

    public Item pop() {
        return items[--n];
    }
}
