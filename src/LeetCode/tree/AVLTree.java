package LeetCode.tree;

import java.util.HashMap;

/**
 * Created by rajkamal on 2/11/18.
 */
public class AVLTree {
    SimpleBinaryTreeNode AVLNode;
    HashMap<Integer, Integer> heightMap;

    public  AVLTree() {
        AVLNode = new SimpleBinaryTreeNode();
        AVLNode.root = null;
        heightMap = new HashMap<Integer, Integer>();
    }

    public int getHeight(SimpleTreeNode node) {
        if (node == null) {
            return  0;
        } else {
            return heightMap.get(node.val);
        }
    }

    public SimpleTreeNode RotateWithLeftChild(SimpleTreeNode k2) {
        SimpleTreeNode k1 = k2.left;
        k2.left = k1.right;
        k1.right = k2;
        heightMap.put(k2.val, Math.max(getHeight(k2.left), getHeight(k2.right)) + 1);
        heightMap.put(k1.val, Math.max(getHeight(k1.left), getHeight(k2.right)) + 1);
        return k1;
    }

    public SimpleTreeNode RotateWithRightChild(SimpleTreeNode k2) {
        SimpleTreeNode k1 =  k2.right;
        k2.right = k1.left;
        k1.left = k2;
        heightMap.put(k2.val, Math.max(getHeight(k2.left), getHeight(k2.right)) + 1);
        heightMap.put(k1.val, Math.max(getHeight(k1.left), getHeight(k2.right)) + 1);
        return k1;
    }

    public SimpleTreeNode DoubleRotateWithLeftChild(SimpleTreeNode k3) {
        k3.left = RotateWithRightChild(k3.left);
        return (RotateWithLeftChild(k3));
    }

    public SimpleTreeNode DoubleRotateWithRightChild(SimpleTreeNode k3) {
        k3.right = RotateWithLeftChild(k3.right);
        return (RotateWithRightChild(k3));
    }

    public SimpleTreeNode insertAVL(SimpleTreeNode node, int data) {
        if (node == null) {
            node = new SimpleTreeNode(data);
            heightMap.put(node.val, 0);
        } else if (node.val > data) {
            node.left  = insertAVL(node.left, data);

            if ((getHeight(node.left) - getHeight(node.right)) == 2) {
                if (data  < node.left.val) {
                    node = RotateWithLeftChild(node);
                } else {
                    node = DoubleRotateWithLeftChild(node);
                }
            }
        } else {
            node.right = insertAVL(node.right, data);
            if ((getHeight(node.right) - getHeight(node.left)) == 2) {
                if (data > node.right.val) {
                    node = RotateWithRightChild(node);
                } else {
                    node = DoubleRotateWithRightChild(node);
                }
            }
        }
        heightMap.put(node.val, Math.max(getHeight(node.left), getHeight(node.right)) + 1);

        return node;
    }


    public void insert_AVL(int data) {
        AVLNode.root = insertAVL(AVLNode.root, data);
    }
}
