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

    public void open(int row, int col)  {
        validateBounds(row, col);
        boolean isPositionOpened = opened[position(row, col)];
        if(!isPositionOpened) {

        }
    }     // open site (row, col) if it is not open already
    public boolean isOpen(int row, int col) {
        validateBounds(row, col);

        return false;
    } // is site (row, col) open?
    public boolean isFull(int row, int col) {
        validateBounds(row, col);
        return false;
    }  // is site (row, col) full?
    public boolean percolates()  {

        return false;
    }            // does the system percolate?

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
        return (row * N) + column;
    }

    public static void main(String[] args) {
    }   // test client (optional)
}
