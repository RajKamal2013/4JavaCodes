package Graph.GraphCodes2017;

import java.util.*;

/**
 * Created by rajkamal on 12/20/16.
 */
public class bfs extends GraphAdjList {
    private HashMap<Integer, Integer> parent;
    private HashSet<Integer> visited;
    private Queue<Integer> Q;

    public bfs() {
        parent = new HashMap<Integer, Integer>();
        visited = new HashSet<Integer>();
        Q = new LinkedList<Integer>();
    }



    public ArrayList<Integer> getpath(int src, int dest) {
        ArrayList <Integer> path = new ArrayList<Integer>();

        int vertex = parent.get(dest);

        path.add(0, dest);

        while (vertex != src) {
           // System.out.println( vertex);
            path.add(0, vertex);
            vertex = parent.get(vertex);
        }

        path.add(0, src);

       // System.out.println();

        return path;
    }


    public ArrayList<Integer> find_path(int src, int dest) {
        if (src == dest)
            return  null;

        Q.offer(src);
        int vertex;
        int node;
        List<Integer> neighbour = null;
        ArrayList<Integer> path = null;
        Iterator<Integer> itr;

        while (!Q.isEmpty()) {
            vertex = Q.poll();
            visited.add(vertex);
            neighbour = getNeighbors(vertex);
            itr = neighbour.iterator();

            while (itr.hasNext()) {
                node = itr.next();

                if (vertex == dest) {
                    path = getpath(src, dest);
                    return path;
                }

                if (!visited.contains(node)) {
                    parent.put(node, vertex);
                    Q.offer(node);
                }

            }
        }
        return path;
    }
}
