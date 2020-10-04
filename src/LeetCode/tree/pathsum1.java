package LeetCode.tree;

/**
 * Created by rajkamal on 2/23/18.
 */
public class pathsum1 {
    public boolean solution(SimpleTreeNode root, int sum) {
        if (root == null) {
            return false;
        } else {
            if ((root.left == null) && (root.right == null)) {
                if (root.val - sum == 0) {
                    return true;
                } else {
                    return false;
                }
            } else {
                boolean left = solution(root.left, sum - root.val);
                boolean right = solution(root.right, sum - root.val);
                return (left || right);
            }
        }
    }
}
