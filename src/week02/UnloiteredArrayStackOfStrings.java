package week02;

/**
 * Improves garbage collection by making the position to be popped null
 */
public class UnloiteredArrayStackOfStrings extends ArrayStackOfStrings {

    public UnloiteredArrayStackOfStrings(int size) {
        super(size);
    }

    @Override
    public String pop() {
        validateBounds();
        String toReturn = items[--pointer];
        items[pointer] = null;
        return toReturn;
    }
}
