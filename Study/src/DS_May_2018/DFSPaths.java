package DS_May_2018;

import java.util.LinkedList;
import java.util.Stack;

/**
 * Created by rajkamal on 5/8/18.
 */
public class DFSPaths {
    private boolean[] marked;
    private int[] edgeTo;
    private int s;

    public DFSPaths(Graph G, int s) {
        this.s = s;
        marked = new boolean[G.V()];
        dfs(G, s);

    }

    private void dfs(Graph G, int v) {
        marked[v] = true;

        for (int w : G.adj[v]) {
            if (!marked[w]) {
                edgeTo[w] = v;
                dfs(G, w);
            }
        }
    }

    public boolean hasPathTo(int v) {
        return marked[v];
    }

    public Iterable<Integer> pathTo(int v) {
        if (!hasPathTo(v)) {
            return null;
        }

        Stack<Integer> stk = new Stack<>();

        for (int x = v; x != s; x = edgeTo[x]) {
            stk.push(x);
        }
        stk.push(s);

        return stk;
    }
}
