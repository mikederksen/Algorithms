package Trees;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class HANFCNSTreeTests {

    @Test
    public void toStringPrintsTreeWithMultipleItems() {
        HANFCNSTreeNode<Integer> tree = new HANFCNSTreeNode<>(0);
        HANFCNSTreeNode<Integer> node1 = new HANFCNSTreeNode<>(1);
        HANFCNSTreeNode<Integer> node2 = new HANFCNSTreeNode<>(2);
        HANFCNSTreeNode<Integer> node3 = new HANFCNSTreeNode<>(3);
        HANFCNSTreeNode<Integer> node4 = new HANFCNSTreeNode<>(4);
        HANFCNSTreeNode<Integer> node5 = new HANFCNSTreeNode<>(5);
        HANFCNSTreeNode<Integer> node6 = new HANFCNSTreeNode<>(6);
        HANFCNSTreeNode<Integer> node7 = new HANFCNSTreeNode<>(7);

        tree.addChild(node1);
        tree.addChild(node2);
        node2.addChild(node3);
        node2.addChild(node4);
        node1.addChild(node5);
        node1.addChild(node6);
        node5.addChild(node7);

        String expected = "0\n" +
                ".1\n" +
                "..5\n" +
                "...7\n" +
                "..6\n" +
                ".2\n" +
                "..3\n" +
                "..4";

        assertEquals(expected, tree.toString());
    }

    @Test
    public void getValueRetrievesValue() {
        Integer value = 10;
        HANFCNSTreeNode<Integer> node = new HANFCNSTreeNode<>(value);

        assertEquals(value, node.getValue());
    }
}
