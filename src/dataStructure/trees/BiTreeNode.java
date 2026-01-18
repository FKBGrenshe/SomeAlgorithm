package dataStructure.trees;

/**
 * @Author: Bingyu Chen
 * @CreateTime: 2026-01-18
 * @Description: 二叉树节点
 */
public class BiTreeNode {

    int value;
    BiTreeNode leftChild, rightChild;

    public BiTreeNode(int value, BiTreeNode leftChild, BiTreeNode rightChild) {
        this.value = value;
        this.leftChild = leftChild;
        this.rightChild = rightChild;
    }

    public BiTreeNode(int value) {
        this.value = value;
    }

    public BiTreeNode() {
    }
}
