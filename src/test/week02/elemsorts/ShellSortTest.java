package test.week02.elemsorts;

import org.junit.Test;
import week02.elemsorts.Shell;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertTrue;

/**
 * Created by tom on 12/24/16.
 */
public class ShellSortTest extends SortTest {

    @Test @Override
    public void ascendingOrderTest() {
        Shell.sort(toSort);
        assertThat(toSort, equalTo(expected));
    }

    @Test @Override
    public void sortedStaysSortedTest() {
        Shell.sort(sorted);
        assertTrue(Shell.isSorted(sorted));
    }
}
