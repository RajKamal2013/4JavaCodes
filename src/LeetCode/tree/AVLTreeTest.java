package LeetCode.tree;

/**
 * Created by rajkamal on 2/11/18.
 */
public class AVLTreeTest {

    public static void test() {
        int[] arr1 = {45, 30, 60, 20, 40, 10, 5, 15, 50, 48, 55, 80, 100, 90, 120};
        Integer[] arr2 = {45, 30, 60, 20, 50, 70, 10};

        AVLTree avltree = new AVLTree();

        for (int val : arr1) {
            avltree.insert_AVL(val);
        }

        avltree.AVLNode.inorder();
        avltree.AVLNode.postorder();
        avltree.AVLNode.preorder();
        avltree.AVLNode.level_order();

    }

    public static void main(String[] args) {
        test();
    }
}
