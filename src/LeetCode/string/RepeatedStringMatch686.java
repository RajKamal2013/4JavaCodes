package LeetCode.string;

/**
 * Created by rajkamal on 4/14/18.
 */
public class RepeatedStringMatch686 {

    public boolean isSubString(String Text, String Pat) {
        if (Text == null && Pat == null) {
            return true;
        }
        if (Text == null || Pat == null) {
            return false;
        }
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        boolean ret = false;
        int D = 256;
        int q = 7;
        int m = Pat.length();
        int n = Text.length();

        //long h = modular_exponentiation(D, m, q);
        long h = 1;
        for (int i = 0;i < m - 1; i++) {
            h = (h*D)%q;
        }

        long P_Value = 0;
        long T_Value = 0;

        for (int i = 0; i < m; i++) {
            P_Value = ((D * P_Value) + Pat.charAt(i)) % q;
            T_Value = ((D * T_Value) + Text.charAt(i)) % q;
        }

        int i,j;
        for (i = 0; i <= n - m; i++) {
            if (T_Value == P_Value) {
                for (j = 0; j < m; j++) {
                    if (Text.charAt(i + j) != Pat.charAt(j)) {
                        break;
                    }
                }

                if (j == m) {
                    ret = true;
                    break;
                }
            }
            if (i < n-m) {
               T_Value = (D * (T_Value - (Text.charAt(i) * h)) + Text.charAt(i + m)) % q;

                if (T_Value < 0) {
                    T_Value  = T_Value + q;
                }
            }
        }

        return ret;
    }

    public boolean validateStrings(String A, String B) {
        boolean ret = true;
        int R = 256;
        boolean [] bittest = new boolean[R];
        for (int i =0; i < B.length(); i++)  {
            bittest[B.charAt(i)] = true;
        }
        for (int i = 0; i < A.length(); i++ ) {
            bittest[A.charAt(i)] = false;
        }
        for (int i = 0; i < R; i++) {
            if (bittest[i] == true) {
                ret = false;
                break;
            }
        }
        return ret;
    }

    public int solution(String A, String B) {
        if (A == null && B == null) {
            System.out.println("Both are null");
            return 0;
        }
        if (A == null || B == null) {
            System.out.println("Either of one is null");
            return -1;
        }
        if (A == B) {
            System.out.println("A and B are same ");
            return 1;
        }
        if (!validateStrings(A, B)) {
            System.out.println("Validation failed !!!");
            return  -1;
        }
        int lenA, lenB;
        boolean ret = false;
        lenA = A.length();
        lenB = B.length();
        if (lenA > lenB) {
            System.out.println(B + " is longer than " + A);
            ret = isSubString(A, B);
            if (ret == true) {
                return 1;
            }
        }
        int count = 1;
        StringBuilder a = new StringBuilder(A);
        while (a.length() < lenB) {
            a.append(A);
            count++;
        }
        //System.out.println("A is repeated " + count + " Times and A is now " + a.toString());
        for (int i = 0; i < 3 * lenB; i++) {
            ret = isSubString(a.toString(), B);
            if (ret == true) {
            //System.out.println("Substring matches after repeatation ");
                break;
            }
            a.append(A);
            count++;
        }
        if (ret == false) {
            System.out.println("No B can never substring of A,tested till count : " + count);
            return  -1;
        }
        return count;
    }

}
