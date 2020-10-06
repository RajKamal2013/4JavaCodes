package LeetCode.string;

/**
 * Created by rajkamal on 3/20/18.
 */
public class validAnagram {

    public boolean isAnagram(String s, String t) {
        int []arr = new int[65536];
        for (int i = 0; i < 65536; i++) {
            arr[i] = 0;
        }

        int length = s.length();

        for (int i = 0; i < length; i++) {
            arr[s.charAt(i)]++;
        }

        length = t.length();

        for (int i = 0; i < length; i++) {
            arr[t.charAt(i)]--;
        }

        for(int i =0; i < 65536; i++) {
            if (arr[i]!=0) {
                return false;
            }
        }

        return  true;

    }
}
