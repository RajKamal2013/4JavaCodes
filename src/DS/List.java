package DS;

import java.util.Iterator;
import java.util.ListIterator;

/**
 * Created by rajkamal on 6/13/18.
 */
public class List <Item> implements Iterable <Item>
{
    private class node
    {
        Item data;
        node next;


        public node() {
            next = null;
        }
    }

    private node first;
    private node last;
    private int N;


    public List()
    {
        first = last = null;
    }

    public List(Item[] a)
    {
        for (Item item : a) {
            append(item);
        }
    }

    public List(Iterable<Item> coll)
    {
        for (Item item : coll) {
            append(item);
        }
    }

    public boolean isEmpty()
    {
        return (first == null);
    }

    public Item first()
    {
        if (isEmpty()) throw  new RuntimeException("List is empty");
        return first.data;
    }

    public Item last()
    {
        if (isEmpty()) throw  new RuntimeException("List is empty");
        return last.data;
    }

    public int size()
    {
        return N;
    }

    public Item removeFirst()
    {
        if (isEmpty()) throw  new RuntimeException("List is empty");
        Item data = first.data;
        first = first.next;
        N--;
        if (isEmpty()) last = null;
        return data;
    }

    public void prepend(Item data)
    {
        node x = new node();
        x.data = data;
        if (isEmpty()) {
            first = x;
            last = x;
        } else {
            x.next = first;
            first = x;
        }
        N++;
    }


    public void append(Item data)
    {
        node x = new node();
        x.data = data;
        if (isEmpty()) {
            first = x;
            last = x;
        } else {
            last.next = x;
            last = x;
        }
        N++;
    }

    public String toString()
    {
        StringBuilder s = new StringBuilder();
        for (Item item : this) {
            s.append(item + " ");
        }
        return s.toString();

    }

    public Item removeLast()
    {
        if (isEmpty()) throw new RuntimeException("List is empty");
        Item data = last.data;
        if (first == last) first = last = null;

        node prev = null;
        node curr = first;

        while(curr.next != null) {
            prev = curr;
            curr = curr.next;
        }
        prev.next = null;
        last = prev;
        return data;
    }


    public boolean contains (Item k)
    {
        node curr = first;
        while (curr != null && !curr.data.equals(k)) {
            curr  = curr.next;
        }
        return (curr != null);
    }

    public Item delete(int k)
    {
        if (k < 1 ) throw new RuntimeException("No Item exist");
        int i = 0;
        node curr, prev;
        prev = null;
        curr = first;

        while (i < k && curr != null) {
            prev = curr;
            curr = curr.next;
            i++;
        }

        if (curr != null) {
            if (prev == null)  {
                first = curr.next;
            } else {
                prev.next = curr.next;
            }

            if (curr.next == null)
                last = prev;
            N--;

            return curr.data;
        } else
            return null;

    }

    public void remove(Item data)
    {
        List <Integer> idx  = new List<>();
        int i = 0;

        for (Item x : this) {
            if (x.equals(data)) {
                idx.prepend(i);
            }
            i++;
        }
        for (int k : idx) {
            delete(k);
        }
    }

    public void reverse() {
        Object[] head = new Object[1];
        node t1 = first;
        node t2 = last;
        reverse(first, head);
        first = (node) head[0];
        last = t1;

    }

    private void reverse(node curr, Object[] head)
    {
        if (curr == null) {
            return;
        }

        node link =  curr.next;

        if (link == null) {
            head[0] = (node)curr;
            return;
        }

        reverse(link, head);
        link.next = curr;
        curr.next = null;
    }


    public Iterator<Item> iterator()
    {
        return new listIterator();
    }

    public class listIterator implements Iterator<Item>
    {
        node current = first;

        public boolean hasNext()
        {
            return (current != null);
        }

        public Item next()
        {
            Item item = current.data;
            current = current.next;
            return item;
        }

        public void remove()
        {
            throw new UnsupportedOperationException();
        }
    }
}
