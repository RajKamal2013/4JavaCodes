package strings.Trie;

import java.util.LinkedList;
import java.util.Queue;

/*
 * Created by rajkamal on 3/13/18.
 */
public class TrieST <Value> {
    /* ASCII */
    private static int R = 256;
    private TrieNode root = null;
    private int n;

    public TrieST() {
        root = null;
    }

    public Value get(String key) {
        TrieNode x = get (root, key, 0);
        if (x == null) {
            return null;
        }
        return (Value) x.val;
    }

    private TrieNode get(TrieNode x, String key, int d) {
        if (x == null) {
            return  null;
        }
        if (key.length() == d) {
            return x;
        }
        char c = key.charAt(d);
        return get(x.next[c], key, d + 1);
    }

    public void put(String key, Value val) {
        root = put(root, key, val, 0);
    }

    private TrieNode put(TrieNode x, String key, Value val, int d) {
        if (x == null) {
            x = new TrieNode();
        }
        if (key.length() == d) {
            if (x.val == null) {
                n++;
            }
            x.val = val;
            return x;
        }
        char c = key.charAt(d);
        x.next[c] = put(x.next[c], key, val, d + 1);
        return x;
    }

    public int size() {
        return n;
    }

    public int Size() {
        return Size(root);

    }

    private int Size(TrieNode x) {
        int count = 0;
        if (x == null) return 0;

        if (x.val != null) count++;

        for(char c = 0; c < R; c++) {
            count += Size(x.next[c]);
        }
        return count;
    }

    public boolean contains(String key) {
        return (get(key) != null);
    }

    public boolean isEmpty() {
        return size() == 0;
    }


    public Iterable<String> keys() {
        return keysWithPrefix("");
    }

    public Iterable<String> keysWithPrefix(String prefix) {
        Queue<String> q = new LinkedList<String>();
        TrieNode x = get(root, prefix, 0);
        collect(x, new StringBuilder(prefix), q);
        return q;
    }

    private void collect(TrieNode x, StringBuilder prefix, Queue<String> q) {
        if (x == null) return;

        if (x.val != null) {
            q.offer(prefix.toString());
        }
        for (char c = 0; c < R; c++) {
            prefix.append(c);
            collect(x.next[c], prefix, q);
            prefix.deleteCharAt(prefix.length() - 1);
        }
    }


    public Iterable<String> keysThatMatch(String pattern) {
        Queue<String> q = new LinkedList<String>();
        collect(root, new StringBuilder(), pattern, q);
        return q;
    }

    private void collect(TrieNode x, StringBuilder prefix, String pattern, Queue<String> q) {
        if (x == null) return;

        int d = prefix.length();
        if (d == pattern.length() && x.val != null) {
            q.offer(prefix.toString());
        }
        // we have wild character at end .
        if (d == pattern.length()) return;

        char c = pattern.charAt(d);
        if (c == '.') {
            for (char ch = 0; ch < R; ch++) {
                prefix.append(ch);
                collect(x.next[ch], prefix, pattern, q);
                prefix.deleteCharAt(prefix.length() - 1);
            }
        } else {
            prefix.append(c);
            collect(x.next[c], prefix, pattern, q);
            prefix.deleteCharAt(prefix.length() - 1);
        }
    }


    public String longestPrefixOf(String querry) {
        if (root == null) return null;
        int length = longestPrefixOf(root, querry, 0, -1);
        if (length == -1) {
            return null;
        } else {
            return querry.substring(0, length);
        }
    }

    private int longestPrefixOf(TrieNode x, String querry, int d, int length) {
        if (x == null) return length;
        if (x.val != null) {
            length = d;
        }

        if (d == querry.length()) {
            return length;
        }
        char c = querry.charAt(d);

        return longestPrefixOf(x.next[c], querry, d + 1, length);
    }

    /*
    public void delete(String key) {
        if (key == null) return;
        root = delete(root, key, 0);
    }

    private TrieNode delete(TrieNode x, String key, int d) {
        if (x == null) return null;

        if (d == key.length()) {
            if (x.val != null) {
                n--;
            }
            x.val = null;
        } else {
            char c = key.charAt(d);
            x.next[c] = delete(x.next[c], key, d+1);
        }

        if (x.val != null)  return x;

        for (int c = 0; c < R; c++) {
            if (x.next[c] != null) {
                return x;
            }
        }
        return null;
    }

    */


}

