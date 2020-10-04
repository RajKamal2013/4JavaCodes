package LeetCode.tree;

/**
 * Created by rajkamal on 2/17/18.
 */
public class findModeTest {

    public static void test() {
        Integer []arr1 = {1, 2, 4, 3, 7};
        findMode API = new findMode();
        SimpleBinaryTreeNode BT = new SimpleBinaryTreeNode();
        int []arr;
        for (Integer data:arr1) {
            BT.insert_BST(data);
        }
        System.out.println("Inorder ");
        BT.inorder();
        arr = API.solution(BT.root);

        System.out.println("Mode in BT: ");
        for (int data: arr ) {
            System.out.print(data + " " );
        }
        System.out.println();
    }

    public static void main(String[] args) {
        test();
    }
}
