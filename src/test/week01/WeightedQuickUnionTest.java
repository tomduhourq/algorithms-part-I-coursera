package test.week01;

import org.junit.Before;
import org.junit.Test;
import test.UnitBaseRunner;
import week01.WeightedQuickUnion;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class WeightedQuickUnionTest extends UnitBaseRunner {

    int N;
    WeightedQuickUnion weightedQuickUnion;

    @Before
    public void setup() {
        N = 10;
        weightedQuickUnion = new WeightedQuickUnion(N);
    }

    @Test
    public void initializationTest() {
        for (int i = 0; i < N - 1; i++) {
            // reflexive
            assertTrue(weightedQuickUnion.connected(i, i));
            // correct initialization
            assertFalse(weightedQuickUnion.connected(i, i + 1));
        }
    }

    @Test
    public void unionAndConnectedTest() {
        // { 0 1 } { 2 } { 3 } { 4 } ...
        weightedQuickUnion.union(0, 1);
        assertTrue(weightedQuickUnion.connected(0, 1));
        // { 0 1 } { 2 3 } { 4 } ...
        weightedQuickUnion.union(2, 3);
        assertTrue(weightedQuickUnion.connected(2, 3));
        // { 0 1 2 3 } { 4 } ...
        weightedQuickUnion.union(0, 3);
        assertTrue(weightedQuickUnion.connected(1, 3));
        assertFalse(weightedQuickUnion.connected(0, 4));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void connectedExceptionTest() {
        weightedQuickUnion.connected(N, N + 1);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void unionExceptionTest() {
        weightedQuickUnion.union(0, N);
    }
}
