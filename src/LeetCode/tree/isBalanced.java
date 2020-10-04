package LeetCode.tree;

/**
 * Created by rajkamal on 2/13/18.
 */
public class isBalanced {

    public int getheight(SimpleTreeNode root, int[] balance) {
        if (root == null) {
            return 0;
        }

        if (balance[0] > 1) {
            return 0;
        }

        int left_height, right_height, heightdiff;

        left_height = getheight(root.left, balance);
        right_height = getheight(root.right, balance);

        heightdiff = Math.abs(left_height - right_height);

        if (heightdiff > balance[0]) {
            balance[0] = heightdiff;
        }

        if (balance[0] > 1) {
            System.out.println("Node " + root.val + " is not balanced");
        }

        return  (((left_height > right_height) ? left_height : right_height) + 1);

    }

    public boolean solution (SimpleTreeNode root) {
        if (root == null) {
            return  true;
        }

        int []balance = {0};

        int height = getheight(root, balance);

        if (balance[0] > 1) {
            return  false;
        } else {
            return  true;
        }
    }

}
