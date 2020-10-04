package Graph.GraphCodes2017;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * Created by rajkamal on 12/21/16.
 */
public class W_Convert {


    public static void main(String[] args) {
        String line;
        BufferedReader in;
        Scanner sc;
        int start, dest;
        String Start, Dest;
        HashMap<String, Integer> vertexLabel = new HashMap<String, Integer>();
        Set<Integer> vertices = new HashSet<Integer>();
        int index;
        Vertex V;

        W_GraphAdjList Graph1 = new W_GraphAdjList();

        try {
            String dir = System.getProperty("user.dir");
            dir = dir + "/JavaPractice/src/Algorithms/src/com/rajkamal/Graph";
            in = new BufferedReader(new FileReader(dir + "/Sample_Weighted_Graph.txt"));
            line = in.readLine();
            index = 0;

            while (line != null) {
                sc = new Scanner(line);
                Start = sc.next();
                Dest = sc.next();

                if (index == 0) {
                    vertexLabel.put(Start, index);
                    index++;
                    vertexLabel.put(Dest, index);
                    index++;
                } else {
                    if (vertexLabel.get(Start) == null) {
                        vertexLabel.put(Start, index);
                        index++;
                    }
                    if (vertexLabel.get(Dest) == null) {
                        vertexLabel.put(Dest, index);
                        index++;
                    }
                }
                line = in.readLine();
            }
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (Map.Entry<String, Integer> entry : vertexLabel.entrySet()) {
            Graph1.addVertex(entry.getValue(), entry.getKey());
        }

        // System.out.println(entry.getKey()+" : "+entry.getValue());


        try {
            String dir = System.getProperty("user.dir");
            dir = dir + "/JavaPractice/src/Algorithms/src/com/rajkamal/Graph";
            in = new BufferedReader(new FileReader(dir + "/Sample_Weighted_Graph.txt"));
            line = in.readLine();
            index = 0;
            int weight = 0;

            while (line != null) {
                sc = new Scanner(line);
                Start = sc.next();
                Dest = sc.next();
                weight = sc.nextInt();

                System.out.println("Addding path from " + vertexLabel.get(Start) + " to " + vertexLabel.get(Dest) + " weight : " + weight);

                Graph1.addEdge(vertexLabel.get(Start), vertexLabel.get(Dest), weight);

                line = in.readLine();
            }

            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


        System.out.println("<-Adjacency List ->");
        System.out.println(Graph1.toString());

        System.out.println();
        for (int i = 0; i < Graph1.getNumVertices(); i++ ) {
            System.out.println("Vertices " + Graph1.getLabel(i) + " labled as " + i);
            V = Graph1.getVertex(i);
            System.out.println("Printing edges ");
            V.printEdges();
            System.out.println();

        }
        System.out.println();

    }

}
