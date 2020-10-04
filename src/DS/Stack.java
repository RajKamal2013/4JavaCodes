package DS;

import java.util.Iterator;

/**
 * Created by rajkamal on 6/12/18.
 */
public class Stack <Item> implements Iterable<Item>
{

    private class node
    {
        node next;
        Item item;
    }

    private node first;

    public Stack ()
    {
        first = null;
    }

    public boolean isEmpty()
    {
        return (first == null);
    }

    public void push(Item item)
    {
        node oldnode = first;
        first = new node();
        first.item = item;
        first.next = oldnode;
    }

    public Item pop()
    {
        Item item = first.item;
        first = first.next;
        return item;
    }

    public Item peek()
    {
        if (isEmpty()) {
            return null;
        } else {
            return first.item;
        }
    }

    public Iterator<Item> iterator()
    {
        return new stackIterator();
    }

    public class stackIterator implements Iterator<Item>
    {
        private node current = first;

        public boolean hasNext()
        {
            return (current != null);

        }
        public Item next()
        {
            Item item = current.item;
            current= current.next;
            return item;
        }
        public void remove()
        {

        }
    }
}
