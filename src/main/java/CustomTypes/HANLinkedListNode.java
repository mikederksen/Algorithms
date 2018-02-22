package CustomTypes;

public class HANLinkedListNode<T> {

    private final T value;
    private HANLinkedListNode<T> next;

    public HANLinkedListNode(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public void setNext(HANLinkedListNode<T> node) {
        next = node;
    }

    public HANLinkedListNode<T> getNext() {
        return next;
    }
}
