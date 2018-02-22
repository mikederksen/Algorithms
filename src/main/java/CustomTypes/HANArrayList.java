package CustomTypes;

public class ArrayList <T> {

    private int counter;
    private Object[] items;

    public ArrayList() {
        counter = 0;
        items = new Object[6];
    }

    public void add(T value) {
        items[counter] = value;
        counter++;
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

    private boolean isOutOfBounds(int index) {
        return index > counter -1;
    }
}
