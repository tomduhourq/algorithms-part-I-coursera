package test.week01;

import org.junit.Before;
import org.junit.Test;
import test.UnitBaseRunner;
import week01.optional.FindMaxOnComponent;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Created by tom on 12/11/16.
 */
public class FindOnMaxComponentTest extends UnitBaseRunner {

    FindMaxOnComponent fm;
    int N;

    @Before
    public void setup() {
        N = 10;
        this.fm = new FindMaxOnComponent(N);
    }

    @Test
    public void maxTest() {
        fm.union(0, 9);
        assertThat(fm.find(0), equalTo(9));
        fm.union(1, 3);
        fm.union(3, 4);
        assertThat(fm.find(1), equalTo(4));
        fm.union(1, 9);
        assertThat(fm.find(1), equalTo(9));
        assertThat(fm.find(8), equalTo(8));
    }
}
