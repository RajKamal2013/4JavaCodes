package LeetCode.tree;

/**
 * Created by rajkamal on 12/19/17.
 */

public class SimpleTreeNode {
    //private int data;
    //private SimpleTreeNode left;
    //private SimpleTreeNode right;
    int val;
    SimpleTreeNode left;
    SimpleTreeNode right;

    public SimpleTreeNode(int data) {
        this.val = data;
        this.left = null;
        this.right = null;
    }

    public SimpleTreeNode() {
        this.right = this.left = null;
    }

    public void setData(int data) {
        this.val = data;
    }

    public int getData() {
        return this.val;
    }

    public SimpleTreeNode getLeft() {
        return this.left;
    }

    public SimpleTreeNode getRight() {
        return this.right;
    }

    public void setLeft(SimpleTreeNode left) {
        this.left = left;
    }

    public void setRight(SimpleTreeNode right) {
        this.right = right;
    }
}