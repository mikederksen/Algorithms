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

    private void addSibling(T value) {
        if(sibling != null) {
            sibling.addSibling(value);
        } else {
            sibling = new HANFCNSTreeNode<>(value);
        }
    }

    public void addChild(T value) {
        if(child != null) {
            child.addSibling(value);
        } else {
            child = new HANFCNSTreeNode<>(value);
        }
    }

    public T getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "";
    }
}
