package DS;

import java.util.Iterator;

/**
 * Created by rajkamal on 6/12/18.
 */
public class DynamicArrayStack <Item> implements Iterable<Item>
{
    public Item[] arr = (Item []) new Object[1];
    private int  N = 0;
    public boolean isEmpty()
    {
        return (N == 0);
    }

    public int size()
    {
        return N;
    }

    public void resize(int max)
    {
        Item[] temp = (Item[]) new Object[max];

        for (int i = 0; i < max; i++) {
            temp[i] = arr[i];
        }
        arr = temp;
    }

    public Item pop()
    {
        Item item = arr[--N];
        arr[N] = null;
        if(N > 0 && N == arr.length/4) {
            resize(arr.length/2);
        }
        return item;
    }

    public void push(Item item)
    {
        if (N == arr.length) {
            resize(2*arr.length);
        }
        arr[N++] = item;
    }

    public Iterator<Item> iterator() {
        return new DynamicArrayStackIterator();
    }

    private class DynamicArrayStackIterator implements Iterator<Item>
    {
        private int i = N;

        public boolean hasNext()
        {
            return (i > 0);
        }

        public Item next()
        {
            return arr[--i];

        }
        public void remove()
        {


        }
    }
}
