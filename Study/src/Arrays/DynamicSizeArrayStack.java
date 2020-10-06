package Arrays;

/**
 * Created by rajkamal on 12/7/16.
 */
public class DynamicSizeArrayStack {
    protected int capacity;
    public static final int CAPACITY = 8;
    public static final int MIN_CAPACITY = 1<<2;
    public int[] stack_rep;
    protected int top = -1;

    public DynamicSizeArrayStack(int capacity) {
        this.capacity = capacity;
        stack_rep = new int[capacity];
    }

    public DynamicSizeArrayStack() {
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

        for ( i = 0; i < top; i++) {
            result = result + stack_rep[i] + " ,";
        }
        result = result + stack_rep[i] + "]";

        return result;
    }

    public void expand(){
        int length = size();
        int []new_array = new int[length << 1];
        System.arraycopy(stack_rep, 0, new_array, 0, length);
        stack_rep = new_array;
    }

    public void shrink(int num){
        int length = size();
        if (length < capacity) {
            return;
        }
        capacity = capacity - num;

        int []new_Array = new int[capacity];
        System.arraycopy(stack_rep, 0, new_Array, 0, length);
        stack_rep = new_Array;
    }
}
