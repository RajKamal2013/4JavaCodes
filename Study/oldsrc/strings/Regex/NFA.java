package strings.Regex;

import java.util.Stack;

/**
 * Created by rajkamal on 1/27/17.
 */
public class NFA {
    private Directed_Graph G;
    private char[] re;
    private int M;

    public NFA(String regexp) {
         re = regexp.toCharArray();
         M  = regexp.length();
         G  = buildEpsilonTransitionDigraph();
    }

    public Directed_Graph buildEpsilonTransitionDigraph() {
        Directed_Graph G = new Directed_Graph(M + 1);
        Stack<Integer> ops = new Stack<Integer>();
        int lp, or;


        for (int i = 0; i < M; i++) {
            lp = i;
            if (re[i] == '(' || re[i] == '|') {
                ops.push(i);
            } else if (re[i] == ')') {
                or = ops.pop();
                if (re[or] == '|') {
                    lp = ops.pop();
                    G.addEdge(lp, or + 1);
                    G.addEdge(or, i);
                } else {
                    lp = or;
                }
            }

            if (i < M - 1 && re[i + 1] == '*') {
                G.addEdge(lp, i + 1);
                G.addEdge(i + 1, lp);
            }

            if (re[i] == '(' || re[i] == '*' || re[i] == ')')
                G.addEdge(i, i + 1);
        }
      //  System.out.println(G.toString());
        return G;
    }



    public boolean recognizes(String txt) {


       // System.out.println("Txt : " + txt + " : Length : " + txt.length());
        Bag<Integer> pc = new Bag<Integer>();
        Directed_DFS dfs = new Directed_DFS(G, 0);

        //System.out.println("DFS for Vretex  0");
        for (int v = 0; v < G.V(); v++) {
            if (dfs.marked(v)) {
          //      System.out.print(v + " ");
                pc.add(v);
            }
        }

       // System.out.println();


        for (int i = 0; i < txt.length(); i++) {
            Bag<Integer> states = new Bag<Integer>();


           // System.out.println("Bag for Vertex : " + i);
           // System.out.println(pc.toString());

//            System.out.println();

            for (int v : pc ) {
                if (v == M)
                    continue;
                if (re[v] == txt.charAt(i) || re[v] == '.')
                    states.add(v+1);
            }

            dfs = new Directed_DFS(G, states);
            pc = new Bag<Integer>();


            //System.out.println("DFS for " + states.toString());

            for(int v = 0; v < G.V(); v++) {
                if (dfs.marked(v)) {
              //      System.out.print(v + " ");
                    pc.add(v);
                }
            }

         //   System.out.println();
        }

        //System.out.println("Bag for Final Vertex : " );
        //System.out.println(pc.toString());


        for (int v : pc)
            if (v == M)
                return  true;
        return  false;
    }
}
