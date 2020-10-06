package LeetCode.tree;

/**
 * Created by rajkamal on 1/2/17.
 */

/*
 * Cases -> 1, 2 -> need to remove first from last
 */

/**
 * Definition for singly-linked list.
 **/

public class removeNthFromEnd{
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public static ListNode remove(ListNode head, int n) {
        if (head == null)
            return null;

        int count = 1;
        ListNode first   = head;
        ListNode second  = head;
        ListNode temp = head;

        while (second != null) {
            if (count == n) {
                System.out.println("Breaking");
                break;
            }
            System.out.println("In the while loop ");
            second = second.next;
            count = count + 1;
        }

        while(second.next != null) {
            temp = first;
            second = second.next;
            first  = first.next;
        }


        /* This is very important thing  to consider */

        if (first == head) {
            head = head.next;
        } else {
            temp.next = first.next;
        }

        return head;
    }

    public static void display (ListNode head) {
        ListNode temp  = head;
        while(temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ListNode head = null;
        head = new ListNode(1);
        ListNode temp = new ListNode(2);
        head.next = temp;
        temp.next = null;
        display(head);
        head = remove(head, 1);
        display(head);

    }
}