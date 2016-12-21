package week02.elemsorts;

/**
 * Created by tom on 12/21/16.
 */
public class Selection extends SortHelper {

    public static void sort(Comparable[] as) {
        for (int i = 0; i < as.length; i++) {
            int min = i;
            for (int j = i; j < as.length; j++) {
                if (as[j].compareTo(as[min]) < 0) {
                    min = j;
                }
            }
            swap(as, i, min);
        }
    }
}
