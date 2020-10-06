package List;

/**
 * Created by rajkamal on 12/5/16.
 */

public class DLLNode {
    int data;
    DLLNode prev;
    DLLNode next;


    public DLLNode(int data) {
        this.data = data;
        prev = null;
        next = null;
    }

    public DLLNode(int data, DLLNode prev, DLLNode next) {
        this.data = data;
        this.next = next;
        this.prev = prev;
    }


    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public DLLNode getPrev() {
        return prev;
    }

    public DLLNode getNext() {
        return next;
    }

    public void setPrev(DLLNode node){
        prev = node;
    }

    public void setNext(DLLNode node){
        next = node;
    }
}
