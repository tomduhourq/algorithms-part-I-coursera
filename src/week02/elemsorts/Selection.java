package week02.elemsorts;

/**
 * Goes over all the elements of the array. Per element,
 * the actual minimum is selected and swapped with the ith element.
 *
 * Complexity: O(N^2)
 */
public class Selection extends SortHelper {

    public static void sort(Comparable[] as) {
        int length = as.length;
        for (int i = 0; i < length; i++) {
            int min = i;
            for (int j = i; j < length; j++) {
                if (less(as[j], as[min])) {
                    min = j;
                }
            }
            swap(as, i, min);
        }
    }
}
