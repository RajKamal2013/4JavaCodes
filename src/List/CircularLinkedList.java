package List;

/**
 * Created by rajkamal on 12/5/16.
 */
public class CircularLinkedList {
    protected CLLNode tail ;
    protected int length;

    public CircularLinkedList(int data) {
        tail = new CLLNode(data);
        tail.setNext(tail);
        length++;
    }

    public CircularLinkedList() {
        length = 0;
        tail = null;
    }


    public void add_to_head(int data) {
        CLLNode node = new CLLNode(data);
        if (tail == null) {
            tail = node;
            tail.setNext(tail);
        } else {
            node.setNext(tail.getNext());
            tail.setNext(node);
        }
        length ++;
    }

    public void add_To_Tail(int data) {
        add_to_head(data);
        tail = tail.getNext();
    }

    // head of the list
    public int Peek() {
        return (tail.getNext().get_Data());
    }


    //tail of the list
    public int TailPeek(){
        return (tail.get_Data());
    }

    public int getSize() {
            return this.length;
    }

    public int remove_from_Head(){
        if (tail == null)
            return Integer.MIN_VALUE;

        CLLNode temp = tail.getNext();
        if (tail == tail.getNext()) {
            tail = null;
        } else {
            tail.setNext(temp.getNext());
            temp.setNext(null);
        }

        length--;

        return (temp.get_Data());
    }


    public int remove_from_Tail(){
        if (tail == null)
            return Integer.MIN_VALUE;
        CLLNode finger = tail.getNext();

        while(finger.getNext() != tail)
            finger = finger.getNext();

        if (finger == tail)
            tail = null;
        else {
            finger.setNext(tail.getNext());
            tail = finger;
        }

        length--;
        return (finger.get_Data());

    }



    public int remove(int data) {
        if (tail == null)
            return Integer.MIN_VALUE;

        CLLNode finger = tail.getNext();
        CLLNode previous = tail;
        int i;

        for (i = 0; i < length && !((finger.get_Data() == data)); i++) {
            previous = finger;
            finger = finger.getNext();
        }

        if (finger.get_Data() == data) {
            if (tail == tail.getNext())
                tail = null;
            else {
                if (finger == tail) {
                    tail = previous;
                }
                previous.setNext(finger.getNext());
            }
            finger.setNext(null);
            length--;
            return finger.get_Data();
        }
        return Integer.MIN_VALUE;
    }


    public boolean contains(int data){
        CLLNode finger = tail.getNext();
        while ((finger!= tail ) && !(finger.get_Data() == data)) {
            finger = finger.getNext();
        }

        return (finger.get_Data() == data);

    }

    public boolean isEmpty(){
        return (tail==null);

    }

    public void clean(){
        length = 0;
        tail = null;
    }

    public String toString() {
        String result = "[";
        if (tail == null)
            return (result + "]");

        CLLNode temp = tail.getNext();

        if (temp == tail)
            result = result + temp.get_Data();
        else {
            while (temp != tail) {
                result = result + temp.get_Data() + " ,";
                temp = temp.getNext();
            }
            result  +=  temp.get_Data();
        }


        return (result + "]");
    }

}
