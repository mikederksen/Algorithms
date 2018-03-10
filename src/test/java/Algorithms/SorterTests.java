package Algorithms;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static junit.framework.TestCase.assertTrue;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@SuppressWarnings("ArraysAsListWithZeroOrOneArgument") // Lists with 1 items should be tested
public class SorterTests {

    private static final String INPUT_NOT_NULL_EXCEPTION = "input should not be null";
    private static final String ITEM = "Aap";

    private List<String> items;
    private List<String> sortedItems;

    @Before
    public void setUp() {
        items = Arrays.asList("A", "X", "C", "Z", "R", "B", "Q");
        sortedItems = sort(items);
    }

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void insertionSortSortsMultipleItems() {
        assertThat(Sorter.insertionSort(items), is(sortedItems));
    }

    @Test
    public void insertionSortSortsSingleItem() {
        assertThat(Sorter.insertionSort(Arrays.asList(ITEM)), is(Arrays.asList(ITEM)));
    }

    @Test
    public void insertionSortThrowsIllegalArgumentExceptionWhenInputIsNull() {
        expectedException.expect(IllegalArgumentException.class);

        Sorter.insertionSort(null);
    }

    @Test
    public void insertionSortReturnsNewInstance() {
        assertTrue(items != Sorter.insertionSort(items));
    }


    @Test
    public void bubbleSortSortsMultipleItems() {
        assertThat(Sorter.bubbleSort(items), is(sortedItems));
    }

    @Test
    public void bubbleSortSortsSingleItem() {
        assertThat(Sorter.bubbleSort(Arrays.asList(ITEM)), is(Arrays.asList(ITEM)));
    }

    @Test
    public void bubbleSortThrowsIllegalArgumentExceptionWhenInputIsNull() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage(INPUT_NOT_NULL_EXCEPTION);

        Sorter.bubbleSort(null);
    }

    @Test
    public void bubbleSortReturnsNewInstance() {
        assertTrue(items != Sorter.bubbleSort(items));
    }


    @Test
    public void selectionSortSortsMultipleItems() {
        assertThat(Sorter.selectionSort(items), is(sortedItems));
    }

    @Test
    public void selectionSortSortsSingleItem() {
        assertThat(Sorter.selectionSort(Arrays.asList(ITEM)), is(Arrays.asList(ITEM)));
    }

    @Test
    public void selectionSortThrowsIllegalArgumentExceptionWhenInputIsNull() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage(INPUT_NOT_NULL_EXCEPTION);

        Sorter.selectionSort(null);
    }

    @Test
    public void selectionSortReturnsNewInstance() {
        assertTrue(items != Sorter.selectionSort(items));
    }


    @Test
    public void mergeSortSortsMultipleItems() {
        assertThat(Sorter.mergeSort(items), is(sortedItems));
    }

    @Test
    public void mergeSortSortsSingleItem() {
        assertThat(Sorter.mergeSort(Arrays.asList(ITEM)), is(Arrays.asList(ITEM)));
    }

    @Test
    public void mergeSortThrowsIllegalArgumentExceptionWhenInputIsNull() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage(INPUT_NOT_NULL_EXCEPTION);

        Sorter.mergeSort(null);
    }

    @Test
    public void mergeSortReturnsNewInstance() {
        assertTrue(items != Sorter.mergeSort(items));
    }


    @Test
    public void quickSortSortsMultipleItems() {
        assertThat(Sorter.quickSort(items), is(sortedItems));
    }

    @Test
    public void quickSortSortsSingleItem() {
        assertThat(Sorter.quickSort(Arrays.asList(ITEM)), is(Arrays.asList(ITEM)));
    }

    @Test
    public void quickSortThrowsIllegalArgumentExceptionWhenInputIsNull() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage(INPUT_NOT_NULL_EXCEPTION);

        Sorter.quickSort(null);
    }

    @Test
    public void quickSortReturnsNewInstance() {
        assertTrue(items != Sorter.quickSort(items));
    }


    private static <T extends Comparable<? super T>> List<T> sort(List<T> input) {
        List<T> sortedItems = new ArrayList<>(input);
        Collections.sort(sortedItems);

        return sortedItems;
    }
}
