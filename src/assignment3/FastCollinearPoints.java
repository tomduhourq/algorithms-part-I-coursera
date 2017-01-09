package assignment3;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;

import java.util.*;


/**
 * Created by tom on 1/9/17.
 */
public class FastCollinearPoints {

    private LineSegment[] segments;

    public FastCollinearPoints(Point[] points) {
        checkInputPoints(points);
        List<LineSegment> lineSegments = new ArrayList<>();
        for (int i = 0; i < points.length - 1; i++) {
            Map<Double, List<Point>> slopesWithI = new HashMap<>();
            for (int j = i + 1; j < points.length; j++) {
                double slopeToI = points[i].slopeTo(points[j]);
                List<Point> actualSlopesWithI = slopesWithI.getOrDefault(slopeToI, new ArrayList<>());
                actualSlopesWithI.add(points[j]);
                slopesWithI.put(slopeToI, actualSlopesWithI);
                for (Map.Entry<Double, List<Point>> entry : slopesWithI.entrySet()) {
                    Point[] toSort = entry.getValue().toArray(new Point[entry.getValue().size()]);
                    if (toSort.length >= 3) {
                        Arrays.sort(toSort, points[i].slopeOrder());
                        LineSegment line = new LineSegment(points[i], toSort[toSort.length - 1]);
                        boolean added = false;
                        for (LineSegment l : lineSegments) {
                            if (l.toString().equals(line.toString())) {
                                added = true;
                                break;
                            }
                        }
                        if (!added) lineSegments.add(line);
                    }
                }
            }
        }

        this.segments = lineSegments.toArray(new LineSegment[lineSegments.size()]);
    }

    public int numberOfSegments() {
        return segments.length;
    }

    public LineSegment[] segments() {
        return segments;
    }

    /** Helper methods. */
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
        FastCollinearPoints collinear = new FastCollinearPoints(points);
        for (LineSegment segment : collinear.segments()) {
            StdOut.println(segment);
            segment.draw();
        }
        StdDraw.show();
    }

}
