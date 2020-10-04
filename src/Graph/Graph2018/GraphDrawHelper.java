package Graph.Graph2018;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

/**
 * Created by rajkamal on 4/11/18.
 */
public class GraphDrawHelper {

    public void drawGraph(Graph G) {
        int[] X = new int[G.V()];
        int[] Y = new int[G.V()];

        int X_max = 2 * G.V();
        int Y_max = 2 * G.V();


        Random rand1 = new Random();
        Random rand2 = new Random();


        GraphDraw frame = new GraphDraw("Test Window");
        frame.setSize(X_max, Y_max);
        frame.setVisible(true);
        ArrayList<Integer> adj;

        for (int i = 0; i < G.V(); i++) {
            X[i] = rand1.nextInt(X_max) + 1;
            Y[i] = rand2.nextInt(Y_max) + 1;
            System.out.println("Vertex :" + Integer.toString(i) + "( " + X[i] + ", " + Y[i] + ")");
            frame.addNode(Integer.toString(i), X[i], Y[i]);
        }

        for (int v = 0; v < G.V(); v++) {
                for (int w: G.adj(v)) {
                    System.out.println("Edge between " + v + " and " + w);
                    frame.addEdge(v, w);
            }
        }

    }


}
