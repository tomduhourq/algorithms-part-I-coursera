package test.week01;

import org.junit.Before;
import org.junit.Test;
import test.UnitBaseRunner;
import week01.QuickUnion;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by tom on 12/8/16.
 */
public class QuickUnionTest extends UnitBaseRunner {

    int N;
    QuickUnion quickUnion;

    @Before
    public void setup() {
        N = 10;
        quickUnion = new QuickUnion(N);
    }

    @Test
    public void initializationTest() {
        for (int i = 0; i < N - 1; i++) {
            // reflexive
            assertTrue(quickUnion.connected(i, i));
            // correct initialization
            assertFalse(quickUnion.connected(i, i + 1));
        }
    }

    @Test
    public void unionAndConnectedTest() {
        // { 0 1 } { 2 } { 3 } { 4 }
        quickUnion.union(0, 1);
        assertTrue(quickUnion.connected(0, 1));
        // { 0 1 } { 2 3 } { 4 }
        quickUnion.union(2, 3);
        assertTrue(quickUnion.connected(2, 3));
        // { 0 1 2 3 } { 4 }
        quickUnion.union(0, 3);
        assertTrue(quickUnion.connected(1, 3));
        assertFalse(quickUnion.connected(0, 4));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void connectedExceptionTest() {
        quickUnion.connected(N, N + 1);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void unionExceptionTest() {
        quickUnion.union(0, N);
    }
}
