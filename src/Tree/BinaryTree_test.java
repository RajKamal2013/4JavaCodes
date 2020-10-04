package Tree;

/**
 * Created by rajkamal on 12/11/16.
 */
public class BinaryTree_test {
    public static void test() {
        int []arr1 = {1, 2, 3, 4, 5, 6, 7};
        int []arr2 = {23, 10, 35, 30, 47, 15, 9};
        BinaryTree BT = new BinaryTree();
        BinaryTree BST = new BinaryTree();

        for (int data:arr1) {
            BT.insert_BT(data);
        }

        for (int data:arr2) {
            BST.insert_BST(data);
        }


        System.out.println("<----------------------------Traversal---------------------------------------------->");
        BT.preorder();
        System.out.println();
        BT.inorder();
        System.out.println();
        BT.postorder();
        BT.level_order();
        System.out.println();

        BST.preorder();
        System.out.println();
        BST.inorder();
        System.out.println();
        BST.postorder();
        System.out.println();
        BST.level_order();
        System.out.println("<------------------------------------------------------------------------------------->");


        System.out.println("<------------------------------Searching----------------------------------------------->");

        for (int data:arr1) {
            System.out.println(data  + " is present in BT " + BT.search_BT(data));
        }

        System.out.println(  " 10 is present in BT " + BT.search_BT(10));

        System.out.println();

        for (int data:arr2) {
            BST.search_BST(data);
        }
        System.out.println();

        System.out.println("<------------------------------------------------------------------------------------->");

        System.out.println("<------------------------------Max, Min, Size----------------------------------------->");
        BT.minimum_BT();
        System.out.println();
        BST.minimum_BST();


        BT.maximum_BT();
        System.out.println();
        BST.maximum_BST();
        System.out.println("<------------------------------------------------------------------------------------->");

        System.out.println("<------------------------------Max, Min, Size----------------------------------------->");

        System.out.println("Size of BST " + BST.size(BST.root));
        System.out.println("Size of BT " + BT.size(BT.root));
        System.out.println("<--------------------------------Deletion--------------------------------------------->");
        BST.delete_BST(10);

        BST.preorder();
        System.out.println();
        BST.inorder();
        System.out.println();
        BST.postorder();
        System.out.println();
        BST.level_order();
        System.out.println();

        BST.insert_BST(10);


        BST.preorder();
        System.out.println();
        BST.inorder();
        System.out.println();
        BST.postorder();
        System.out.println();
        BST.level_order();
        System.out.println();

    }
    public  static  void main (String [] args) {
        test();
    }
}
