package Graph.GraphCodes2017;


import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;

/**
 * Created by rajkamal on 12/21/16.
 */
public class djkstra extends W_GraphAdjList{
    HashSet<Integer> visted;
    HashMap<Integer, Integer> parents;
    PriorityQueue<Vertex> Q = new PriorityQueue<Vertex>();

    public djkstra() {
        visted = new HashSet<Integer>();
        parents = new HashMap<Integer, Integer>();
        Q = new PriorityQueue<Vertex>();
    }
/*
    public AbstractList<Integer> Shortest_Path(String src, String dest) {
            Vertex Src, Dest;
            int temp = getVertexIndex(src);
            Src = getVertex(temp);
            temp = getVertexIndex(dest);
            Dest = getVertex(temp);

            Q.add(Src);



    }
    */
}
