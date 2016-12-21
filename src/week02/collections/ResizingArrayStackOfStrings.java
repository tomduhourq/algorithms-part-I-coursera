package week02.collections;

/**
 * Uses repeated doubling to alter the size of the array and capacity
 * of the stack when pushing elements.
 *
 * For pop it considers 1/4 of the size.
 *
 * First approach: on push and on pop resize by 1 ~ O(n^2) - slow!
 * Second approach: resize the items array infrequently.
 *
 * Push:
 *      - best O(1) - no resizing
 *      - worst O(N) - array is full => resize
 *
 * Pop:
 *      - best O(1) - no resizing
 *      - worst O(N) - array is a quarter full => shrink to half
 */
public class ResizingArrayStackOfStrings {

    private String[] items;
    private int pointer;

    public ResizingArrayStackOfStrings() {
        items = new String[1];
    }

    /**
     * Uses the idea of resizing infrequently, that is
     * when the items array is full.
     *
     * Takes O(N) to resize full array.
     */
    public void push(String item) {
        if (fullArray()) {
            resize(2 * items.length);
        }
        items[pointer++] = item;
    }

    /**
     * Avoids loitering and halves the size when
     * the items array is one quarter full.
     *
     * Guarantees the invariant that the items array
     * is between 25% and 100% full.
     */
    public String pop() {
        String item = items[--pointer];
        items[pointer] = null;
        if (quarterArrayFull()) {
            resize(items.length / 2);
        }
        return item;
    }

    /** Helper methods. */
    private boolean fullArray() {
        return pointer == items.length;
    }

    private boolean quarterArrayFull() {
        return pointer > 0 && pointer == items.length / 4;
    }

    private void resize(int newSize) {
        String[] copy = new String[newSize];
        for (int i = 0; i < pointer; i++) {
            copy[i] = items[i];
        }
        items = copy;
    }
}
