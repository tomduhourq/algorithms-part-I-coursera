package test.week02.collections;

import org.junit.Before;
import org.junit.Test;
import test.UnitBaseRunner;
import week02.collections.Bag;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

/**
 * Created by tom on 12/19/16.
 */
public class BagTest extends UnitBaseRunner {

    private Bag<Integer> bag;

    @Before
    public void setup() {
        bag = new Bag<>();
    }

    @Test
    public void addTwoElementsAndForTest() {
        bag.add(2);
        bag.add(45);

        for (int i : bag) {
            assertThat(i, is(either(equalTo(2)).or(equalTo(45))));
        }
    }
}
