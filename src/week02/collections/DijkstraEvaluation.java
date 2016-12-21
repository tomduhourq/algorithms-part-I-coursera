package week02.collections;

import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * Evaluates arithmetic operations with a simple rule:
 *
 * 1- `(` is ignored
 * 2- any number stacks to the number stacks
 * 3- any operator stacks to the op stack
 * 4- `)` means pop operator and 2 numbers
 */
public class DijkstraEvaluation {

    public static void main(String[] args) {
        Stack<String> ops = new Stack<String>();
        Stack<Double> operands = new Stack<Double>();
        while(!StdIn.isEmpty()) {
            String s = StdIn.readString();
            if (s.equals("(")) {}
            else if (s.equals("+") || s.equals("*")) {
                ops.push(s);
            }
            else if (s.equals(")")) {
                String operator = ops.pop();
                if (operator.equals("+")) {
                    operands.push(operands.pop() + operands.pop());
                }
                else if (operator.equals("*")) {
                    operands.push(operands.pop() * operands.pop());
                }
            }
            else {
                operands.push(Double.parseDouble(s));
            }
        }
        StdOut.println(operands.pop());
    }
}
