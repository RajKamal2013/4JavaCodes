package List;

/**
 * Created by rajkamal on 12/5/16.
 */

public class DoubleLinkedList {
    private DLLNode head;
    private DLLNode tail;
    int length;


    public DoubleLinkedList() {
        head = new DLLNode(Integer.MIN_VALUE, null, null);
        tail = new DLLNode(Integer.MIN_VALUE, head, null);
        head.setNext(tail);
        length = 0;
    }

    public int getPosition(int data){
        DLLNode  temp = head;
        int position = 0;
        while (temp != null) {
            if (temp.getData() == data) {
                return position;
            }
            position+=1;
            temp = temp.getNext();
        }

        return Integer.MIN_VALUE;
    }

    public void insert_head(int data){
        DLLNode newNode = new DLLNode(data, head, head.getNext());
        head.getNext().setPrev(newNode);
        head.setNext(newNode);
        length+=1;
    }

    public void insert(int data, int position) {
        if (position < 0)
            position = 0;
        if (position > length) {
            position = length;
        }
        if (head == null) {
            head = new DLLNode(data);
            tail = head;
        } else {
            DLLNode temp = head;
            for (int i = 0; i < position; i++) {
                temp = temp.getNext();
            }

            DLLNode newNode = new DLLNode(data);
            newNode.next = temp.next;
            newNode.prev = temp;
            newNode.next.prev = newNode;
            temp.next = newNode;
        }
        length++;
    }

    public void insert_tail(int data) {
        DLLNode newNode = new DLLNode(data, tail.getPrev(), tail);
        tail.getPrev().setNext(newNode);
        tail.setPrev(newNode);
        length+=1;
    }

    public void remove(int position) {
        if (position < 0)
            position = 0;
        if (position >= length)
            position = length;

        if (head == null)
            return;

        if (position == 0) {
            head = head.getNext();
            if (head == null)
                tail = null;
        } else {
            DLLNode temp = head;
            for (int i = 0; i < position; i++) {
                temp = temp.getNext();
            }
            temp.getNext().setPrev(temp.getPrev());
            temp.getPrev().setNext(temp.getNext());
            temp = null;

        }
        length--;
    }

    public int remove_head() {
        if (length == 0)
            return Integer.MIN_VALUE;
        else {
            DLLNode temp = head.getNext();
            head.setNext(temp.getNext());
            temp.getNext().setPrev(head);
            length--;
            return temp.getData();

        }
    }

    public synchronized  void remove_Matched(DLLNode node) {
        if (head == null)
            return;

        if(node.equals(head)) {
            head = head.getNext();
            if (head == null )
                tail = null;

            return;

        }

        DLLNode p = head;

        while (p != null ){
            if (node.equals(p)) {
                p.prev.next = p.next;
                p.next.prev = p.prev;
                return;

            }
        }
    }

    public int remove_Tail() {
        if(length == 0)
            return Integer.MIN_VALUE;

        DLLNode save = tail.getPrev();
        tail.setPrev(save.getPrev());
        save.getPrev().setNext(tail);
        length--;
        return save.getData();
    }

    public String toString() {
        String result = "[]";
        if (length == 0)
            return result;
        result = "[ " + head.getNext().getData();

        DLLNode temp = head.getNext().getNext();
        while(temp != tail) {
            result += ", " + temp.getData();
            temp = temp.getNext();
        }

        return result + "]";
    }

    public void clearList() {
        head = null;
        tail = null;
        length = 0;
    }

    public  DLLNode search(int data) {
        if (length == 0) {
            return null;
        }

        DLLNode temp = head;
        while (temp != tail) {
            if (temp.getData() == data)
                return temp;
            temp = temp.getNext();
        }

        return null;
    }
}

