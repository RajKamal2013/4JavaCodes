package LeetCode.tree;

import java.util.ArrayList;

/**
 * Created by rajkamal on 3/4/18.
 */
public class PostOrderTest {

    public static void test() {
        SimpleBinaryTreeNode BST1 = new SimpleBinaryTreeNode();
        SimpleBinaryTreeNode BST2 = new SimpleBinaryTreeNode();
        SimpleBinaryTreeNode BST3 = new SimpleBinaryTreeNode();
        SimpleBinaryTreeNode BST4 = new SimpleBinaryTreeNode();
        SimpleBinaryTreeNode BST5 = new SimpleBinaryTreeNode();
        IterativePostOrder API = new IterativePostOrder();

        int []arr1 = {45, 30, 60, 20, 40, 10};
        int []arr2 = {40, 50, 60, 70};
        int []arr3 = { 40, 20, 10, 5};
        int []arr4 = { 40, 20, 10, 5, 60};
        int []arr5 = { 40, 50, 20, 60, 70};

        ArrayList<Integer> list = null;
        //int []arr4 = {null};

        for (int data: arr1) {
            BST1.insert_BST(data);
        }


        for (int data: arr2) {
            BST2.insert_BST(data);
        }
        for (int data: arr3) {
            BST3.insert_BST(data);
        }
        for (int data: arr4) {
            BST4.insert_BST(data);
        }
        for (int data: arr5) {
            BST5.insert_BST(data);
        }

        System.out.println("Print Recursive PostOrder ");
        BST1.postorder();
        list = API.solution(BST1.root);
        System.out.println("-------------------------------");



        System.out.println("Print Recursive PostOrder ");
        BST2.postorder();
        list = API.solution(BST2.root);


        System.out.println("-------------------------------");
        System.out.println("Print Recursive PostOrder ");
        BST3.postorder();
        list = API.solution(BST3.root);
        System.out.println("-------------------------------");
        System.out.println("Print Recursive PostOrder ");
        BST4.postorder();
        list = API.solution(BST4.root);

        System.out.println("-------------------------------");
        System.out.println("Print Recursive PostOrder ");
        BST5.postorder();
        list = API.solution(BST5.root);



    }

    public static void main(String[] args) {
        test();
    }

}
