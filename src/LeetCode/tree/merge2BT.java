package LeetCode.tree;


/**
 * Created by rajkamal on 12/16/17.
 */
public class merge2BT {
    BinaryTreeNode<Integer> BT = new BinaryTreeNode<Integer>();

    public static TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return null;
        }

        TreeNode node = new TreeNode();
        if (t1 == null) {
            node.setData(t2.getData());
            node.setLeft(t2.getLeft());
            node.setRight(t2.getRight());
            return node;
        } else if (t2 == null) {
            node.setData(t1.getData());
            node.setLeft(t1.getLeft());
            node.setRight(t1.getRight());
        } else {
            node.setData(node.add(t1.getData(), t2.getData()));
            node.setLeft(mergeTrees(t1.getLeft(), t2.getLeft()));
            node.setRight(mergeTrees(t1.getRight(), t2.getRight()));
        }
        return node;
    }

    public static void main(String[] args) {
        int []arr1 = {45, 30, 60, 20, 40, 10, 5, 15, 50, 48, 55, 80, 100, 90, 120};
        int []arr2 = {45, 30, 60, 20, 40, 10, 5, 15, 50, 48, 55, 80, 100, 90, 120};

        BinaryTreeNode BT1 = new BinaryTreeNode();
        BinaryTreeNode BT2 = new BinaryTreeNode();


        for (int data:arr1) {
            BT1.insert_BT(data);
        }

        for (int data:arr2) {
            BT2.insert_BT(data);
        }

        System.out.println("Level Order of BT1");
        BT1.level_order();
        System.out.println("Level Order of BT2");
        BT2.level_order();

        BinaryTreeNode BT3 = new BinaryTreeNode();
        BT3.root = mergeTrees(BT1.root, BT2.root);

        System.out.println("Level Order of BT3");
        BT3.level_order();

    }
}
