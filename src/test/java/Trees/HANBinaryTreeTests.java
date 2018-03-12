package Trees;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

public class HANBinaryTreeTests {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void emptyTreeHadDepth0() {
        HANBinaryTree<Integer> tree = new HANBinaryEmpty<>();

        int depth = tree.getDepth();

        assertEquals(0, depth);
    }

    @Test
    public void treeWith5HasDepth1() {
        HANBinaryTree<Integer> tree = new HANBinaryEmpty<Integer>().add(5);

        int depth = tree.getDepth();

        assertEquals(1, depth);
    }

    @Test
    public void treeWith5and3HasDepth2() {
        HANBinaryTree<Integer> tree = new HANBinaryEmpty<Integer>().add(5).add(3);

        int depth = tree.getDepth();

        assertEquals(2, depth);
    }

    @Test
    public void treeWith5and3and8HasDepth2() {
        HANBinaryTree<Integer> tree = new HANBinaryEmpty<Integer>().add(5).add(3).add(8);

        int depth = tree.getDepth();

        assertEquals(2, depth);
    }

    @Test
    public void treeWith5and8HasDepth2() {
        HANBinaryTree<Integer> tree = new HANBinaryEmpty<Integer>().add(5).add(8);

        int depth = tree.getDepth();

        assertEquals(2, depth);
    }

    @Test
    public void treeWith5and3and1HasDepth3() {
        HANBinaryTree<Integer> tree = new HANBinaryEmpty<Integer>().add(5).add(3).add(1);

        int depth = tree.getDepth();

        assertEquals(3, depth);
    }

    @Test
    public void treeWith5and5HasDepth1() {
        HANBinaryTree<Integer> tree = new HANBinaryEmpty<Integer>().add(5).add(5);

        int depth = tree.getDepth();

        assertEquals(1, depth);
    }

    @Test
    public void emptyTreeHasCount0() {
        HANBinaryTree<Integer> tree = new HANBinaryEmpty<Integer>();

        int count = tree.getCount();

        assertEquals(0, count);
    }

    @Test
    public void treeWith5HasCount1() {
        HANBinaryTree<Integer> tree = new HANBinaryEmpty<Integer>().add(5);

        int count = tree.getCount();

        assertEquals(1, count);
    }

    @Test
    public void treeWith5and3and8HasCount3() {
        HANBinaryTree<Integer> tree = new HANBinaryEmpty<Integer>().add(5).add(3).add(8);

        int count = tree.getCount();

        assertEquals(3, count);
    }

    @Test
    public void emptyTreeDoesNotContains5() {
        HANBinaryTree<Integer> tree = new HANBinaryEmpty<Integer>();

        boolean result = tree.contains(5);

        assertEquals(false, result);
    }

    @Test
    public void treeWith5Contains5() {
        HANBinaryTree<Integer> tree = new HANBinaryEmpty<Integer>().add(5);

        boolean result = tree.contains(5);

        assertEquals(true, result);
    }

    @Test
    public void treeWith5and3and8Contains8() {
        HANBinaryTree<Integer> tree = new HANBinaryEmpty<Integer>().add(5).add(3).add(8);

        boolean result = tree.contains(8);

        assertEquals(true, result);
    }

    @Test
    public void treeWith5and3and8Contains5() {
        HANBinaryTree<Integer> tree = new HANBinaryEmpty<Integer>().add(5).add(3).add(8);

        assertTrue(tree.contains(5));
    }

    @Test
    public void treeWith5and3and8DoesNotContain7() {
        HANBinaryTree<Integer> tree = new HANBinaryEmpty<Integer>().add(5).add(3).add(8);

        boolean result = tree.contains(7);

        assertEquals(false, result);
    }

    @Test
    public void emptyTreeDoesNotFinds5() {
        expectedException.expect(NoSuchElementException.class);
        HANBinaryTree<Integer> tree = new HANBinaryEmpty<>();

        tree.find(5);
    }

    @Test
    public void treeWith5Finds5() {
        HANBinaryTree<Integer> tree = new HANBinaryEmpty<Integer>().add(5);

        assertEquals((Integer) 5, tree.find(5));
    }

