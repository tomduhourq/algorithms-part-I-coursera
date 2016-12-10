package week01;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * UF client that only manages to build
 * the DC graph.
 */
public class UFClient {
    public static void main(String[] args) {
        int n = StdIn.readInt();
        QuickFind quickFind = new QuickFind(n);
        while(!StdIn.isEmpty()) {
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            if(!quickFind.connected(p, q)) {
                quickFind.union(p, q);
                StdOut.println(p + " " + q);
            }
        }
    }
}
