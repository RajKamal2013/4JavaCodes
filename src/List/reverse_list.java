package List;

import List.LinkedList;
import List.ListNode;

/**
 * Created by rajkamal on 12/6/16.
 */
public class reverse_list {

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        ListNode node, node1, node2;
        int[] arr = {23, 34, 56, 78, 99, 67, 88, 100, 45, 68};
        for (int i = 0; i < arr.length; i++) {
            node = new ListNode(arr[i]);
            list.insertAtEnd(node);
        }

        System.out.println(list.toString());

        list.head = list.recurssive_reverse_list(list.getHead());
        System.out.println("Recursive  Reverse ");
        System.out.println(list.toString());

        System.out.println("Normal List ");
        list.head = list.recurssive_reverse_list(list.getHead());
        System.out.println(list.toString());

        System.out.println("Iterative Reverse ");
        list.head = list.iterative_reverse_list(list.getHead());
        System.out.println(list.toString());

        System.out.println("Normal List");
        list.head = list.iterative_reverse_list(list.getHead());
        System.out.println(list.toString());
    }
}