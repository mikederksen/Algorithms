package Algorithms;

import java.util.ArrayList;
import java.util.List;

public class Sorter {

    private static final String INPUT_NOT_NULL_EXCEPTION = "input should not be null";

    public static <T extends Comparable<T>> List insertionSort(List<T> input) {
        if (input == null) {
            throw new IllegalArgumentException(INPUT_NOT_NULL_EXCEPTION);
        }

        List<T> sortedItems = new ArrayList<>(input);
        int size = sortedItems.size();

        for (int i = 1; i < size; i++) {
            for (int j = i; j > 0; j--) {
                if (sortedItems.get(j).compareTo(sortedItems.get(j - 1)) < 0) {
                    T temp = sortedItems.get(j);
                    sortedItems.set(j, sortedItems.get(j - 1));
                    sortedItems.set(j - 1, temp);
                }
            }
        }

        return sortedItems;
    }

    public static <T extends Comparable<? super T>> List bubbleSort(List<T> input) {
        if (input == null) {
            throw new IllegalArgumentException(INPUT_NOT_NULL_EXCEPTION);
        }

        List<T> sortedItems = new ArrayList<>(input);
        int size = sortedItems.size();

        for (int i = 0; i < size; i++) {
            for (int j = 1; j < (size - i); j++) {
                if (sortedItems.get(j - 1).compareTo(sortedItems.get(j)) > 0) {
                    T temp = sortedItems.get(j - 1);
                    sortedItems.set(j - 1, sortedItems.get(j));
                    sortedItems.set(j, temp);
                }

            }
        }

        return sortedItems;
    }

    public static <T extends Comparable<T>> List selectionSort(List<T> input) {
        if (input == null) {
            throw new IllegalArgumentException(INPUT_NOT_NULL_EXCEPTION);
        }

        List<T> sortedItems = new ArrayList<>(input);
        int size = sortedItems.size();

        for (int i = 0; i < size - 1; i++) {
            int index = i;

            for (int j = i + 1; j < size; j++) {
                if (sortedItems.get(j).compareTo(sortedItems.get(index)) < 0) {
                    index = j;
                }
            }

            T smaller = sortedItems.get(index);
            sortedItems.set(index, sortedItems.get(i));
            sortedItems.set(i, smaller);
        }

        return sortedItems;
    }

    public static <T extends Comparable<T>> List mergeSort(List<T> input) {
        if (input == null) {
            throw new IllegalArgumentException(INPUT_NOT_NULL_EXCEPTION);
        }

        List<T> sortedItems = new ArrayList<>(input);

        return sortedItems;
    }

    public static <T extends Comparable<T>> List quickSort(List<T> input) {
        if (input == null) {
            throw new IllegalArgumentException(INPUT_NOT_NULL_EXCEPTION);
        }

        List<T> sortedItems = new ArrayList<>(input);

        return sortedItems;
    }
}
