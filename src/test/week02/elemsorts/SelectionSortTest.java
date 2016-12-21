package test.week02.elemsorts;

import org.junit.Test;
import test.UnitBaseRunner;
import week02.elemsorts.Selection;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertTrue;

public class SelectionSortTest extends UnitBaseRunner {

    private Integer[] toSort = { 2, 7, 3, 43, 5, 1 };
    private Integer[] expected = { 1, 2, 3, 5, 7, 43 };

    @Test
    public void ascendingOrderTest() {
        Selection.sort(toSort);
        assertThat(toSort, equalTo(expected));
    }

    @Test
    public void sortedStaysSortedTest() {
        Integer[] as = { 1, 2, 3, 4, 5 };
        Selection.sort(as);
        assertTrue(Selection.isSorted(as));
    }
}
