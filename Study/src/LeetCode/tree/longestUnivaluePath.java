package LeetCode.tree;

/**
 * Created by rajkamal on 3/2/18.
 */
public class longestUnivaluePath {
    int ans;
    public int path(SimpleTreeNode node) {
        if (node == null) {
            return 0;
        }

        int left_path = path(node.left);
        int right_path = path(node.right);
        int left =  0, right = 0;

        if ((node.left != null) && (node.val == node.left.val)){
            left = left + left_path + 1;
        }

        if ((node.right != null) && (node.val == node.right.val)) {
            right = right + right_path + 1;
        }

        ans  = Math.max(ans, left + right);

        return Math.max(left, right);

    }

    public int solution (SimpleTreeNode root) {
        ans = 0;
        path (root);
        return ans;
    }
}
