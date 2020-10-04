package strings;

import java.util.AbstractList;
import java.util.Iterator;

/**
 * Created by rajkamal on 1/12/17.
 */
public class stringtest {

    public static void test() {
        String str = "Hi I am Raj Kamal. I am working on String Algorithms and I want to improve my DS and Algo";
        String substr = "am";
        int pos;


        System.out.println("String    --> " + str);
        System.out.println("SubString --> " + substr);


        /*
        System.out.println("Printing ASCII value ");

        for (int i = 0; i < str.length(); i++) {
            System.out.println("Ascii value of " + str.charAt(i) + " : " + (int)str.charAt(i));
        }
        */

        bruteforce search1 = new bruteforce();


        AbstractList<Integer> index;


        System.out.println( "Brute Force Algorithm ");
        index = search1.search(str, substr);
        Iterator<Integer> itr = index.iterator();

        while(itr.hasNext()) {
            pos = itr.next();
            System.out.println("Substring : < " + substr + " > is Found At position :" + pos);
        }


        System.out.println();
        System.out.println("Rabin Karp Algorithm");

        rabin_karp search2 = new rabin_karp();
        index = search2.search(str, substr);

        itr = index.iterator();

        while(itr.hasNext()) {
            pos = itr.next();
            System.out.println("Substring : < " + substr + " > is Found At position :" + pos);
        }
    }


    public static void main(String[] args) {
        test();
    }
}
