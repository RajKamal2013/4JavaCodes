package strings.Trie;

/**
 * Created by rajkamal on 3/13/18.
 */
public class TrieNode {
    private static int R = 256;
    public Object val;
    public TrieNode[] next;

    public TrieNode() {
        val = null;
        next = new TrieNode[R];
    }
}
