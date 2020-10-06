package strings;

import java.util.Scanner;

/**
 * Created by rajkamal on 12/29/16.
 */

/*
  1, 11, 21, 1211, 111221, .... (we need to find the next pattern
 */
public class nextpattern {
    public static String next_pattern(String str) {
        int count = 0;
        Character s = null;
        String res = null;
        int len = 0;


        while(len < str.length()) {
            s = str.charAt(len);
            count = 1;
           // System.out.println("before while loop for second time " + s + " " + len + " " + str.charAt(len));
            len++;
            while ((len < str.length()) && (str.charAt(len) == s)){
           //     System.out.println("Inside while loop for second time " + s + " " + len + " " + str.charAt(len));
                count++;
                len++;
            }
          //  System.out.println("after while loop for second time " + s + " " + len + " " );
             res = (res == null)?(Integer.toString(count) + s):(res + Integer.toString(count) + s);
        }
        return res;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        String res = next_pattern(str);
        System.out.println("Pattern After " + str + " is " + res);
    }
}
