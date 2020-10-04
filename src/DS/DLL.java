package DS;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by rajkamal on 6/13/18.
 */
public class DLL <Item> implements Iterable<Item>
{
    private class doubleNode
    {
        Item item;
        doubleNode next;
        doubleNode prev;
    }

    private int N;
    private doubleNode first;
    private doubleNode last;

    public DLL()
    {
        first = null;
        last = null;
    }

    public DLL(Item[] a)
    {
        for (Item item : a) {
            append(item);
        }
    }

    public DLL(Iterable<Item> coll)
    {
        for (Item t : coll) {
            append(t);
        }
    }

    public boolean isEmpty()
    {
        return (first == null);
    }

    public int size()
    {
        return N;
    }

    public Item first()
    {
        if (first == null) throw new RuntimeException("List is Empty");
        return first.item;
    }

    public Item last()
    {
        if (last == null) throw new RuntimeException("List is Empty");
        return last.item;
    }

    public void append(Item item )
    {
        doubleNode x = new doubleNode();
        x.item = item;
        if (isEmpty()) {
            first = x;
            last = x;
        } else {
            x.prev = last;
            last.next = x;
            last = x;
        }
        N++;
    }

    public void prepend(Item item)
    {
        doubleNode x = new doubleNode();
        x.item = item;
        if (isEmpty()) {
            first = x;
            last = x;
        } else {
            x.next = first;
            first.prev = x;
            first = x;
        }
        N++;
    }

    public boolean contains(Item item)
    {
        doubleNode curr = first;
        while((curr != null) && (curr.item != item)) {
            curr = curr.next;
        }
        if (curr == null) {
            return false;
        } else {
            return  true;
        }
    }

    public Item removeFirst()
    {
        if (isEmpty()) throw new RuntimeException("List is Empty");
        Item item = first.item;
        if (first.next != null) {
            first = first.next;
            first.prev = null;
        }
        N--;
        if (first == null) last = null;
        return item;
    }


    public Item removeLast()
    {
        if (isEmpty()) throw new RuntimeException("List is Empty");
        Item item = last.item;
        if (last.prev != null) {
            last = last.prev;
            last.next = null;
        }
        N--;
        if (last == null) first = null;
        return item;

    }

    public void remove(Item item)
    {



    }

    public String toString()
    {
        StringBuilder s = new StringBuilder();
        for (Item item : this)
            s.append(item + " ");
        return s.toString();
    }

    public Iterator<Item> iterator()
    {
        return new DLLIterator();
    }

    private class DLLIterator implements Iterator<Item>
    {
        doubleNode curr = first;

        public boolean hasNext()
        {
            return (first != null);
        }

        public Item next()
        {
            if (!hasNext()) throw new RuntimeException("List is empty");
            Item item = curr.item;
            curr = curr.next;
            return item;
        }

        public void remove()
        {
            throw new RuntimeException("API not supported");
        }
    }

    public Iterable<Item> reversed()
    {
        return new ReverseIterable();
    }

    public class ReverseIterable implements Iterable<Item>
    {
        public String toString()
        {
            StringBuilder str = new StringBuilder();
            for (Item item : this) {
                str.append(item + " ");
            }
            return str.toString();
        }
        public Iterator<Item> iterator() {
            return new ReverseListIterator();
        }

        public class ReverseListIterator implements Iterator<Item>
        {
            doubleNode curr = last;

            public boolean hasNext()
            {
                return (curr != null);
            }

            public Item next()
            {
                if (!hasNext()) throw new NoSuchElementException();
                Item data = curr.item;
                curr = curr.prev;
                return data;
            }
        }

    }

}
