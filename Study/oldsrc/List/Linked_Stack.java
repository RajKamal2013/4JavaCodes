package List;

import java.util.EmptyStackException;

/**
 * Created by rajkamal on 12/7/16.
 */
public class Linked_Stack {
    private int length;
    private ListNode top;


    public Linked_Stack() {
        length = 0;
        top = null;
    }

    public Linked_Stack(int data){
        length = 1;
        ListNode temp = new ListNode(data);
        top = temp;
    }

    public boolean is_Empty() {
        return (length == 0);
    }

    public int pop() throws EmptyStackException{
        if(is_Empty())
            throw new EmptyStackException();
        int data = top.getData();

        top = top.getNext();
        length--;
        return  data;
    }

    public void push (int data) {
        ListNode temp = new ListNode(data);
        temp.setNext(top);
        top = temp;
        length++;
    }

    public int size() {
        return length;
    }

    public int peek() throws EmptyStackException{
        if (is_Empty())
            throw new EmptyStackException();

        return (top.getData());
    }

    public String toString(){
        String result = "[ ";
        ListNode current = top;
        while (current != null) {
            result = result + current.getData() + " " ;
            current = current.getNext();
        }
        result = result + " ]";

        return  result;
    }
}
