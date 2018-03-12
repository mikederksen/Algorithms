package Trees;

import java.util.Optional;

@SuppressWarnings("WeakerAccess")
public class HANFCNSTreeNode<T> {

    private T value;
    private HANFCNSTreeNode<T> child;
    private HANFCNSTreeNode<T> sibling;

    public HANFCNSTreeNode(T value) {
        this.value = value;
    }

    public void addChild(HANFCNSTreeNode<T> value) {
        if (child != null) {
            child.addSibling(value);
        } else {
            child = value;
        }
    }

    public T getValue() {
        return value;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        appendToString(0, builder);

        return builder.toString();
    }

    private void appendToString(int indent, StringBuilder builder) {
        if(indent != 0) {
            builder.append('\n');
        }

        builder.append(new String(new char[indent]).replace('\0', '.'));
        builder.append(value);

        if(child != null) {
            child.appendToString(indent + 1, builder);
        }

        if(sibling != null) {
            sibling.appendToString(indent, builder);
        }
    }

    private void addSibling(HANFCNSTreeNode<T> value) {
        if (sibling != null) {
            sibling.addSibling(value);
        } else {
            sibling = value;
        }
    }
}
