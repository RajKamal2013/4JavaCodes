package LeetCode.tree;


/**
 * Created by rajkamal on 12/16/17.
 * Given a binary search tree and the lowest and highest boundaries as
 * L and R, trim the tree so that all its elements lies in [L, R]
 * (R >= L). You might need to change the root of the tree, so the
 * result should return the new root of the trimmed binary search tree.
 *
 */
public class trimbinarytree {

    public static TreeNode trimBST(TreeNode root, int L, int R) {
        if (root == null) {
            return null;
        }

        return  root;
    }

    public static void main(String[] args) {
        BinaryTreeNode<Integer> BST = new BinaryTreeNode<Integer>();
        int []arr1 = {45, 30, 60, 20, 40, 10, 5, 15, 50, 48, 55, 80, 100, 90, 120};

        BinaryTreeNode BST1 = new BinaryTreeNode();

        for (int data:arr1) {
            BST1.insert_BST(data);
        }

        BST1.root = trimBST(BST1.root, 45, 90);

        BST1.inorder();
        BST1.preorder();
        BST1.postorder();
        BST1.level_order();
    }

}
