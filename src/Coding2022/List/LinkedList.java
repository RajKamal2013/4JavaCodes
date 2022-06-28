package Coding2022.List;

import DS.List.Link;

import java.util.ArrayList;

public class LinkedList {
    public ListNode head = null;

    public LinkedList() {
        head = null;
    }
    public LinkedList(int data) {
        this.head = new ListNode(data);
    }

    public LinkedList(ArrayList<Integer> arr) {
        head = null;
        ListNode prev = null;
        for (int data: arr) {
            if (head == null) {
                head = new ListNode(data);
                head.next = null;
                prev = head;
            } else {
                prev.next  = new ListNode(data);
                prev = prev.next;
            }
        }
    }

    public boolean isEmpty() {
        return (head == null);
    }

    public int size() {
        if (isEmpty()) {
            return 0;
        }
        ListNode  curr =  this.head;
        int count = 1;
        while (curr != null) {
            count = count + 1;
            curr = curr.next;
        }
        return count;
    }

    public void insertAtN(int pos, int data) {
        if ((pos < 0 ) && (pos > size() + 1)) {
            return;
        }

        ListNode newNode = new ListNode(data);
        ListNode curr = null;

        if (pos == 0) {
            if (this.head == null) {
                this.head = newNode;
                this.head.next = null;
            } else {
                newNode.next = this.head;
                this.head = newNode;
            }
            return;
        } else if (pos == size() + 1) {
                curr = this.head;
                while (curr.next != null) {
                    curr = curr.next;
                }
                curr.next = newNode;
                newNode.next = null;
                return;
        } else {
            curr = this.head;
            for (int i = 0; i < pos; i++) {
                curr = curr.next;
            }
            newNode.next = curr.next;
            curr.next = newNode;
            return;
        }
    }

    public void prepend(int data) {
        insertAtN(0, data);
    }

    public void append(int data) {
        ListNode newNode = new ListNode(data);
        ListNode curr = null;
        curr = this.head;
        while (curr.next != null) {
            curr = curr.next;
        }
        curr.next = newNode;
        newNode.next = null;
        return;
    }

    public void remove(int data) {
        ListNode curr, prev;
        curr = this.head;
        if (curr.data == data) {
            this.head = this.head.next;
            return;
        }
        curr  = this.head;
        prev = curr;
        while (curr != null) {
            if (curr.data == data) {
                prev.next = curr.next;
                return;
            }
            prev = curr;
            curr = curr.next;
        }
    }

    public void removeFront() {
        if (this.head == null) {
            return;
        }
        this.head = this.head.next;
    }

    public void removeLast() {
        if (isEmpty()) {
            return;
        }

        ListNode curr = this.head;
        while(curr.next != null) {
            curr = curr.next;
        }
        curr.next = null;
    }

    public String toString() {
        String result="[";
        if (head == null)
            return result + "]";
        result = result + head.data;

        ListNode temp = head.next;

        while(temp!=null) {
            result = result + " ," + temp.data;
            temp = temp.next;
        }
        return result + "]";
    }


    public boolean contains(int data) {
        ListNode curr  = this.head;
        while (curr != null) {
            if (curr.data == data) {
                return true;
            }
            curr = curr.next;
        }
        return false;
    }

    public void reverse() {
        ListNode curr, rev, temp;
        curr = this.head;
        rev = null;
        while (curr != null) {
            temp = curr.next;
            curr.next = rev;
            rev = curr;
            curr = temp;
        }
        this.head = rev;
    }
}
