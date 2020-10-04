package LeetCode.tree;

import java.util.Queue;

/**
 * Created by rajkamal on 2/13/18.
 */
public class isSubTree {


    public boolean isEqual(SimpleTreeNode s, SimpleTreeNode t) {

        if (s == null && t == null) {
            return  true;
        }

        if (s == null || t == null) {
            return  false;
        }

        if(s.val !=  t.val) {
            return false;
        } else {
           return (isEqual(s.left, t.left) && isEqual(s.right, t.right));
        }
    }

    public boolean solution(SimpleTreeNode s, SimpleTreeNode t) {

        Queue<SimpleTreeNode> Q = new java.util.LinkedList<SimpleTreeNode>();
        SimpleTreeNode node;
        boolean res = false;

        Q.offer(s);
        while (!Q.isEmpty()) {
            node = Q.poll();

            if (node.val == t.val) {
                System.out.println("Calling isEqual for " + node.val + " and " + t.val);
                res = isEqual(node, t);
                if (res == true) {
                    break;
                }
            }

            if (node.left != null) {
                Q.offer(node.left);
            }
            if (node.right != null) {
                Q.offer(node.right);
            }
        }
        return res;
    }

}
