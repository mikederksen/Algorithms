package CustomTypes;

import java.util.ArrayList;
import java.util.EmptyStackException;

public class HANArrayStack<T> implements java.io.Serializable {

    private ArrayList<T> items;

    public HANArrayStack() {
        items = new ArrayList<>();
    }

    public T push(T x) {
        items.add(x);

        return x;
    }

    public T pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }

        return items.remove(items.size() - 1);
    }

    public T peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }

        return items.get(items.size() - 1);
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public int size() {
        return items.size();
    }

    public void clear() {
        items.clear();
    }

    @Override
    public String toString() {
        return items.toString();
    }
}