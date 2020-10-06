package LeetCode.tree;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by rajkamal on 3/4/18.
 */
public class IterativePostOrder {
    public ArrayList<Integer> solution(SimpleTreeNode root) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        if (root == null) {
            return list;
        }
        Stack<SimpleTreeNode> stk = new Stack<SimpleTreeNode>();
        SimpleTreeNode curr = root;
        Boolean fromStk = false;
        SimpleTreeNode prev = null;

        while (curr != null) {
       //     System.out.println("Curr : " + curr.val) ;
            if (prev != null) {
         //       System.out.println("Prev : " + prev.val);
            }
            if (!stk.isEmpty()) {
         //       System.out.println("Stack Peek " + stk.peek().val);
            }

            if ((curr.left != null) && (!fromStk)) {
           //     System.out.println("Pushing " + curr.val + " in the stack ");
                stk.push(curr);
                curr = curr.left;
            } else {
                if (curr.right != null) {
                    if ((prev != null )&&(curr.left == prev )){
                        curr = curr.right;
                        fromStk = false;
                    } else if (curr.right == prev) {
             //           System.out.println("<else if > Adding " + curr.val + " to the list ");
                        prev = curr;
                        list.add(curr.val);
                        if (!stk.isEmpty()) {
                            curr = stk.peek();
                            stk.pop();
                            fromStk = true;
                        } else {
                            curr = null;
                        }
                    } else {
               //         System.out.println("Pushing " + curr.val + " in the stack ");
                        stk.push(curr);
                        curr = curr.right;
                    }
                } else {
                //    System.out.println("<else > Adding  " + curr.val + " to the list ");
                    list.add(curr.val);
                    prev = curr;
                    fromStk = true;
                    if (stk.isEmpty()) {
                        curr = null;
                    } else {
                        curr = stk.peek();
                        if ((curr.right != null) && (curr.right != prev)) {
                            curr = stk.peek();
                        } else {
                    //        System.out.println("<else > Poping :" + curr.val + " from the stack");
                            stk.pop();
                        }
                    }
                }
            }
        }
        System.out.println("Iterative Postorder :");
        for (int data : list) {
            System.out.print(data + " ");
        }
        System.out.println();
        return  list;
    }
}
