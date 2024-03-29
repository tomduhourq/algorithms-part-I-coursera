package test.week01;

import assignment1.Percolation;
import org.junit.Before;
import org.junit.Test;
import test.UnitBaseRunner;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Tests methods from the assignment1.Percolation class
 */
public class PercolationTest extends UnitBaseRunner {

    Percolation p;
    int N;

    @Before
    public void setup() {
        N = 4;
        p = new Percolation(N);
    }

    // ((1 * N) + 3) - (N + 1)
    @Test
    public void openTest() {
        p.open(1, 3);
        assertTrue(p.isOpen(1, 3));
        p.open(4, 4);
        assertTrue(p.isOpen(4, 4));
    }

    @Test(expected = IllegalArgumentException.class)
    public void outOfBoundsRowPositiveTest() {
        p.isOpen(N + 1, 1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void outOfBoundsRowZeroTest() {
        p.isOpen(0, 1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void outOfBoundsColumnTest() {
        p.isOpen(1, N + 1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void outOfBoundsColumnZeroTest() {
        p.isOpen(1, 0);
    }

    @Test
    public void isFullTest() {
        p.open(1, 3);
        p.open(2, 3);
        assertTrue(p.isFull(2, 3));
    }

    @Test
    public void percolatesTest() {
        p.open(1, 3);
        p.open(2, 3);
        p.open(2, 2);
        p.open(3, 2);
        p.open(4, 2);
        assertTrue(p.percolates());
    }

    @Test
    public void doesNotPercolateTest() {
        p.open(1, 3);
        p.open(2, 3);
        p.open(2, 2);
        p.open(3, 2);
        p.open(4, 1);
        assertFalse(p.percolates());
    }
}
