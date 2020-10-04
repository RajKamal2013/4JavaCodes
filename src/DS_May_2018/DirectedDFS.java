package DS_May_2018;

/**
 * Created by rajkamal on 5/4/18.
 */
public class DirectedDFS {
    private boolean[] marked;

    public DirectedDFS(Digraph G, int s){
        marked  = new boolean[G.V()];
    }

    private void dfs(Digraph G, int s) {
        marked[s] = true;

        for (int v : G.adj(s)) {
            if (!marked[s]) {
                dfs(G, v);
            }
        }
    }

    public boolean visited(int v) {
        return marked[v];
    }
}
