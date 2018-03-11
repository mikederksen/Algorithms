package Trees;

public class HANBinaryEmpty<T extends Comparable<? super T>>
        extends HANBinaryTree<T> {

    @Override
    public int getDepth() {
        return 0;
    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public HANBinaryTree<T> add(T value) {
        return new HANBinaryNode<T>(value);
    }

    @Override
    public boolean contains(T value) {
        return false;
    }
}
