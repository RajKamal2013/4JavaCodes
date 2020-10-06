package LeetCode.string;

/**
 * Created by rajkamal on 4/2/18.
 * LeetCode :- 767 (String)
 * Solution + Optimization => less then O(n^2) with 2 optimization
 * Corner cases list =>
 *
 *
 */
public class RotateString767 {

    public boolean verify(String A, int index, String B) {
        boolean ret = true;
        if (index == 0) {
            for (int i = 0; i < A.length(); i++ ) {
                if (B.charAt(i) != A.charAt(i)) {
                    ret = false;
                    break;
                }
            }
        } else {
            int k = 0;
            for (int i = index; i <A.length() ; i++ ) {
                if (B.charAt(k++) != A.charAt(i)) {
                    ret = false;
                    break;
                }
            }

            for (int i = 0; i < index; i++) {
                if (B.charAt(k++) != A.charAt(i)) {
                    ret = false;
                    break;
                }
            }
        }
        return  ret;
    }

    public boolean Solution(String A, String B) {
        /** Pre Check
         * 0. Size checks for both
         * 1. next character in rotation 2 cases
         * 2. check the length of two half.
         * 3. once 1 and 2  verifies call the verify
         */
        int len1, len2;
        boolean ret = false;

        if ((A == null) && (B == null)) {
            return true;
        }

        if((A.length() == 0) && (B.length() == 0)) {
            return  true;
        }

        if (A.length() != B.length()) {
            return  false;
        }


         for (int i = 0; i < A.length(); i++) {
             if (A.charAt(i) == B.charAt(0)) {
                 /* case 1 verification */
                 if ((i < A.length() - 1) &&(A.charAt(i+1) != B.charAt(1))) {
                     continue;
                 }
                 /* case 2 verify => length */
                 if (i != 0) {
                     len1 = i;
                     len2 = A.length() - i;

                     if (len1 + len2 != B.length()) {
                         continue;
                     }
                 }
                 /* case3 => call verify */
                 ret = verify(A, i, B);
                 if (ret == true) {
                     break;
                 }
             }
         }
        return ret;
    }

    public void toString(String A, String B, boolean ret) {
        System.out.println("String :"+  B + " is rotated from " +  " String :" + A +
                ": "  + ret);
    }
}
