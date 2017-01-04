package week03;

import week02.elemsorts.SortHelper;

import java.util.Comparator;

/**
 * Created by tom on 1/1/17.
 */
public class MergeComparator {
    private static final int CUTOFF = 7;
    private static Comparable[] aux;

    public static void sort(Object[] as, Comparator comparator) {
        aux = new Comparable[as.length];
        sort (comparator, as, aux, 0, as.length - 1);
    }

    private static void sort(Comparator comparator, Object[] as, Object[] aux, int lo, int hi) {
        // Improve performance overhead (recursion) for small arrays.
        if (hi <= lo) return;
        int mid = lo + (hi - lo) / 2;
        sort (comparator, as, aux, lo, mid);
        sort (comparator, as, aux, mid + 1, hi);
        // Last element of first array is less than the first of the second --> Stop!
        if (!less(comparator, as[mid + 1], as[mid])) return;
        merge (comparator, as, aux, lo, mid, hi);
    }

    private static void merge(Comparator comparator, Object[] as, int lo, int mid, int hi) {
        merge(comparator, as, aux, lo, mid, hi);
    }

    /**
     * Merge:
     *
     * 1- Copy as to auxiliary array [lo, hi]
     * 2- Pointer to lo (i) and mid + 1 (j)
     * 3- Compare i and j and put it to k, updating i or j accordingly
     */
    private static void merge(Comparator comparator, Object[] as, Object[] aux, int lo, int mid, int hi) {
        assert isSorted(comparator, as, lo, mid); // precondition that first sub array is ordered
        assert isSorted(comparator, as, mid + 1, hi); // precondition that second sub array is ordered

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
            else if (less(comparator, aux[j], aux[i]))  as[k] = aux[j++];
                // first less than first
            else                            as[k] = aux[i++];
        }

        assert isSorted(comparator, as, lo, hi); // postcondition that whole as array is sorted
    }

    public static boolean isSorted(Object[] as, Comparator comparator) {
        return isSorted(comparator, as, 0, as.length);
    }

    public static boolean isSorted(Comparator comparator, Object[] as, int from, int to) {
        for (int i = from + 1; i < to; i++) {
            if (less(comparator, as[i], as[i - 1])) {
                return false;
            }
        }
        return true;
    }

    protected static boolean less(Comparator comparator, Object v, Object w) {
        return comparator.compare(v, w) < 0;
    }

    public static void buSort(Object[] as, Comparator comparator) {
        int length = as.length;
        aux = new Comparable[length];
        for (int sz = 1; sz < length; sz = 2 * sz) {
            for (int lo = 0; lo < length - sz; lo += 2 * sz) {
                merge(comparator, as, lo, lo + sz - 1, Math.min(lo + (2 * sz) - 1, length - 1));
            }
        }
    }
}
