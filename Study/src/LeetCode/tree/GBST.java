package LeetCode.tree;

/**
 * Created by rajkamal on 12/29/17.
 */
public class GBST {
    SimpleBinaryTreeNode BST;

    public GBST() {
        BST = new SimpleBinaryTreeNode();
    }

    public void GBST_insert(int data) {
        BST.insert_BST(data);
    }

    public void GBST_Level_Order() {
        BST.level_order();
    }

    public void GBST_inorder() {
        BST.inorder();
    }

    public void GBST_preorder() {
        BST.preorder();
    }

    public void GBST_postorder() {
        BST.postorder();
    }

    public SimpleTreeNode BST2GBST(SimpleTreeNode root) {
        if (root == null) {
            return null;
        }
        SimpleTreeNode node;

        root.setRight(BST2GBST(root.getRight()));

        if ((root.getRight() == null) && (root.getLeft() == null)) {
            return  root;
        } else if (root.getLeft() == null) {
            //get the maximum value in right side ie, left most of right
            node = root.getRight().getLeft();
            if (node != null) {
                while (node != null) {
                    node = node.getLeft();
                }
                root.setData(root.getData() + node.getData());
            } else {
                root.setData(root.getData() + root.getRight().getData());
            }
        } else if (root.getRight() == null) {
            node = root.getLeft();
            if (node != null ) {
                while (node.getRight() != null) {
                    node = node.getRight();
                }
                node.setData(root.getData() + node.getData());
            }
        } else {
            node = root.getRight().getLeft();
            if (node != null) {
                while (node != null) {
                    node = node.getLeft();
                }
                root.setData(root.getData() + node.getData());
            } else {
                root.setData(root.getData() + root.getRight().getData());
            }

            node = root.getLeft().getRight();
            if (node != null ) {
                while (node.getRight() != null) {
                    node = node.getRight();
                }
                node.setData(root.getData() + node.getData());
            }
        }
        root.setLeft(BST2GBST(root.getLeft()));

        return root;
    }

    public void Create_GBST() {
        BST.root = BST2GBST(BST.root);
    }
}
