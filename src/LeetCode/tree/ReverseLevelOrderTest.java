package LeetCode.tree;

import java.util.List;

/**
 * Created by rajkamal on 2/12/18.
 */
public class ReverseLevelOrderTest {
    public static void test() {
        Integer []arr1 = {45, 30, 60, 20, 40, 10, 5, 15, 50, 48, 55, 80, 100, 90, 120};

        List<List<Integer>> list;

        ReverseLevelOrder API = new ReverseLevelOrder();

        SimpleBinaryTreeNode BST = new SimpleBinaryTreeNode();

        for (int data:arr1) {
            BST.insert_BT(data);
        }

        list = API.solution(BST.root);

        if (list == null) {
            return;
        }

        System.out.print("[");
        for (List<Integer> l1 : list) {
            System.out.print("[");
            for (int data : l1) {
                System.out.print(data + " ");
            }
            System.out.print("]");
        }
        System.out.println("]");

    }


    public static void main(String[] args) {
        test();
    }
}
