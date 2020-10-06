package Graph.WeightedGraph2017;

import java.util.*;

/**
 * Created by rajkamal on 12/24/16.
 */
public class dfs {


    private HashSet<vertex> visted;
    private HashMap<vertex, vertex> parents;
    private Stack<vertex> stk;

    public dfs() {
        visted = new HashSet<vertex>();
        parents = new HashMap<vertex, vertex>();
        stk = new Stack<vertex>();
    }

    public ArrayList<vertex> getpath(vertex src, vertex dest) {
        ArrayList <vertex> path = new ArrayList<vertex>();

        vertex v = parents.get(dest);

        path.add(0, dest);
        while (v != src) {
            // System.out.println( vertex);
            path.add(0, v);
            v = parents.get(v);
        }

        path.add(0, src);

        return path;

    }

    public ArrayList<vertex> find_path(graphAdjList graph, vertex src, vertex dest) {

        if (src == dest) {
            return null;
        }

        if (graph == null)
            return null;

        ArrayList<vertex> neighbours = null;
        ArrayList<vertex> path  = null;
        Iterator<vertex>  itr;

        vertex v;
        vertex nodes;

        stk.push(src);
        visted.add(src);

        while (!stk.isEmpty()) {
            v = stk.pop();

            if (v == dest) {
                path = getpath(src, dest);
                return path;
            }

            neighbours = graph.getNeighbours(v);

            if (neighbours == null)
                System.out.println("Neighbours are null");

            if (neighbours != null ) {
                itr = neighbours.iterator();
                while(itr.hasNext()) {
                    nodes = itr.next();
                    if (!visted.contains(nodes)) {
                        visted.add(nodes);
                        parents.put(nodes, v);
                        stk.push(nodes);
                    }
                }
            }

        }

        return null;
    }

}
