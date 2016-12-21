package week02.collections;

public class QueueOfStrings {

    private class Node {
        String item;
        Node next;
    }

    private Node first, last;

    /**
     * Places the item passed by parameter as the last element
     * of the internal representation
     */
    public void enqueue(String item) {
        Node oldLast = last;
        last = new Node();
        last.item = item;
        last.next = null;
        if(isEmpty()) {
            first = last;
        }
        else {
            oldLast.next = last;
        }
    }

    /**
     * Returns the first item that was inserted.
     *
     * This is the first item in the representation.
     */
    public String dequeue() {
        String toReturn = first.item;
        first = first.next;
        if(isEmpty()) {
            last = null;
        }
        return toReturn;
    }


    public boolean isEmpty() {
        return first == null;
    }
}
