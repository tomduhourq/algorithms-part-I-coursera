package test.week01;

import org.junit.Before;
import org.junit.Test;
import test.UnitBaseRunner;
import week01.QuickFindUF;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class QuickFindUFTest extends UnitBaseRunner {

    int N;
    QuickFindUF quickFindUf;

    @Before
    public void setup() {
        N = 5;
        quickFindUf = new QuickFindUF(N);
    }

    @Test
    public void initializationTest() {
        for (int i = 0; i < N - 1; i++) {
            // reflexive
            assertTrue(quickFindUf.connected(i, i));
            // correct initialization
            assertFalse(quickFindUf.connected(i, i + 1));
        }
    }

    @Test
    public void unionAndConnectedTest() {
        // { 0 1 } { 2 } { 3 } { 4 }
        quickFindUf.union(0, 1);
        assertTrue(quickFindUf.connected(0, 1));
        // { 0 1 } { 2 3 } { 4 }
        quickFindUf.union(2, 3);
        assertTrue(quickFindUf.connected(2, 3));
        // { 0 1 2 3 } { 4 }
        quickFindUf.union(0, 3);
        assertTrue(quickFindUf.connected(1, 3));
        assertFalse(quickFindUf.connected(0, 4));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void connectedExceptionTest() {
        quickFindUf.connected(N, N + 1);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void unionExceptionTest() {
        quickFindUf.union(0, N);
    }
}
