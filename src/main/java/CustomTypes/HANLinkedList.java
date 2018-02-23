package CustomTypes;

import java.util.Optional;

// HANLinkedList should not be package-prive since this is a library
@SuppressWarnings({"WeakerAccess"})
public class HANLinkedList<T> {

    private Optional<HANLinkedListNode<T>> firstNode;

    public HANLinkedList() {
        firstNode = Optional.empty();
    }

    public void addFirst(T value) {
        HANLinkedListNode<T> newFirstNode = new HANLinkedListNode<>(value);
        firstNode.ifPresent(newFirstNode::setNext);
        firstNode = Optional.of(newFirstNode);
    }

    public void removeFirst() {
        firstNode.ifPresent(currentFirst ->
                firstNode = currentFirst.getNext());
    }

    public void insert(int index, T value) {
        HANLinkedListNode<T> nodeBeforeTarget = getNode(index - 1);
        HANLinkedListNode<T> newTargetNode = new HANLinkedListNode<>(value);
        Optional<HANLinkedListNode<T>> maybeOldTargetNode = nodeBeforeTarget.getNext();

        nodeBeforeTarget.setNext(newTargetNode);
        maybeOldTargetNode.ifPresent(newTargetNode::setNext);
    }

    public void delete(int index) {
        HANLinkedListNode<T> nodeBeforeTarget = getNode(index - 1);
        HANLinkedListNode<T> targetNode =
                nodeBeforeTarget.getNext().orElseThrow(ArrayIndexOutOfBoundsException::new);

        targetNode.getNext().ifPresent(nodeBeforeTarget::setNext);
    }

    public T get(int index) {
        return getNode(index).getValue();
    }

    private HANLinkedListNode<T> getNode(int index) {
        HANLinkedListNode<T> next = firstNode.orElseThrow(ArrayIndexOutOfBoundsException::new);

        for (int i = 0; i < index; i++) {
            Optional<HANLinkedListNode<T>> nextDing = next.getNext();
            next = nextDing.orElseThrow(ArrayIndexOutOfBoundsException::new);
        }

        return next;
    }
}
