package week02.elemsorts;

/**
 * Performs shell sort with h starting at 3h + 1
 * (Donald Knuth sequence) for interleaved
 * positions in the array.
 */
public class Shell extends SortHelper {

    public static void sort(Comparable[] as) {
        int length = as.length;

        int h = computeH(length);

        // perform h sort passes starting by h
        while (h >= 1) {
            // insertion sort over h
            for (int i = h; i < length; i++) {
                for (int j = i; j >= h && less(as[j], as[j - h]); j-= h) {
                    swap(as, j, j - h);
                }
            }
            h = h / 3;
        }
    }

    /**
     * Generates the 3h + 1 sequence
     * until getting to a third of the array.
     *
     * 1, 4, 13, 40, 121, 364, ...
     */
    private static int computeH(final int length) {
        int h = 1;
        while(h < length / 3) {
            h = 3 * h + 1;
        }
        return h;
    }
}
