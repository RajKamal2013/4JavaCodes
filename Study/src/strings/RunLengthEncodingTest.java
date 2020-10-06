package strings;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

/**
 * Created by rajkamal on 3/15/18.
 */
public class RunLengthEncodingTest {
    public static void test() {
        RunLengthEncoding rt = new RunLengthEncoding();
        int number = 10;
        ArrayList<Integer> list;

        list = rt.NumberToDigits(number);
        Iterator<Integer> itr;

        /*
        System.out.println("Digit list for the number " + number + " : "  );
        System.out.println("size :" + list.size());
        itr = list.iterator();
        while (itr.hasNext()) {
            System.out.print(itr.next() + " ");
        }
        System.out.println();

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter 5 the digits one by one ");
        for (int i = 0; i < 5; i++) {
            number = sc.nextInt();
            list = rt.NumberToDigits(number);
            System.out.println("Digit list for the number " + number + " : "  );
            itr = list.iterator();
            while (itr.hasNext()) {
                System.out.print(itr.next() + " ");
            }
            System.out.println();

        }

        */

        //char [] arr = {'a',  'a', 'a', 'b', 'c', 's', 's','s'};
           // char[] arr = {'a'};
        char []arr = {'o','o','o','o','o','o','o','o','o','o'};
        int count = rt.solution(arr);
        System.out.println("Size of compressed array:" + count);
    }

    public static void main(String[] args) {
        test();
    }
}
