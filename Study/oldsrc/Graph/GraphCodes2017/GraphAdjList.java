package Graph.GraphCodes2017;


import java.util.*;

/**
 * Created by rajkamal on 12/18/16.
 */
public class GraphAdjList extends Graph{

    private Map<Integer, ArrayList<Integer>> adjListsMap;

    public GraphAdjList() {
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

    public List<Integer> getNeighbors(int v) {
        return new ArrayList<Integer>(adjListsMap.get(v));
    }

    public List<Integer> getInNeighbors(int v) {
        List<Integer> arr = new ArrayList<Integer>();

        List<Integer> adjacent;
        Iterator<Integer> itr;

        for (int i = 0;i < getNumVertices(); i++) {
            adjacent = getNeighbors(i);
            itr = adjacent.iterator();
            while(itr.hasNext()) {
                if (itr.next() == v)
                    arr.add(i);
            }
        }
        return arr;
    }

    public List<Integer> getDistance2(int v) {

        List<Integer> twoHop = new ArrayList<Integer>();
        List<Integer> oneHop = adjListsMap.get(v);

        List <Integer> temp;

        Iterator<Integer> itr = oneHop.iterator();

        while(itr.hasNext()) {
            temp = getNeighbors(itr.next());
            twoHop.addAll(temp);
        }

        return twoHop;
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
