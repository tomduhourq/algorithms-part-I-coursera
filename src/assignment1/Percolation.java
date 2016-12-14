package assignment1;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

/**
 * Numbers are coming to the API methods as (1, n)
 */
public class Percolation {

    private int n;
    private boolean[] opened;
    private WeightedQuickUnionUF uf;
    private int top;
    private int bottom;

    public Percolation(final int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("Size must be greater than 0");
        }
        this.n = n;
        this.opened = new boolean[n * n];
        this.uf = new WeightedQuickUnionUF((n * n) + 2);
        this.top = n * n;
        this.bottom = (n * n) + 1;
    }

    /**
     * Validates that the (x, y) point is within the bounds of the square (n, n),
     * if this cell is not yet opened, updates the opened array to true on the 1D position
     * and creates a union between neighbors from left, right, up and down.
     */
    public void open(final int row,final int col)  {
        validateBounds(row, col);
        int position1D = position(row, col);
        boolean isPositionOpened = opened[position1D];
        if (!isPositionOpened) {
            opened[position1D] = true;
            connectTopOrBottom(row, position1D);
            unionWithNeighbors(row, col, position1D);
        }
    }

    /** Getter for opened */
    public boolean isOpen(final int row, final int col) {
        validateBounds(row, col);
        return opened[position(row, col)];
    }

    /**
     * Validates that the site is opened and that it is connected to the top
     */
    public boolean isFull(final int row,final int col) {
        validateBounds(row, col);
        int position1D = position(row, col);
        return opened[position1D] && uf.connected(top, position1D);
    }

    public boolean percolates()  {
        return uf.connected(top, bottom);
    }

    /** Helper methods */

    /**
     * Validates that the (x, y) position is inside the
     * square limited by (n, n)
     *
     * @param row the x coordinate
     * @param col the y coordinate
     */
    private void validateBounds(final int row,final int col) {
        if (row <= 0 || row > n || col <= 0 || col > n) {
            throw new IndexOutOfBoundsException("(" + row + "," + col + ") out of bounds. Size is " + n);
        }
    }

    /**
     * Maps a 2D point to a single point index
     * to access opened
     *
     * @param row the x component
     * @param column the y component
     * @return the direct position to access the opened array
     */
    private int position(final int row,final int column) {
        return ((row * n) + column) - (n + 1);
    }

    /**
     * Validates the possible positions to create unions to
     * up, left down and right neighbors before performing the union.
     * using the UF object.
     */
    private void unionWithNeighbors(final int row,final int col,final int position1D) {
        int upPosition = position1D - n;
        int downPosition = position1D + n;
        int leftPosition = position1D - 1;
        int rightPosition = position1D + 1;

        // Verify update on up neighbor
        if (row > 1 && opened[upPosition]) {
            uf.union(position1D, upPosition);
        }
        // Verify update on down neighbor
        if (row < n && opened[downPosition]) {
            uf.union(position1D, downPosition);
        }
        // Verify update on the left neighbor
        if (row > 1 && col > 1 && opened[leftPosition]) {
            uf.union(position1D, leftPosition);
        }
        // Verify update on right neighbor
        if (row < n && col < n && opened[rightPosition]) {
            uf.union(position1D, rightPosition);
        }
    }

    private void connectTopOrBottom(final int row,final int position1D) {
        if (row == 1) {
            uf.union(position1D, top);
        }
        if (row == n) {
            uf.union(position1D, bottom);
        }
    }

    public static void main(String[] args) {
    }   // test client (optional)
}
