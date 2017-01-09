package assignment3;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Performs the search for line lineSegments in O(N^4)
 */
public class BruteCollinearPoints {

    private LineSegment[] lineSegments;

    public BruteCollinearPoints(final Point[] points) {
        checkInputPoints(points);
        List<LineSegment> segments = new ArrayList<>();
        for (int i = 0; i < points.length - 3; i++) {
            for (int j = i + 1; j < points.length - 2; j++) {
                for (int k = j + 1; k < points.length - 1; k++) {
                    for (int l = k + 1; l < points.length; l++) {
                        if (sameSlope(points[i], points[j], points[k], points[l])) {
                            segments.add(new LineSegment(points[i], points[l]));
                        }
                    }
                }
            }
        }
        this.lineSegments = segments.toArray(new LineSegment[segments.size()]);
    }

    public  int numberOfSegments()    {
        return lineSegments.length;
    }

    public LineSegment[] segments()  {
        return lineSegments;
    }

    private void checkInputPoints(final Point[] points) {
        if (points == null) {
            throw new NullPointerException("Null array!");
        }
        for (int i = 0; i < points.length; i++) {
            if (points[i] == null) {
                throw new NullPointerException(String.format("Null point at position: %d in the array!", i));
            }
        }
        Arrays.sort(points);
        for (int i = 1; i < points.length; i++) {
            if (points[i].toString().equals(points[i - 1].toString())) {
                throw new IllegalArgumentException(String.format("Points cannot be repeated: %s", points[i].toString()));
            }
        }
    }

    /**
     * As points are sorted at this moment, we can tell if they have the same slope by ascending order
     * due to transitivity of the ordering.
     */
    private boolean sameSlope(final Point p1, final Point p2, final Point p3, final Point p4) {
        return (p1.slopeTo(p2) == p1.slopeTo(p3)) && (p1.slopeTo(p2) == p1.slopeTo(p4));
    }

    public static void main(String[] args) {

        // read the n points from a file
        In in = new In("src/assignment3/equidistant.txt");
        int n = in.readInt();
        Point[] points = new Point[n];
        for (int i = 0; i < n; i++) {
            int x = in.readInt();
            int y = in.readInt();
            points[i] = new Point(x, y);
        }

        // draw the points
        StdDraw.enableDoubleBuffering();
        StdDraw.setXscale(0, 32768);
        StdDraw.setYscale(0, 32768);
        for (Point p : points) {
            p.draw();
        }
        StdDraw.show();

        // print and draw the line segments
        BruteCollinearPoints collinear = new BruteCollinearPoints(points);
        for (LineSegment segment : collinear.segments()) {
            StdOut.println(segment);
            segment.draw();
        }
        StdDraw.show();
    }
}
