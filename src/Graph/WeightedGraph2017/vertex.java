package Graph.WeightedGraph2017;

/**
 * Created by rajkamal on 12/22/16.
 */
public class vertex {
    private int label;
    private String name;

    public vertex (String name, int label) {
        this.label = label;
        this.name = name;
    }

    public void setName(String name ) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setLabel(int label) {
        this.label = label;
    }

    public int getLabel() {
        return  this.label;
    }
}




