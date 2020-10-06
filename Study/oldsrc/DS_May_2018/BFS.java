package DS_May_2018;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by rajkamal on 5/8/18.
 */
public class BFS {
    private boolean[] marked;
    private int s;
    private int edgeTo[];
    private int disTo[];

    public BFS(Graph G, int s) {
        this.s = s;
        marked = new boolean[G.V()];
        edgeTo = new int[G.V()];
        disTo = new int[G.V()];
        disTo[s] = 0;
        bfs(G, s);
    }

    public BFS(Graph G, Iterable<Integer> sources) {
        marked = new boolean[G.V()];
        edgeTo = new int[G.V()];
        disTo = new int[G.V()];

        for (int w: sources) {
            disTo[w] = Integer.MIN_VALUE;
        }
        bfs(G, sources);
    }

    private void bfs(Graph G, int s) {
        Queue<Integer> Q = new LinkedList<Integer>();
        marked[s] = true;
        disTo[s] = 0;
        Q.offer(s);
        int v;

        while (!Q.isEmpty()) {
            v = Q.poll();
            for (int w : G.adj(v)) {
                if (!marked[w]) {
                    edgeTo[w] = v;
                    disTo[w] = disTo[v] + 1;
                    marked[w] = true;
                    Q.offer(w);
                }
            }
        }
    }

    private void bfs(Graph G, Iterable<Integer> sources) {
        Queue<Integer> Q = new LinkedList<Integer>();
        for (int w : sources) {
            marked[w] = true;
            disTo[w] = 0;
            Q.offer(w);
        }

        int v;

        while (!Q.isEmpty()) {
            v = Q.poll();
            for (int w : G.adj(v)) {
                if (!marked[w]) {
                    edgeTo[w] = v;
                    disTo[w] = disTo[v] + 1;
                    marked[w] = true;
                    Q.offer(w);
                }
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

        for (int x = v; x !=s ; x = edgeTo[x]) {
            stk.push(x);
        }

        stk.push(s);
        return stk;
    }

}
