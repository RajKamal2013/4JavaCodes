package LeetCode.tree;

import LeetCode.tree.BTFromString;

/**
 * Created by rajkamal on 12/29/17.
 */
public class TestBTFromString {
    public static void main(String[] args) {
        Integer []arr = {1, 2, 3, 4};
        BTFromString BT = new BTFromString();
        BT.BT_Insertion(arr);
        System.out.println("Level Order ");
        BT.BT_LevelOrder();
        System.out.println();
        System.out.println("Recursive Level Order");
        BT.Rec_BT_Preorder();
        System.out.println("Iterative Level Order");
        BT.Itr_BT_Preorder();
    }
}
