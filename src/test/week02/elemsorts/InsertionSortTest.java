package test.week02.elemsorts;

import org.junit.Test;
import week02.elemsorts.Insertion;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertTrue;

/**
 * Insertion sort test
 */
public class InsertionSortTest extends SortTest {

    @Test @Override
    public void ascendingOrderTest() {
        Insertion.sort(toSort);
        assertThat(toSort, equalTo(expected));
    }

    @Test @Override
    public void sortedStaysSortedTest() {
        Insertion.sort(sorted);
        assertTrue(Insertion.isSorted(sorted));
    }
}
