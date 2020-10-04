package Graph.WeightedGraph2017;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/**
 * Created by rajkamal on 12/24/16.
 */
public class graphAdjList extends graph {
        HashMap<vertex, ArrayList<edge>> adjListMap;

       public graphAdjList()  {
           adjListMap = new HashMap<vertex, ArrayList<edge>>();
       }

        public void implementAddVertex(vertex v) {
            ArrayList<edge> adjList = new ArrayList<edge>();
            adjListMap.put(v, adjList);
        }

        public void implementAddEdge(edge e) {
            vertex v = e.getSrcVertex();
            ArrayList<edge> list = adjListMap.get(v);
            list.add(e);
        }

        public ArrayList<vertex> getNeighbours(vertex v){
            ArrayList<vertex> list = new ArrayList<vertex>();
            ArrayList<edge> adjList = adjListMap.get(v);
            Iterator<edge> itr = adjList.iterator();
            vertex neighbours;
            edge edges;

            while(itr.hasNext()) {
                edges = itr.next();
                neighbours = edges.getDestVertex();
                list.add(neighbours);
            }

            return list;
        }


        public String adjacencyString() {

            String s = "Adjacency list" + "\n";

            s = s + "Vertices Notation -- \n ";
            s += " (size (vertices + edges )" + getNumVertices() + "+" + getNumEdges() + " integers):";

            for (vertex v : adjListMap.keySet()) {
                s += "\n\t" + v.getName() + ": ";
                for (edge w : adjListMap.get(v)) {
                    s += w.getDestVertex().getName() + ", ";
                }
            }


            s += "\n Label Notation " ;


            for (vertex v : adjListMap.keySet()) {
                s += "\n\t" + v.getLabel() + ": ";
                for (edge w : adjListMap.get(v)) {
                    s += w.getDestVertex().getLabel() + ", ";
                }
            }
            return s;
        }


}
