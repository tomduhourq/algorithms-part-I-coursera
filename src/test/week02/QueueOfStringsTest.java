package test.week02;

import org.junit.Before;
import org.junit.Test;
import test.UnitBaseRunner;
import week02.QueueOfStrings;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertTrue;

public class QueueOfStringsTest extends UnitBaseRunner{

    private QueueOfStrings queue;

    @Before
    public void setup() {
        queue = new QueueOfStrings();
    }

    @Test
    public void initializationTest() {
        assertTrue(queue.isEmpty());
    }

    @Test
    public void fifoTest() {
        queue.enqueue("Hi");
        queue.enqueue("My");
        queue.enqueue("name");
        assertThat(queue.dequeue(), equalTo("Hi"));
    }

    @Test(expected = NullPointerException.class)
    public void insertAndDequeueTwiceTest() {
        queue.enqueue("Hi");
        queue.dequeue();
        queue.dequeue();
    }
}
