package LeetCode.tree;

import java.util.ArrayList;

/**
 * Created by rajkamal on 12/21/17.
 */
public class TwoSumInBST {

    public static boolean find2sum(ArrayList<Integer> list, int value) {
        int size = list.size();
        int []arr2 = new int[size];

        int i = 0;
        for (int item : list) {
            arr2[i] = item;
            i = i + 1;
        }

        int left = 0, right = size - 1;
        int sum = 0;
        boolean datafound = false;

        while (left < right) {
            sum = arr2[left] + arr2[right];

            if (sum == value ) {
                datafound = true;
                break;
            } else if (sum >  value) {
                right = right - 1;
            } else {
                left = left + 1;
            }
        }

        System.out.println();
        if (datafound == false) {
            System.out.println("Data " + value + " is not found in BST");
        } else {
            System.out.println("Data " + value + " is found at index " + left + " and " + right);
        }

        return  datafound;
    }
    public static boolean find2sum2(ArrayList<Integer> list, int value) {
        int start = 0;
        int end = list.size() - 1;
        int sum = 0;
        boolean ret = false;

        while (start < end) {
                sum = list.get(start) + list.get(end);
                if (sum == value) {
                    ret = true;
                    break;
                } else if (sum > value) {
                    end = end - 1;
                } else {
                    start = start + 1;
                }
        }
        return ret;
    }


    public static void test() {
        IterativeInorder InorderList = new IterativeInorder();
        ArrayList<Integer> res;
        int value;

        //-------------------------------------------------------------------------//
        System.out.println("Test 1");
        int []arr1 = {45, 30, 60, 20, 40, 10, 5, 15, 50, 48, 55, 80, 100, 90, 120};
        SimpleBinaryTreeNode BST = new SimpleBinaryTreeNode();
        for (int item : arr1) {
            BST.insert_BST(item);
        }
        System.out.println("Iterative  Inorder ");
        res = InorderList.getInorderList(BST);
        for (int item: res) {
            System.out.print(item + " ");
        }
        value = 90;
        boolean datafound = find2sum(res, value);
        if (datafound == false) {
            System.out.println("Data " + value + " is not found in BST");
        } else {
            System.out.println("Data " + value + " is  found in BST");
        }
        System.out.println();

        //-----------------------------------------------------------------------//
        System.out.println("Test 2 ");
        int []arr2 = {5, 3, 6, 2, 4, 7};
        SimpleBinaryTreeNode BST2 = new SimpleBinaryTreeNode();
        InorderList = new IterativeInorder();
        for (int item : arr2) {
            BST2.insert_BST(item);
        }
        System.out.println("Iterative  Inorder ");
        res = InorderList.getInorderList(BST2);
        for (int item: res) {
            System.out.print(item + " ");
        }
        value = 9;
        datafound = find2sum(res, value);
        if (datafound == false) {
            System.out.println("Data " + value + " is not found in BST");
        } else {
            System.out.println("Data " + value + " is  found in BST");
        }
        datafound = find2sum2(res, value);
        if (datafound == false) {
            System.out.println("Data " + value + " is not found in BST");
        } else {
            System.out.println("Data " + value + " is  found in BST");
        }
        System.out.println();
        //----------------------------------------------------------------------//

    }

    public static void main(String[] args) {
        test();
    }
}
