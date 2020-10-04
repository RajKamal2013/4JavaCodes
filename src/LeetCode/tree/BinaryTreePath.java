package LeetCode.tree;

import java.util.ArrayList;

/**
 * Created by rajkamal on 2/13/18.
 */
public class BinaryTreePath {


    public String convert_list2string(ArrayList<Integer> list) {
        String res = "";
        int size = 0;

        for (int var:list) {
            if (size == list.size() - 1) {
                res = res + Integer.toString(var) ;
            } else {
                res = res + Integer.toString(var) + "->";
            }
            size = size + 1;
        }

        return res;

    }

    public ArrayList<String> Convert(SimpleTreeNode root, ArrayList<Integer> list, ArrayList<String> res) {
        String str;

        if (root == null) {
            str = convert_list2string(list);
            res.add(str);
            return res;
        }

        list.add(root.val);
        if (root.left == null && root.right == null) {
            res = Convert(null, list, res);
        } else {
            if (root.left != null) {
                res = Convert(root.left, list, res);
            }
            if (root.right != null) {
                res = Convert(root.right, list, res);
            }
        }
        list.remove(new Integer(root.val));

        return res;

    }

    public ArrayList<String> solution(SimpleTreeNode root) {
        ArrayList<String> res = new ArrayList<String>();
        ArrayList<Integer> list = new ArrayList<Integer>();

        res = Convert(root, list, res);

        return res;
    }
}
