package Graph.GraphCodes2017;


import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by rajkamal on 12/21/16.
 */
public class Vertex implements Comparable<Vertex>{
    private int label;
    private String name;
    private int weight;
    private ArrayList<Edge> neighbours;


    public Vertex(int label, String name) {
        this.label = label;
        this.name = name;
        this.weight = Integer.MAX_VALUE;
        neighbours = new ArrayList<Edge>();
    }

    @Override
    public int compareTo(Vertex V) {
        if (this.weight > V.getVertexWeight())
            return 1;
        else if (this.weight < V.getVertexWeight())
            return -1;
        else
            return 0;
    }

    public void  setLable(int label){
        this.label = label;
    }

    public int getLabel() {
        return this.label;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setVertexWeight(int weight){
        this.weight = weight;
    }

    public int getVertexWeight(){
        return  this.weight;
    }

    public ArrayList<Edge> getNeighbours() {
        return this.neighbours;
    }

    public void addNeighbour(Edge edge) {
        this.neighbours.add(edge);
    }

    public void printEdges() {
        Edge e;

        Iterator<Edge> itr = this.neighbours.iterator();

        System.out.println("Neighbours of " + this.getName() + "(" + this.getLabel() + ")");
        while(itr.hasNext()) {
            e = itr.next();
            System.out.print("---->");
            System.out.print( "(" +  "Dest :" + e.getDest() + ", Weight :" + e.getEdgeWeight() + ")"  );
        }

        System.out.println();
    }
}
