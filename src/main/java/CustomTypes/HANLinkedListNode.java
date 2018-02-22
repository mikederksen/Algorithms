package CustomTypes;

import java.util.Optional;

public class HANLinkedListNode<T> {

    private final T value;
    private Optional<HANLinkedListNode<T>> next;

    public HANLinkedListNode(T value) {
        if (value == null) {
            throw new IllegalArgumentException();
        }

        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public void setNext(HANLinkedListNode<T> node) {
        next = Optional.of(node);
    }

    public Optional<HANLinkedListNode<T>> getNext() {
        return next;
    }
}
