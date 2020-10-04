package LeetCode.tree;

/**
 * Created by rajkamal on 2/13/18.
 */
public class isSymmetricTest {
    public static void test() {
        Integer []arr1 = {1, 2, 2, 3, 4, 4, 3};
        SimpleBinaryTreeNode BT = new SimpleBinaryTreeNode();
        isSymmetric API = new isSymmetric();
        boolean res = false;

        for (int data:arr1) {
            BT.insert_BT(data);
        }

        res = API.solution(BT.root);

        System.out.println("Is BT Symmetric? :" + res);
    }

    public static void main(String[] args) {
        test();
    }
}

