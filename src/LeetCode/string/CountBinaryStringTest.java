package LeetCode.string;

/**
 * Created by rajkamal on 4/9/18.
 */
public class CountBinaryStringTest {
    public static void test() {
        CountBinaryString696 API = new CountBinaryString696();
        int count;

        String[] S1 = {" ", "", "1", "0", "11", "00", "10", "01", "00011", "10101"};
        String S = "00110011";


        count = API.Solution(S);
        System.out.println("Count of occurances in String: " +  S  + " is:  " + count);

       for (String str:S1){
           count = API.Solution(str);
           System.out.println("Count of occurances in String: " +  str  + " is:  " + count);



       }

    }

    public static void main(String[] args) {
        test();
    }
}
