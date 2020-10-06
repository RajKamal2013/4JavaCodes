package DS_May_2018;

/**
 * Created by rajkamal on 5/12/18.
 */
public class TwoColor {
    private boolean[] marked;
    private boolean[] color;
    private boolean isTwoColor;


    public TwoColor(Graph G) {
        marked = new boolean[G.V()];
        color = new boolean[G.V()];
        isTwoColor = true;

        for (int v = 0; v < G.V(); v++) {
            if (!marked[v]) {
                dfs(G, v);
            }
        }
    }

    private void dfs(Graph G, int u) {
        for (int v : G.adj(u)) {
            if (!marked[v]) {
                color[v] = !color[u];
                dfs(G, v);
            } else {
                if (color[v] == color[u]) {
                    isTwoColor = false;
                }
            }
        }
    }

    public boolean isBipartite() {
        return isTwoColor;
    }
}
