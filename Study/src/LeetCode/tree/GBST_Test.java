package LeetCode.tree;

import LeetCode.tree.GBST;

/**
 * Created by rajkamal on 12/29/17.
 */
public class GBST_Test {
    public static void main(String[] args) {
        GBST tree = new GBST();
        int []arr1 = {2, 0, 3, -4, 1};
        for (int items : arr1) {
            tree.GBST_insert(items);
        }

        System.out.println("Level Order ");
        tree.GBST_Level_Order();
        tree.GBST_inorder();
        tree.GBST_preorder();
        tree.GBST_postorder();

        tree.Create_GBST();

        System.out.println("After Converting to Greater TREE");
        System.out.println("Level Order ");
        tree.GBST_Level_Order();
        tree.GBST_inorder();
        tree.GBST_preorder();
        tree.GBST_postorder();

    }
}
