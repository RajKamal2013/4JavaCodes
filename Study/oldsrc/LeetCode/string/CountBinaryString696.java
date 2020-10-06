package LeetCode.string;

import java.util.ArrayList;

/**
 * Created by rajkamal on 4/9/18.
 */
public class CountBinaryString696 {

    public int Solution(String S) {

        if (S.length() <= 1) {
            return 0;
        }

        int count = 0;
        int prev, prev_count, curr, curr_count, index;
        ArrayList<String> t1 = new ArrayList<>();  // prev
        ArrayList<String> t2 = new ArrayList<>();  // curr
        String s1, s2;

        index = 1;
        curr = 0;
        curr_count = 1;
        prev_count = 0;
        prev = 0;

        while (index < S.length()) {
            if (S.charAt(curr) == S.charAt(index)) {
                curr_count++;
                if (curr_count <= prev_count) {
                    count++;
                    s1 = S.substring(prev, prev + curr_count);
                    s2 = S.substring(curr, curr + curr_count);
                    t1.add(s1);
                    t2.add(s2);
                }
            } else {
                prev = curr;
                prev_count = curr_count;
                curr = index;
                curr_count = 1;
                if (prev_count >= 1) {
                    count++;
                    s1 = S.substring(prev, prev + curr_count);
                    s2 = S.substring(curr, curr + curr_count);
                    t1.add(s1);
                    t2.add(s2);
                    System.out.println();
                }
            }
            index++;
        }

        index--;
/*
        if (curr_count == 1) {
            if (curr_count <= prev_count) {
                count++;
                s1 = S.substring(prev, prev + curr_count);
                s2 = S.substring(curr, curr + curr_count);
                t1.add(s1);
                t2.add(s2);
            }
        }
    */


        System.out.println("Count Binary String : " + count);
        System.out.println("printing list t1");
        for(String str:t1) {
            System.out.print(str + "  ");
        }
        System.out.println();
        System.out.println("Printing List t2");
        for(String str:t2) {
            System.out.print(str + "  ");
        }
        System.out.println();
        return count;
    }
}
