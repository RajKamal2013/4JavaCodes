package DS_May_2018;

import java.util.ArrayList;

/**
 * Created by rajkamal on 5/8/18.
 */
public class Graph {
    private int V;
    private int E;
    ArrayList<Integer>[] adj;

    public Graph(int v) {
        this.V = v;
        adj = new ArrayList[v];
        for (int i = 0;i < v; i++) {
            adj[i] = new ArrayList<Integer>();
        }
    }

    public int V() {
        return V;
    }

    public void addEdge(int u, int v) {
        adj[u].add(v);
        adj[v].add(u);
    }

    public Iterable<Integer> adj(int v) {
        return adj[v];
    }
}
