package Trees;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class HANBinaryEmpty<T extends Comparable<? super T>> implements IHANBinaryTree<T> {

    @Override
    public int getDepth() {
        return 0;
    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public IHANBinaryTree<T> add(T value) {
        return new HANBinaryNode<>(value);
    }

    @Override
    public boolean contains(T value) {
        return false;
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
