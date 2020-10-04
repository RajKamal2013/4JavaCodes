package List;

import java.util.EmptyStackException;

/**
 * Created by rajkamal on 12/7/16.
 */
public class Linked_Stack_Test {

    public static void test() {
        Linked_Stack linked_stack = new Linked_Stack();
        ListNode node = null;
        int data = 0, peek = 0, size = 0;
        int []arr = {1, 2, 3,  4, 5, 6, 7};
        for (int i = 0; i < arr.length; i++) {
            linked_stack.push(arr[i]);
        }

        System.out.println("Stack Representation ");
        System.out.println(linked_stack.toString());
        size = linked_stack.size();
        System.out.println("Size of the stack " + size);
        try {
            peek = linked_stack.peek();
        }catch (EmptyStackException ex){
            System.out.println("Stack is Empty");
        }
        System.out.println("Peek of the stack " + peek);

        try {
            data = linked_stack.pop();
        }catch(EmptyStackException ex) {
            System.out.println("Stack is Empty");
        }
        try {
            peek = linked_stack.peek();
        }catch (EmptyStackException ex){
            System.out.println("Stack is Empty");
        }
        System.out.println("Peek of the stack " + peek);

        System.out.println("Stack Representation ");
        System.out.println(linked_stack.toString());
        size = linked_stack.size();
        System.out.println("Size of the stack " + size);

    }

    public static void main(String []args){
            test();
    }

}
