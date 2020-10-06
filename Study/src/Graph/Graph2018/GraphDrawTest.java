package Graph.Graph2018;

/**
 * Created by rajkamal on 4/11/18.
 */
public class GraphDrawTest {
    //Here is some example syntax for the GraphDraw class
    public static void main(String[] args) {
        GraphDraw frame = new GraphDraw("Test Window");

        frame.setSize(400,300);

        frame.setVisible(true);


        frame.addNode("1", 50,50);
        frame.addNode("2", 100,100);
        frame.addNode("3", 0,290);
        frame.addEdge(0,1);
        frame.addEdge(0,2);
    }
}
