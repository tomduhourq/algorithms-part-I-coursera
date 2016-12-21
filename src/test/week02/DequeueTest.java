package test.week02;

import assignment2.Deque;
import org.junit.Before;
import org.junit.Test;
import test.UnitBaseRunner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

/**
 * Created by tom on 12/19/16.
 */
public class DequeueTest extends UnitBaseRunner {

    Deque<Integer> deque;

    @Before
    public void setup() {
        deque = new Deque<>();
    }

    @Test
    public void emptyAddFirstRemoveLast() {
        deque.addFirst(1);
        assertThat(deque.removeLast(), equalTo(1));
    }

    @Test
    public void emptyAddLastRemoveFirst() {
        deque.addLast(23);
        assertThat(deque.removeFirst(), equalTo(23));
    }

    @Test
    public void addThreeElements() {
        deque.addFirst(23);
        deque.addLast(22);
        deque.addLast(11);
        assertThat(deque.removeLast(), equalTo(11));
    }

    @Test
    public void addFirstThenRemoveLastShouldComeAsQueue() {
        deque.addFirst(1);
        deque.addFirst(2);

        assertThat(deque.removeLast(), equalTo(1));
        assertThat(deque.removeLast(), equalTo(2));
    }

    @Test
    public void addLastThenRemoveFirstShouldComeAsQueue() {
        deque.addLast(1);
        deque.addLast(2);

        assertThat(deque.removeFirst(), equalTo(1));
        assertThat(deque.removeFirst(), equalTo(2));
    }

    @Test
    public void addFirstRemoveFirstShouldComeAsStackTest() {
        deque.addFirst(1);
        deque.addFirst(2);
        deque.addFirst(3);

        assertThat(deque.removeFirst(), equalTo(3));
        assertThat(deque.removeFirst(), equalTo(2));
        assertThat(deque.removeFirst(), equalTo(1));
    }

    @Test
    public void addLastRemoveLastShouldComeAsStackTest() {
        deque.addLast(1);
        deque.addLast(2);
        deque.addLast(3);

        assertThat(deque.removeLast(), equalTo(3));
        assertThat(deque.removeLast(), equalTo(2));
        assertThat(deque.removeLast(), equalTo(1));
    }

    @Test
    public void iteratorShouldProvideElementsAsAStackTest() {
        deque.addFirst(1);
        deque.addLast(2);
        deque.addLast(3);

        int count = 1;
        for (int i : deque) {
            assertThat(i, equalTo(count++));
        }
    }
}
