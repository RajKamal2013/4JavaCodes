package LeetCode.tree;

/**
 * Created by rajkamal on 1/21/18.
 */
public class LeftLeafSumsTest {

    public static void test() {
        SimpleBinaryTreeNode BST1 = new SimpleBinaryTreeNode();
        SimpleBinaryTreeNode BST2 = new SimpleBinaryTreeNode();
        LeftLeafSums LeftLeafSumsFunc = new LeftLeafSums();

        int arr1[] = {10, 9, 20, 15, 30};
        int []arr2 = {45, 30, 60, 20, 40, 10, 5, 15, 50, 48, 55, 80, 100, 90, 120};
        int sum = 0;

        for (int var:arr1) {
            BST1.insert_BST(var);
        }

        for (int var:arr2) {
            BST2.insert_BST(var);
        }


        sum = LeftLeafSumsFunc.solution(BST1.root);
        System.out.println("Sum of the left leaves :" + sum);

        sum = LeftLeafSumsFunc.solution(BST2.root);
        System.out.println("Sum of the left leaves :" + sum);

    }

    public static void main(String[] args) {
        test();
    }
}
