
/**
 * Created by rajkamal on 11/30/17.
 */

/*
public class IsBST {
    /*
     * Definition for a binary tree node.
     */
/*
    static int left_max = MAX;
    static int right_min = MIN;

    public boolean isValidBST(TreeNode root) {
        if (root == null)
                return true;
        boolean left, right;
        int max, min;

        right = isValidBST(root.right);
        if (right == false)
            return false;

        if (root.left == null && root.right == null){
            right_min = root.val;
            return true;
        } else if (root.left == null) {
            right_min = root.val;
        } else {
            right_min = left_max;
        }

        if (root.val > right_min) {
            return false;
        }

        left = isValidBST(root.left);
        if (left == false )
            return false;

        if (root.left != null && root.right != null) {
            left_max = root.val;
        } else if (root.right == null) {
            left_max = root.val;
        } else {
            left_max = right_min;
        }

        if (root.val < left_max)
            return false;

        return true;
    }

    public static void main(String[] args) {
        TreeNode BT = new TreeNode(25);
        BT.left

    }
}
*/