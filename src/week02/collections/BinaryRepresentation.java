package week02.collections;

import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * A simple static object that can tell you the binary representation of any int
 */
public class BinaryRepresentation {
    public static String toBinary(final int toRepresent) {
        StringBuilder builder = new StringBuilder();
        Stack<Integer> stack = new Stack<>();
        int count = toRepresent;

        while(count > 0) {
            stack.push(count % 2);
            count = count / 2;
        }

        while(!stack.isEmpty()) {
            builder.append(stack.pop());
        }

        return builder.toString();
    }

    public static void main(String[] args) {
        Integer toPass = StdIn.readInt();
        StdOut.println(BinaryRepresentation.toBinary(toPass));
    }
}
