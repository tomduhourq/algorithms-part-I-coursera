package test.week01;

import org.junit.Before;
import org.junit.Test;
import test.UnitBaseRunner;
import week01.QuickFind;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class QuickFindTest extends UnitBaseRunner {

    int N;
    QuickFind quickFind;

    @Before
    public void setup() {
        N = 5;
        quickFind = new QuickFind(N);
    }

    @Test
    public void initializationTest() {
        for (int i = 0; i < N - 1; i++) {
            // reflexive
            assertTrue(quickFind.connected(i, i));
            // correct initialization
            assertFalse(quickFind.connected(i, i + 1));
        }
    }

    @Test
    public void unionAndConnectedTest() {
        // { 0 1 } { 2 } { 3 } { 4 }
        quickFind.union(0, 1);
        assertTrue(quickFind.connected(0, 1));
        // { 0 1 } { 2 3 } { 4 }
        quickFind.union(2, 3);
        assertTrue(quickFind.connected(2, 3));
        // { 0 1 2 3 } { 4 }
        quickFind.union(0, 3);
        assertTrue(quickFind.connected(1, 3));
        assertFalse(quickFind.connected(0, 4));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void connectedExceptionTest() {
        quickFind.connected(N, N + 1);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void unionExceptionTest() {
        quickFind.union(0, N);
    }
}
