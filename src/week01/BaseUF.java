package week01;

public abstract class BaseUF {
    protected int[] elements;

    protected void validateBounds(int p, int q) {
        if(!bounded(p, q)) {
            throw new IndexOutOfBoundsException(String.format("(%d, %d) pair not bounded to elements size", p, q));
        }
    }

    private boolean bounded(int p, int q) {
        int actualLength = elements.length;
        return p < actualLength && q < actualLength;
    }

    protected int[] initializeElements(int N) {
        int[] result = new int[N];
        for (int i = 0; i < N; i++) {
            result[i] = i;
        }
        return result;
    }

    public boolean connected(int p, int q) {
        validateBounds(p, q);
        return connectedTemplate(p, q);
    }

    protected abstract boolean connectedTemplate(int p, int q);

    public void union(int p, int q) {
        validateBounds(p, q);
        unionTemplate(p, q);
    }

    protected abstract void unionTemplate(int p, int q);
}
