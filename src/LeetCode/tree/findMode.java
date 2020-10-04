package LeetCode.tree;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by rajkamal on 2/17/18.
 */
public class findMode {
    public int[] solution (SimpleTreeNode root) {

        ArrayList<Integer> list = new ArrayList<Integer>();
        //ArrayList<Integer> list1 = new ArrayList<Integer>();
        Stack <SimpleTreeNode> stk = new Stack<SimpleTreeNode>();

        boolean from_stk = false;
        Integer count = 0;
        Integer c_data = 0;
        Integer max_count = 0;
        SimpleTreeNode curr = root;
        Integer data = Integer.MAX_VALUE;
        if (root != null) {
            if (root.val == Integer.MAX_VALUE) {
                data = 0;
            } else {
                data = Integer.MAX_VALUE;
            }
        }

        while (curr != null) {
            if ((curr.left != null) && (!from_stk)) {
                stk.push(curr);
                curr = curr.left;
            } else {
                if (curr.right != null) {
                    //list1.add(curr.val);
                    if (data == curr.val) {
                        c_data = data;
                        count = count + 1;
                    } else {
                        data = curr.val;
                        //System.out.println("Current value : " + data + " " + curr.val);
                        if (max_count == 0) {
                            if (count == 0 ) {
                                max_count = 1;
                            } else {
                                max_count = count;
                            }
                            c_data = data;
                            list.add(c_data);
                        } else if (max_count < count) {
                            max_count = count;
                            list.clear(); //edit
                            //System.out.println("1. max count " + " g" + " : " + max_count);
                            //System.out.println("1. Data clearing and adding < " + data + " count : " + count);
                            list.add(c_data);
                        } else if ((count != 1) && (max_count == count)){
                            //System.out.println("1. Data adding  == " + data + " count : " + count);
                            //System.out.println("1. max count :"  + max_count);
                            list.add(c_data);
                        } else if ((count == 1) && (max_count == count)) {
                            c_data = data;
                            if (!list.contains(data)) {
                                list.add(c_data);
                            }
                        }
                        count = 1;
                    }
                    curr = curr.right;
                    from_stk = false;
                } else {
                   // System.out.println("Here ");
                   // list1.add(curr.val);
                    if (data == curr.val) {
                        //System.out.println("here  -- " + data + "curr "  + curr.val);
                        c_data = data;
                        count = count + 1;
                    } else {
                        data = curr.val;
                        //System.out.println("Current value : " + data + " " + curr.val);
                        if (max_count == 0) {
                            if (count == 0 ) {
                                max_count = 1;
                            } else {
                                max_count = count;
                            }
                            c_data = data;
                            list.add(c_data);
                            //System.out.println("2. max count : " + max_count);
                            // System.out.println("2. Data adding First " + data + " count : " + count);
                            // list.add(data);
                        } else if (max_count < count) {
                            max_count = count;
                            list.clear(); //edit
                            //System.out.println("2. max count : " + max_count);
                            //System.out.println("2. Data clearing and adding  < " + data + " count : " + count);
                            list.add(c_data);
                            //  data = curr.val;
                        } else if ((count != 1) && (max_count == count)) {
                            //System.out.println("2. max count : " + max_count);
                            //System.out.println("2. Data adding  == " + data + " count : " + count);
                            list.add(c_data);

                        } else if ((count == 1) && (max_count == count)) {
                            c_data = data;
                            if (!list.contains(c_data)) {
                                list.add(c_data);
                            }
                        }
                        count = 1;
                    }
                    from_stk = true;
                    if (stk.isEmpty()) {
                        curr = null;
                        if (count > 1) {
                            if (max_count < count ) {
                                max_count = count;
                                list.clear();
                                list.add(data);
                            } else if (max_count == count) {
                                list.add(data);
                            } else {}
                        } else if (count == 1) {
                            if (max_count == 1) {
                                if (!list.contains(data)) {
                                    list.add(data);
                                }
                            }
                        }
                    } else {
                        curr = stk.peek();
                        stk.pop();
                    }

                }
            }
        }


        //for (int val : list1) {
        // System.out.print(val + " ");
        //}
        // System.out.println();
        int arr [] = new int[list.size()];
        int index = 0;
        //System.out.println("Size of list " + list.size());
        for (int val : list) {
            arr[index] = val;
            //System.out.println("Adding " + val + " to the array :" + arr[index]);
            index = index + 1;
        }
        return arr;
    }
}
