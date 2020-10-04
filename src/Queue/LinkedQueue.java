package Queue;

import List.ListNode;

/**
 * Created by rajkamal on 12/8/16.
 */
public class LinkedQueue {
    int length;
    ListNode rear, front;

    public LinkedQueue() {
        length = 0;
        front = rear = null;
    }

    public LinkedQueue(int data) {
        ListNode node = new ListNode(data);
        front = node;
        rear = node;
        length = 1;
    }

    public boolean isEmpty() {
        return (length == 0);
    }

    public int first() throws Exception {
        if (isEmpty())
            throw new Exception("Queue is empty");
        return front.getData();

    }

    public int size() {
        return  length;
    }

    public void enqueue(int data) {
        ListNode node = new ListNode(data);
        if (isEmpty()) {
            front = node;
        }else
            rear.setNext(node);

        rear = node;
        length++;
    }

    public int dequeue() throws Exception {
        if (isEmpty()) {
            throw new Exception("Queue Emoty");
        }

        int result = front.getData();
        front = front.getNext();
        length--;
        if (isEmpty()) {
            rear = null;
        }

        return result;
    }

    public String toString() {
        String result =""
                ;
        ListNode current = front;

        while (current != null) {
            result = result + current.toString() + "\n";
            current = current.getNext();
        }
        return result;

    }
}
