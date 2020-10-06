package LeetCode.tree;

/**
 * Created by rajkamal on 2/27/17.
 */
public class Recurrsive_Reverse {

    public static class ListNode {
          int val;
          ListNode next;
          ListNode(int x) { val = x; }
    }

    public static ListNode reverse(ListNode head, ListNode prev, ListNode rev) {
            if (head == null)
                return null;

            if(head.next != null) {
                prev = reverse(head.next, prev, rev);
                prev.next = head ;
                if (rev == null) {
                    rev = prev;
                    System.out.println("reverse data" + rev.val);
                }
                head.next = null;
                prev = prev.next;
                return rev;
            } else {
                return head;
            }
    }

    public static void treverse(ListNode current, ListNode[]head) {
        if (current == null) {
            return;
        }

        ListNode next = current.next;

        if (next == null) {
            head[0] = current;
            return;
        }

        treverse(next, head);
        next.next = current;
        current.next = null;
     }

    public static ListNode reverseList(ListNode head) {
            ListNode prev = null;
            ListNode []rev = new ListNode[1];

            rev[0] = head;
            //prev = reverse(head, prev, rev);
            treverse(head, rev);
            if (rev[0] != null)
                display(rev[0]);
            else
                System.out.println("Reverse is null ");
            //display(prev);
            return rev[0];
    }

    public static void display(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = null;
        display(head);
        ListNode prev = null;
        prev = reverseList(head);

        display(prev);

    }

}

