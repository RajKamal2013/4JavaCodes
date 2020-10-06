package LeetCode.tree;

/**
 * Created by rajkamal on 1/26/18.
 */
public class MinAbsDiffTest {

    public static void test() {
        int []arr1 = {45, 30, 60, 20, 40, 10, 5, 15, 50, 48, 55, 80, 100, 90, 120};
        int []arr2 = {45, 30, 60, 20, 50, 70, 10};
        int min = 0;

        SimpleBinaryTreeNode BST1 = new SimpleBinaryTreeNode();
        SimpleBinaryTreeNode BST2 = new SimpleBinaryTreeNode();

        for (int val : arr1) {
            BST1.insert_BST(val);
        }

        for (int val : arr2) {
            BST2.insert_BST(val);
        }

        MinAbsDiff API = new MinAbsDiff();

        min = API.solution(BST1.root);
        min = API.solution1(BST1.root);
        min = API.solution(BST2.root);
        min = API.solution1(BST2.root);

    }

    public static void main(String[] args) {
        test();
    }
}
