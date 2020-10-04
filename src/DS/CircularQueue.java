package DS;

import java.util.Iterator;

/**
 * Created by rajkamal on 6/13/18.
 */
public class CircularQueue<Item> implements Iterable<Item>
{
    Item arr[];
    int N;
    int front, rear;

    public CircularQueue(int size)
    {
        N = size;
        arr = (Item[]) new Object[N];
        front = rear = -1;
    }

    public boolean isEmpty()
    {
        return (front == -1);
    }

    public void enqueue(Item item)
    {
        if ((front == 0) && (rear == N - 1)) {
            System.out.println("Queue is Full");
            return;
        } else if (rear + 1 == front) {
            System.out.println("Queue is Full");
        } else if (front ==   -1) {
            front = rear = 0;
        } else if ((rear == N -1 ) && (front != 0)) {
            rear = 0;
        } else {
            rear++;
        }
        arr[rear] = item;
    }

    public Item dequeue()
    {
        Item data;
        if (front == -1) {
            System.out.println("Queue is Empty");
            return null;
        }
        data = arr[front];

        if (front == rear) {
            front = rear = -1;
        } else if (front == N - 1) {
            front = 0;
        } else {
            front ++;
        }
        return data;
    }

    public Item peek()
    {
        return arr[front];
    }


    public Iterator<Item> iterator()
    {
        return new CircularQueueIterator();
    }

    public class CircularQueueIterator implements Iterator<Item>
    {
        int current = front;

        public boolean hasNext()
        {
            return (current == -1);
        }

        public Item next()
        {
            Item data = arr[current];
            current++;
            return data;
        }

        public void remove()
        {

        }
    }
}
