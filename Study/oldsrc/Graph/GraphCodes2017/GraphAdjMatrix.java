package Graph.GraphCodes2017;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by rajkamal on 12/18/16.
 */

public class GraphAdjMatrix extends Graph {
    private final int defaultNumVertices = 5;
    private int[][] adjMatrix;

    public GraphAdjMatrix() {
        adjMatrix = new int[defaultNumVertices][defaultNumVertices];
    }

    public void implementAddVertex( ) {
        int v = getNumVertices();

        if (v >= adjMatrix.length) {
            int[][] Matrix;
            Matrix = new int[v * 2][v * 2];

            for (int i = 0; i < adjMatrix.length; i++) {
                for (int j = 0; j < adjMatrix.length; j++) {
                    Matrix[i][j] = adjMatrix[i][j];
                }
            }
            adjMatrix = Matrix;
        }

        for(int i = 0; i < adjMatrix[v].length; i++)
            adjMatrix[v][i] = 0;
    }

    public void implementAddEdge(int v, int w) {
        adjMatrix[v][w] = 1;
    }


    public List<Integer> getNeighbors(int v) {
        List<Integer> neighbours = new ArrayList<Integer>();
        for (int i = 0; i < getNumVertices(); i++) {
            if (adjMatrix[v][i] != 0)
                neighbours.add(i);
        }

        return neighbours;
    }

    public List<Integer> getInNeighbors(int v) {

        List<Integer> res = new ArrayList<Integer>();

        for(int i =0; i < getNumVertices(); i++) {
                if (adjMatrix[i][v] != 0)
                    res.add(i);
            }
        return res;
    }

    public List<Integer> getDistance2(int v) {
        int num = getNumVertices();
        List<Integer> res = new ArrayList<Integer>();

        int[][] twoHop = new int[num][num];

        int sum = 0;

        for (int i = 0; i < num; i++) {
            for (int j = 0; j < num; j++) {
                for (int k = 0; k < num; k++) {
                    sum = sum + adjMatrix[i][k] * adjMatrix[k][j];
                }
                twoHop[i][j] = sum;
                sum = 0;
            }
        }

        for (int i = 0; i < num; i++) {
            for (int j = 0; j < num; j++) {
                System.out.print(twoHop[i][j] + " ");
            }
            System.out.println();
        }


        for (int i = 0; i < getNumVertices(); i++) {
            if (twoHop[v][i] ==  2)
                res.add(i);
        }

        return  res;
    }


    public String adjacencyString() {
        int dim = getNumVertices();
        String s = "Adjacency matrix";
        s += " (size " + dim + "x" + dim + " = " + dim* dim + " integers):";
        for (int i = 0; i < dim; i ++) {
            s += "\n\t"+ i+": ";
            for (int j = 0; j < dim; j++) {
                s += adjMatrix[i][j] + ", ";
            }
        }
        return s;
    }

    public ArrayList<Integer>find_path(int src, int dest) {
        return  null;
    }

}
