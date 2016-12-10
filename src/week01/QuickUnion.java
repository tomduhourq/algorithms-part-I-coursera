package week01;

/**
 * Solves the dynamic connectivity problem treating the
 * elements as a forest, in which elements[i] is the
 * parent of i.
 *
 * Initialization: O(n)
 * Find/Connected: O(2n) = O(n) - includes costs of finding roots
 * Union: O(2n) = O(n) - includes costs of finding roots
 *
 * The defect is that Find is expensive here, and that
 * `tall` trees may be generated
 */
public class QuickUnion extends BaseUF {

    public QuickUnion(int N) {
        this.elements = initializeElements(N);
    }

    /**
     * Checks if the roots of both elements is the same,
     * meaning they are connected.
     */
    @Override
    protected boolean connectedTemplate(int p, int q) {
        return root(p) == root(q);
    }

    /**
     * Makes p's root point to q, connecting
     * both trees.
     */
    @Override
    protected void unionTemplate(int p, int q) {
        elements[root(p)] = root(q);
    }

    /** Helper methods */
    private boolean isRoot(int p) {
        return elements[p] == p;
    }

    private int root(int p) {
       if(isRoot(p)) {
           return p;
       }
       else {
           return root(elements[p]);
       }
    }
}
