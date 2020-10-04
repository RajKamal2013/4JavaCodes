package DS_May_2018;

/**
 * Created by rajkamal on 5/4/18.
 */
public class DepthFirstSearch {
    private boolean[] marked;

    public DepthFirstSearch(Digraph G, int s) {
        marked = new boolean[G.V()];
        dfs(G, s);
    }

    private void dfs(Digraph G, int s) {
        marked[s] = true;

        for (int v : G.adj(s)) {
            if (!marked[v]) {
                dfs(G, v);
            }
        }
    }

    /* to find which all vertices are connected */
    public boolean visited (int v) {
        return marked[v];
    }


}
