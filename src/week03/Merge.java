package week03;

import edu.princeton.cs.algs4.Insertion;
import week02.elemsorts.SortHelper;

/**
 * At most N log N compares, with 2 strategies:
 *
 * - Recursive merge sort, classic algorithm
 * - Linear space algorithm by bottom up sorting it
 */
public class Merge extends SortHelper {

    private static final int CUTOFF = 7;
    private static Comparable[] aux;

    public static void sort(Comparable[] as) {
        aux = new Comparable[as.length];
        sort (as, aux, 0, as.length - 1);
    }

    private static void sort(Comparable[] as, Comparable[] aux, int lo, int hi) {
        // Improve performance overhead (recursion) for small arrays.
        if (hi <= lo + CUTOFF - 1) {
            Insertion.sort(as, lo, hi);
            return;
        }
        int mid = lo + (hi - lo) / 2;
        sort (as, aux, lo, mid);
        sort (as, aux, mid + 1, hi);
        // Last element of first array is less than the first of the second --> Stop!
        if (!less(as[mid + 1], as[mid])) return;
        merge (as, aux, lo, mid, hi);
    }

    private static void merge(Comparable[] as, int lo, int mid, int hi) {
        merge(as, aux, lo, mid, hi);
    }

    /**
     * Merge:
     *
     * 1- Copy as to auxiliary array [lo, hi]
     * 2- Pointer to lo (i) and mid + 1 (j)
     * 3- Compare i and j and put it to k, updating i or j accordingly
     */
    private static void merge(Comparable[] as, Comparable[] aux, int lo, int mid, int hi) {
        assert isSorted(as, lo, mid); // precondition that first sub array is ordered
        assert isSorted(as, mid + 1, hi); // precondition that second sub array is ordered

        for (int k = lo; k <= hi; k++) {
            aux[k] = as[k];
        }

        int i = lo;
        int j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            // done with first sub array
            if      (i > mid)               as[k] = aux[j++];
            // done with second sub array
            else if (j > hi)                as[k] = aux[i++];
            // second less than first
            else if (less(aux[j], aux[i]))  as[k] = aux[j++];
            // first less than first
            else                            as[k] = aux[i++];
        }

        assert isSorted(as, lo, hi); // postcondition that whole as array is sorted
    }


    public static void buSort(Comparable[] as) {
        int length = as.length;
        aux = new Comparable[length];
        for (int sz = 1; sz < length; sz = 2 * sz) {
            for (int lo = 0; lo < length - sz; lo += 2 * sz) {
                merge(as, lo, lo + sz - 1, Math.min(lo + (2 * sz) - 1, length - 1));
            }
        }
    }
}
