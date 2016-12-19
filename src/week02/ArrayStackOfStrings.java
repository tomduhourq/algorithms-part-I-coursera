package week02;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * This implementation uses a fixed size array to represent the stack.
 * It loiters the elements on poping them, meaning the element which has been popped
 * still remains in the structure.
 */
public class ArrayStackOfStrings {

    protected String[] items;
    protected int pointer = 0;
    private int initialSize;

    public ArrayStackOfStrings(int size) {
        if (size <= 0) {
            throw new IllegalArgumentException("size must be greater than 0.");
        }
        this.items = new String[size];
        this.initialSize = size;
    }

    public void push(String item) {
        validateBounds();
        items[pointer++] = item;
    }

    public String pop() {
        validateBounds();
        return items[--pointer];
    }

    public boolean isEmpty() {
        return pointer == 0;
    }

    protected void validateBounds() {
        if (pointer < 0 || pointer >= initialSize) {
            throw new StackOverflowError("cannot perform operation due to unavailable space. This structure has size " + initialSize);
        }
    }

    public static void main(String[] args) {
        ArrayStackOfStrings stack = new ArrayStackOfStrings(2);
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
}
