/**
 * Created by rajkamal on 12/3/16.
 */
package List;

import java.lang.*;

public class LinkedList {
        public LinkedList() {
            length = 0;
            head = null;
        }

        ListNode head;

        private int length = 0;

        public synchronized ListNode getHead() {
            return head;
        }

        public synchronized void insertAtBegin(ListNode node) {
            node.next = head;
            head = node;
            length++;
        }

        public synchronized void insertAtEnd(ListNode node) {
            if (head ==null)
                head = node;

            else {
                ListNode p, q;
                for (p = head; (q = p.getNext())!= null; p = q);
                p.setNext(node);
            }
            length++;
        }

        public void insert(int data, int position) {
            if (position < 0) {
                position = 0;
            }
            if (position > length) {
                position = length;
            }
            if (head == null) {
                head = new ListNode(data);
            } else if (position == 0) {
                ListNode temp = new ListNode(data);
                temp.next = head;
                head = temp;
            } else {
                ListNode temp = head;
                for (int i = 0; i < position; i++) {
                    temp = temp.getNext();
                }
                ListNode newNode = new ListNode(data);
                newNode.next = temp.next;
                temp.setNext(newNode);
            }
            length++;
        }

        public synchronized ListNode removeFromBegin() {
            ListNode node = head;
            if(node != null) {
                head = node.getNext();
                node.setNext(null);
                length--;
            }
            return node;
        }

        public synchronized ListNode removeFromEnd() {
            if (head == null)
                return null;
            ListNode p = head, q= null, next = head.getNext();
            if (next == null) {
                head = null;
                return p;
            }
            while((next=p.getNext())!= null) {
                q = p;
                p = next;
            }
            q.setNext(null);
            length--;
            return p;
        }

        public synchronized void removeMatched(ListNode node) {
            if (head == null)
                return;

            if(node.equals(head)) {
                head = head.getNext();
                node = null;
                return;
            }

            ListNode p = head, q = null;

            while ((q = p.getNext())!=null) {
                if (node.equals(q)) {
                    p.setNext(q.getNext());
                    node = null;
                    return;
                }
                p = q;
            }
        }

        public synchronized void remove(int position) {
            if (position < 0)
                position = 0;

            if (position >= length)
                position = length - 1;

            if (head == null)
                return;

            if (position == 0) {
                head = head.getNext();
            }

            else {
                ListNode temp = head;

                for(int i = 1; i < position; i++) {
                    temp = temp.getNext();
                }

                temp.setNext(temp.getNext().getNext());
            }

            length--;
        }

        public String toString() {
            String result="[";
            if (head == null)
                return result + "]";
            result = result + head.getData();

            ListNode temp = head.getNext();

            while(temp!=null) {
                result = result + " ," + temp.getData();
                temp = temp.getNext();
            }

            return result + "]";
        }

        public int length() {
            return length;
        }

        public int getPosition(int data) {
            ListNode temp = head;

            int pos = 0;

            while(temp != null) {
                if (temp.getData() == data) {
                    return pos;
                } else {
                    pos++;
                    temp = temp.getNext();
                }
            }

            return Integer.MIN_VALUE;
        }

        public int search(int data) {
            ListNode node = head;
            if (node == null)
                return -1;
            else {
                while(node != null) {
                    if (node.getData() == data) {
                        return 0;
                    } else
                        node = node.getNext();
                }
                return -1;
            }
        }

        public ListNode getNode(int data) {
            ListNode node = head;
            if (node == null)
                return null;
            else {
                while(node != null) {
                    if (node.getData() == data) {
                        return node;
                    } else
                        node = node.getNext();
                }
                return null;
            }
        }

        public ListNode recurssive_reverse_list(ListNode list) {
            if (list == null)
                return null;
            if (list.getNext() == null)
                return list;

            ListNode list_remaining = list.getNext();

            list.setNext(null);

            ListNode reverse = recurssive_reverse_list(list_remaining);

            list_remaining.setNext(list);

            return reverse;

        }

        public ListNode iterative_reverse_list(ListNode list) {
            if (list == null)
                return null;
            if (list.getNext() == null)
                return list;

            ListNode curr, prev, temp;

            curr = list;
            prev = null;

            while(curr != null) {
                temp = curr.getNext();

                curr.setNext(prev);

                prev = curr;
                curr = temp;
            }

            return prev;
        }

        public int Find_Middle(ListNode list) {
            ListNode slow_ptr = list;
            ListNode fast_ptr = list;

            int i = 0;

            while (fast_ptr.getNext() != null) {
                if (i == 0) {
                    fast_ptr = fast_ptr.getNext();
                    i = 1;
                }

                else if (i == 1) {
                    fast_ptr = fast_ptr.getNext();
                    slow_ptr = slow_ptr.getNext();
                    i = 0;
                }
            }

            return (slow_ptr.getData());

        }

        public void print_list_from_end(ListNode curr) {
            if (curr == null)
                return;

            print_list_from_end(curr.getNext());
            System.out.print(curr.getData() + " ");
        }

        public void display_node(ListNode node) {
            if (node == null)
                return;
            while(node != null){
                System.out.println(node.getData());
                node = node.getNext();
            }
            System.out.println();
        }

        public boolean IsEven() {
            boolean result = false;

            ListNode list_Head = head;

            while ((list_Head != null) && (list_Head.getNext() != null)) {
                list_Head = list_Head.getNext().getNext();
            }
            if (list_Head == null)
                result = true;

            return result;
        }

        public void clearList() {
            head = null;
            length = 0;
        }
}





