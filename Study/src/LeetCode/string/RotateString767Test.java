package LeetCode.string;

/**
 * Created by rajkamal on 4/2/18.
 */
/** Corner case :-
 * 1. null string
 * 2. length diff
 * 3. Same string
 * 4. one error , 2 error
 * 5. Repeatative  string
 *
 */
public class RotateString767Test {
    public static void test() {
        String A[] = {"","abcde", "abcde", " ", "abcde", "aaaabaaa", "aaaaaaaaa"};
        String B[] = {"","deabc", "edabc", "abdc", "abcde", "aaaaaaab", "aaaaaaaaa"};

        boolean ret;

        RotateString767 API = new RotateString767();
        ret = API.Solution(A[0], B[0]);
        API.toString(A[0], B[0], ret);

    }


    public static void main(String[] args) {
        test();
    }
}
