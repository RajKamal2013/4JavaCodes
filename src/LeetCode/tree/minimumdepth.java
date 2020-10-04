package LeetCode.tree;

import java.util.LinkedList;
import java.util.Queue;

/*
 * Created by rajkamal on 2/23/18.
 */
public class minimumdepth {
    public int solution(SimpleTreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<SimpleTreeNode> Q = new LinkedList<SimpleTreeNode>();
        SimpleTreeNode curr = null;
        Q.offer(root);
        Q.offer(null);
        int depth = 1;
        while (!Q.isEmpty()) {
            curr = Q.poll();
            if (curr != null) {
                if ((curr.left == null) && (curr.right == null)) {
                    break;
                }

                if (curr.left != null) {
                    Q.offer(curr.left);
                }

                if (curr.right != null) {
                    Q.offer(curr.right);
                }
            } else {
                depth = depth + 1;
                if (!Q.isEmpty()) {
                    Q.offer(null);
                }
            }
        }

        if (curr != null) {
            System.out.println("Minimum Depth Node : " + curr.val + " Min Depth : " + depth);
        }
        return depth;
    }
}
