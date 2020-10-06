package DS_May_2018;

import java.util.Iterator;
import java.util.Stack;
import java.util.zip.Inflater;

/**
 * Created by rajkamal on 5/5/18.
 */
public class DepthFirstDirectedPaths {
    private boolean[] marked;
    private int[] edgeTo;
    private int s;

    public DepthFirstDirectedPaths(Digraph G, int s) {
        this.s = s;
        edgeTo = new int[G.V()];
        marked = new boolean[G.V()];
        dfs(G,s);
    }

    private void dfs(Digraph G, int u) {
        marked[u] = true;
        for (int v: G.adj(u)) {
            if (!marked[v]) {
                edgeTo[v] = u;
                dfs(G, v);
            }

        }
    }

    public boolean hasPathTo(int v) {
        return marked[v];
    }

    public Iterable <Integer> pathTo(int v) {
        if (!hasPathTo(v)) {
            return null;
        }

        Stack<Integer> path = new Stack<Integer>();

        for (int x = v; x != s; x = edgeTo[x]) {
            path.push(x);
        }
        path.push(s);
        return path;
    }
}
