package LeetCode.list;

/**
 * Created by rajkamal on 10/23/17.
 */

// Definition for singly-linked list.
 class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }

class M2List {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if ((l1 == null) && (l2 == null)) {
            return null;
        } else if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else {
            ListNode L, l;
            if (l1.val >  l2.val) {
                l = new ListNode(l2.val);
                l2 = l2.next;
            } else {
                l = new ListNode(l1.val);
                l1 = l1.next;

            }
            L = l;
            while ((l1 != null) && (l2 != null)) {
                if (l1.val > l2.val) {
                    l.next = new ListNode(l2.val);
                    l2 = l2.next;
                    l = l.next;
                } else {
                    l.next = new ListNode(l1.val);
                    l1 = l1.next;
                    l = l.next;
                }
            }
            if (l1 == null) {
                while (l2 != null) {
                    l.next = new ListNode(l2.val);
                    l2 = l2.next;
                    l = l.next;
                }
            }

            if (l2 == null) {
                while (l1 != null) {
                    l.next = new ListNode(l1.val);
                    l1 = l1.next;
                    l = l.next;
                }
            }

            l.next = null;
            return L;
        }
    }
}