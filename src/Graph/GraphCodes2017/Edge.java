package Graph.GraphCodes2017;


/**
 * Created by rajkamal on 12/21/16.
 */
public class Edge {
    private int src;
    private int dest;
    private int weight;

    Edge(int src, int dest, int weight) {
        this.src = src;
        this.weight = weight;
        this.dest = dest;
    }

    public int getSrc() {
        return this.src;
    }

    public  void setSrc(int src) {
        this.src = src;
    }

    public int  getEdgeWeight() {
        return this.weight;
    }

    public void setEdgeWeight(int weight) {
        this.weight = weight;
    }

    public int getDest(){
        return this.dest;
    }

    public void setDest(int dest) {
        this.dest = dest;
    }
}
