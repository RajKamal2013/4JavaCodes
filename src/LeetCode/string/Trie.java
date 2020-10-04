package LeetCode.string;

/**
 * Created by rajkamal on 3/14/18.
 */

/** Implement a trie with insert, search, and startsWith methods.
 * Note: You may assume that all inputs are consist of lowercase letters a-z.
 */

import java.util.LinkedList;
import java.util.Queue;

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */

public class Trie {
    int offset = 97;
    int R = 26;
    public class Node {
        int val = -1;
        public Node next[] = new Node[R];
    }

    public Node root;
    /** Initialize your data structure here. */
    public Trie() {
        root = new Node();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        root = insert(root, word, 0);
    }

    /** Private method to insert key in trie */
    private Node insert (Node x, String word, int d) {
        if (x == null) {
            x = new Node();
        }
        if (d == word.length()) {
            x.val = 1;
            return x;
        }

        char c = word.charAt(d);
        x.next[c - offset] = insert(x.next[c - offset], word, d + 1);
        return x;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        boolean ret = false;
        if (root == null) return ret;
        Node x = search(root, word, 0);
        if (x != null) {
            if (x.val == 1) {
                ret = true;
            }
        }
        return ret;
    }

    /** Private method for searching the key */
    private Node search(Node x, String word, int d) {
        if (x == null) return  null;

        if (d == word.length()) {
            return x;
        }

        char c = word.charAt(d);
        return search(x.next[c - offset], word, d + 1);
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
       // Queue<String> q = new LinkedList<String>();
        boolean ret = false;
        Node x = search(root, prefix, 0);
        //startsWith(x, new StringBuilder(prefix), q);
        //if (!q.isEmpty()) ret = true;
        ret = startsWith(x, new StringBuilder(prefix));
        return ret;
    }

    /** Private method supporting the StartWith */
    /*
    private void startsWith(Node x, StringBuilder prefix, Queue<String> q) {
        if (x == null) return;
        if (x.val == 1) {
            q.offer(prefix.toString());
        }

        for (int i = 0; i < R; i++) {
            prefix = prefix.append(offset + i);
            startsWith(x.next[i], prefix, q);
            prefix.deleteCharAt(prefix.length() - 1);
        }
    }
    */
    private boolean startsWith(Node x, StringBuilder prefix) {
        if (x == null) return false;
        if (x.val == 1) {
            return true;
        }
        boolean ret = false;

        for (int i = 0; i < R; i++) {
            prefix = prefix.append(offset + i);
            ret = startsWith(x.next[i], prefix);
            if (ret == true) break;
            prefix.deleteCharAt(prefix.length() - 1);
        }
        return ret;
    }

}

