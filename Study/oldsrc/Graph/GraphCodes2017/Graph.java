package Graph.GraphCodes2017;

import java.util.*;

/**
 * Created by rajkamal on 12/18/16.
 */
public abstract class Graph {
    private int numVertices;
    private int numEdges;
    private Map<Integer, String > vertexLabel;


    public Graph() {
        numEdges = 0;
        numVertices = 0;
        vertexLabel = null;
    }

    public int getNumVertices() {
        return numVertices;
    }

    public int getNumEdges() {
        return numEdges;
    }


    /*
     * return index of newly add vertices
     */
    public int addVertex() {
        implementAddVertex();
        numVertices++;
        return (numVertices - 1);
    }

    public abstract void implementAddVertex();

    public void addEdge(int v, int w) {
        if (v < numVertices && v < numVertices) {
            implementAddEdge(v, w);
            numEdges++;
        }else {
            throw new IndexOutOfBoundsException();
        }
    }

    public abstract void implementAddEdge(int v, int w);

    public abstract List<Integer> getNeighbors(int v);

    public abstract List<Integer> getInNeighbors(int v);

    /**
     * The degree sequence of a graph is a sorted (organized in numerical order
     * from largest to smallest, possibly with repetitions) list of the degrees
     * of the vertices in the graph.
     *
     * @return The degree sequence of this graph.
     */

    public List<Integer> degreeSequence() {
        ArrayList<Integer> degree = new ArrayList<Integer>();
        ArrayList<Integer> adjacent;
        for (int i = 0; i < numVertices; i++) {
            degree.add(getNeighbors(i).size());
        }
        Collections.sort(degree);
        return degree;
    }

   public abstract List<Integer> getDistance2(int v);

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


    public void initializeLabels() {

        vertexLabel = new HashMap<Integer,String>();
    }


    public boolean hasVertex(int v)
    {
        return v < getNumVertices();
    }

    public boolean hasVertex(String s)
    {

        return vertexLabel.containsValue(s);
    }

    public void addLabel(int v, String s) {
        if (v < getNumVertices() && !vertexLabel.containsKey(v))
        {
            vertexLabel.put(v, s);
        }
        else {
            System.out.println("ERROR: tried to label a vertex that is out of range or already labeled");
        }
    }

    public String getLabel(int v) {
        if (vertexLabel.containsKey(v)) {
            return vertexLabel.get(v);
        }
        else return null;
    }


    public abstract ArrayList<Integer>find_path(int src, int dest);


    public int getIndex(String s) {
        for (Map.Entry<Integer,String> entry : vertexLabel.entrySet()) {
            if (entry.getValue().equals(s))
                return entry.getKey();
        }
        System.out.println("ERROR: No vertex with this label");
        return -1;
    }
}
