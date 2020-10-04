package Graph.WeightedGraph2017;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by rajkamal on 12/22/16.
 */
public abstract class graph {
    private HashMap<String, vertex> V;
    private HashMap<String, edge> E;

    public  graph() {
        V = new HashMap<String, vertex>();
        E = new HashMap<String, edge>();
    }

    public int getNumVertices() {
        return V.size();
    }

    public int getNumEdges() {
        return E.size();
    }

    public vertex hasVertex(String name ) {
        vertex v = V.get(name);

        return v;
    }

    public edge hasEdge(vertex src, vertex dest) {
        String str = src.getName() + "-" + dest.getName();

        edge e = E.get(str);

        return e;
    }

    public void addVertex(String name, int  label) {
            vertex v = new vertex(name, label);
            V.put(name, v);
            implementAddVertex(v);
    }

    public abstract void implementAddVertex(vertex v);

    public void addEdge(vertex src, vertex dest, int weight) {

        edge e = new edge(src, dest, weight);

        String str = src.getName() + "-" + dest.getName();

        E.put(str, e);

        implementAddEdge(e);

    }

    public abstract void implementAddEdge(edge e);

    public abstract ArrayList<vertex> getNeighbours(vertex src);

    /*
    public abstract ArrayList<vertex> getInNeighbours(vertex src);
    */

    public String toString() {
        String s = "\nGraph with " + getNumVertices() + " vertices and " + getNumEdges() + " edges.\n";
            if (getNumVertices() <= 20) s += adjacencyString();
            return s;
    }

    public abstract String adjacencyString();

}
