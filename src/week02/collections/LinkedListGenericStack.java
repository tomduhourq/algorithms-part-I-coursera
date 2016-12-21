package week02.collections;

/**
 * Generic stack implementation.
 *
 * @param <Item> the homogeneous type that the stack holds.
 */
public class LinkedListGenericStack<Item> {

    private class Node {
        Item item;
        Node next;
    }

    private Node first = null;

    public boolean isEmpty() {
        return first == null;
    }

    public void push(Item item) {
        Node old = first;
        first = new Node();
        first.item = item;
        first.next = old;
    }

    public Item pop() {
        Item item = first.item;
        first = first.next;
        return item;
    }
}
