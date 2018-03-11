package Trees;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class HANBinaryTreeTests {

    @Test
    public void emptyTreeHadDepth0() {
        HANBinaryTree<Integer> tree = new HANBinaryEmpty<Integer>();

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
    public void treeWith5and3HasDepth2()
    {
        HANBinaryTree<Integer> tree = new HANBinaryEmpty<Integer>().add(5).add(3);

        int depth = tree.getDepth();

        assertEquals(2, depth);
    }

    @Test
    public void treeWith5and3and8HasDepth2()
    {
        HANBinaryTree<Integer> tree = new HANBinaryEmpty<Integer>().add(5).add(3).add(8);

        int depth = tree.getDepth();

        assertEquals(2, depth);
    }

    @Test
    public void treeWith5and8HasDepth2()
    {
        HANBinaryTree<Integer> tree = new HANBinaryEmpty<Integer>().add(5).add(8);

        int depth = tree.getDepth();

        assertEquals(2, depth);
    }

    @Test
    public void treeWith5and3and1HasDepth3()
    {
        HANBinaryTree<Integer> tree = new HANBinaryEmpty<Integer>().add(5).add(3).add(1);

        int depth = tree.getDepth();

        assertEquals(3, depth);
    }

    @Test
    public void treeWith5and5HasDepth1()
    {
        HANBinaryTree<Integer> tree = new HANBinaryEmpty<Integer>().add(5).add(5);

        int depth = tree.getDepth();

        assertEquals(1, depth);
    }

    @Test
    public void emptyTreeHasCount0()
    {
        HANBinaryTree<Integer> tree = new HANBinaryEmpty<Integer>();

        int count = tree.getCount();

        assertEquals(0, count);
    }

    @Test
    public void treeWith5HasCount1()
    {
        HANBinaryTree<Integer> tree = new HANBinaryEmpty<Integer>().add(5);

        int count = tree.getCount();

        assertEquals(1, count);
    }

    @Test
    public void treeWith5and3and8HasCount3()
    {
        HANBinaryTree<Integer> tree = new HANBinaryEmpty<Integer>().add(5).add(3).add(8);

        int count = tree.getCount();

        assertEquals(3, count);
    }

    @Test
    public void emptyTreeDoesNotContains5()
    {
        HANBinaryTree<Integer> tree = new HANBinaryEmpty<Integer>();

        boolean result = tree.contains(5);

        assertEquals(false, result);
    }

    @Test
    public void treeWith5Contains5()
    {
        HANBinaryTree<Integer> tree = new HANBinaryEmpty<Integer>().add(5);

        boolean result = tree.contains(5);

        assertEquals(true, result);
    }

    @Test
    public void treeWith5and3and8Contains8()
    {
        HANBinaryTree<Integer> tree = new HANBinaryEmpty<Integer>().add(5).add(3).add(8);

        boolean result = tree.contains(8);

        assertEquals(true, result);
    }

    @Test
    public void treeWith5and3and8DoesNotContain7()
    {
        HANBinaryTree<Integer> tree = new HANBinaryEmpty<Integer>().add(5).add(3).add(8);

        boolean result = tree.contains(7);

        assertEquals(false, result);
    }

}
