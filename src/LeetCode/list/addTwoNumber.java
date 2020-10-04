package LeetCode.list;

/**
 * Created by rajkamal on 1/2/17.
 */
public class addTwoNumber {

    public static class ListNode {
            int val;
            ListNode next;
            ListNode(int x) {
                val = x;
            }
    }

    public static ListNode add(ListNode l1, ListNode l2) {
        int carry = 0, sum = 0, data = 0;
        ListNode head = null, node = null, prev = null;

        while ((l1 != null) && (l2 != null)) {
            sum = l1.val + l2.val + carry;
            if (sum >= 10) {
                data  = sum % 10;
                carry = sum/10;
            } else {
                carry = 0;
                data = sum;
            }

            node = new ListNode(data);
            node.next = null;
            if (head == null) {
                head = node;
                prev = head;
            } else {
                prev.next = node;
                prev = node;
            }

            l1 = l1.next;
            l2 = l2.next;
        }

        while (l1 != null) {
            sum = carry + l1.val;

            if (sum >= 10) {
                data = sum % 10;
                carry = sum/10;
            } else {
                carry = 0;
                data = sum;
            }
            node = new ListNode(data);
            node.next = null;
            if (head == null) {
                head = node;
                prev = head;
            } else {
                prev.next = node;
                prev = node;
            }

            l1 = l1.next;
        }


        while (l2 != null) {
            sum = carry + l2.val;

            if (sum >= 10) {
                data = sum % 10;
                carry = sum/10;
            } else {
                carry = 0;
                data = sum;
            }
            node = new ListNode(data);
            node.next = null;
            if (head == null) {
                head = node;
                prev = head;
            } else {
                prev.next = node;
                prev = node;
            }

            l2 = l2.next;

        }
        if (carry != 0) {
            node = new ListNode(carry);
            prev.next = node;
        }

        return head;
    }

    public static void display(ListNode head) {
        ListNode temp = head;
        while(temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String [] args) {
        ListNode l1 = null;
        l1 = new ListNode(2);
        ListNode temp = new ListNode(4);
        l1.next = temp;
        temp = new ListNode(3);
        l1.next.next = temp;
        temp.next = null;
        display(l1);

        ListNode l2 = null;
        l2 = new ListNode(5);
        temp = new ListNode(6);
        l2.next = temp;
        temp = new ListNode(4);
        l2.next.next = temp;
        temp.next = null;
        display(l2);

        ListNode res = add(l1, l2);
        display(res);
    }
}
