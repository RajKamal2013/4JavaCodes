package LeetCode.string;

/**
 * Created by rajkamal on 4/14/18.
 */
public class RepeatedStringMatchTest {

    public static void test() {
        String[] A = {null, null, "anddc", "abcdef", "ab", "abab", "a", "b", "cccbcabbcbbbbbcbacaaabbcbaaabaacbaabbbccaacbbbccab"};
        String[] B = {null, "abcs", null, "abcdef", "abc", "ab", "aaaaaaaa", "bbbbbbbbbbbbbbbbbbb", "ccccbcabbcbbbbbcbacaaabbcbaaabaacbaabbbccaacbbbccabccccbcabbcbbbbbcbacaaabbcbaaabaacbaabbbccaacbbbccabccccbcabbcbbbbbcbacaaabbcbaaabaacbaabbbccaacbbbccabbcccbcabbcbbbbbcbacaaabbcbaaabaacbaabbbccaacbbbccabccccbcabbcbbbbbcbacaaabbcbaaabaacbaabbbccaacbbbccabacccbcabbcbbbbbcbacaaabbcbaaabaacbaabbbccaacbbbccabbcccbcabbcbbbbbcbacaaabbcbaaabaacbaabbbccaacbbbccabbcccbcabbcbbbbbcbacaaabbcbaaabaacbaabbbccaacbbbccabccccbcabbcbbbbbcbacaaabbcbaaabaacbaabbbccaacbbbccabbcccbcabbcbbbbbcbacaaabbcbaaabaacbaabbbccaacbbbccabbcccbcabbcbbbbbcbacaaabbcbaaabaacbaabbbccaacbbbccabbcccbcabbcbbbbbcbacaaabbcbaaabaacbaabbbccaacbbbccabbcccbcabbcbbbbbcbacaaabbcbaaabaacbaabbbccaacbbbccabbcccbcabbcbbbbbcbacaaabbcbaaabaacbaabbbccaacbbbccabccccbcabbcbbbbbcbacaaabbcbaaabaacbaabbbccaacbbbccabbcccbcabbcbbbbbcbacaaabbcbaaabaacbaabbbccaacbbbccabacccbcabbcbbbbbcbacaaabbcbaaabaacbaabbbccaacbbbccabccccbcabbcbbbbbcbacaaabbcbaaabaacbaabbbccaacbbbccabacccbcabbcbbbbbcbacaaabbcbaaabaacbaabbbccaacbbbccabacccbcabbcbbbbbcbacaaabbcbaaabaacbaabbbccaacbbbccabacccbcabbcbbbbbcbacaaabbcbaaabaacbaabbbccaacbbbccabbcccbcabbcbbbbbcbacaaabbcbaaabaacbaabbbccaacbbbccabbcccbcabbcbbbbbcbacaaabbcbaaabaacbaabbbccaacbbbccabccccbcabbcbbbbbcbacaaabbcbaaabaacbaabbbccaacbbbccabbcccbcabbcbbbbbcbacaaabbcbaaabaacbaabbbccaacbbbccabacccbcabbcbbbbbcbacaaabbcbaaabaacbaabbbccaacbbbccabacccbcabbcbbbbbcbacaaabbcbaaabaacbaabbbccaacbbbccabacccbcabbcbbbbbcbacaaabbcbaaabaacbaabbbccaacbbbccabbcccbcabbcbbbbbcbacaaabbcbaaabaacbaabbbccaacbbbccabacccbcabbcbbbbbcbacaaabbcbaaabaacbaabbbccaacbbbccabacccbcabbcbbbbbcbacaaabbcbaaabaacbaabbbccaacbbbccabccccbcabbcbbbbbcbacaaabbcbaaabaacbaabbbccaacbbbccabbcccbcabbcbbbbbcbacaaabbcbaaabaacbaabbbccaacbbbccabacccbcabbcbbbbbcbacaaabbcbaaabaacbaabbbccaacbbbccabacccbcabbcbbbbbcbacaaabbcbaaabaacbaabbbccaacbbbccabbcccbcabbcbbbbbcbacaaabbcbaaabaacbaabbbccaacbbbccabbcccbcabbcbbbbbcbacaaabbcbaaabaacbaabbbccaacbbbccabbcccbcabbcbbbbbcbacaaabbcbaaabaacbaabbbccaacbbbccabccccbcabbcbbbbbcbacaaabbcbaaabaacbaabbbccaacbbbccabccccbcabbcbbbbbcbacaaabbcbaaabaacbaabbbccaacbbbccabacccbcabbcbbbbbcbacaaabbcbaaabaacbaabbbccaacbbbccabacccbcabbcbbbbbcbacaaabbcbaaabaacbaabbbccaacbbbccabccccbcabbcbbbbbcbacaaabbcbaaabaacbaabbbccaacbbbccabbcccbcabbcbbbbbcbacaaabbcbaaabaacbaabbbccaacbbbccabbcccbcabbcbbbbbcbacaaabbcbaaabaacbaabbbccaacbbbccabbcccbcabbcbbbbbcbacaaabbcbaaabaacbaabbbccaacbbbccabccccbcabbcbbbbbcbacaaabbcbaaabaacbaabbbccaacbbbccabccccbcabbcbbbbbcbacaaabbcbaaabaacbaabbbccaacbbbccabacccbcabbcbbbbbcbacaaabbcbaaabaacbaabbbccaacbbbccabb"};

        String A1="abcd";
        String B1="cdabcdab";
        int count;

        RepeatedStringMatch686 API = new RepeatedStringMatch686();
        count = API.solution(A1, B1);

        System.out.println(B1.toString() + " becomes substring of " + A1.toString() +
                " after repeating " + A1.toString()  + ", " + count + " Times" );


        for (int i = 0; i < A.length; i++) {
            count = API.solution(A[i], B[i]);

            if (count == -1 ) {
                if (A[i]!= null & B[i]!=null) {
                    System.out.println(B[i].toString() + " can never becomes substring of " +
                            A[i].toString());
                } else {
                    System.out.println("Either is null and so cannot be substring");
                }
            }

            if (count == 0) {
                System.out.println("A and B both are null ");
            }
            if (A[i] != null && B[i]!= null) {
                System.out.println(B[i].toString() + " becomes substring of " + A[i].toString() +
                        " after repeating " + A[i].toString() + ", " + count + " Times");
            }
        }
/*
        String Pat, Text;
        Pat = "abcd";
        Text = "cdabcd";
        boolean ret = API.isSubString(Text, Pat);
        System.out.println(Pat + " is substring of " + Text + "  :"  + ret);
*/

    }

    public static void main(String[] args) {
        test();
    }
}
