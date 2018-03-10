package CustomTypes;

import Exceptions.EmptyQuackException;

import java.util.EmptyStackException;
import java.util.LinkedList;

@SuppressWarnings("WeakerAccess")
public class HANQuack<T> {
    private LinkedList<T> items;

    public HANQuack() {
        items = new LinkedList<>();
    }

    public void push(T item) {
        items.push(item);
    }

    /**
     * Stack
     */
    public T pop() {
        if (items.size() == 0) {
            throw new EmptyQuackException();
        }

        return items.removeFirst();
    }

    /**
     * Stack
     */
    public T peek() {
        if (items.size() == 0) {
            throw new EmptyQuackException();
        }

        return items.getFirst();
    }

    /**
     * Queue
     */
    public T dequeue() {
        if (items.size() == 0) {
            throw new EmptyQuackException();
        }

        return items.removeLast();
    }

    /**
     * Queue
     */
    public T poll() {
        if (items.size() == 0) {
            throw new EmptyQuackException();
        }

        return items.getLast();
    }

    public void clear() {
        items.clear();
    }

    public int getSize() {
        return items.size();
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }

    public void quack() {
        System.out.println("Quackerdequack!");
    }

    @Override
    public String toString() {
        return items.toString();
    }
}
