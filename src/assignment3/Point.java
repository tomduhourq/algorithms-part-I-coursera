package assignment3;

import edu.princeton.cs.algs4.StdDraw;

import java.util.Comparator;

public class Point implements Comparable<Point> {

    private final int x;
    private final int y;

    /**
     * Initializes a new point.
     *
     * @param  x the <em>x</em>-coordinate of the point
     * @param  y the <em>y</em>-coordinate of the point
     */
    public Point(final int x, final int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Draws this point to standard draw.
     */
    public void draw() { StdDraw.point(x, y); }

    /**
     * Draws the line segment between this point and the specified point
     * to standard draw.
     *
     * @param that the other point
     */
    public void drawTo(final Point that) { StdDraw.line(this.x, this.y, that.x, that.y); }

    /**
     * Given by the formula (y1 − y0) / (x1 − x0).
     * Treat the slope of a horizontal line segment as positive zero;
     * treat the slope of a vertical line segment as positive infinity;
     * treat the slope of a degenerate line segment (between a point and itself) as negative infinity.
     *
     * @param that the point to get the slope to
     * @return the double meaning the slope to the provided point.
     */
    public double slopeTo(final Point that) {
        if (isEqualTo(that)) {
            return Double.NEGATIVE_INFINITY;
        }
        // Vertical line
        else if (this.x == that.x && this.y != that.y) {
            return Double.POSITIVE_INFINITY;
        }
        // Horizontal line
        else if (this.y == that.y) {
            return 0;
        }
        else {
            return ((that.y - this.y) / (double) (that.x - this.x));
        }
    }

    /**
     * Compares two points by y-coordinate, breaking ties by x-coordinate.
     * Formally, the invoking point (x0, y0) is less than the argument point
     * (x1, y1) if and only if either y0 < y1 or if y0 = y1 and x0 < x1.
     *
     * @param  that the other point
     * @return the value <tt>0</tt> if this point is equal to the argument
     *         point (x0 = x1 and y0 = y1);
     *         a negative integer if this point is less than the argument
     *         point; and a positive integer if this point is greater than the
     *         argument point
     */
    @Override
    public int compareTo(final Point that) {
        if (this.y < that.y || (this.y == that.y && this.x < that.x)) return -1;
        else if (isEqualTo(that)) return 0;
        else return 1;
    }

    /**
     * Compares two points by the slope they make with this point.
     * The slope is defined as in the slopeTo() method.
     *
     * @return the Comparator that defines this ordering on points
     */
    public Comparator<Point> slopeOrder() {
        return new Comparator<Point>() {
            @Override
            public int compare(Point p1, Point p2) {
                return Double.compare(slopeTo(p1), slopeTo(p2));
            }
        };
    }

    /** Helper methods. */

    /**
     * In order not to override equals() --> assignment prohibits this
     */
    private boolean isEqualTo(final Point that) {
        return this.x == that.x && this.y == that.y;
    }

    /**
     * Returns a string representation of this point.
     * This method is provide for debugging;
     * your program should not rely on the format of the string representation.
     *
     * @return a string representation of this point
     */
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}
