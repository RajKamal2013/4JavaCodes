package Sorting;

import List.LinkedList;
import List.ListNode;

/**
 * Created by rajkamal on 12/6/16.
 */
public class Merge_Sorted_List {
    public static ListNode recursive_merge(ListNode head1, ListNode head2){
        if (head1 == null)
            return head2;
        if (head1 == null)
            return head2;

        ListNode head = new ListNode(0);

        if (head1.getData() < head2.getData()) {
            head = head1;
            head.setNext(recursive_merge(head1.getNext(), head2));
        } else {
            head = head2;
            head.setNext(recursive_merge(head1, head2.getNext()));
        }
        return head;
    }

    public static ListNode iterative_merge(ListNode head1, ListNode head2) {
        ListNode curr  = new ListNode(0);
        ListNode head = curr;

        while((head1 != null) && (head2 != null)) {
            if (head1.getData() < head2.getData()){
                curr.setNext(head1);
                head1 = head1.getNext();
            } else {
                curr.setNext(head2);
                head2= head2.getNext();
            }
        }
        if (head1 != null) {
            curr.setNext(head1);
        }
        if (head2 != null){
            curr.setNext(head2);
        }

        return (head.getNext());

    }

    public static void display_node(ListNode node) {
        if (node == null)
            return;
        while(node != null){
            System.out.print (node.getData() + " ");
            node = node.getNext();
        }
        System.out.println();
    }

    public static void test() {
        int []arr1 = {1, 2, 5,  7, 8, 10, 34, 56};
        int []arr2 = {10, 34, 56, 78, 99, 100, 200, 300};

        LinkedList list1 = new LinkedList();
        LinkedList list2 = new LinkedList();
        ListNode node = null;

        for (int i = 0; i < arr1.length; i++) {
            node = new ListNode(arr1[i]);
            list1.insertAtEnd(node);
        }

        System.out.println(list1.toString());

        for (int i = 0; i < arr2.length; i++) {
            node = new ListNode(arr2[i]);
            list2.insertAtEnd(node);
        }

        System.out.println(list2.toString());

        System.out.println("Recursive Merge ");
        node = recursive_merge(list1.getHead(), list2.getHead());

        display_node(node);

        System.out.println("iterative merge ");
        node = iterative_merge(list1.getHead(), list2.getHead());

        display_node(node);



    }


    public static void main (String[]args){
        test();

    }
}