    @Test
    public void treeWith5and3and8Finds8() {
        HANBinaryTree<Integer> tree = new HANBinaryEmpty<Integer>().add(5).add(3).add(8);

        assertEquals((Integer) 8, tree.find(8));
    }

    @Test
    public void treeWith5and3and8Find5() {
        HANBinaryTree<Integer> tree = new HANBinaryEmpty<Integer>().add(5).add(3).add(8);

        assertEquals((Integer) 5, tree.find(5));
    }

    @Test
    public void treeWith5and3and8DoesNotFind7() {
        expectedException.expect(NoSuchElementException.class);
        HANBinaryTree<Integer> tree = new HANBinaryEmpty<Integer>().add(5).add(3).add(8);

        tree.find(7);
    }

    @Test
    public void treeWithMultipleCanIterate() {
        int[] items = new int[]{5, 3, 2, 4, 16, 10, 11, 12};
        HANBinaryTree<Integer> tree = new HANBinaryEmpty<>();

        for (int item : items) {
            tree = tree.add(item);
        }

        Iterator<Integer> iterator = tree.iterator();
        Arrays.sort(items);

        for (Integer item : items) {
            assertEquals(item, iterator.next());
        }
    }

    @Test
    public void findMinFindsMinimumWhenMultipleItemspPresent() {
        Integer expected = 3;
        HANBinaryTree<Integer> tree = new HANBinaryEmpty<Integer>().add(5).add(expected).add(8);

        assertEquals(expected, tree.findMin());
    }

    @Test
    public void findMinFindsMaximumWhenMultipleItemspResent() {
        Integer expected = 8;
        HANBinaryTree<Integer> tree = new HANBinaryEmpty<Integer>().add(5).add(3).add(expected);

        assertEquals(expected, tree.findMax());
    }

    @Test
    public void findMinFindsMinimumWhenOneItemPresent() {
        Integer expected = 5;
        HANBinaryTree<Integer> tree = new HANBinaryEmpty<Integer>().add(expected);

        assertEquals(expected, tree.findMin());
    }

    @Test
    public void findMaxFindsMaximumWhenOneItemPresent() {
        Integer expected = 5;
        HANBinaryTree<Integer> tree = new HANBinaryEmpty<Integer>().add(expected);

        assertEquals(expected, tree.findMax());
    }

    @Test
    public void findMinThrowsNoSuchElementExceptionWhenEmpty() {
        expectedException.expect(NoSuchElementException.class);
        HANBinaryTree<Integer> tree = new HANBinaryEmpty<>();

        tree.findMin();
    }

    @Test
    public void findMaxThrowsNoSuchElementExceptionWhenEmpty() {
        expectedException.expect(NoSuchElementException.class);
        HANBinaryTree<Integer> tree = new HANBinaryEmpty<>();

        tree.findMax();
    }

    @Test
    public void toStringPrintsTreeWithMultiple() {
        HANBinaryTree<Integer> tree = new HANBinaryEmpty<Integer>().add(5).add(3).add(8);

        String expected = "5\n" +
                          ".3\n" +
                          ".8";

        assertEquals(expected, tree.toString());
    }

    @Test
    public void toStringPrintsTreeWithMultipleWhenLeftLongerThanRight() {
        HANBinaryTree<Integer> tree = new HANBinaryEmpty<Integer>().add(5).add(3).add(8).add(1);

        String expected = "5\n" +
                          ".3\n" +
                          "..1\n" +
                          ".8";

        assertEquals(expected, tree.toString());
    }

    @Test
    public void toStringPrintsNothingWhenEmpty() {
        HANBinaryTree<Integer> tree = new HANBinaryEmpty<>();

        assertEquals("", tree.toString());
    }

    @Test
    public void toStringPrintsManyItems() {
        HANBinaryTree<Integer> tree = new HANBinaryEmpty<Integer>()
                .add(5)
                .add(3)
                .add(8)
                .add(1)
                .add(10)
                .add(11)
                .add(14)
                .add(13)
                .add(14)
                .add(15);

        String expected = "5\n" +
                          ".3\n" +
                          "..1\n" +
                          ".8\n" +
                          "..10\n" +
                          "...11\n" +
                          "....14\n" +
                          ".....13\n" +
                          ".....15";

        assertEquals(expected, tree.toString());
    }
}
