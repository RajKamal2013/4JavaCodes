package LeetCode.tree;

import java.util.Stack;

/**
 * Created by rajkamal on 1/4/18.
 */
public class Twosum {
    SimpleBinaryTreeNode BST;

    public Twosum() {
        BST = new SimpleBinaryTreeNode();
    }

    public void findSum(SimpleTreeNode root, int sum) {
        Stack<SimpleTreeNode> s1 = new Stack<SimpleTreeNode>();
        Stack<SimpleTreeNode> s2 = new Stack<SimpleTreeNode>();
        boolean fromStk1, fromStk2, done;
        fromStk1 = false;
        fromStk2 = false;

        SimpleTreeNode node1, node2;

        done = false;

        node1 = root;

        while (!done) {
            if ((node1.left != null) && (!fromStk1)) {
                s1.push(node1);
                node1 = node1.left;
            } else {
                fromStk1 = false;
                if (node1.right != null) {
                    System.out.print(node1.val + " ");
                    node1 = node1.right;
                } else {
                    fromStk1 = true;
                    System.out.print(node1.val + " ");
                    if (!s1.isEmpty()) {
                        node1 = s1.peek();
                        s1.pop();
                    }else {
                        done = true;
                    }
                }
            }
        }

        System.out.println();

        done = false;
        node2 = root;
        while (!done) {
            if ((node2.right != null) && (!fromStk2)) {
                s2.push(node2);
                node2 = node2.right;
            } else {
                fromStk2 = false;
                if (node2.left != null) {
                    System.out.print(node2.val + " ");
                    node1 = node1.left;
                } else {
                    fromStk2 = true;
                    System.out.print(node2.val +  " ");
                    if (!s2.isEmpty()) {
                        node2 = s2.peek();
                        s2.pop();
                    }else {
                        done = true;
                    }
                }
            }
        }

        System.out.println();
    }

}
