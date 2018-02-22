package CustomTypes;

public class HANLinkedList<T> {

    private HANLinkedListNode<T> firstNode;

    public void addFirst(T value) {
        HANLinkedListNode<T> previousFirst = firstNode;
        firstNode = new HANLinkedListNode<T>(value);
        firstNode.setNext(previousFirst);
    }

    public void removeFirst() {
        firstNode = firstNode.getNext();
    }

    public void insert(int index, T value) {
        HANLinkedListNode<T> nodeBeforeTarget = getNode(index - 1);
        HANLinkedListNode<T> currentTargetNode = nodeBeforeTarget.getNext();
        HANLinkedListNode<T> newTargetNode = new HANLinkedListNode<T>(value);

        newTargetNode.setNext(currentTargetNode);
        nodeBeforeTarget.setNext(newTargetNode);
    }

    public void delete(int index) {
        HANLinkedListNode<T> nodeBeforeTarget = getNode(index - 1);
        HANLinkedListNode<T> nodeAfterTarget = nodeBeforeTarget.getNext()
                                                               .getNext();

        nodeBeforeTarget.setNext(nodeAfterTarget);
    }

    public T get(int index) {
        return getNode(index).getValue();
    }

    private HANLinkedListNode<T> getNode(int index) {
        HANLinkedListNode<T> next = firstNode;

        for (int i = 0; i < index; i++) {
            next = next.getNext();
        }

        return next;
    }
}
