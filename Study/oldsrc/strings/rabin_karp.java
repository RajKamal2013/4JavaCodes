package strings;

import java.util.ArrayList;

/**
 * Created by rajkamal on 1/13/17.
 */
public class rabin_karp {


    // We are using Prime Number :- 7 //
    public long modular_Exponentiation(long d, long m, long q) {
        long result = 1;

        for (int i = 0; i < m; i++) {
            result = (result * d) % q;
        }

        return result;
    }

    /* S1 -> pattern, S2 -> Substring */

    public boolean verrify(String s1, String s2) {
        int m = s1.length();

        for (int i = 0; i < m; i++) {
            if (s1.charAt(i) != s2.charAt(i))
                return false;
        }

        return true;
    }


    public ArrayList<Integer> search(String str, String substr) {
        ArrayList<Integer> index = new ArrayList<Integer>();

        int n = str.length();
        int m = substr.length();

        long q = 7;
        long d = 256;

        /* using prime number 7 */
        long h = modular_Exponentiation(d, m - 1,  q);

        long P_Value = 0;
        long T_Value = 0;

        for (int i = 0; i  < m; i++) {
            P_Value = (d * P_Value + (int) substr.charAt(i)) % q;
            T_Value = (d * T_Value + (int) str.charAt(i)) % q;
        }


        for (int i = 0; i < n-m; i++) {

            if (P_Value == T_Value) {
                if (verrify(substr, str.substring(i)))
                    index.add(i);
            }

            if (i < n-m) {
                T_Value = ((d * (T_Value - (int)str.charAt(i) * h)) + (int)str.charAt(i + m)) % q;
            }
        }

        return index;
    }

}
