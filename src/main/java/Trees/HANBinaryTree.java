package Trees;

import javax.management.openmbean.KeyAlreadyExistsException;

public abstract class HANBinaryTree<T extends Comparable<? super T>> {

    public abstract int getDepth();

    public abstract int getCount();

    public abstract HANBinaryTree<T> add(T value);

    public abstract boolean contains(T value);
}
