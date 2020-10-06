package LeetCode.tree;

/**
 * Created by rajkamal on 1/25/17.
 */
public class LCA {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    };

    public static TreeNode Lowest_Common_Acncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null)
            return null;
        if (root == p || root == q) {
            return root;
        }
        TreeNode left, right;
        left = Lowest_Common_Acncestor(root.left, p, q);
        right = Lowest_Common_Acncestor(root.right, p, q);


        if (left != null && right != null) {
            return root;
        } else {
            return ((left != null) ? left : right);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(2);
        root.right = new TreeNode(4);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(7);
        root.right.left = new TreeNode(8);
        root.right.right = new TreeNode(10);

        TreeNode test = Lowest_Common_Acncestor(root, root.left, root.left.right);

        System.out.println("LCA of 2 and 5 is " + test.val);
    }
}
