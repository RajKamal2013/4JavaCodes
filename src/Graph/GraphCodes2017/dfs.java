package Graph.GraphCodes2017;

import java.util.*;

/**
 * Created by rajkamal on 12/20/16.
 */
public class dfs extends GraphAdjList {

    private HashSet <Integer> visted;
    private HashMap<Integer, Integer> parents;
    private Stack<Integer> stk;

    public dfs() {
        visted = new HashSet<Integer>();
        parents = new HashMap<Integer, Integer>();
        stk = new Stack<Integer>();
    }

    public ArrayList<Integer> getpath(int src, int dest) {
        ArrayList <Integer> path = new ArrayList<Integer>();

        int vertex = parents.get(dest);

        path.add(0, dest);
        while (vertex != src) {
           // System.out.println( vertex);
            path.add(0, vertex);
            vertex = parents.get(vertex);
        }

        path.add(0, src);

        return path;

    }

    public ArrayList<Integer> find_path(int src, int dest) {

        if (src == dest) {
            return null;
        }

        List<Integer> neighbours = null;
        ArrayList<Integer> path  = null;
        Iterator<Integer>  itr;

        int vertex;
        int nodes;

        stk.push(src);

        while (!stk.isEmpty()) {
            vertex = stk.pop();

            visted.add(vertex);

            if (vertex == dest) {
                path = getpath(src, dest);
                return path;
            }

            neighbours = getNeighbors(vertex);

            if (neighbours == null)
                System.out.println("Neighbours are null");

            if (neighbours != null ) {
                itr = neighbours.iterator();
                while(itr.hasNext()) {
                    nodes = itr.next();
                    if (!visted.contains(nodes)) {
                        parents.put(nodes, vertex);
                        stk.push(nodes);
                    }
                }
            }

        }

        return null;
    }

}
