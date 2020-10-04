package Graph.WeightedGraph2017;


/**
 * Created by rajkamal on 12/22/16.
 */
public class edge {
    private vertex src;
    private vertex dest;
    private int weight;


    public edge(vertex src, vertex dest, int weight) {
        this.dest = dest;
        this.src = src;
        this.weight = weight;
    }

    public vertex getSrcVertex() {
        return this.src;
    }

    public void setSrcVertex(vertex src) {
        this.src = src;
    }

    public vertex getDestVertex() {
        return this.dest;
    }

    public void setDestVertex(vertex dest) {
        this.dest = dest;
    }

    public int getWeight() {
        return  this.weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}
