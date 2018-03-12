package Trees;

@SuppressWarnings("WeakerAccess")
public abstract class HANBinaryTree<T extends Comparable<? super T>> implements Iterable<T> {

    public abstract int getDepth();

    public abstract int getCount();

    public abstract HANBinaryTree<T> add(T value);

    public abstract boolean contains(T value);

    public abstract T findMin();

    public abstract T findMax();

    public abstract T find(T value);

    public abstract HANBinaryTree<T> balance();

    public abstract boolean isAvl();

    protected abstract void appendToString(int indent, StringBuilder builder);
}
