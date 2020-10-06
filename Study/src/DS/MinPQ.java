package DS;

import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by rajkamal on 6/14/18.
 */
public class MinPQ <Key> implements Iterable<Key>
{
    private Key[] pq;
    private int N;
    private Comparator<Key> comp;

    public MinPQ(int initCapacity)
    {
        pq = (Key[]) new Object[initCapacity + 1];
        N = 0;
    }

    public MinPQ()
    {
        this(1);
    }

    public MinPQ(int initCapacity, Comparator<Key> comp)
    {
        this.comp = comp;
        pq = (Key[]) new Object[initCapacity + 1];
        N = 0;
    }

    public MinPQ (Comparator<Key> comp)
    {
        this(1, comp);
    }

    public MinPQ(Key[] keys)
    {
        N = keys.length;
        pq = (Key[]) new Object[keys.length + 1];
        for (int i = 0;i < N; i++)
        {
            pq[i + 1] = keys[i];
        }

        for (int i = N/2; i >= 1; i--)
        {
            sink(i);
        }
    }

    public boolean isEmpty()
    {
        return (N == 0);
    }

    public int size()
    {
        return N;
    }

    private void resize(int capacity)
    {
        Key[] temp = (Key[]) new Object[capacity];
        for (int i = 1;i <= N; i++) {
            temp[i] = pq[i];
        }
        pq = temp;
    }

    public void insert(Key x)
    {
        if (N == pq.length - 1) resize(2 * pq.length);
        pq[++N] = x;
        swim(N);
    }

    public Key delMin()
    {
        if (N == 0) throw  new RuntimeException("Heap is empty");
        swap(1, N);
        Key min = pq[N--];
        sink(1);
        pq[N + 1] = null;
        if ((N > 0) && (N == pq.length/4))  resize(pq.length/2);
        return min;
    }

    private void swap(int i, int j)
    {
        Key temp = pq[i];
        pq[i] = pq[j];
        pq[j] = temp;
    }

    private boolean greater(int i, int j)
    {
        if (comp == null) {
            return (((Comparable<Key>)pq[i]).compareTo(pq[j]) > 0);
        } else {
            return (comp.compare(pq[i], pq[j]) > 0);
        }
    }

    private void swim(int k)
    {
        while (k >= 1 && greater(k/2, k)) {
            swap(k, k/2);
            k = k/2;
        }
    }

    private void sink(int k)
    {
        while (2*k <= N) {
            int j = 2 *k;
            if (j < N && greater(j, j++)) {
                j++;
            }
            if (!greater(k, j)) {
                break;
            }
            swap(k, j);
            k = j;
        }
    }

    private boolean isMinHeap()
    {
        return isMinHeap(1);
    }

    private boolean isMinHeap(int k)
    {
        if (k > N) return  true;

        int left = 2 *k;
        int right = 2 *k + 1;

        if ((left <= N) && greater(k, left))
            return false;
        if ((right <= N) && greater(k, right))
            return false;
        return isMinHeap(left) && isMinHeap(right);
    }

    public Iterator<Key> iterator()
    {
        return new HeapIterator();
    }

    public class HeapIterator implements Iterator<Key>
    {
        private MinPQ<Key> copy;
        public HeapIterator()
        {
            if(comp == null)
                copy = new MinPQ<Key>(size());
            else
                copy = new MinPQ<Key>(size(), comp);

            for (int i = 1; i <= N; i++)
                copy.insert(pq[i]);
        }

        public boolean hasNext()
        {
            return !copy.isEmpty();
        }

        public Key next()
        {
            if (!hasNext()) throw  new NoSuchElementException("Empty Heap");
            return copy.delMin();

        }

        public void remove()
        {
            System.out.println("Not Supported !! ");
        }
    }

}
