package LeetCode.tree;

/**
 * Created by rajkamal on 2/13/18.
 */
public class isSubTreeTest {
    public static void test() {
        int []arr1 = {45, 30, 60, 20, 40, 10, 5, 15, 50, 48, 55, 80, 100, 90, 120};
        int []arr2 = {60, 50, 48, 55, 80, 100, 90, 120};
        boolean res = false;
        SimpleBinaryTreeNode s = new SimpleBinaryTreeNode();
        SimpleBinaryTreeNode t = new SimpleBinaryTreeNode();
        isSubTree API = new isSubTree();

        for (int data:arr1) {
            s.insert_BST(data);
        }

        for (int data:arr2) {
            t.insert_BST(data);
        }

        res = API.solution(s.root, t.root);

        System.out.println("is S is SubTree of T : " + res);

    }

    public static void main(String[] args) {
        test();
    }
}
