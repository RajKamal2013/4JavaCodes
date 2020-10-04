package DS;
import java.util.Iterator;
/**
 * Created by rajkamal on 6/12/18.
 */

public class Bag <Item> implements Iterable<Item>
{
    private Node first;
    private int size;

    private class Node
    {
        Node next;
        Item item;
    }

    public Bag() {
        first = null;
        size = 0;
    }

    public void add(Item item)
    {
        Node oldNode = first;
        first = new Node();
        first.item = item;
        first.next = oldNode;
    }

    public Iterator<Item> iterator()
    {
        return new BagIterator();
    }

    public  class BagIterator implements Iterator<Item>
    {
        private Node current = first;


        public boolean hasNext()
        {
            return (current != null);
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
