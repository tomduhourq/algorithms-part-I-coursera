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
        QuickFindUF quickFindUf = new QuickFindUF(n);
        while(!StdIn.isEmpty()) {
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            if(!quickFindUf.connected(p, q)) {
                quickFindUf.union(p, q);
                StdOut.println(p + " " + q);
            }
        }
    }
}
