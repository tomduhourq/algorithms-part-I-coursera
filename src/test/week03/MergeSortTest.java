package test.week03;

import org.junit.Test;
import test.week02.elemsorts.SortTest;
import week03.Merge;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

/**
 * Created by tom on 1/1/17.
 */
public class MergeSortTest extends SortTest {
    @Override
    public void ascendingOrderTest() {
        Merge.sort(toSort);
        assertThat(toSort, equalTo(expected));
    }

    @Override
    public void sortedStaysSortedTest() {
        Merge.sort(sorted);
        assertTrue(Merge.isSorted(sorted));
    }

    @Test
    public void ascendingOrderBUTest() {
        Merge.buSort(toSort);
        assertThat(toSort, equalTo(expected));
    }

    @Test
    public void sortedStaysSortedBUTest() {
        Merge.buSort(sorted);
        assertTrue(Merge.isSorted(sorted));
    }
}
