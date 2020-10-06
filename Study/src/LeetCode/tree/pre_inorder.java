package LeetCode.tree;

/**
 * Created by rajkamal on 1/20/17.
 */
public class pre_inorder {

    public static class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode(int x) { val = x; }
      }

    public static int search(int[]arr, int val) {
            int index = -1;
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == val) {
                   // System.out.println("Data Found at  " + i);
                    index = i;
                    break;
                }
            }

            return index;
        }

    public static TreeNode BuildTree_Driver(int[] preorder, int pre_start, int[]inorder, int in_start, int in_end) {
        TreeNode root;
        int data;
        int in_index;
        int pre_index;
        if (pre_start > preorder.length -1  || in_start > in_end ) {
            return null;
        }

        data = preorder[pre_start];
        root = new TreeNode(data);
        in_index = search(inorder, data);

        root.left   = BuildTree_Driver(preorder, pre_start + 1, inorder, in_start, in_index - 1);
        root.right  = BuildTree_Driver(preorder, pre_start + in_index - in_start + 1, inorder, in_index + 1, in_end);

        return root;

    }

    public static TreeNode buildTree(int[] preorder, int[] inorder) {

        TreeNode root;
        root = BuildTree_Driver(preorder, 0, inorder, 0, inorder.length - 1);

        return root;
    }

    public static void postorder(TreeNode root) {
        if(root != null) {
            postorder(root.left);
            postorder(root.right);
            System.out.print(root.val + " ");
        }
    }


    public static void main(String[] args) {
        /*
        int[] pre_order = {1, 2};
        int[] in_order  = {2, 1};
        */
        int[] pre_order = {1, 2, 3};
        int[] in_order  = {1, 3, 2};
        TreeNode root = buildTree(pre_order, in_order);
        postorder(root);
        System.out.println();
    }
}
