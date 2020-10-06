package LeetCode.tree;

/**
 * Created by rajkamal on 1/21/18.
 */
public class sametree {

    public boolean solution (SimpleTreeNode p, SimpleTreeNode  q) {
        if ((p == null) && (q == null)) {
            return true;
        } else if ((p == null) && (q != null)) {
            return false;
        } else if ((p != null) && (q == null)) {
            return false;
        } else {
            if (p.val != q.val) {
                return false;
            } else {
                boolean isLeft = solution(p.left, q.left);
                boolean isRight = solution(p.right, q.right);
                return (isLeft && isRight);
            }
        }
    }
}
