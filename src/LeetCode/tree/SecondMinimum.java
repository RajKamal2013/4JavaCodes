package LeetCode.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by rajkamal on 2/12/18.
 */
public class SecondMinimum {

    public int solution(SimpleTreeNode root) {
        int FAILURE = -1;
        SimpleTreeNode node;
        Queue<SimpleTreeNode> Q = new LinkedList<SimpleTreeNode>();
        int minimum = Integer.MAX_VALUE;
        int second_minimum = Integer.MAX_VALUE;

        if (root == null) {
            return FAILURE;
        }

        Q.offer(root);
        Q.offer(null);

        while (!Q.isEmpty()) {
            node = Q.poll();


            if (node != null) {
                if (node.val < second_minimum) {
                    if (node.val <= minimum) {
                        if (node.val < minimum) {
                            second_minimum = minimum;
                            minimum = node.val;
                        }
                    } else {
                        second_minimum = node.val;
                    }
                }

                if (node.left != null) {
                    Q.offer(node.left);
                }

                if (node.right != null) {
                    Q.offer(node.right);
                }
            } else {
                if (!Q.isEmpty()) {
                    Q.offer(null);
                }
            }
        }

        if (second_minimum == Integer.MAX_VALUE) {
            return  FAILURE;
        }

        return second_minimum;
    }



}
