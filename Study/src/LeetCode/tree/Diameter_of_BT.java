package LeetCode.tree;

/**
 * Created by rajkamal on 1/28/18.
 */
public class Diameter_of_BT {

    public int find_diameter(SimpleTreeNode node, int []diameter) {
        if (node == null) {
            return 0;
        }

        int lt_len = 0;
        int rt_len = 0;
        int len = 0;

        lt_len = find_diameter(node.left, diameter);
        rt_len = find_diameter(node.right, diameter);

        len = lt_len + rt_len;

        if (len > diameter[0]) {
            diameter[0] = len;
        }

        return ((lt_len > rt_len) ? (lt_len + 1) : (rt_len + 1));
    }

    public int solution(SimpleTreeNode node) {
        int []diameter = {0};

        int len = find_diameter(node, diameter);

        return diameter[0];
    }
}
