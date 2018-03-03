package CustomTypes;

import java.util.Optional;

// HANLinkedList should not be package-private since this is a library
@SuppressWarnings({"WeakerAccess"})
public class HANLinkedList<T> {

    private Optional<HANLinkedListNode<T>> firstNode;
    private int size;

    public HANLinkedList() {
        firstNode = Optional.empty();
        size = 0;
    }

    public void addFirst(T value) {
        HANLinkedListNode<T> newFirstNode = new HANLinkedListNode<>(value);
        firstNode.ifPresent(newFirstNode::setNext);
        firstNode = Optional.of(newFirstNode);

        size++;
    }

    public void removeFirst() {
        firstNode.ifPresent(currentFirst ->{
            firstNode = currentFirst.getNext();
            size--;
        });
    }

    public void insert(int index, T value) {
        HANLinkedListNode<T> newTargetNode = new HANLinkedListNode<>(value);
        final Optional<HANLinkedListNode<T>> oldTargetNode;

        if(index == 0) {
            oldTargetNode = firstNode;
            firstNode = Optional.of(newTargetNode);
        } else {
            HANLinkedListNode<T> nodeBeforeTarget = getNode(index - 1);
            oldTargetNode = nodeBeforeTarget.getNext();

            nodeBeforeTarget.setNext(newTargetNode);
        }

        oldTargetNode.ifPresent(newTargetNode::setNext);

        size++;
    }

    public void delete(int index) {
        if(index == 0) {
            removeFirst();
        } else {
            HANLinkedListNode<T> nodeBeforeTarget = getNode(index - 1);
            HANLinkedListNode<T> targetNode = nodeBeforeTarget
                    .getNext()
                    .orElseThrow(ArrayIndexOutOfBoundsException::new);

            nodeBeforeTarget.setNext(targetNode.getNext().orElse(null));
            size--;
        }
    }

    public T get(int index) {
        return getNode(index).getValue();
    }

    public int getSize() {
        return size;
    }

    private HANLinkedListNode<T> getNode(int index) {
        HANLinkedListNode<T> next = firstNode
                .orElseThrow(ArrayIndexOutOfBoundsException::new);

        for (int i = 0; i < index; i++) {
            next = next
                    .getNext()
                    .orElseThrow(ArrayIndexOutOfBoundsException::new);
        }

        return next;
    }
}
