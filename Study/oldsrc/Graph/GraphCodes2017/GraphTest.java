package Graph.GraphCodes2017;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * Created by rajkamal on 12/18/16.
 */
public class GraphTest {
    public static void test () {
        String line;
        BufferedReader in;
        Scanner sc;
        int start, dest;
        String Start, Dest;
        Map<Integer, String> vertexLabel = new HashMap<Integer, String>();
        Set<Integer> vertices = new HashSet<Integer>();


        GraphAdjList graph1 = new GraphAdjList();

        GraphAdjMatrix graph2 = new GraphAdjMatrix();

        dfs graph3 = new dfs();

        bfs graph4 = new bfs();

        try {
            String dir = System.getProperty("user.dir");
            dir = dir + "/JavaPractice/src/Algorithms/src/com/rajkamal/Graph";
            in = new BufferedReader(new FileReader(dir + "/sample.txt"));

            line = in.readLine();

            while (line != null) {
                sc = new Scanner(line);
                start = sc.nextInt();
                dest = sc.nextInt();
                Start = sc.next();
                Dest = sc.next();
                // System.out.println("Path From " + Start + " " + start + " to" + Dest + " " + dest);
                vertices.add(start);
                vertices.add(dest);
                vertexLabel.put(start, Start);
                vertexLabel.put(dest, Dest);

                line = in.readLine();

            }

            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


        System.out.println("number of vertices " + vertices.size());

        for (int i = 0; i < vertices.size(); i++) {
            graph1.addVertex();
            graph2.addVertex();
            graph3.addVertex();
            graph4.addVertex();
        }


        try {
            String dir = System.getProperty("user.dir");
            dir = dir + "/JavaPractice/src/Algorithms/src/com/rajkamal/Graph";
            in = new BufferedReader(new FileReader(dir + "/sample.txt"));

            line = in.readLine();


            while (line != null) {
                sc = new Scanner(line);
                start = sc.nextInt();
                dest = sc.nextInt();
                Start = sc.next();
                Dest = sc.next();

                graph1.addEdge(start, dest);
                graph2.addEdge(start, dest);
                graph3.addEdge(start, dest);
                graph4.addEdge(start, dest);

                vertexLabel.put(start, Start);
                vertexLabel.put(dest, Dest);

                line = in.readLine();

            }
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        graph1.initializeLabels();
        int a, b;
        String c;


        for (Map.Entry<Integer, String> entry : vertexLabel.entrySet())
        {
            a = entry.getKey();
            c = entry.getValue();
            //System.out.println(a  + "--/--" + c);
            //graph1.addLabel(a, c);
           // graph3.addLabel(a, c);
            //graph4.addLabel(a, c);
        }



        List<Integer> degree;
        Iterator<Integer> itr;
        List<Integer> invertices;
        List<Integer> path = null;


        System.out.println("Graph 1 ");
        //System.out.println(graph1.toString());
        System.out.println("Degree Sequence -");
        degree = graph1.degreeSequence();
        itr = degree.iterator();
        while(itr.hasNext()) {
            System.out.print(itr.next() + " ");
        }
        System.out.println();
        System.out.println("in Neighbour--");
        for (int i =0; i < graph1.getNumVertices(); i++) {
            invertices = graph1.getInNeighbors(i);
            itr = invertices.iterator();
            System.out.print(i + "-->");
            while(itr.hasNext()) {
                System.out.print(itr.next() + " ");
            }

            System.out.println();
        }
        System.out.println();
        System.out.println("2---Hop ");
        for (int i =0; i < graph1.getNumVertices(); i++) {
            invertices = graph1.getDistance2(i);
            itr = invertices.iterator();
            System.out.print(i + " -->");
            while(itr.hasNext()) {
                System.out.print(itr.next() + " ");
            }
            System.out.println();
        }
        System.out.println();



        System.out.println("Graph 2 ");
       // System.out.println(graph2.toString());
        System.out.println("Degree Sequence -");
        degree = graph2.degreeSequence();
        itr = degree.iterator();
        while(itr.hasNext()) {
            System.out.print(itr.next() + " ");
        }
        System.out.println();
        for (int i =0; i < graph2.getNumVertices(); i++) {
            invertices = graph2.getInNeighbors(i);
            itr = invertices.iterator();
            System.out.print(i + " -->");
            while(itr.hasNext()) {
                System.out.print(itr.next() + " ");
            }

            System.out.println();

        }

        System.out.println();
        System.out.println("2---Hop ");
        /*
        invertices = graph2.getDistance2(0);
        for (int i =0; i < graph2.getNumVertices(); i++) {
            invertices = graph2.getDistance2(i);
            itr = invertices.iterator();
            System.out.print(i + " -->");
            while(itr.hasNext()) {
                System.out.print(itr.next() + " ");
            }
            System.out.println();
        }
*/


        System.out.println("Graph 3 ");
       // System.out.println(graph3.toString());
        System.out.println("Degree Sequence -");
        degree = graph3.degreeSequence();
        itr = degree.iterator();
        while(itr.hasNext()) {
            System.out.print(itr.next() + " ");
        }
        System.out.println();
        System.out.println("DFS VISIT --");
        a = 0;
        b = 7;
        path = graph3.find_path(a, b);
        itr = path.iterator();
        System.out.println("Path from " + "0  to 7"  + " -->");
        while(itr.hasNext()) {
            System.out.print(itr.next() + " ");
        }
        System.out.println();


        System.out.println("Graph 4 ");
      //  System.out.println(graph4.toString());
        System.out.println("Degree Sequence -");
        degree = graph4.degreeSequence();
        itr = degree.iterator();
        while(itr.hasNext()) {
            System.out.print(itr.next() + " ");
        }
        System.out.println();
        System.out.println("BFS VISIT --");
        a = 0;
        b = 7;
        path = graph4.find_path(a, b);
        itr = path.iterator();
        System.out.println("Path from " + "0  to 7"  + " -->");
        while(itr.hasNext()) {
            System.out.print(itr.next() + " ");
        }
        System.out.println();


    }


    public static void main(String [] args) {
        test();
    }
}
