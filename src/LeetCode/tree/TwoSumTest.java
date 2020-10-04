package LeetCode.tree;

/**
 * Created by rajkamal on 1/4/18.
 */
public class TwoSumTest {
    public static void test() {
        Twosum tree = new Twosum();

       int []arr1 = {45, 30, 60, 20, 40, 10, 5, 15, 50, 48, 55, 80, 100, 90, 120};
       // int []arr1 = {5, 30, 60, 20, 40, 10, 15, 50, 48, 55, 80, 100, 90, 120};

        for (int data:arr1) {
            tree.BST.insert_BST(data);
        }

        tree.BST.inorder();
        tree.findSum(tree.BST.root, 45);
    }

    public static void main(String[] args) {
        test();
    }
}
