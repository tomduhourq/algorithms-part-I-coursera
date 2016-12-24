package test.week02.elemsorts;

import org.junit.Test;
import test.UnitBaseRunner;

/**
 * Base class to test sort algorithms.
 */
public abstract class SortTest extends UnitBaseRunner {

    protected Integer[] sorted = { 1, 2, 3, 4, 5 };
    protected Integer[] toSort = { 2, 7, 3, 43, 5, 1 };
    protected Integer[] expected = { 1, 2, 3, 5, 7, 43 };

    @Test
    public abstract void ascendingOrderTest();

    @Test
    public abstract void sortedStaysSortedTest();
}
