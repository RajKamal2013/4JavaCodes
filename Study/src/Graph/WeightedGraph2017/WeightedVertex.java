package Graph.WeightedGraph2017;


/**
 * Created by rajkamal on 12/24/16.
 */
public class WeightedVertex implements Comparable<WeightedVertex>{
        private vertex v;
        private int weight;

        public WeightedVertex(vertex v, int weight) {
            this.v = v;
            this.weight = weight;
        }

        public vertex getWeightedVertex() {
            return this.v;
        }

        public int getVertexWeight() {
            return this.weight;
        }

        public void setWeightedVertex(vertex v) {
            this.v = v;
        }

        public void setVertexWeight(int weight) {
            this.weight = weight;
        }

        @Override
        public int compareTo(WeightedVertex V) {
            if (this.weight > V.getVertexWeight())
                return 1;
            else if (this.weight < V.getVertexWeight())
                return -1;
            else
                return 0;
        }
}

