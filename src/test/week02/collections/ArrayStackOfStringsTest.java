package test.week02.collections;

import org.junit.Before;
import org.junit.Test;
import test.UnitBaseRunner;
import week02.collections.ArrayStackOfStrings;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

public class ArrayStackOfStringsTest extends UnitBaseRunner {

    private ArrayStackOfStrings stack;

    @Before
    public void setup() {
        stack = new ArrayStackOfStrings(4);
    }

    @Test
    public void pushAndPopTest() {
        stack.push("Hi");
        assertThat(stack.pop(), equalTo("Hi"));
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void popOnEmptyStackTest() {
        stack.pop();
    }
}
