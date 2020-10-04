package LeetCode.string;

import java.io.*;
import java.util.Scanner;

/**
 * Created by rajkamal on 3/14/18.
 */
public class TrieTest {

    public static void test() {
        Trie st = new Trie();
        String strLine;
        int i = 0;
        Scanner sc;
        String key;
        String str;

        try (FileInputStream fileInputStream = new FileInputStream(new File("src/trie.txt"))) {
            BufferedReader br = new BufferedReader(new InputStreamReader(fileInputStream));
            while ((strLine = br.readLine()) != null)   {
               // System.out.print("String ->  ");
               // System.out.println(strLine);
                str = strLine.toLowerCase();
                str = str.replace(".", " ");
                str = str.replaceAll("\\W", " ");
                str = str.replaceAll("\\d", "");
                str.trim();
               // System.out.print("Trimmed string ->  ");
               // System.out.println(str);
                sc = new Scanner(str);
                i = 0;
                while (sc.hasNext()) {
                    key = sc.next();
                    System.out.println("key -" + key);
                    st.insert(key);
                    i++;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println();
/*
        for (i = 0; i < 5; i++) {
            sc = new Scanner(System.in);
            System.out.println("Enter key to Search: ");
            key = sc.next();
            System.out.println(key + "'s Existence :" + st.search(key));
        }
*/

        for (i = 0; i < 2; i++ ) {
            sc = new Scanner(System.in);
            System.out.println("Enter key to Search that startWith: ");
            key = sc.next();
            System.out.println("key with prefix " + key + " existence :" + st.startsWith(key));
        }

    }

    public static void main(String[] args) {
        test();
    }
}
