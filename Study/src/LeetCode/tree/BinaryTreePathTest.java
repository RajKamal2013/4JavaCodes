package LeetCode.tree;

import java.util.List;

/**
 * Created by rajkamal on 2/13/18.
 */
public class BinaryTreePathTest {
    public static void test() {

        BinaryTreePath API = new BinaryTreePath();
        int []arr1 = {45, 30, 60, 40};
        SimpleBinaryTreeNode BST = new SimpleBinaryTreeNode();
        for (int data:arr1) {
            BST.insert_BST(data);
        }

        List<String > res;
        res = API.solution(BST.root);

        for (String str : res) {
            System.out.print(str + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        test();
    }
}
