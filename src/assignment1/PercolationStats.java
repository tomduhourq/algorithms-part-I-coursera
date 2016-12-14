package assignment1;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

public class PercolationStats {

    private double[] percolationThresholds;
    private int t;

    public PercolationStats(final int n,final int trials) {
        validateParams(n, trials);
        this.percolationThresholds = new double[trials];
        this.t = trials;
        for (int i = 0; i < trials; i++) {
            Percolation percolation = new Percolation(n);
            while (!percolation.percolates()) {
                percolation.open(StdRandom.uniform(1, n + 1), StdRandom.uniform(1, n + 1));
            }
            percolationThresholds[i] = fractionOpened(percolation, n);
        }
    }

    public double mean() {
        return StdStats.mean(percolationThresholds);
    }
    public double stddev() {
        return StdStats.stddev(percolationThresholds);
    }

    public double confidenceLo()  {
        return mean() - (1.96 * stddev() / Math.sqrt(t));
    }

    public double confidenceHi() {
        return mean() + (1.96 * stddev() / Math.sqrt(t));
    }

    public static void main(final String[] args) {
        PercolationStats stats = new PercolationStats(2, 1000);
        StdOut.println(String.format("mean = %f\nstddev = %f\n95 percent confidence interval = %f, %f", stats.mean(), stats.stddev(), stats.confidenceLo(), stats.confidenceHi()));
    }


    private void validateParams(final int n, final int trials) {
        if (n <= 0 || trials <= 0) {
            throw new IllegalArgumentException("Params should be greater than 0.");
        }
    }

    private double fractionOpened(final Percolation percolation, final int size) {
        int count = 0;
        for (int i = 1; i <= size; i++) {
            for (int j = 1; j <= size; j++) {
                if (percolation.isOpen(i, j)) {
                    count++;
                }
            }
        }
        return 1.0 * count / (size * size);
    }
}
