package LeetCode.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by rajkamal on 1/21/18.
 */
public class LeftLeafSums {

    boolean isLeaf(SimpleTreeNode node) {
        return ((node.left == null ) && (node.right == null));
    }

    int solution(SimpleTreeNode root) {
        Queue<SimpleTreeNode> Q = new LinkedList<SimpleTreeNode>();
        SimpleTreeNode curr;
        int sum = 0;

        //empty tree
        if (root == null) {
            return sum;
        }

        Q.offer(root);

        // root is not leaf
        if (isLeaf(root)) {
            return sum;
        }

        // only push non leaf node in the queue
        while (!Q.isEmpty()) {
            curr = Q.poll();

            // find if left is leaf;
            if (curr.left != null) {
                if (!isLeaf(curr.left)) {
                    // non leaf node is pushed to queue
                    Q.offer(curr.left);
                } else {
                    // curr node is left leaf
                    sum = sum + curr.left.val;
                }
            }

            // find is right is leaf
            if (curr.right != null) {
                if (!isLeaf(curr.right)) {
                    // non leaf node is pushed to Queue
                    Q.offer(curr.right);
                }
            }
        }

        return sum;
    }

}
