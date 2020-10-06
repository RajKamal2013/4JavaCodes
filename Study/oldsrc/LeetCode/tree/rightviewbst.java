package LeetCode.tree;

import java.util.*;

/**
 * Created by rajkamal on 1/27/17.
 */
public class rightviewbst {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    ;


    public static List<Integer> rightSideView(TreeNode root) {
        Queue<TreeNode> Q  = new LinkedList<TreeNode>();
        List<Integer> list = new ArrayList<Integer>();

        if (root == null)
            return list;

        Q.offer(root);
        Q.offer(null);
        TreeNode temp = null;
        int curr_item = 0;

        while(!Q.isEmpty()) {
            temp = Q.poll();
            if (temp != null) {
                if (curr_item == 0) {
                    list.add(temp.val);
                    curr_item = curr_item + 1;
                }
                if(temp.right != null) {
                    Q.offer(temp.right);
                }
                if (temp.left != null) {
                    Q.offer(temp.left);
                }
            } else {
                if (!Q.isEmpty())
                    Q.offer(null);
                curr_item = 0;

            }
        }

        return list;
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(2);
        //root.right = new TreeNode(4);
        root.left.left = new TreeNode(7);
        root.left.right = new TreeNode(3);
        root.left.left.left = new TreeNode(4);
        root.left.left.right = new TreeNode(5);

        List<Integer> list;

        list = rightSideView(root);

        Iterator<Integer> itr = list.iterator();

        while (itr.hasNext()) {
            System.out.println(itr.next());
        }

    }
}
