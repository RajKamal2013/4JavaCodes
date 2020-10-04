package Graph.WeightedGraph2017;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;


/**
 * Created by rajkamal on 12/27/16.
 */
public class CountSimplePath extends dfs {
    private HashSet<vertex> visited;
    int count;

    public CountSimplePath() {
        visited = new HashSet<vertex>();
        count = 0;
    }


    public  boolean isNeighbour(ArrayList<vertex> neighbour, vertex t) {
        Iterator<vertex> itr = neighbour.iterator();
        vertex temp;
        while(itr.hasNext()) {
            temp = itr.next();
            if (temp == t) {
                return true;
            }
        }
        return false;
    }

    public int Count_Simple_Path(graphAdjList G, vertex src, vertex dest) {
        ArrayList<vertex> neighbour;
        ArrayList<vertex> path;
        Iterator<vertex> itr;
        vertex t;
        visited.add(src);

        neighbour = G.getNeighbours(src);

        itr = neighbour.iterator();

        while(itr.hasNext()) {
            t = itr.next();
            if (isNeighbour(neighbour, t)) {
                path = getpath(t, dest);
                if(path != null)
                    count++;
            }
        }

        return count;
    }



}
