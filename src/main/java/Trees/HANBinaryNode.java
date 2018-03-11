package Trees;

public class HANBinaryNode<T extends Comparable<? super T>> extends HANBinaryTree<T> {
    private T _value;
    private HANBinaryTree<T> _left;
    private HANBinaryTree<T> _right;

    public HANBinaryNode(T value) {
        this(value, new HANBinaryEmpty<>(), new HANBinaryEmpty<>());
    }

    public HANBinaryNode(T value, HANBinaryTree<T> left, HANBinaryTree<T> right) {
        _value = value;
        _left = left;
        _right = right;
    }

    @Override
    public int getDepth() {
        return 1 + Math.max(_left.getDepth(), _right.getDepth());
    }

    @Override
    public int getCount() {
        return 1 + _left.getCount() + _right.getCount();
    }

    @Override
    public HANBinaryTree<T> add(T value) {
        if (value.compareTo(_value) == 0) {
            return this;
        } else if (value.compareTo(_value) < 0) {
            return new HANBinaryNode<T>(value, _left.add(value), _right);
        } else {
            return new HANBinaryNode<T>(value, _left, _right.add(value));
        }
    }

    @Override
    public boolean contains(T value) {
        if (value.compareTo(_value) == 0) {
            return true;
        } else if (value.compareTo(_value) < 0) {
            return _left.contains(value);
        } else {
            return _right.contains(value);
        }
    }
}
