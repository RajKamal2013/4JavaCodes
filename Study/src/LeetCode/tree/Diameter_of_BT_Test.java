package LeetCode.tree;

/**
 * Created by rajkamal on 1/28/18.
 */
public class Diameter_of_BT_Test {
    public static void test() {
        SimpleBinaryTreeNode BT = new SimpleBinaryTreeNode();
        int arr[] = {45, 30, 60, 20, 40, 10, 5, 15, 50, 48, 55, 80, 100, 90, 120};

        for (int val : arr) {
            BT.insert_BST(val);
        }

        Diameter_of_BT API = new Diameter_of_BT();

        int diameter = API.solution(BT.root);

        System.out.println("Diamter of the BT: " + diameter);
    }

    public static void main(String[] args) {
        test();

    }
}
