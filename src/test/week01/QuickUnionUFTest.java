package test.week01;

import org.junit.Before;
import org.junit.Test;
import test.UnitBaseRunner;
import week01.QuickUnionUF;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by tom on 12/8/16.
 */
public class QuickUnionUFTest extends UnitBaseRunner {

    int N;
    QuickUnionUF quickUnionUF;

    @Before
    public void setup() {
        N = 10;
        quickUnionUF = new QuickUnionUF(N);
    }

    @Test
    public void initializationTest() {
        for (int i = 0; i < N - 1; i++) {
            // reflexive
            assertTrue(quickUnionUF.connected(i, i));
            // correct initialization
            assertFalse(quickUnionUF.connected(i, i + 1));
        }
    }

    @Test
    public void unionAndConnectedTest() {
        // { 0 1 } { 2 } { 3 } { 4 }
        quickUnionUF.union(0, 1);
        assertTrue(quickUnionUF.connected(0, 1));
        // { 0 1 } { 2 3 } { 4 }
        quickUnionUF.union(2, 3);
        assertTrue(quickUnionUF.connected(2, 3));
        // { 0 1 2 3 } { 4 }
        quickUnionUF.union(0, 3);
        assertTrue(quickUnionUF.connected(1, 3));
        assertFalse(quickUnionUF.connected(0, 4));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void connectedExceptionTest() {
        quickUnionUF.connected(N, N + 1);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void unionExceptionTest() {
        quickUnionUF.union(0, N);
    }
}
