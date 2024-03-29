package week02.elemsorts;

/**
 * Created by tom on 12/21/16.
 */
public class SortHelper {

    protected static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    /**
     * Swaps item at i index on j index
     */
    protected static void swap(Object[] as, int i, int j) {
        Object swap = as[i];
        as[i] = as[j];
        as[j] = swap;
    }

    public static boolean isSorted(Comparable[] as) {
        return isSorted(as, 0, as.length);
    }

    public static boolean isSorted(Comparable[] as, int from, int to) {
        for (int i = from + 1; i < to; i++) {
            if (less(as[i], as[i - 1])) {
                return false;
            }
        }
        return true;
    }
}
