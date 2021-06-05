package algoPrinciton;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;


public class RandomWord {
    public static void main(String[] args) {
        String max = "";
        int idx = 0;
        boolean ret = false;
        while (!StdIn.isEmpty()) {
            idx = idx + 1;
            String str = StdIn.readString();
            ret = StdRandom.bernoulli((double)1/idx);
            if (ret) {
                max = str;
            }
        }
        StdOut.println(max);
    }

}
