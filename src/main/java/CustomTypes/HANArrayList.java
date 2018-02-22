package CustomTypes;

import java.util.Arrays;

public class HANArrayList<T> {

    private int counter;
    private Object[] items;

    public HANArrayList() {
        counter = 0;
        items = new Object[6];
    }

    public void add(T value) {
        items[counter] = value;
        counter++;

        if(counter == items.length) {
            doubleArray();
        }
    }

    public void set(int index, T value) {
        if(isOutOfBounds(index)) {
            throw new ArrayIndexOutOfBoundsException();
        }

        items[index] = value;
    }

    public T get (int index) {
        if(isOutOfBounds(index)) {
            throw new IndexOutOfBoundsException();
        }

        return (T) items[index];
    }

    private void doubleArray() {
        items = Arrays.copyOf(items, items.length * 2);
    }

    private boolean isOutOfBounds(int index) {
        return index > counter -1;
    }
}
