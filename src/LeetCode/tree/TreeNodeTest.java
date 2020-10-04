package LeetCode.tree;

import LeetCode.tree.BinaryTreeNode;

/**
 * Created by rajkamal on 12/16/17.
 */
public class TreeNodeTest {
    public static void test() {
        int []arr1 = {45, 30, 60, 20, 40, 10, 5, 15, 50, 48, 55, 80, 100, 90, 120};

        BinaryTreeNode BT = new BinaryTreeNode();
        BinaryTreeNode BST = new BinaryTreeNode<Double>();

        for (int data:arr1) {
            BT.insert_BT(data);
        }

        for (int data:arr1) {
            BST.insert_BST(data);
        }

        System.out.println("<-----------------Traversal--------------------------->");
        System.out.println("BT");
        BT.level_order();
        System.out.println();

        System.out.println("BST");
        BST.preorder();
        System.out.println();
        BST.inorder();
        System.out.println();
        BST.postorder();
        System.out.println();
        BST.level_order();
        System.out.println("<------------------------------------------------------>");

        System.out.println("<-------------Deletion Test---------------------->");
        int []del_array = {45, 20, 80, 90};
        for (int items:del_array) {
            BST.BST_delete(items);
            System.out.println("---------After Deleting data " + items + "---------");
            BST.preorder();
            System.out.println();
            BST.inorder();
            System.out.println();
            BST.postorder();
            System.out.println();
            BST.level_order();
            System.out.println();

        }
    }

    public static void main(String[] args) {
        test();
    }
}
