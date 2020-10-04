package LeetCode.tree;

/**
 * Created by rajkamal on 2/28/18.
 */
public class pathsum1Test {

    public static void test() {
        int []arr1 = {45, 30, 60, 20, 40, 50, 80};
        SimpleBinaryTreeNode BST = new SimpleBinaryTreeNode();
        pathsum1 API = new pathsum1();

        for (int data : arr1) {
            BST.insert_BST(data);
        }

        BST.inorder();
        int sum = 95;
        boolean ans;
        int []sum_tests = {0, 95, 115, 155, 185, 90, 100};

        ans = API.solution(BST.root, sum);
        System.out.println("Sum : 95 exist in BST : " + ans);
        for (int data : sum_tests ) {
            ans = API.solution(BST.root, data);
            System.out.println("Sum : " + data + " exist in BST : " + ans);
        }

    }


    public static void main(String[] args) {
        test();
    }
}
