package List;

/**
 * Created by rajkamal on 12/5/16.
 */
public class ListNode {
        int data;
        ListNode next;

        public ListNode(int data) {
            this.data = data;
            this.next = null;
        }


        public void setData(int data) {
            this.data = data;
        }

        public int getData() {
            return data;
        }

        public void setNext(ListNode next) {
            this.next = next;
        }

        public ListNode getNext(){
            return this.next;
        }

        public int ListLength(ListNode headNode) {
            int length = 0;
            ListNode currentNode = headNode;
            while (currentNode != null) {
                length ++;
                currentNode = currentNode.getNext();
            }

            return length;
        }

        public String toString() {
            String result = Integer.toString(this.getData());
            return  result;
        }
}

