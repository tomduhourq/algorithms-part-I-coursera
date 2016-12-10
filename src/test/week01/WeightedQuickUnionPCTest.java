package test.week01;

import org.junit.Before;
import org.junit.Test;
import test.UnitBaseRunner;
import week01.WeightedQuickUnionPC;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class WeightedQuickUnionPCTest extends UnitBaseRunner {
    int N;
    WeightedQuickUnionPC weightedQuickUnionPC;

    @Before
    public void setup() {
        N = 10;
        weightedQuickUnionPC = new WeightedQuickUnionPC(N);
    }

    @Test
    public void initializationTest() {
        for (int i = 0; i < N - 1; i++) {
            // reflexive
            assertTrue(weightedQuickUnionPC.connected(i, i));
            // correct initialization
            assertFalse(weightedQuickUnionPC.connected(i, i + 1));
        }
    }

    @Test
    public void unionAndConnectedTest() {
        // { 0 1 } { 2 } { 3 } { 4 } ...
        weightedQuickUnionPC.union(0, 1);
        assertTrue(weightedQuickUnionPC.connected(0, 1));
        // { 0 1 } { 2 3 } { 4 } ...
        weightedQuickUnionPC.union(2, 3);
        assertTrue(weightedQuickUnionPC.connected(2, 3));
        // { 0 1 2 3 } { 4 } ...
        weightedQuickUnionPC.union(0, 3);
        assertTrue(weightedQuickUnionPC.connected(1, 3));
        assertFalse(weightedQuickUnionPC.connected(0, 4));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void connectedExceptionTest() {
        weightedQuickUnionPC.connected(N, N + 1);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void unionExceptionTest() {
        weightedQuickUnionPC.union(0, N);
    }
}
