package DS_May_2018;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by rajkamal on 5/4/18.
 */
public class Digraph {
    private int V;
    private int E;
    private ArrayList<Integer>adj[];

    public Digraph(int v) {
        this.V = V;
        adj = new ArrayList [V];
        for (int i = 0; i < V; i++ ) {
            adj[i] = new ArrayList<Integer>();
        }
    }

    public int V() {
        return this.V;
    }

    public int E() {
        return this.E;
    }

    public void addEdge(int u, int v) {
        adj[u].add(v);
    }

    public Iterable<Integer> adj(int v) {
        return adj[v];
    }

    public Digraph reverse() {
        Digraph R = new Digraph(this.V);

        for (int u = 0; u < this.V; u++) {

            for (int v : adj[u]) {
                R.addEdge(v, u);
            }
        }

        return  R;
    }
}
