package LeetCode.tree;

/**
 * Created by rajkamal on 3/2/18.
 */
public class minimumdepthTest {
    public static void test() {
        int []arr1 = {45, 30, 60, 20, 40, 10, 5, 15, 50, 48, 55, 80, 100, 90, 120};
        SimpleBinaryTreeNode BST = new SimpleBinaryTreeNode();
        int min_depth;
        for (int data : arr1) {
            BST.insert_BST(data);
        }

        minimumdepth API = new minimumdepth();
        min_depth = API.solution(BST.root);
        System.out.println("Minimum Depth of the Tree BST with root : " + BST.root.val + " is " + min_depth);
    }
    public static void main(String[] args) {
        test();
    }
}
