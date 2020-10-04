package DS_May_2018;

/**
 * Created by rajkamal on 5/12/18.
 */
public class cycle {
    private boolean marked[];
    private boolean hasCycle;

    public cycle(Graph G) {
        marked = new boolean[G.V()];
        for (int s = 0; s < G.V(); s++) {
            dfs(G, s, s);
        }
    }

    private void dfs(Graph G, int u, int v) {
        marked[u] = true;

        for (int w : G.adj(u)) {
            if (!marked[w]) {
                dfs(G, w, u);
            } else if (w != v) {
                hasCycle = true;
            }
        }
    }

    public boolean ret() {
        return hasCycle;
    }
}
