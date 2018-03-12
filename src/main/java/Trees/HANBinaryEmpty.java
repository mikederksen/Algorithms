package Trees;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class HANBinaryEmpty<T extends Comparable<? super T>> extends HANBinaryTree<T> {

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
        return new HANBinaryNode<>(value);
    }

    @Override
    public boolean contains(T value) {
        return false;
    }

    @Override
    public T find(T value) {
        throw new NoSuchElementException();
    }

    @Override
    public HANBinaryTree<T> balance() {
        return new HANBinaryEmpty<T>();
    }

    @Override
    public String toString() {
        return "";
    }

    @Override
    protected void appendToString(int indent, StringBuilder builder) {
        // Do nothing. This is the leaf node
    }

    @Override
    public T findMin() {
        throw new NoSuchElementException();
    }

    @Override
    public T findMax() {
        throw new NoSuchElementException();
    }

    @Override
    public Iterator<T> iterator() {
        return new EmptyIterator();
    }

    private class EmptyIterator implements Iterator<T> {

        @Override
        public boolean hasNext() {
            return false;
        }

        @Override
        public T next() {
            throw new NoSuchElementException();
        }
    }
}
