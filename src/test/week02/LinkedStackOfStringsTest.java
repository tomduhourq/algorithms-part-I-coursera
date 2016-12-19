package test.week02;

import org.junit.Before;
import org.junit.Test;
import test.UnitBaseRunner;
import week02.LinkedStackOfStrings;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

public class LinkedStackOfStringsTest extends UnitBaseRunner {

    private LinkedStackOfStrings stack;

    @Before
    public void setup() {
        stack = new LinkedStackOfStrings();
    }

    @Test
    public void pushAndPopTest() {
        stack.push("Hi");
        assertThat(stack.pop(), equalTo("Hi"));
    }

    @Test(expected = NullPointerException.class)
    public void popOnEmptyStackTest() {
        stack.pop();
    }
}
