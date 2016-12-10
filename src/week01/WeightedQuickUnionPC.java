package week01;

public class WeightedQuickUnionPC extends WeightedQuickUnion {
    /**
     * Initializes both elements and treeSizes with 1,
     * meaning that at the start, the trees are unitary.
     *
     * @param N the size of the elements.
     */
    public WeightedQuickUnionPC(int N) {
        super(N);
    }

    /**
     * Takes the root of the given elements, with a slight performance increase compared
     * against {@link QuickUnion}, by making the element `p` point to the value of its parent.
     * This is called path compression.
     */
    @Override
    protected int root(int p) {
        if(isRoot(p)) {
            return p;
        }
        else {
            elements[p] = elements[elements[p]];
            return root(elements[p]);
        }
    }
}
