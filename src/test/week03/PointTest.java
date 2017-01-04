package test.week03;

import assignment3.Point;
import org.junit.Test;
import test.UnitBaseRunner;

import java.util.Comparator;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

public class PointTest extends UnitBaseRunner {

    Point central = new Point(1, 1);
    Point up = new Point(1, 2);
    Point down = new Point(1, 0);
    Point right = new Point(3, 1);
    Point left = new Point(0, 1);
    Point upLeft = new Point(0, 2);
    Point upRight = new Point(3, 2);
    Point downLeft = new Point(0, 0);
    Point downRight = new Point(3, 0);

    Comparator<Point> centralComparator = central.slopeOrder();

    // COMPARE TO

    @Test
    public void compareToTest() {
        // equality
        assertThat(central.compareTo(central), equalTo(0));
        // central is below up
        assertThat(central.compareTo(up), equalTo(-1));
        // up is on top of central
        assertThat(up.compareTo(central), equalTo(1));
        // right is at the right of central
        assertThat(central.compareTo(right), equalTo(-1));
        // left is at left of central
        assertThat(central.compareTo(left), equalTo(1));
    }

    @Test
    public void compareToDiagonalTest() {
        assertThat(central.compareTo(upLeft), equalTo(-1));
        assertThat(central.compareTo(upRight), equalTo(-1));
        assertThat(central.compareTo(downLeft), equalTo(1));
        assertThat(central.compareTo(downRight), equalTo(1));
    }

    // SLOPE TO

    @Test
    public void sameTest() {
        assertThat(central.slopeTo(central), equalTo(Double.NEGATIVE_INFINITY));
    }

    @Test
    public void horizontalTest() {
        assertThat(central.slopeTo(left), equalTo(0.0));
        assertThat(central.slopeTo(right), equalTo(0.0));
    }

    @Test
    public void verticalTest() {
        assertThat(central.slopeTo(up), equalTo(Double.POSITIVE_INFINITY));
        assertThat(central.slopeTo(down), equalTo(Double.POSITIVE_INFINITY));
    }

    @Test
    public void diagonalTest() {
        assertThat(central.slopeTo(upRight), equalTo(0.5));
        assertThat(central.slopeTo(upLeft), equalTo(-1.0));
        assertThat(central.slopeTo(downLeft), equalTo(1.0));
        assertThat(central.slopeTo(downRight), equalTo(-0.5));
    }

    // SLOPE ORDER

    @Test
    public void slopeOrderTest() {
        assertThat(centralComparator.compare(upLeft, upRight), equalTo(-1));
        assertThat(centralComparator.compare(upLeft, upLeft), equalTo(0));
        assertThat(centralComparator.compare(central, central), equalTo(0));
        assertThat(centralComparator.compare(central, upRight), equalTo(-1));
        assertThat(centralComparator.compare(downLeft, upRight), equalTo(1));
    }
}
