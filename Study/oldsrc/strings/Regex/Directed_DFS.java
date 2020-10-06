package strings.Regex;


/**
 * Created by rajkamal on 1/27/17.
 */
public class Directed_DFS {
    private boolean[] marked;

    public  Directed_DFS(Directed_Graph G, int s) {
        marked = new boolean[G.V()];
        dfs(G, s);
    }

    private void dfs(Directed_Graph G, int v) {
        marked[v] = true;
        for ( int w : G.adj(v)) {
            if (!marked[w])
                dfs(G, w);
        }
    }



    public Directed_DFS(Directed_Graph G, Iterable<Integer> sources) {
        marked = new boolean[G.V()];
        for (int v : sources)
            dfs(G, v);
    }

    public boolean marked(int v) {
        return marked[v];
    }

}
