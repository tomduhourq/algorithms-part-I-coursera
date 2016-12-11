package test.week01;

import assignment1.Percolation;
import org.junit.Before;
import org.junit.Test;
import test.UnitBaseRunner;

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
}
