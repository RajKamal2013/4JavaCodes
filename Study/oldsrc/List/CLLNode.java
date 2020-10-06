package List;

/**
 * Created by rajkamal on 12/5/16.
 */
public class CLLNode {
    int data;
    CLLNode next;


    public CLLNode(int data) {
        this.data = data;
        this.next = null;
    }

    public int get_Data() {
        return this.data;
    }

    public void set_Data(int data){
        this.data = data;
    }

    public CLLNode getNext() {
        return this.next;
    }

    public void setNext(CLLNode node){
        this.next = node;
    }
}
