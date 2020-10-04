package Graph.GraphCodes2017;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by rajkamal on 12/21/16.
 */
public class W_GraphAdjList extends W_Graph{
    private Map<Integer, ArrayList<Integer>> adjListsMap;

    public W_GraphAdjList() {
        adjListsMap =  new HashMap<Integer,ArrayList<Integer>>();
    }

    public void implementAddVertex(){
        int v = getNumVertices();
        ArrayList<Integer> neighbours = new ArrayList<Integer>();
        adjListsMap.put(v, neighbours);
    }

    public void implementAddEdge(int v, int w) {
        adjListsMap.get(v).add(w);
    }

    public ArrayList<Integer> getNeighbours(int v) {
        return new ArrayList<Integer>(adjListsMap.get(v));
    }


    public String adjacencyString() {
        String s = "Adjacency list" + "\n";

        s = s + "Vertices Notation -- \n ";
        s += " (size " + getNumVertices() + "+" + getNumEdges() + " integers):";

        for (int v : adjListsMap.keySet()) {
            s += "\n\t" + v + ": ";
            for (int w : adjListsMap.get(v)) {
                s += w + ", ";
            }
        }

        s += "\n Label Notation " ;


        for (int v : adjListsMap.keySet()) {
            s += "\n\t" + getLabel(v) + ": ";
            for (int w : adjListsMap.get(v)) {
                s += getLabel(w) + ", ";
            }
        }
        return s;
    }

    public ArrayList<Integer>find_path(int src, int dest) {
        return  null;
    }



}
