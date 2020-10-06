package LeetCode.tree;

/**
 * Created by rajkamal on 12/21/17.
 */
public class invertTree {

    public static SimpleTreeNode invertTreeNode(SimpleTreeNode root) {
        if (root == null) {
            return null;
        }

        SimpleTreeNode left = root.getLeft();
        SimpleTreeNode right = root.getRight();

        root.setLeft(invertTreeNode(right));
        root.setRight(invertTreeNode(left));

        return root;
    }

   public static void test() {
       SimpleBinaryTreeNode BT = new SimpleBinaryTreeNode();

       Integer []arr2 = {45, 30, 60, 20, 50, 70, 10};

       for (Integer item : arr2) {
           BT.insert_BT(item);
       }

       System.out.println("Level Order :- ");
       BT.level_order();

       BT.root = invertTreeNode(BT.root);

       System.out.println("Level Order :- ");

       BT.level_order();
   }

    public static void main(String[] args) {
        test();
    }
}
