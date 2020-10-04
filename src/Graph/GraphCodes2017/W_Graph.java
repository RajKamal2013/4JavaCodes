
package Graph.GraphCodes2017;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 * Created by rajkamal on 12/21/16.
 */
public abstract class W_Graph {
        private int numVertices;
        private int numEdges;
        private HashMap<String, Integer> Label;
        private HashMap<Integer, Vertex> Map;

        public W_Graph() {
            numEdges = 0;
            numVertices = 0;
            Map = new HashMap<Integer, Vertex>();
            Label = new HashMap<String, Integer>();
        }

    public int getNumVertices() {
        return numVertices;
    }

    public int getNumEdges() {
        return numEdges;
    }


    public int addVertex(int label, String name) {
        implementAddVertex();
        Vertex V = new Vertex(label, name);
        Map.put(label, V);
        Label.put(name, label);
        numVertices ++;
        return (numVertices - 1);
    }

    public Vertex getVertex(int label ) {
        return Map.get(label);
    }

    public abstract void implementAddVertex();

    public void addEdge(int v, int w, int weight) {
        if (v < numVertices && v < numVertices) {
            implementAddEdge(v, w);
            Edge edge = new Edge(v, w, weight);
            Vertex V = Map.get(v);
            V.addNeighbour(edge);
            numEdges++;
        }else {
            throw new IndexOutOfBoundsException();
        }
    }

    public abstract void implementAddEdge(int v, int w);


    public String getLabel(int label) {
        Vertex V = Map.get(label);
        return V.getName();

    }

    public abstract List<Integer> getNeighbours(int v);

    public List<Integer> degreeSequence() {
        ArrayList<Integer> degree = new ArrayList<Integer>();
        ArrayList<Integer> adjacent;
        for (int i = 0; i < numVertices; i++) {
            degree.add(getNeighbours(i).size());
        }
        Collections.sort(degree);
        return degree;
    }

    public String toString() {
        String s = "\nGraph with " + numVertices + " vertices and " + numEdges + " edges.\n";
        s += "Degree sequence: " + degreeSequence() + ".\n";
        if (numVertices <= 20) s += adjacencyString();
        return s;
    }
    /**
     * Generate string representation of adjacency list
     * @return the String
     */
    public abstract String adjacencyString();

    public int getVertexIndex(String label) {
        return Label.get(label);
    }

}
