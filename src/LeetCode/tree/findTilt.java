package LeetCode.tree;

/**
 * Created by rajkamal on 1/21/18.
 */
public class findTilt {

    public int getSum(SimpleTreeNode node, int[] tilt) {
        int left_sum = 0;
        int right_sum = 0;

        if (node == null) {
            return 0;
        }


        left_sum = getSum(node.left, tilt);
        right_sum = getSum(node.right, tilt);

        tilt[0] = tilt[0] + Math.abs(left_sum - right_sum);

        return (left_sum + right_sum + node.val);

    }

    public int solution(SimpleTreeNode node) {
        if (node == null) {
            return 0;
        }

        int []tilt = {0};
        int sum;

        sum = getSum(node, tilt);
        return tilt[0];
    }
}
