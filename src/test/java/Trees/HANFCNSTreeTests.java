package Trees;

import org.junit.Test;

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

        System.out.println(tree);
    }
}
