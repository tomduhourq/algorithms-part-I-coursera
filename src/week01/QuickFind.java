package week01;

/**
 * A class representing the dynamic connectivity problem
 * by a quick find (connected) operation but slow union.
 *
 * Initialization: O(n)
 * Connected/Find: O(1)
 * Union: O(n)
 *
 * The defect is that union is expensive.
 */
public class QuickFind extends BaseUF {

    public QuickFind(int N)  {
        this.elements = initializeElements(N);
    }

    /**
     * Quick find
     */
    @Override
    protected boolean connectedTemplate(int p, int q) {
        return elements[p] == elements[q];
    }

    /**
     * Overrides the elements connected to q to the value of the p components,
     * only if p and q are not connected.
     */
    @Override
    protected void unionTemplate(int p, int q) {
        changeAllElements(elements[q], elements[p]);
    }


    /** HELPER METHODS */
    private void changeAllElements(int oldValue, int newValue) {
        for (int i = 0; i < elements.length; i++) {
            if(elements[i] == oldValue) {
                elements[i] = newValue;
            }
        }
    }
}
