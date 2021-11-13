package CodingPractice.Array;

/*
 * Problem :- Given 2 Array, find out second one is subsequence of first one.
 * A1: [1,2,3,4]. A2 =[1, 3, 4]
 * Here A2 is subsequence of A1.
 */

import edu.princeton.cs.algs4.In;

import java.util.Random;
import java.util.Vector;

public class arraySubsequence {
    Vector<Integer> seq;
    Vector<Integer> subseq;

    /* Main API */
    public boolean isValidSubsequence(Vector<Integer> array, Vector<Integer> sequence) {
        int i, j, m, n;
        i = j = 0;
        m = sequence.size();
        n = array.size();

        display();

        while (i < n) {
            if (array.get(i).equals(sequence.get(j))) {
                j = j + 1;
                if (j == m) {
                    return  true;
                }
            }
            i++;
        }

        if (j == m) {
            return true;
        }
        return false;
    }

    public void display()
    {
        int n, m;
        n = seq.size();
        m = subseq.size();

        System.out.println("--Sequence--");
        for (int i = 0; i < n; i++) {
            System.out.print(seq.get(i) + " ");
        }
        System.out.println();

        System.out.println("-- Subsequence --");
        for (int i = 0; i < subseq.size(); i++) {
            System.out.print(subseq.get(i) + " ");
        }
        System.out.println();
    }
    /* Function to Generate Subsequence */
    public void generate_valid_subsequence(int range, int bound) {
        int m,n;

        if (seq != null) {
            seq.clear();
        }
        if (subseq != null) {
            subseq.clear();
        }
        Random rand = new Random();

        do {
            n = rand.nextInt(range);
            m = n;
        } while (n == 0);

        seq = new Vector<Integer>(n);
        subseq = new Vector<Integer>(n);

        for (int i = 0; i < n; i++) {
            seq.add(rand.nextInt(bound));
        }

        int range1 = m/2;
        if (range1 > 1) {
            int k = rand.nextInt(range1);
            if (k == 0) {
                k = 1;
            }
            int j = 0;
            j = j + k;
            //System.out.println("K & M " + k +" : " + m);
            int data;
            while (j < m) {
                data = seq.get(j);
                subseq.add(data);
                j = j + k;
            }
        } else {
            subseq = new Vector<Integer>(seq);
        }
    }

    /* Function to Generate Subsequence */
    public void generate_invalid_subsequence(int range, int bound) {
        int m,n;

        if (seq != null) {
            seq.clear();
        }

        if (subseq != null) {
            subseq.clear();
        }

        Random rand  = new Random();
        n = rand.nextInt(range);
        m = 0;
        m = n;
        seq = new Vector<Integer>(n);
        subseq = new Vector<Integer>(n);

        for (int i = 0; i < n; i++) {
            seq.add(rand.nextInt(bound));
        }

        for (int i = 0; i < n; i++) {
            System.out.print(seq.get(i) + " ");
        }
        int range1 = m/2;
        if (range1 > 1) {
            int k = rand.nextInt(range1);
            if (k == 0) {
                k = 1;
            }
            int j = 0;
            j = j + k;
            System.out.println();
            System.out.println("K & M " + k +" : " + m);
            int data;
            while (j < m) {
                data = rand.nextInt(bound);
                subseq.add(data);
                j = j + k;
            }
        } else {
            subseq = new Vector<Integer>(seq);
        }
    }


    public static void main(String[] args) {
        arraySubsequence gen = new arraySubsequence();
        boolean res;
        for (int i = 0; i < 100; i++) {
            gen.generate_valid_subsequence(20 + i * 5, 10 * (i + 1));
            if (!(gen.seq.isEmpty()) && !(gen.subseq.isEmpty())) {
                res = gen.isValidSubsequence(gen.seq, gen.subseq);
                System.out.println("Result : " + res);
            } else {
                System.out.println("Result : " + "True");
            }
        }


        for (int i = 0; i < 100; i++) {
            gen.generate_invalid_subsequence(20 + i * 5, 10 * (i + 1));
            if (!(gen.seq.isEmpty()) && !(gen.subseq.isEmpty())) {
                res = gen.isValidSubsequence(gen.seq, gen.subseq);
                System.out.println("Result : " + res);
            } else {
                System.out.println("Result : " + "True");
            }
        }
    }
}
