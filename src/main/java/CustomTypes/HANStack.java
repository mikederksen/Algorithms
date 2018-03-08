package CustomTypes;

import java.util.EmptyStackException;

// HANLinkedList should not be package-private since this is a library
@SuppressWarnings("WeakerAccess")
public class HANStack<T> {

    private HANLinkedList<T> items;

    public HANStack() {
        items = new HANLinkedList<>();
    }

    public T pop() {
        if(isEmpty()) {
            throw new EmptyStackException();
        }

        T topItem = top();
        items.removeFirst();

        return topItem;
    }

    public T top() {
        if(isEmpty()) {
            throw new EmptyStackException();
        }

        return items.get(0);
    }

    public void push(T value) {
        items.addFirst(value);
    }

    public int getSize() {
        return items.getSize();
    }

    public boolean isEmpty() {
        return getSize() <= 0;
    }

    @Override
    public String toString() {
        return items.toString();
    }
}
