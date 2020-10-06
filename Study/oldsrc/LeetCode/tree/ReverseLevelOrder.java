package LeetCode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by rajkamal on 2/12/18.
 */
public class ReverseLevelOrder {

    public List<List<Integer>> solution(SimpleTreeNode root) {

        List<List<Integer>> list = new ArrayList<List<Integer>>();

        Queue<SimpleTreeNode> Q = new LinkedList<SimpleTreeNode>();

        if (root == null) {
            return  list;
        }

        Q.offer(root);
        Q.offer(null);
        SimpleTreeNode node;
        List<Integer> level = new ArrayList<Integer>();

        while (!Q.isEmpty()) {
            node = Q.poll();

            if (node != null) {
                level.add(node.val);
                if (node.left != null) {
                    Q.offer(node.left);
                }
                if (node.right != null) {
                    Q.offer(node.right);
                }

            } else {
                list.add(0, level);
                level = null;
                if (!Q.isEmpty()) {
                    Q.offer(null);
                    level = new ArrayList<Integer>();
                }
            }
        }
        return list;
    }
}
