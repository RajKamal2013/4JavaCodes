package PPM.Regex;

import strings.Regex.Bag;

import java.util.Stack;

/**
 * Created by rajkamal on 1/27/17.
 */
public class Directed_Graph {
    private final int V;
    private int E;
    private Bag<Integer>[] adj;


    public Directed_Graph(int V) {
        if (V < 0) {
            throw new RuntimeException("Number of Vertices  must be non negative ");
        }

        this.V = V;
        this.E = 0;
        adj = (Bag<Integer>[]) new Bag[V];

        for (int i = 0; i < V; i++ ) {
            adj[i] = new Bag<Integer>();
        }

    }

    public Directed_Graph(Directed_Graph G) {
        this(G.V());
        this.E = G.E();
        for (int v = 0; v < G.V(); v++) {
            // reverse so that adjacency list is in same order as original
            Stack<Integer> reverse = new Stack<Integer>();
            for (int w : G.adj[v]) {
                reverse.push(w);
            }
            for (int w : reverse) {
                adj[v].add(w);
            }
        }
    }

    public int V() {
        return V;
    }

    public int E() {
        return  E;
    }

    public void addEdge(int v, int w) {
        adj[v].add(w);
        E++;
    }

    public Iterable<Integer> adj(int v) {
        return adj[v];
    }

    public String toString() {
        StringBuilder s = new StringBuilder();
        String NEWLINE = System.getProperty("line.separator");
        s.append(V + " " + E + NEWLINE);
        for (int v = 0; v < V; v++) {
            s.append(v + ": ");
            for (int w : adj[v]) {
                s.append(w + " ");
            }
            s.append(NEWLINE);
        }
        return s.toString();
    }
}
