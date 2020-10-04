package LeetCode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by rajkamal on 12/20/17.
 */
public class EachLevelAverage {
    public static List<Double> averageOfLevels(SimpleTreeNode root) {
        ArrayList<Double> avg_list = new ArrayList<Double>();
        Queue<SimpleTreeNode> Q  = new LinkedList<SimpleTreeNode>();

        if (root == null) {
            return null;
        }

        Q.offer(root);
        Q.offer(null);

        SimpleTreeNode node;
        double total = 0;
        double count = 0;
        double avg = 0;

        while (!Q.isEmpty()) {
            node = Q.poll();
            if (node != null) {
                total = total + node.getData();
                count = count + 1;
                if (node.getLeft() != null) {
                    Q.offer(node.getLeft());
                }
                if (node.getRight() != null) {
                    Q.offer(node.getRight());
                }
            } else {
                avg = total / count;
                avg_list.add(avg);
                count = 0;
                total = 0;
                avg = 0;
                if (!Q.isEmpty()) {
                    Q.offer(null);
                }
            }
        }

        return avg_list;
    }

    public static void main(String[] args) {
       // int []arr1 = {45, 30, 60, 20, 40, 10, 5, 15, 50, 48, 55, 80, 100, 90, 120};
        Integer []arr1 = {3, 9, 20, null, null, 21, 22};

        SimpleBinaryTreeNode BT = new SimpleBinaryTreeNode();

        for (Integer data:arr1) {
            if (data == null)
                BT.insert_BT(null);
            else
                BT.insert_BT(data);
        }

        System.out.println("<-----------------Traversal--------------------------->");
        System.out.println("BT");
        BT.level_order();
        System.out.println();

        System.out.println("BST");
        BT.preorder();
        System.out.println();
        BT.inorder();
        System.out.println();
        BT.postorder();
        System.out.println();
        BT.level_order();
        System.out.println("<------------------------------------------------------>");

        ArrayList<Double> avg_list;

        avg_list = (ArrayList<Double>) averageOfLevels(BT.root);

        System.out.println("Average of Each Level ");
        int level = 0;
        for (double item : avg_list) {
            System.out.println("Level:" + level +  " Average: " + item );
            level = level + 1;
        }

    }
}
