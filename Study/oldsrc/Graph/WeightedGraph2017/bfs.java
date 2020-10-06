package Graph.WeightedGraph2017;

import java.util.*;

/**
 * Created by rajkamal on 12/24/16.
 */
public class bfs {
    private HashMap<vertex, vertex> parent;
    private HashSet<vertex> visited;
    private Queue<vertex> q;

    public bfs() {
        parent = new HashMap<vertex, vertex>();
        visited = new HashSet<vertex>();
        q = new LinkedList<vertex>();
    }

    public ArrayList<vertex> getpath(vertex src, vertex dest) {
        ArrayList <vertex> path = new ArrayList<vertex>();

        vertex v = parent.get(dest);

        path.add(0, dest);

        while (v != src) {
            // System.out.println( vertex);
            path.add(0, v);
            v = parent.get(v);
        }

        path.add(0, src);

        // System.out.println();

        return path;
    }


    public ArrayList<vertex> find_path(graphAdjList graph, vertex src, vertex dest) {
        if (src == dest)
            return  null;

        if (graph == null)
            return null;

        q.offer(src);
        visited.add(src);

//        System.out.println("Queuing  " + src.getName() + " to Queue ");
        vertex v;
        vertex node;
        ArrayList<vertex> neighbour = null;
        ArrayList<vertex> path = null;
        Iterator<vertex> itr;

        while (!q.isEmpty()) {
            v = q.poll();
          //  System.out.println("Dequeing " + v.getName() + " from the Queue ");
            if (v == dest) {
                path = getpath(src, dest);
                return path;
            }


            neighbour = graph.getNeighbours(v);
            itr = neighbour.iterator();
            while (itr.hasNext()) {
                node = itr.next();
                if (!visited.contains(node)) {
                    visited.add(node);
                    parent.put(node, v);
                   // System.out.println("Queuing  " + node.getName() + " to Queue ");
                    q.offer(node);
                }
            }
        }
        return path;
    }
}
