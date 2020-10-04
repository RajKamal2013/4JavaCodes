package DS;

import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by rajkamal on 6/14/18.
 */
public class MaxPQ<Key> implements Iterable<Key> {
    Key[] pq;
    int N;
    private Comparator<Key> comp;


    public MaxPQ(int initCapacity) {
        pq = (Key[]) new Object[initCapacity + 1];
        N = 0;
    }

    public MaxPQ() {
        this(1);
    }

    public MaxPQ(int initCapacity, Comparator<Key> comp) {
        this.comp = comp;
        pq = (Key[]) new Object[initCapacity + 1];
        N = 0;
    }

    public MaxPQ(Comparator<Key> comp) {
        this(1, comp);
    }

    public boolean isEmpty() {
        return (N == 0);
    }

    public int size() {
        return N;
    }

    public void resize(int capacity) {
        Key[] temp = (Key[]) new Object[capacity];
        for (int i = 1; i <= N; i++) {
            temp[i] = pq[i];
        }
        pq = temp;
    }

    public void swap(int i, int j) {
        Key temp = pq[i];
        pq[i] = pq[j];
        pq[j] = temp;
    }

    public boolean less(int i, int j) {
        if (comp == null)
            return ((((Comparable<Key>) pq[i]).compareTo(pq[j])) > 0);
        else
            return (comp.compare(pq[i], pq[j]) > 0);
    }

    /* percolate up */
    private void swim(int k) {
        while (k >= 1 && less(k, k / 2)) {
            swap(k, k / 2);
            k = k / 2;
        }
    }

    /* percolate down , heapify */
    private void sink(int k) {
        while (2 * k <= N) {
            int j = 2 * k;
            if (less(j, j + 1)) {
                j++;
            }
            if (!less(k, j))
                break;
            else {
                swap(k, j);
                k = j;
            }
        }
    }

    public void insert(Key key)
    {
        if (N == pq.length - 1) resize(2 * pq.length);
        pq[++N] = key;
        swim(N);
    }

    public Key deleteMax()
    {
        if (N == 0) throw new NoSuchElementException("Key not found, heap empty");
        Key data = pq[N--];
        sink(1);
        pq[N+1] = null;
        if((N > 0) && (N == pq.length/4))  resize(pq.length/2);
        return data;
    }

    public boolean isMaxHeap()
    {
        return isMaxHeap(1);
    }

    public boolean isMaxHeap(int k)
    {
        int left = 2*k;
        int right = 2*k + 1;
        if (left <= N && !less(k, left))
            return false;
        if (right <= N && !less(k, right))
            return false;

        return isMaxHeap(left) && isMaxHeap(right);
    }

    public Iterator<Key> iterator()
    {
        return new HeapIterator();
    }

    public class HeapIterator implements Iterator<Key>
    {
        private MaxPQ<Key> copy;

        public HeapIterator()
        {
            if (comp == null)
                copy = new MaxPQ<Key>(size());
            else
                copy = new MaxPQ<Key>(size(), comp);
            for (int i = 1; i <= N; i++)
            {
                copy.insert(pq[i]);
            }

        }

        public boolean hasNext()
        {
            return (!copy.isEmpty());
        }

        public Key next()
        {
            if (!hasNext()) throw new RuntimeException("heap is empty");
            return copy.deleteMax();
        }

        public void remove()
        {
            System.out.println("Operation not supported!!");
            return;
        }
    }

}