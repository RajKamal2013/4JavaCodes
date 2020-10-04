package Graph.Graph2018;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by rajkamal on 4/11/18.
 */
public class Graph {
    private int V;
    private int E;
    private ArrayList<Integer>[] adj;
    private static final String NEWLINE = System.getProperty("line.separator");

    public Graph(int v) {
        this.V = v;
        E = 0;
        adj = new ArrayList[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new ArrayList<Integer>();
        }
    }

    public int V() {
        return V;
    }

    public int E() {
        return E;
    }

    public void addEdge(int v, int w) {
        adj[v].add(w);
        adj[w].add(v);
        E++;
    }

    public Iterable<Integer> adj(int v) {
        return adj[v];
    }


    public int degree(int v) {
        return adj[v].size();
    }

    public int maxDegree() {
        int max = 0;
        for (int i = 0; i < V; i++ ) {
            if (degree(i) > max) {
                max = degree(i);
            }
        }
        return max;
    }

    public double average() {
        return (2*E())/V();
    }

    public int numberOfSelfLoops() {
        int count = 0;
        for (int i = 0; i < V(); i++) {
            for (int w:adj[i]) {
                if (i == w) {
                    count++;
                }
            }
        }
        return count;
    }

    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append(V + " vertices, " + E + " edges " + NEWLINE);
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

