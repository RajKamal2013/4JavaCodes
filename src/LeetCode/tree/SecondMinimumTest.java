package LeetCode.tree;

/**
 * Created by rajkamal on 2/12/18.
 */
public class SecondMinimumTest {
    static void test() {
        SecondMinimum API = new SecondMinimum();

        SimpleBinaryTreeNode BST = new SimpleBinaryTreeNode();

        int[] arr = {45, 30, 60, 20, 40, 10, 5, 15, 50, 48, 55, 80, 100, 90, 120};

        for (int data:arr) {
            BST.insert_BST(data);
        }

        int answer = API.solution(BST.root);

        System.out.println("Inorder ");
        BST.inorder();
        System.out.println("Second Minimum :" + answer);

    }

    public static void main(String[] args) {
        test();
    }
}
