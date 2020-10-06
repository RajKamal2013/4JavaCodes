package LeetCode.tree;

/**
 * Created by rajkamal on 3/2/18.
 */
public class longestUnivaluePathTest {

    public static void test() {
       // int []arr = {5, 4, 5, 1, 1, 0, 5};
       // int []arr = {1, 4, 5, 4, 4, 5};
        int [] arr = {1, 2, 2, 2, 2};
        longestUnivaluePath API = new longestUnivaluePath();
        SimpleBinaryTreeNode BT = new SimpleBinaryTreeNode();

        for (int data : arr){
            BT.insert_BT(data);
        }

        BT.level_order();

        int len = API.solution(BT.root);

        System.out.println("Longest univalue Path : "  + len);
    }

    public static void main(String[] args) {
        test();
    }
}
