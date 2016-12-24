package week02.elemsorts;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.util.HashMap;
import java.util.Map;

/**
 * Several shuffling techniques.
 */
public class Shuffle extends SortHelper {

    /**
     * Uses a random number between 0 and 1, associates each
     * number with an element, then sorts those randoms and
     * produces a new array of randomly placed elements.
     */
    public static <T> void naive(T[] items) {
        int length = items.length;
        Map<Double, T> randomMapping = new HashMap<>();
        for (int i = 0; i < length; i++) {
            randomMapping.put(StdRandom.uniform(0D, 1D), items[i]);
        }
        Double[] keys = randomMapping.keySet().toArray(new Double[length]);
        Shell.sort(keys);
        for (int i = 0; i < length; i++) {
            items[i] = randomMapping.get(keys[i]);
        }
    }

    /**
     * Random shuffles the array by selecting a uniform
     * number between 0 and i per pass and swaps it with
     * ith position.
     */
    public static <T> void knuth(T[] items) {
        int length = items.length;
        for (int i = 1; i < length; i++) {
            swap(items, i, StdRandom.uniform(0, i));
        }
    }

    public static void main(String[] args) {
        String[] strings = { "hola", "hi", "aloh", "1", "shuffle", "all", "things" };
        Shuffle.naive(strings);
        StdOut.println("-------- NAIVE --------");
        for (int i = 0; i < strings.length; i++) {
            StdOut.println(strings[i]);
        }
        StdOut.println("-------- KNUTH --------");
        Shuffle.knuth(strings);
        for (int i = 0; i < strings.length; i++) {
            StdOut.println(strings[i]);
        }
    }
}
