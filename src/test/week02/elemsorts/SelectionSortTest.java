package test.week02.elemsorts;

import org.junit.Test;
import week02.elemsorts.Selection;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertTrue;

public class SelectionSortTest extends SortTest {

    @Test @Override
    public void ascendingOrderTest() {
        Selection.sort(toSort);
        assertThat(toSort, equalTo(expected));
    }

    @Test @Override
    public void sortedStaysSortedTest() {
        Selection.sort(sorted);
        assertTrue(Selection.isSorted(sorted));
    }
}
