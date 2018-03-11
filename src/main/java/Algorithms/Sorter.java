package Algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SuppressWarnings("WeakerAccess")
public class Sorter {

    private static final String INPUT_NOT_NULL_EXCEPTION = "input should not be null";

    public static <T extends Comparable<? super T>> List<T> insertionSort(List<T> input) {
        if (input == null) {
            throw new IllegalArgumentException(INPUT_NOT_NULL_EXCEPTION);
        }

        return Arrays.asList(insertionSort((T[]) input.toArray()));
    }

    public static <T extends Comparable<? super T>> T[] insertionSort(T[] input) {
        if (input == null) {
            throw new IllegalArgumentException(INPUT_NOT_NULL_EXCEPTION);
        }

        int size = input.length;

        for (int i = 1; i < size; i++) {
            for (int j = i; j > 0; j--) {
                if (input[j].compareTo(input[j - 1]) < 0) {
                    T temp = input[j];
                    input[j] = input[j - 1];
                    input[j - 1] = temp;
                }
            }
        }

        return input;
    }

    public static <T extends Comparable<? super T>> List bubbleSort(List<T> input) {
        if (input == null) {
            throw new IllegalArgumentException(INPUT_NOT_NULL_EXCEPTION);
        }

        return Arrays.asList(bubbleSort((T[]) input.toArray()));
    }

    public static <T extends Comparable<? super T>> T[] bubbleSort(T[] input) {
        if (input == null) {
            throw new IllegalArgumentException(INPUT_NOT_NULL_EXCEPTION);
        }

        int size = input.length;

        for (int i = 0; i < size; i++) {
            for (int j = 1; j < (size - i); j++) {
                if (input[j - 1].compareTo(input[j]) > 0) {
                    T temp = input[j - 1];
                    input[j - 1] = input[j];
                    input[j] = temp;
                }
            }
        }

        return input;
    }

    public static <T extends Comparable<? super T>> List selectionSort(List<T> input) {
        if (input == null) {
            throw new IllegalArgumentException(INPUT_NOT_NULL_EXCEPTION);
        }

        return Arrays.asList(selectionSort((T[]) input.toArray()));
    }

    public static <T extends Comparable<? super T>> T[] selectionSort(T[] input) {
        if (input == null) {
            throw new IllegalArgumentException(INPUT_NOT_NULL_EXCEPTION);
        }

        int size = input.length;

        for (int i = 0; i < size - 1; i++) {
            int index = i;

            for (int j = i + 1; j < size; j++) {
                if (input[j].compareTo(input[index]) < 0) {
                    index = j;
                }
            }

            T smaller = input[index];
            input[index] = input[i];
            input[i] = smaller;
        }

        return input;
    }

    public static <T extends Comparable<? super T>> List mergeSort(List<T> input) {
        if (input == null) {
            throw new IllegalArgumentException(INPUT_NOT_NULL_EXCEPTION);
        }

        return Arrays.asList(mergeSort((T[]) input.toArray()));
    }

    public static <T extends Comparable<? super T>> T[] mergeSort(T[] input) {
        mergeSort(input, 0, input.length - 1);

        return input;
    }

    private static <T extends Comparable<? super T>> void mergeSort(T[] input, int links, int rechts) {
        if (links < rechts) {
            int midden = (links + rechts) / 2;

            mergeSort(input, links, midden);
            mergeSort(input, midden + 1, rechts);

            merge(input, links, midden, rechts);
        }
    }

    private static <T extends Comparable<? super T>> void merge(T[] input, int links, int midden, int rechts) {
        // Find sizes of two subarrays to be merged
        int arraySizeLinks = midden - links + 1;
        int arraySizeRechts = rechts - midden;

        /* Create temp arrays */
        ArrayList<T> tempLinks = new ArrayList<>(arraySizeLinks);
        ArrayList<T> tempRechts = new ArrayList<>(arraySizeRechts);

        /*Copy data to temp arrays*/
        for (int i = 0; i < arraySizeLinks; ++i) {
            tempLinks.add(input[links + i]);
        }
        for (int i = 0; i < arraySizeRechts; ++i) {
            tempRechts.add(input[midden + 1 + i]);
        }


        /* Merge the temp arrays */

        // Initial indexes of first and second subarrays
        int indexLinks = 0, indexRechts = 0;

        // Initial index of merged subarry array
        int mergedIndex = links;
        while (indexLinks < arraySizeLinks && indexRechts < arraySizeRechts) {
            if (tempLinks.get(indexLinks).compareTo(tempRechts.get(indexRechts)) <= 0) {
                input[mergedIndex] = tempLinks.get(indexLinks);
                indexLinks++;
            } else {
                input[mergedIndex] = tempRechts.get(indexRechts);
                indexRechts++;
            }
            mergedIndex++;
        }

        /* Copy remaining elements of L[] if any */
        while (indexLinks < arraySizeLinks) {
            input[mergedIndex] = tempLinks.get(indexLinks);
            indexLinks++;
            mergedIndex++;
        }

        /* Copy remaining elements of R[] if any */
        while (indexRechts < arraySizeRechts) {
            input[mergedIndex] = tempRechts.get(indexRechts);
            indexRechts++;
            mergedIndex++;
        }
    }


    public static <T extends Comparable<? super T>> List<T> quickSort(List<T> input) {
        if (input == null) {
            throw new IllegalArgumentException(INPUT_NOT_NULL_EXCEPTION);
        }

        return Arrays.asList(quickSort((T[]) input.toArray()));
    }

    public static <T extends Comparable<? super T>> T[] quickSort(T[] input) {
        if (input == null) {
            throw new IllegalArgumentException(INPUT_NOT_NULL_EXCEPTION);
        }

        quickSort(input, 0, input.length - 1);

        return input;
    }

    private static <T extends Comparable<? super T>> void quickSort(T[] arr, int low, int high) {
        if (arr == null || arr.length == 0) {
            return;
        }

        if (low >= high) {
            return;
        }

        int middle = low + (high - low) / 2;
        T pivot = arr[middle];

        int i = low;
        int j = high;

        while (i <= j) {
            while (arr[i].compareTo(pivot) < 0) {
                i++;
            }

            while (arr[j].compareTo(pivot) > 0) {
                j--;
            }

            if (i <= j) {
                T temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
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
