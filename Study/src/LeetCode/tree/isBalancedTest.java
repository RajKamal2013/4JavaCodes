package LeetCode.tree;

/**
 * Created by rajkamal on 2/14/18.
 */
public class isBalancedTest {
    public static void test() {
        Integer []arr1 = {30, 40, 60, 70, 50};
        SimpleBinaryTreeNode BT = new SimpleBinaryTreeNode();

        for (Integer data:arr1) {
            BT.insert_BST(data);
        }

        BT.level_order();

        isBalanced API = new isBalanced();

        boolean isBalance = API.solution(BT.root);

        System.out.println("BT with  root " + BT.root.val + " is Balanced ? " + isBalance);

    }

    public static void main(String[] args) {
        test();
    }
}
