package LeetCode.tree;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by rajkamal on 1/26/18.
 */
public class MinAbsDiff {


    public int solution(SimpleTreeNode root) {
        /* Get the inorder
         * Find the differences of two neighbouring node
         * get the minimum of all the differences.
         */
        int minimum = Integer.MAX_VALUE;
        Stack<SimpleTreeNode> stk = new Stack<SimpleTreeNode>();
        ArrayList<Integer> list = new ArrayList<Integer>();
        boolean fromStk = false;
        boolean stop = false;
        SimpleTreeNode node = root;
        int node1 , node2, min;
        node1 = Integer.MAX_VALUE;
        node2 = Integer.MAX_VALUE;



        if (node == null) {
            return Integer.MAX_VALUE;
        }

        while (!stop) {
            if ((node.left != null) && (!fromStk)) {
                stk.push(node);
                node = node.left;
            } else {
                fromStk = false;
                if (node.right != null) {
                    list.add(node.val);
                    node = node.right;
                } else {
                    list.add(node.val);
                    fromStk = true;
                    if (!stk.isEmpty()) {
                        node = stk.peek();
                        stk.pop();
                    } else {
                        stop = true;
                    }
                }
            }
        }


        for (int val : list) {
            System.out.print(val + " ");
        }
        System.out.println();


        for (int i = 0; i < list.size() - 1; i++) {
            min = Math.abs(list.get(i) - list.get(i+1));

            if (min < minimum) {
                minimum = min;
                node1 = list.get(i);
                node2 = list.get(i+ 1);
            }
        }


        System.out.println("Minimum node " + node1 + " and " + node2 + " and Diff is " + minimum);

        return minimum;
    }

    public int solution1(SimpleTreeNode root) {
        /* Get the inorder
         * Find the differences of two neighbouring node
         * get the minimum of all the differences.
         */
        int minimum = Integer.MAX_VALUE;
        Stack<SimpleTreeNode> stk = new Stack<SimpleTreeNode>();
        boolean fromStk = false;
        boolean done = false;
        SimpleTreeNode node = root;
        int node1, node2, min1, min2, min;
        node1 = root.val;
        min1 = Integer.MAX_VALUE;
        min2 = Integer.MAX_VALUE;
        if (node.left != null) {
            node2 = node.left.val;
        } else if (node.right != null) {
            node2 = node.right.val;
        } else {
            return Integer.MAX_VALUE;
        }

        node1 = Integer.MAX_VALUE;



        if (node == null) {
            return Integer.MAX_VALUE;
        }

        while (!done) {
            if ((node.left != null) && (!fromStk)) {
                stk.push(node);
                node = node.left;
            } else {
                fromStk = false;
                if (node.right != null) {
                    min = Math.abs(node1 - node.val);
                    node1 = node.val;
                    if (min < minimum) {
                        minimum = min;
                        min1 = node1;
                        min2 = node2;
                    }
                    node = node.right;

                } else {
                    min = Math.abs(node1 - node.val);
                    node1 = node.val;
                    if (min < minimum) {
                        minimum = min;
                        min1 = node1;
                        min2 = node2;
                    }
                    fromStk = true;
                    if (!stk.isEmpty()) {
                        node = stk.peek();
                        stk.pop();
                    } else {
                        done = true;
                    }
                }
            }
        }

        System.out.println("Minimum node " + min1 + " and " + min2 + " and Diff is " + minimum);

        return minimum;
    }



}
