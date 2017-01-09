package test.week03;

import assignment3.FastCollinearPoints;
import assignment3.Point;
import org.junit.After;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import test.UnitBaseRunner;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.emptyArray;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

/**
 * Created by tom on 1/9/17.
 */
public class FastCollinearPointsTest extends UnitBaseRunner {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @After
    public void after() {
        expectedException = ExpectedException.none();
    }

    @Test
    public void blowsOnNullInputTest() {
        expectedException.expect(NullPointerException.class);
        expectedException.expectMessage("Null array!");
        new FastCollinearPoints(null);
    }

    @Test
    public void blowsOnNullPointTest() {
        expectedException.expect(NullPointerException.class);
        expectedException.expectMessage("Null point at position: 2 in the array!");
        Point[] points = { new Point(1, 1), new Point(2, 1), null };
        new FastCollinearPoints(points);
    }

    @Test
    public void blowsOnRepeatedPointTest() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("Points cannot be repeated: (2, 1)");
        Point[] points = { new Point(1, 1), new Point(2, 1), new Point(2, 1) };
        new FastCollinearPoints(points);
    }

    @Test
    public void incorrectSizeTest() {
        Point[] sizeOne = { new Point(1, 1) };
        Point[] sizeTwo = { new Point(1, 1), new Point(2, 1) };
        Point[] sizeThree = { new Point(1, 1), new Point(2, 1), new Point(4, 1) };

        List<Point[]> allPoints = Arrays.asList(sizeOne, sizeTwo, sizeThree);

        for (Point[] points : allPoints) {
            FastCollinearPoints fdp = new FastCollinearPoints(points);
            assertThat(fdp.numberOfSegments(), equalTo(0));
            assertThat(fdp.segments(), is(emptyArray()));
        }
    }

    @Test
    public void worksTest() throws InterruptedException {
        Point[] points = { new Point(1, 1), new Point(0, 1), new Point(4, 4), new Point(3, 1), new Point(0, 0), new Point(2, 2), new Point(2, 1), new Point(3, 3) };
        FastCollinearPoints fdp = new FastCollinearPoints(points);
        assertThat(fdp.numberOfSegments(), equalTo(4));
    }
}
