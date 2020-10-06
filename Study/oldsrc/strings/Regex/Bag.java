package strings.Regex;

import java.util.Iterator;

/**
 * Created by rajkamal on 1/27/17.
 */
public class Bag<Item> implements Iterable<Item> {
        private int N;         // number of elements in bag
        private Node first;    // beginning of bag


        private class Node {
            private Item item;
            private Node next;
        }

        public Bag() {
            first = null;
            N = 0;
        }

        public boolean isEmpty() {
            return first == null;
        }

        public int size() {
            return  N;
        }

        public void add(Item item) {
            Node oldNode = first;
            first = new Node();
            first.item = item;
            first.next = oldNode;
            N++;
        }


        public String toString() {

            Node temp = this.first;
            String str = new String();
            for (int i = 0; i < N; i++) {
                str = str + temp.item + " ";
            }

            return str;

        }

        public Iterator<Item> iterator() {
            return  new ListIterator();
        }

        public class ListIterator implements  Iterator<Item> {
            private Node  current = first;

            public boolean hasNext() {
                return  current != null;
            }

            public void remove() {
                throw new UnsupportedOperationException();
            }

            public Item next() {
                if (!hasNext())
                    throw new UnsupportedOperationException();
                Item item = current.item;
                current = current.next;
                return item;
            }

        }

}