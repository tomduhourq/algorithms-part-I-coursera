package week01.optional;

import week01.WeightedQuickUnionPC;

public class FindMaxOnComponent extends WeightedQuickUnionPC {

    private int[] max;
    /**
     * Initializes both elements and treeSizes with 1,
     * meaning that at the start, the trees are unitary.
     *
     * @param N the size of the elements.
     */
    public FindMaxOnComponent(int N) {
        super(N);
        max = initializeElements(N);
    }

    /**
     * Finds the largest number in i's connected component.
     *
     * @param i the number to check for its connected component
     * @return the max of i's component.
     */
    public int find(int i) {
        validateBounds(i, i);
        return max[root(i)];
    }

    @Override
    public void union(int p, int q) {
        int rootP = root(p);
        int rootQ = root(q);
        if(rootP == rootQ) return;
        if(treeSizes[rootP] < treeSizes[rootQ]){
            elements[rootP] = rootQ;
            treeSizes[rootQ] += treeSizes[rootP];
        }
        else {
            elements[rootQ] = rootP;
            treeSizes[rootP] += treeSizes[rootQ];
        }
        updateMax(rootP, rootQ);
    }

    /**
     * Updates the max array with the max of both roots
     */
    private void updateMax(int rootP, int rootQ) {
        int maxP = max[rootP];
        int maxQ = max[rootQ];
        if(maxP > maxQ) {
            max[rootQ] = maxP;
        }
        else {
            max[rootP] = maxQ;
        }
    }

}
