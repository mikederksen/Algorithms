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
        quickSort(sortedItems, 0, sortedItems.size() - 1);

        return sortedItems;
    }

    private static <T extends Comparable<T>> void quickSort(List<T> arr, int low, int high) {
        if (arr == null || arr.size() == 0) {
            return;
        }

        if (low >= high) {
            return;
        }

        int middle = low + (high - low) / 2;
        T pivot = arr.get(middle);

        int i = low;
        int j = high;

        while (i <= j) {
            while (arr.get(i).compareTo(pivot) < 0) {
                i++;
            }

            while (arr.get(j).compareTo(pivot) > 0) {
                j--;
            }

            if (i <= j) {
                T temp = arr.get(i);
                arr.set(i, arr.get(j));
                arr.set(j, temp);
                i++;
                j--;
            }
        }

        if (low < j) {
            quickSort(arr, low, j);
        }

        if (high > i) {
            quickSort(arr, i, high);
        }
    }
}