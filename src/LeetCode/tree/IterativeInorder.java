package LeetCode.tree;


import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by rajkamal on 12/21/17.
 */
public class IterativeInorder {

    ArrayList<Integer> res;

    public IterativeInorder() {
        res = new ArrayList<Integer>();
    }

    public ArrayList<Integer> inorder(SimpleTreeNode root) {
        SimpleTreeNode prev, curr, child;
        res = new ArrayList<Integer>();
        Stack<SimpleTreeNode> stk = new Stack<SimpleTreeNode>();
        curr = root;
        boolean fromStk = false;

        while (curr != null) {
            if ((curr.left != null) && (!fromStk)) {
                stk.push(curr);
                curr = curr.left;
            } else {
                if (curr.right != null) {
                    res.add(curr.val);
                    curr = curr.right;
                    fromStk = false;
                } else {
                    res.add(curr.val);
                    fromStk = true;
                    if (stk.isEmpty()) {
                        curr = null;
                    } else {
                        curr = stk.peek();
                        stk.pop();
                    }
                }
            }
        }
        return  res;
    }


    public ArrayList<Integer> getInorderList(SimpleBinaryTreeNode BST) {
        res = inorder(BST.root);
        return res;
    }


}
