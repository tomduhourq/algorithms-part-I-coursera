package week02.elemsorts;

import edu.princeton.cs.algs4.StdOut;

import java.io.File;

/**
 * Created by tom on 12/21/16.
 */
public class FileSorter {
    public static void main(String[] args) {
        File directory = new File(args[0]);
        File[] files = directory.listFiles();
        Insertion.sort(files);
        for (int i = 0; i < files.length; i++) {
            StdOut.println(files[i].getName());
        }
    }
}
