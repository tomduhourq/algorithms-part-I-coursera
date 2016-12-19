package test.week02;

import org.junit.Before;
import org.junit.Test;
import test.UnitBaseRunner;
import week02.LinkedListGenericStack;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

public class LinkedListGenericStackTest extends UnitBaseRunner {

    private LinkedListGenericStack<Integer> linkedListGenericStack;

    @Before
    public void setup() {
        linkedListGenericStack = new LinkedListGenericStack<>();
    }

    @Test
    public void pushAndPopTest() {
        linkedListGenericStack.push(1);
        assertThat(linkedListGenericStack.pop(), equalTo(1));
    }

    @Test
    public void pushTwiceAndPop() {
        linkedListGenericStack.push(-1);
        linkedListGenericStack.push(32);
        assertThat(linkedListGenericStack.pop(), equalTo(32));
    }

    @Test(expected = NullPointerException.class)
    public void popOnEmptyStackTest() {
        linkedListGenericStack.pop();
    }
}
