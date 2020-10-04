package DS;

import java.util.Iterator;

/**
 * Created by rajkamal on 6/13/18.
 */
public class Queue <Item> implements Iterable<Item> {
    private node first;
    private node last;
    int N;

    private class node
    {
        Item item;
        node next;
    }

    public Queue()
    {
        first = last = null;
        N = 0;
    }

    public  boolean isEmpty()
    {
        return (first == null);
    }


    public int size()
    {
        return N;
    }

    public void enqueue(Item item)
    {
        node oldNode = last;
        last = new node();
        last.item = item;
        last.next = null;
        if (isEmpty()) {
            first = last;
        } else {
            oldNode.next = last;
        }
        N++;
    }

    public Item dequeue()
    {
        if (isEmpty()) {
            return  null;
        }
        Item item = first.item;
        first = first.next;
        N--;
        if (isEmpty()) {
            last = null;
        }
        return item;
    }

    public Iterator<Item> iterator()
    {
        return new QueueIterator();
    }


    public class QueueIterator implements Iterator<Item>
    {
        node current = first;

        public boolean hasNext()
        {
            return  (current == null);
        }

        public Item next()
        {
            Item item = current.item;
            current = current.next;
            return item;
        }

        public void remove()
        {


        }

    }
}
