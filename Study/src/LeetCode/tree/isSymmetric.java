package LeetCode.tree;

/**
 * Created by rajkamal on 2/13/18.
 */
public class isSymmetric {

    public boolean isEqual(SimpleTreeNode s, SimpleTreeNode t) {
        if ((s ==  null) && (t == null)) {
            return true;
        }
        if (s == null || t == null) {
            return false;
        }

        if (s.val != t.val) {
            return false;
        } else {
             return ((isEqual(s.left, t.right)) && (isEqual(s.right, t.left)));
        }
    }

    public boolean solution(SimpleTreeNode root) {
        if (root == null) {
            return true;
        }
        return isEqual(root.left, root.right);
    }

}
