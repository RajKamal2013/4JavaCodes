package Queue;

/**
 * Created by rajkamal on 12/8/16.
 */
public class FixedSizeQueue {
    private int[] queueRep;
    private int front, rear, size;

    private static final int CAPACITY = 16;


    public FixedSizeQueue () {
        queueRep = new int[CAPACITY];
        front = rear = size = 0;
    }

    public FixedSizeQueue(int cap) {
        queueRep = new int[cap];
        size = front = rear = 0;
    }

    public void enQueue(int data ) throws IllegalStateException {
        if (size == CAPACITY)
            throw new IllegalStateException("Queue is FULL: Overflow");
        else {
            size++;
            queueRep[rear] = data;
            rear = (rear + 1) % CAPACITY;
        }
    }

    public int deQueue() throws IllegalStateException {
        if  (size == 0)
            throw new IllegalStateException("Queue is Empty : UnderFlow");
        else {
            size--;
            int data = queueRep[front];
            queueRep[front] = Integer.MIN_VALUE;
            front = (front + 1) % CAPACITY;
            return data;
        }
    }

    public boolean isEmpty() {
        return (size == 0);
    }

    public boolean isFull() {
        return (size == CAPACITY);
    }

    public int size() {
        return size;
    }

    public String toString() {
        String result = "[";

        for (int i = 0; i < size; i++) {
            result = result + Integer.toString(queueRep[(front + i) % CAPACITY]) ;
            if (i < size - 1)
                result = result + " ,";
        }
        result = result + "]";
        return result;
    }
}
