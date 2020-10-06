package strings.Trie;

import java.io.*;
import java.util.Scanner;

/**
 * Created by rajkamal on 3/13/18.
 */
public class TrieSTTest {

    public static void test() {
        // build symbol table from standard input
        TrieST<Integer> st = new TrieST<Integer>();
        TrieST<Integer> st2 = new TrieST<Integer>();

        /* Basic Test */
        String Data = "hello he says to Be Patient and she sells sea shells by the sea shore and do shellsort";
        Scanner sc = new Scanner(Data);
        int i = 0;
        String key;
        System.out.println("Adding Key-Value: " );
        while (sc.hasNext()) {
            key = sc.next();
            System.out.println(key + " - " +  i);
            st.put(key, i);
            i++;
        }
        System.out.println("Displaying all the keys ");
        sc = new Scanner(Data);
        key = "";
        // print results
        if (st.size() < 100) {
            while (sc.hasNext()) {
                key = sc.next();
                System.out.println(key + " " + st.get(key));
            }
            System.out.println();
        }
        i = 0;
        String keys;

        /* I/O Test */

        String input_data = "";
        System.out.println("Input the string :");
        sc = new Scanner(System.in);


       // while (sc.hasNextLine()) {
        keys = sc.nextLine();
        sc = new Scanner(keys);
        System.out.println("Adding Key-Value: " );
        while (sc.hasNext()) {
            key = sc.next();
            System.out.println(key + " - " +  i);
            st2.put(key, i);
            i++;
        }
        //}


        sc = new Scanner(System.in);
        //while(sc.hasNext()) {
            System.out.println("Enter key to Search: ");
            key = sc.next();
            System.out.println(key + " " + st2.get(key));
        //}



        /* File Testing */

        /*
        FileInputStream fstream = new FileInputStream("src/trie.txt");
        BufferedReader br = new BufferedReader(new InputStreamReader(fstream));

        String strLine;
        //Read File Line By Line
        while ((strLine = br.readLine()) != null)   {
            // Print the content on the console
            System.out.println (strLine);
        }
        */

        try (FileInputStream fileInputStream = new FileInputStream(new File("src/trie.txt"))) {
            BufferedReader br = new BufferedReader(new InputStreamReader(fileInputStream));

            String strLine;
            //Read File Line By Line
            i = 0;
            while ((strLine = br.readLine()) != null)   {
                // Print the content on the console
                sc = new Scanner(strLine);
                while (sc.hasNext()) {
                    key = sc.next();
                    System.out.println(key + " - " + i);
                    st2.put(key, i);
                    i++;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

//        stream = (new File("src/trie.txt"))
//        try {
//            Scanner scanner = new Scanner(file);
//            while (sc.hasNextLine()) {
//                keys = scanner.nextLine();
//                System.out.println(keys);
//            }
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//            keys = e.getLocalizedMessage();
//        }


        System.out.println("longestPrefixOf(\"shellsort\"):");
        System.out.println(st.longestPrefixOf("shellsort"));

        System.out.println("longestPrefixOf(\"hell\"):");
        System.out.println(st.longestPrefixOf("hell"));

        System.out.println("longestPrefixOf(\"quicksort\"):");
        System.out.println(st.longestPrefixOf("quicksort"));


        System.out.println("keysWithPrefix(\"shor\"):");
         for (String s : st.keysWithPrefix("shor"))
             System.out.println(s);


        System.out.println("keysThatMatch(\".he.l.\"):");
        for (String s : st.keysThatMatch(".he.l."))
             System.out.println(s);

    }

    public static void main(String[] args) {
        test();
    }
}
