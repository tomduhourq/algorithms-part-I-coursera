package week02.elemsorts;

/**
 * Insertion sort: for each element, order the ith element
 * by moving it to the left, until ordered.
 *
 * sort is O(N^2)
 */
public class Insertion extends SortHelper {

    public static void sort(Comparable[] as) {
        int length = as.length;
        for (int i = 0; i < length; i++) {
            for (int j = i; j > 0 && less(as[j], as[j - 1]); j--) {
                swap(as, j, j - 1);
            }
        }
    }
}
