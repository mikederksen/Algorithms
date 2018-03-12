package Trees;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

@SuppressWarnings("WeakerAccess")
public class HANBinaryNode<T extends Comparable<? super T>> extends HANBinaryTree<T> {
    private T value;
    private HANBinaryTree<T> left;
    private HANBinaryTree<T> right;

    public HANBinaryNode(T value) {
        this(value, new HANBinaryEmpty<>(), new HANBinaryEmpty<>());
    }

    public HANBinaryNode(T value, HANBinaryTree<T> left, HANBinaryTree<T> right) {
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
    public HANBinaryTree<T> add(T value) {
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
        try {
            find(value);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    @Override
    public T find(T value) {
        if(isSame(value)) {
            return this.value;
        } else if (isSmaller(value)) {
            return left.find(value);
        } else {
            return right.find(value);
        }
    }

    @Override
    public HANBinaryTree<T> balance() {
        List<T> sortedItems = new ArrayList<>();

        for(T item : this) {
            sortedItems.add(item);
        }

        return sortedArrayToBalanced(sortedItems, 0, sortedItems.size() -1);
    }

    private HANBinaryTree<T> sortedArrayToBalanced(List<T> arr, int start, int end){
        if (start > end){
            return new HANBinaryEmpty<>();
        }

        int mid = (start + end) / 2;

        return new HANBinaryNode<>(
                arr.get(mid),
                sortedArrayToBalanced(arr, start, mid - 1),
                sortedArrayToBalanced(arr, mid + 1, end));
    }

    @Override
    public T findMin() {
        return left instanceof HANBinaryNode
                ? left.findMin()
                : value;
    }

    @Override
    public T findMax() {
        return right instanceof HANBinaryNode
                ? right.findMax()
                : value;
    }

    @Override
    public Iterator<T> iterator() {
        return new HANBinaryNodeIterator();
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        appendToString(0, builder);

        return builder.toString();
    }

    @Override
    protected void appendToString(int indent, StringBuilder builder) {
        if(indent != 0) {
            builder.append('\n');
            builder.append(new String(new char[indent - 1]).replace('\0', ' '));
            builder.append('┝');
        }

        builder.append(value);

        left.appendToString(indent + 1, builder);
        right.appendToString(indent + 1, builder);
    }

    private boolean isSame(T value) {
        return value.compareTo(this.value) == 0;
    }

    private boolean isSmaller(T value) {
        return value.compareTo(this.value) < 0;
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
