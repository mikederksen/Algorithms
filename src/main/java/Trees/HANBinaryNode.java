package Trees;

import java.util.Iterator;

@SuppressWarnings("WeakerAccess")
public class HANBinaryNode<T extends Comparable<? super T>> implements IHANBinaryTree<T> {
    private T value;
    private IHANBinaryTree<T> left;
    private IHANBinaryTree<T> right;

    public HANBinaryNode(T value) {
        this(value, new HANBinaryEmpty<>(), new HANBinaryEmpty<>());
    }

    public HANBinaryNode(T value, IHANBinaryTree<T> left, IHANBinaryTree<T> right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    @Override
    public int getDepth() {
        return 1 + Math.max(left.getDepth(), right.getDepth());
    }

    @Override
    public int getCount() {
        return 1 + left.getCount() + right.getCount();
    }

    @Override
    public IHANBinaryTree<T> add(T value) {
        if (value.compareTo(this.value) == 0) {
            return this;
        } else if (value.compareTo(this.value) < 0) {
            return new HANBinaryNode<>(this.value, left.add(value), right);
        } else {
            return new HANBinaryNode<>(this.value, left, right.add(value));
        }
    }

    @Override
    public boolean contains(T value) {
        if (value.compareTo(this.value) == 0) {
            return true;
        } else if (value.compareTo(this.value) < 0) {
            return left.contains(value);
        } else {
            return right.contains(value);
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new HANBinaryNodeIterator();
    }

    private class HANBinaryNodeIterator implements Iterator<T> {
        private final Iterator<T> leftIterator;
        private final Iterator<T> rightIterator;
        private T current = null;

        public HANBinaryNodeIterator() {
            leftIterator = left instanceof HANBinaryNode
                    ? ((HANBinaryNode)left).iterator()
                    : null;

            rightIterator = right instanceof HANBinaryNode
                    ? ((HANBinaryNode)right).iterator()
                    : null;
        }

        @Override
        public boolean hasNext() {
            return hasLeft() || current == null || hasRight();
        }

        @Override
        public T next() {
            if(hasLeft()) {
                return leftIterator.next();
            } else if(current == null) {
                current = value;
                return current;
            } else if(hasRight()) {
                return rightIterator.next();
            } else {
                throw new IndexOutOfBoundsException();
            }
        }

        private boolean hasLeft () {
            return leftIterator != null && leftIterator.hasNext();
        }

        private boolean hasRight() {
            return rightIterator != null && rightIterator.hasNext();
        }
    }
}
