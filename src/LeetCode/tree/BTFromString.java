package LeetCode.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by rajkamal on 12/29/17.
 */
public class BTFromString {
    SimpleBinaryTreeNode BT;

    public BTFromString() {
        BT = new SimpleBinaryTreeNode();
    }

    public void BT_Insertion(Integer[] arr) {
        int size = arr.length;
        if (size == 0) {
            BT.root = null;
            return;
        }
        int index = 0;
        Queue<SimpleTreeNode> Q = new LinkedList<SimpleTreeNode>();
        BT.root = new SimpleTreeNode(arr[index]);
        Q.offer(BT.root);
        SimpleTreeNode curr;
        index = index + 1;

        while(index < size) {
            curr = Q.poll();

            if (arr[index] == null) {
                curr.setLeft(null);
            } else {
                curr.setLeft(new SimpleTreeNode(arr[index]));
                Q.offer(curr.getLeft());
            }
            index = index + 1;
            if (index < size) {
                if (arr[index] == null) {
                    curr.setRight(null);
                } else {
                    curr.setRight(new SimpleTreeNode(arr[index]));
                    Q.offer(curr.getRight());
                }
                index = index + 1;
            }
        }
    }

    public void BT_LevelOrder() {
        Queue<SimpleTreeNode> Q = new LinkedList<SimpleTreeNode>();
        Q.offer(BT.root);
        SimpleTreeNode curr;
        int index = 0;

        while (!Q.isEmpty()) {
            curr = Q.poll();

            if (curr != null) {
                System.out.println("Index : " + index + " Data : " + curr.getData());
            } else {
                System.out.println("Index : " + index + " Data : " + "NULL");
            }
            if (curr != null) {
                Q.offer(curr.getLeft());
                Q.offer(curr.getRight());
            }

            index = index + 1;
        }
    }

    public String Preorder(SimpleTreeNode root) {
        String str = "";
        if (root != null) {

            int left_index, right_index;
           // System.out.print(root.getData());
            str = str + Integer.toString(root.getData());

            if ((root.getRight() != null) && (root.getLeft() != null)) {
                left_index  = 1;
                right_index = 1;
            } else if ((root.getLeft() != null) && (root.getRight() == null)) {
                left_index = 1;
                right_index = 0;
            } else if ((root.getLeft() == null) && (root.getRight() != null)) {
                left_index = 1;
                right_index = 1;
            } else {
                left_index = 0;
                right_index = 0;
            }

            if (left_index == 1) {
               // System.out.print("(");
                str = str + "(";
            }

            str = str + Preorder(root.getLeft());

            if (left_index == 1) {
                str = str + ")";
                //System.out.print(")");
            }
            if (right_index == 1) {
                //System.out.print("(");
                str = str + "(";
            }

            str = str  + Preorder(root.getRight());
            if (right_index == 1) {
                //System.out.print(")");
                str = str + ")";
            }
        }
        return str;
    }

    public void Rec_BT_Preorder() {
        String str = Preorder(BT.root);
        System.out.println(str);
    }

    public void Itr_BT_Preorder() {
        SimpleTreeNode curr;
        Stack<SimpleTreeNode> stk = new Stack<SimpleTreeNode>();

        curr = BT.root;
        stk.push(curr);

        while (!stk.isEmpty()) {
            curr = stk.peek();
            stk.pop();
            if (curr.getRight() != null){
                stk.push(curr.getRight());
            }
            if (curr.getLeft() != null) {
                stk.push(curr.getLeft());
            }

            System.out.print(curr.getData() + " ");
        }
        System.out.println();
    }

    public SimpleTreeNode getRoot() {
        return BT.root;
    }

}
