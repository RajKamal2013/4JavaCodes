package List;

import List.LinkedList;
import List.ListNode;

/**
 * Created by rajkamal on 12/6/16.
 */
public class Find_Intersection {

    public static int get_list_length(ListNode head) {
        int len = 0;
        ListNode temp = head;
        while (temp != null) {
            len++;
            temp = temp.getNext();
        }
        return len;
    }

    public static void test() {
        int []arr1 = {1, 2, 4, 5, 7, 8, 9, 23, 45, 67};
        int []arr2 = {23, 45, 100, 200, 400, 600, 67, 89, 90, 45, 9, 23, 45, 67};
        LinkedList list1 = new LinkedList();
        LinkedList list2 = new LinkedList();
        ListNode node;

        for (int i = 0; i < 10; i++) {
            node = new ListNode(arr1[i]);
            list1.insertAtEnd(node);
        }
        for (int i = 0; i < 14; i++) {
            node = new ListNode(arr2[i]);
            list2.insertAtEnd(node);
        }

        System.out.println(list1.toString());
        System.out.println(list2.toString());
        ListNode node1 = list1.getHead();
        ListNode node2 = list2.getHead();

        int data = find_intersection(node1, node2);

        System.out.println("intersection point " + data);

    }
    public static int find_intersection(ListNode list1, ListNode list2) {
        int len1 = 0;
        int len2 = 0;
        ListNode head1, head2;
        head1 = list1;
        head2 = list2;

        len1  = get_list_length(list1);
        len2  = get_list_length(list2);

        int diff = Math.abs(len1 - len2);

        if (len1 > len2) {
            head1 = list1;
            head2 = list2;
        } else {
            head1 = list2;
            head2 = list1;
        }
        for (int i = 0; i < diff; i++ ) {
            head1 = head1.getNext();
        }

        while(head1 != null && head2 != null) {
            if (head1.getData() == head2.getData()) {
                return head1.getData();
            }
            head1 = head1.getNext();
            head2 = head2.getNext();
        }

        return Integer.MIN_VALUE;
    }

    public static void main(String []args) {
        test();
    }
}
