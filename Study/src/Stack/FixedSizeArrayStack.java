package Stack;

/**
 * Created by rajkamal on 12/7/16.
 */
public class FixedSizeArrayStack {
    protected int capacity;
    public static final int CAPACITY = 10;
    public int[] stack_rep;
    protected int top = -1;

    public FixedSizeArrayStack(int capacity) {
        this.capacity = capacity;
        stack_rep = new int[capacity];
    }
    public FixedSizeArrayStack() {
        this.capacity = CAPACITY;
        stack_rep = new int[CAPACITY];
    }

    public int size()  {
        return (top+1);
    }

    public boolean isEmpty(){
        if (top == -1)
            return true;
        else
            return false;
    }

    public int top() throws Exception {
        if (isEmpty()){
            throw new Exception("Stack is empty");
        }
        return stack_rep[top];
    }

    public int pop() throws Exception{
        if (isEmpty()) {
            throw new Exception("Stack is empty");
        }
        int data = stack_rep[top];
        stack_rep[top--] = Integer.MIN_VALUE;
        return data;
    }

    public void push(int data) throws Exception{
        if (size() == capacity) {
            throw new Exception("Stack is Full");
        }
        stack_rep[++top] = data;
    }
    public String  toString(){
        if (isEmpty()) {
            System.out.println("[]");
            return "[]";
        }
        int i;
        String result = "[";

        for ( i = 0; i < size() - 1; i++) {
            result = result + stack_rep[i] + " ,";
        }
        result = result + stack_rep[i] + "]";

        return result;
    }
}
