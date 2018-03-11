package Trees;

public interface IHANBinaryTree<T extends Comparable<? super T>> extends Iterable<T> {

    int getDepth();

    int getCount();

    IHANBinaryTree<T> add(T value);

    boolean contains(T value);
}
