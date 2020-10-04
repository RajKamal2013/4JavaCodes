package strings;

import java.util.ArrayList;

/**
 * Created by rajkamal on 1/12/17.
 */
public class bruteforce {
    public ArrayList<Integer> search(String str, String substr) {
        int j, i;

        int m,n;
        n = str.length();
        m = substr.length();

       // System.out.println("String : < " + str + " > && Substring : < " + substr + " >");

        ArrayList<Integer> index = new ArrayList<Integer>();
        for (i = 0; i < n - m ; i++) {
            j = 0;
            while ((j < m ) && (str.charAt(i + j) == substr.charAt(j))) {
                j++;
            }
            if (j == m) {
         //       System.out.println("Substring is found at " + i);
                index.add(i);
            }
        }
        return index;
    }
}
