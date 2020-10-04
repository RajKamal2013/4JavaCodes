package LeetCode.tree;

/**
 * Created by rajkamal on 1/21/18.
 */
public class sametreetest {

    public static void test() {
        SimpleBinaryTreeNode BST1 = new SimpleBinaryTreeNode();
        SimpleBinaryTreeNode BST2 = new SimpleBinaryTreeNode();
        SimpleBinaryTreeNode BST3 = new SimpleBinaryTreeNode();
        SimpleBinaryTreeNode BST4 = new SimpleBinaryTreeNode();

        sametree sametree_test = new sametree();

        int arr1[] = {45, 30, 60, 20, 40, 10, 5, 15, 50, 48, 55, 80, 100, 90, 120};
        int arr2[] = {45, 30, 60, 20, 50, 70, 10};
        int arr3[] = {2, 1, 3};
        boolean res;


        for (int var:arr1) {
            BST1.insert_BST(var);
        }

        for (int var:arr2) {
            BST2.insert_BST(var);
        }

        for (int var:arr3) {
            BST3.insert_BST(var);
        }

        for (int var:arr1) {
            BST4.insert_BST(var);
        }

        BST1.level_order();
        BST4.level_order();
        res = sametree_test.solution(BST1.root, BST4.root);
        System.out.println("BST1 and BST2 similar test result " + res);

        System.out.println();

        BST2.level_order();
        BST3.level_order();
        res = sametree_test.solution(BST2.root, BST3.root);
        System.out.println("BST2 and BST3 similar test result " + res);


    }
    public static void main(String[] args) {
        test();
    }
}
