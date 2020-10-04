package Graph.WeightedGraph2017;
import java.util.*;

/*
 * Created by rajkamal on 12/24/16.
 */


public class djkstra {
    private HashSet<vertex> visted;
    private HashMap<vertex, vertex> parent;
    private PriorityQueue<WeightedVertex> pq;
    private HashMap<vertex, WeightedVertex> vertexweightMap;

    public djkstra() {
        visted = new HashSet<vertex>();
        parent = new HashMap<vertex, vertex>();
        pq = new PriorityQueue<WeightedVertex>();
        vertexweightMap = new HashMap<vertex, WeightedVertex>();
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

        return path;
    }

    public ArrayList<vertex> find_path(graphAdjList graph, vertex src, vertex dest ) {

        if(graph == null)
            return  null;

        if (src == dest)
            return  null;

        WeightedVertex v = new WeightedVertex(src, 0);
        WeightedVertex updated, curr;
        vertex node = null;
        ArrayList<vertex> neighbour = null;
        ArrayList<vertex> path = null;
        Iterator<vertex> itr;

        vertexweightMap.put(src, v);
        pq.offer(v);
        parent.put(src, null);
        int weight;
        int temp;
        edge e;

        while(!pq.isEmpty()) {
            v = pq.poll();
            if (v.getWeightedVertex() == dest) {
                path = getpath(src, dest);
                return path;
            }
            neighbour = graph.getNeighbours(v.getWeightedVertex());
            itr = neighbour.iterator();
            while (itr.hasNext()) {
                node = itr.next();
                if (!visted.contains(node)) {
                    parent.put(node, v.getWeightedVertex());
                    e =  graph.hasEdge(v.getWeightedVertex(), node);
                    weight = v.getVertexWeight() +  e.getWeight();
                    updated = new WeightedVertex(node, weight);
                    if(vertexweightMap.get(node) != null) {
                        curr = vertexweightMap.get(node);
                        temp = curr.getVertexWeight();
                        if (weight < temp) {
                            vertexweightMap.remove(node);
                            pq.remove(curr);
                            vertexweightMap.put(node, updated);
                            pq.add(updated);
                        }
                    } else {
                        vertexweightMap.put(node, updated);
                        pq.add(updated);
                    }
                }
            }
            visted.add(src);
        }
        return  null;
    }

}
