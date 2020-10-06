package LeetCode.tree;

/**
 * Created by rajkamal on 1/21/18.
 */
public class findTilt_test {

    public static void test() {
        int arr1[] = {2, 1, 3};
        int arr2[] = {45, 30, 60, 20, 50, 70, 40};
        int tilt = 0;

        SimpleBinaryTreeNode BST1 = new SimpleBinaryTreeNode();
        SimpleBinaryTreeNode BST2 = new SimpleBinaryTreeNode();

        findTilt findTilt_API = new findTilt();

        for (int var:arr1) {
            BST1.insert_BST(var);

        }

        for (int var:arr2) {
            BST2.insert_BST(var);
        }

        tilt = findTilt_API.solution(BST1.root);
        System.out.println("TILT of the BST is " +  tilt);

        tilt = findTilt_API.solution(BST2.root);
        System.out.println("TILT of the BST is " +  tilt);

    }

    public static void main(String[] args) {
        test();
    }
}
