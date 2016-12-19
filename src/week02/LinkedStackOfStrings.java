package week02;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * Uses a private Node class to implement a stack structure.
 */
public class LinkedStackOfStrings {

    private class Node {
        String item;
        Node next;
    }

    private Node first = null;

    public void push(String item) {
        Node old = first;
        first = new Node();
        first.item = item;
        first.next = old;
    }

    public String pop() {
        String item = first.item;
        first = first.next;
        return item;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public static void main(String[] args) {
        LinkedStackOfStrings stack = new LinkedStackOfStrings();
        while(!StdIn.isEmpty()) {
            String s = StdIn.readString();
            if (s.equals("-")) {
                StdOut.print(stack.pop());
            }
            else {
                stack.push(s);
            }
        }
    }

    /** Extra: Deletes last node of the list. */
    private void deleteLast() {
        Node toBeLast = first;
        while (toBeLast.next.next != null) {
            toBeLast = toBeLast.next;
        }
        toBeLast.next = null;
    }
}
