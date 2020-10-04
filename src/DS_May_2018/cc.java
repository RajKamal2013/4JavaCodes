package DS_May_2018;

import java.util.HashSet;
import java.util.LinkedList;

/**
 * Created by rajkamal on 5/12/18.
 */
public class cc {
    private boolean marked[];
    private int[] id;
    private int count;

    public cc(Graph G) {
        marked = new boolean[G.V()];
        id = new int[G.V()];
        count = 0;

        for (int v = 0; v < G.V(); v++) {
            if (!marked[v]) {
                dfs(G, v);
                count++;
            }
        }
    }

    private void dfs(Graph G, int u) {
        marked[u] = true;
        id[u] = count;

        for (int w: G.adj(u)) {
            if (!marked[u]) {
                dfs(G, u);
            }
        }
    }

    public boolean connected(int v, int w) {
        return  (id[v] == id[w]);
    }

    public int count() {
        return count;
    }

    public int get_id(int v) {
        return id[v];
    }

    public void printCC() {
        LinkedList<Integer> list[] = new LinkedList[count];
        for (int i = 0; i < count; i++) {
            list[i] = new LinkedList<Integer>();
        }
        for (int v = 0; v < id.length; v++) {
            list[id[v]].add(v);
        }

        for (int i = 0; i < count; i++) {
            System.out.println("Vertices with CC id:" + count);
            for (int w : list[i]) {
                System.out.print(w + " ");
            }
        }
    }
}
