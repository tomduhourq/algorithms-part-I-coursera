package week01;

/**
 * Addresses the dynamic connectivity problem,
 * improving on the union of the trees generated, taking
 * into account the size of both trees.
 *
 * Initialization: O(2n) = O(n)
 * Find/Connected: O(lg N)
 * Union: O(lg n)
 *
 * The depth of any node `x` is increased by 1 when the tree T1
 * containing `x` is merged into another tree T2.
 *
 * |T2| >= |T1| => size of tree holding `x` after merge is at least 2 |T1|
 * size of tree holding `x` can double at most lgN times, since there are N nodes
 * in the tree.
 */
public class WeightedQuickUnion extends BaseUF {

    /** Extra array holding the size of the tree of element i*/
    private int[] treeSizes;

    /**
     * Initializes both elements and treeSizes with 1,
     * meaning that at the start, the trees are unitary.
     *
     * @param N the size of the elements.
     */
    public WeightedQuickUnion(int N) {
        this.elements = initializeElements(N);
        this.treeSizes = initializeWithValue(N, 1);
    }

    /**
     * Same as {@link QuickUnion}
     */
    @Override
    protected boolean connectedTemplate(int p, int q) {
        return root(p) == root(q);
    }

    /**
     * Creates a union of p and q taking into consideration
     * the shortest tree to create the union to the root
     * of the largest tree.
     *
     * As this algorithm works only with roots, we only need to update
     * the value of the roots on `treeSizes`.
     *
     * Connection testing has already been made on the parent class.
     */
    @Override
    protected void unionTemplate(int p, int q) {
        int pRoot = root(p);
        int qRoot = root(q);
        if(pRoot == qRoot) {
            return;
        }
        if(treeSizes[pRoot] < treeSizes[qRoot]) {
            joinTrees(pRoot, qRoot);
        }
        else {
            joinTrees(qRoot, pRoot);
        }
    }

    /** Helper methods */

    /**
     * Joins the shortest to the tallest tree and accumulates
     * the size on the root of the tallest tree.
     */
    private void joinTrees(int shortestTreeRoot, int tallestTreeRoot) {
        elements[shortestTreeRoot] = tallestTreeRoot;
        treeSizes[tallestTreeRoot] += treeSizes[shortestTreeRoot];
    }

    protected boolean isRoot(int p) {
        return elements[p] == p;
    }

    /**
     * Takes the root of the given element
     */
    protected int root(int p) {
        if(isRoot(p)) {
            return p;
        }
        else {
            return root(elements[p]);
        }
    }

    private int[] initializeWithValue(int size, int value) {
        int[] toReturn = new int[size];
        for (int i = 0; i < size; i++) {
            toReturn[i] = value;
        }
        return toReturn;
    }
}
