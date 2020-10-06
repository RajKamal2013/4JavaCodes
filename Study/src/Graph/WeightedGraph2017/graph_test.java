package Graph.WeightedGraph2017;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

/**
 * Created by rajkamal on 12/24/16.
 */
public class graph_test {

    public static void test () {
        String line;
        BufferedReader in;
        Scanner sc;
        String str;
        String src, dest;
        int weight;
        vertex v;
        vertex Src, Dest;
        int val;
        edge e;
        ArrayList<vertex> path;
        ArrayList<vertex> adjlist;
        Iterator<vertex> itr;

        itr = null;
        path = null;
        adjlist = null;
        src = dest = null;
        Src = Dest = null;

        graphAdjList graph1 =  new graphAdjList();
        bfs graph2 = new bfs();
        dfs graph3 = new dfs();
        djkstra graph4 = new djkstra();

        try {
            String dir = System.getProperty("user.dir");
            dir = dir + "/JavaPractice/src/Algorithms/src/com/rajkamal/Graph/WeightedGraph2017";
            in = new BufferedReader(new FileReader(dir + "/vertex.txt"));

            line = in.readLine();

            while (line != null) {
                sc = new Scanner(line);
                str  = sc.next();
                val  = sc.nextInt();
                graph1.addVertex(str, val);
                line = in.readLine();
            }

            in.close();
        } catch (IOException exep) {
            exep.printStackTrace();
        }

        try {
            String dir = System.getProperty("user.dir");
            dir = dir + "/JavaPractice/src/Algorithms/src/com/rajkamal/Graph/WeightedGraph2017";
            in = new BufferedReader(new FileReader(dir + "/edge.txt"));

            line = in.readLine();

            while (line != null) {
                sc = new Scanner(line);
                src   = sc.next();
                dest  = sc.next();
                weight = sc.nextInt();
                Src = graph1.hasVertex(src);
                if (Src == null)
                    System.out.println("Error : Source Vertex " + "src " + " not Found");
                else {
                    Dest = graph1.hasVertex(dest);
                    if (Dest == null)
                        System.out.println("Error : Destination Vertex " + "dest " + " not Found");
                    else {
                        graph1.addEdge(Src, Dest, weight);
                    }
                }
                line = in.readLine();
            }

            in.close();
        } catch (IOException exep) {
            exep.printStackTrace();
        }

        System.out.println(graph1.toString());

        src = "s";
        v = graph1.hasVertex(src);
        adjlist = graph1.getNeighbours(v);

        itr = adjlist.iterator();

        System.out.println("Adjacency List for vertex  " + src);

        System.out.print(src + " -------> ");
        while(itr.hasNext()) {
            v = itr.next();
            System.out.print(v.getName() + " ");
        }
        System.out.println();

        src = "t";
        v = graph1.hasVertex(src);
        adjlist = graph1.getNeighbours(v);

        itr = adjlist.iterator();

        System.out.println("Adjacency List for vertex  " + src);

        System.out.print(src + " -------> ");
        while(itr.hasNext()) {
            v = itr.next();
            System.out.print(v.getName() + " ");
        }
        System.out.println();

        src = "x";
        v = graph1.hasVertex(src);
        adjlist = graph1.getNeighbours(v);

        itr = adjlist.iterator();

        System.out.println("Adjacency List for vertex  " + src);

        System.out.print(src + " -------> ");
        while(itr.hasNext()) {
            v = itr.next();
            System.out.print(v.getName() + " ");
        }
        System.out.println();

        src = "y";
        v = graph1.hasVertex(src);
        adjlist = graph1.getNeighbours(v);

        itr = adjlist.iterator();

        System.out.println("Adjacency List for vertex  " + src);

        System.out.print(src + " -------> ");
        while(itr.hasNext()) {
            v = itr.next();
            System.out.print(v.getName() + " ");
        }
        System.out.println();


        src = "z";
        v = graph1.hasVertex(src);
        adjlist = graph1.getNeighbours(v);

        itr = adjlist.iterator();

        System.out.println("Adjacency List for vertex  " + src);

        System.out.print(src + " -------> ");
        while(itr.hasNext()) {
            v = itr.next();
            System.out.print(v.getName() + " ");
        }
        System.out.println();

        System.out.println();

        src = "s";
        dest = "z";
        Src = graph1.hasVertex(src);
        Dest = graph1.hasVertex(dest);
        path = graph2.find_path(graph1, Src, Dest);

        System.out.println("BFS Path from  " + src + " to " + dest + ": " );

        itr = path.iterator();

        while(itr.hasNext()) {
            v = itr.next();
            System.out.print(v.getName() +  "  ");
        }

        System.out.println();

        itr = path.iterator();

        while(itr.hasNext()) {
            v = itr.next();
            System.out.print(v.getLabel() +  "  ");
        }

        System.out.println();

        System.out.println();


        src = "s";
        dest = "z";
        Src = graph1.hasVertex(src);
        Dest = graph1.hasVertex(dest);
        path = graph3.find_path(graph1, Src, Dest);

        System.out.println("DFS Path from  " + src + " to " + dest + ": " );

        itr = path.iterator();

        while(itr.hasNext()) {
            v = itr.next();
            System.out.print(v.getName() +  "  ");
        }

        System.out.println();

        itr = path.iterator();

        while(itr.hasNext()) {
            v = itr.next();
            System.out.print(v.getLabel() +  "  ");
        }

        System.out.println();

        System.out.println();

        src = "s";
        dest = "z";
        Src = graph1.hasVertex(src);
        Dest = graph1.hasVertex(dest);
        path = graph4.find_path(graph1, Src, Dest);

        System.out.println("Djskstra Path from  " + src + " to " + dest + ": " );

        itr = path.iterator();

        while(itr.hasNext()) {
            v = itr.next();
            System.out.print(v.getName() +  "  ");
        }

        System.out.println();

        itr = path.iterator();

        while(itr.hasNext()) {
            v = itr.next();
            System.out.print(v.getLabel() +  "  ");
        }

        System.out.println();

        System.out.println();



    }

    public static void main(String[] args) {
        test();
    }

}

