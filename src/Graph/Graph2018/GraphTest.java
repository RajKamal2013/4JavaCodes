package Graph.Graph2018;

import java.io.*;
import java.util.Scanner;

/**
 * Created by rajkamal on 4/11/18.
 */
public class GraphTest {
    public static void test() {
        Scanner sc = new Scanner(System.in);
        int V;
        int E;
        int v;
        int w;
        Graph G = null;
        try (FileInputStream fileInputStream = new FileInputStream(new File("src/basicGraph.txt"))) {
            BufferedReader br = new BufferedReader(new InputStreamReader(fileInputStream));

            String strLine;
            //Read File Line By Line
            strLine = br.readLine();
            sc = new Scanner(strLine);
            V = sc.nextInt();
            G = new Graph(V);
            strLine = br.readLine();
            sc = new Scanner(strLine);
            E = sc.nextInt();
            for(int i = 0; i < E; i++) {
                strLine = br.readLine();
                sc = new Scanner(strLine);
                v = sc.nextInt();
                w = sc.nextInt();
                G.addEdge(v,w);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (G != null) {
            System.out.println(G.toString());
        }
/*
        GraphDrawHelper graph = new GraphDrawHelper();
        graph.drawGraph(G);
*/
    }



    public static void main(String[] args) {
        test();
    }
}
