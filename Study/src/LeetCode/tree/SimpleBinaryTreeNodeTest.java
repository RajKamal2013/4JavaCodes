package LeetCode.tree;

/**
 * Created by rajkamal on 12/20/17.
 */
public class SimpleBinaryTreeNodeTest {

    public static void test() {
        int []arr1 = {45, 30, 60, 20, 40, 10, 5, 15, 50, 48, 55, 80, 100, 90, 120};
        Integer []arr2 = {45, 30, 60, 20, 50, 70, 10};


        SimpleBinaryTreeNode BT = new SimpleBinaryTreeNode();
        SimpleBinaryTreeNode BST = new SimpleBinaryTreeNode();

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

        SimpleBinaryTreeNode BT2 = new SimpleBinaryTreeNode();
        for (Integer item : arr2) {
            BT2.insert_BT(item);

        }

        System.out.println("BT Level Order ");
        BT2.level_order();

        /*
        Integer data = 60;
        BT2.BT_delete(data);
        System.out.println("BT Level Order after deleting " + data );
        BT2.level_order();
        */

        System.out.println("<------------__MAX_DEPTH--------------------->");
        int max_Depth = BT.maxDepth(BT.root);

        System.out.println("Max Depth of BT with Root " + BT.root.getData() + " is " + max_Depth);

        int data = 130;
        BT.insert_BT(data);
        max_Depth = BT.maxDepth(BT.root);

        System.out.println("Max Depth of BT with Root " + BT.root.getData() + " is " + max_Depth);

       // System.out.println("Max Depth of BT with Root " + BT.root.getData() + "is " + max_Depth);
       // System.out.println("Max Depth of BT with Root " + BT.root.getData() + "is " + max_Depth);
    }

    public static void main(String[] args) {
        test();
    }

}
