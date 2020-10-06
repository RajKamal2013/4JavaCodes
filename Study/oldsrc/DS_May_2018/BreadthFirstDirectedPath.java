package DS_May_2018;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by rajkamal on 5/5/18.
 */
public class BreadthFirstDirectedPath {
    private int s;
    private boolean[] marked;
    private int[] edgeTo;
    private int[] distTo;

    public BreadthFirstDirectedPath(Digraph G, int s) {
        marked = new boolean[G.V()];
        edgeTo = new int[G.V()];
        distTo = new int[G.V()];

        for (int v = 0; v < G.V(); v++) {
            distTo[v] = 0;
        }

        bfs(G, s);
    }


    public BreadthFirstDirectedPath(Digraph G, Iterable<Integer> sources) {
        marked = new boolean[G.V()];
        edgeTo = new int[G.V()];
        distTo = new int[G.V()];

        for (int v = 0; v < G.V(); v++) {
            distTo[v] = -1;
        }

        bfs(G, sources);
    }

    private void bfs(Digraph G, int s) {
        Queue <Integer> Q = new LinkedList<>();
        marked[s] = true;
        distTo[s] = 0;
        Q.offer(s);

        while(!Q.isEmpty()) {
            int u = Q.poll();
            for (int v : G.adj(u) ) {

                if (!marked[v]) {
                    edgeTo[v] = u;
                    marked[v] = true;
                    distTo[v] = distTo[u] + 1;
                    Q.offer(v);
                }
            }
        }
    }

    public void bfs(Digraph G, Iterable<Integer> sources) {
        Queue<Integer> Q = new LinkedList<>();
        for (int s : sources) {
            distTo[s] = 0;
            marked[s] = true;
            Q.offer(s);
        }

        while (!Q.isEmpty()) {
            int u = Q.poll();

            for (int v : G.adj(u)) {

                if (!marked[v]) {
                    edgeTo[v] = u;
                    distTo[v] = distTo[u] + 1;
                    marked[v] = true;
                }
            }
        }
    }

    public Iterable <Integer> PathTo(int v) {

        if (!marked[v]) {
            return null;
        }

        Stack<Integer> stk = new Stack<>();

        for (int x = v; distTo[x] != 0; x = edgeTo[x] ) {
            stk.push(x);
        }

        return stk;
    }

    public boolean hasPathTo(int v) {
        return marked[v];

    }

    public int distTo(int v) {
        return distTo[v];
    }
}

