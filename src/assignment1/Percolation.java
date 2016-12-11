package assignment1;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

/**
 * Numbers are coming to the API methods as (1, N)
 */
public class Percolation {

    private int N;
    private boolean[] opened;
    private WeightedQuickUnionUF uf;

    public Percolation(int n) {
        this.N = n;
        this.opened = new boolean[n * n];
        this.uf = new WeightedQuickUnionUF(n * n);
    }

    /**
     * Validates that the (x, y) point is within the bounds of the square (N, N),
     * if this cell is not yet opened, updates the opened array to true on the 1D position
     * and creates a union between neighbors from left, right, up and down.
     */
    public void open(int row, int col)  {
        validateBounds(row, col);
        int position1D = position(row, col);
        boolean isPositionOpened = opened[position1D];
        if(!isPositionOpened) {
            opened[position1D] = true;
            unionWithNeighbors(row, col, position1D);
        }
    }

    /** Getter for opened */
    public boolean isOpen(int row, int col) {
        validateBounds(row, col);
        return opened[position(row, col)];
    }

    /**
     * Validates that the site is opened and that it connects
     * top and bottom.
     */
    public boolean isFull(int row, int col) {
        validateBounds(row, col);
        int position1D = position(row, col);
        return opened[position1D]; //&& connectsTopToBottom(position1D);
    }

    public boolean percolates()  {
        return false;
    }

    /** Helper methods */

    /**
     * Validates that the (x, y) position is inside the
     * square limited by (N, N)
     *
     * @param row the x coordinate
     * @param col the y coordinate
     */
    private void validateBounds(int row, int col) {
        if(row <= 0 || row > N || col <= 0 || col > N) {
            throw new IllegalArgumentException("(" + row + "," + col + ") out of bounds. Size is " + N);
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
    private int position(int row, int column) {
        return ((row * N) + column) - (N + 1);
    }

    /**
     * Validates the possible positions to create unions to
     * up, left down and right neighbors before performing the union.
     * using the UF object.
     */
    private void unionWithNeighbors(int row, int col, int position1D) {
        int upPosition = position1D - N;
        int downPosition = position1D + N;
        int leftPosition = position1D - 1;
        int rightPosition = position1D + 1;

        // Verify update on up neighbor
        if(row > 1 && opened[upPosition]) {
            uf.union(position1D, upPosition);
        }
        // Verify update on down neighbor
        if(row < N && opened[downPosition]) {
            uf.union(position1D, downPosition);
        }
        // Verify update on the left neighbor
        if(row > 1 && col > 1 && opened[leftPosition]) {
            uf.union(position1D, leftPosition);
        }
        // Verify update on right neighbor
        if(row < N && col < N && opened[rightPosition]) {
            uf.union(position1D, rightPosition);
        }
    }

    public static void main(String[] args) {
    }   // test client (optional)
}