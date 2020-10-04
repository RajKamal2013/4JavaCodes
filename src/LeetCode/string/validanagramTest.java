package LeetCode.string;

/**
 * Created by rajkamal on 3/20/18.
 */
public class validanagramTest {
    public static void test() {
        //String str1 = "anagram";
        //String str2= "nagaram";
        String str1 = "car";
        String str2= "tar";

        boolean ret;
        validAnagram API = new validAnagram();
        ret = API.isAnagram(str1, str2);
        System.out.println("str1 " + str1 + " and " + str2 + " are anagrams: " + ret);
     }

    public static void main(String[] args) {
        test();
    }
}
