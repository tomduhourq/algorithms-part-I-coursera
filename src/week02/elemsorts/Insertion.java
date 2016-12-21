package week02.elemsorts;

/**
 * Insertion sort class
 *
 * sort is O(N^2)
 */
public class Insertion extends SortHelper {

    public static void sort(Comparable[] as) {
        int N = as.length;
        for (int i = 0; i < N; i++) {
            for (int j = i; j > 0; j--) {
                if (as[j].compareTo(as[j - 1]) < 0) {
                    swap(as, j, j - 1);
                }
                else {
                    break;
                }
            }
        }
    }
}
