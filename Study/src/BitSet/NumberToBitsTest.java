package BitSet;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

/**
 * Created by rajkamal on 3/15/18.
 */
public class NumberToBitsTest {
    public static void test() {
        int data = 5;
        NumberToBits api = new NumberToBits();
        ArrayList<Integer> list;
        Iterator<Integer> itr;
        list = api.DecToBinary(data);
        itr = list.iterator();
        System.out.println("Bit Representation of Number: " + data);
        while (itr.hasNext()) {
            System.out.print(itr.next());
        }
        System.out.println();


        Scanner sc = new Scanner(System.in);
        System.out.println("Enter 5 number one by one ");
        for (int i = 0;i < 5; i++) {
            data = sc.nextInt();
            list = api.DecToBinary(data);
            itr = list.iterator();
            System.out.println("Bit Representation of Number: " + data);
            while (itr.hasNext()) {
                System.out.print(itr.next());
            }
            System.out.println();

        }


    }
    public static void main(String[] args) {
        test();
    }
}
