package strings;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by rajkamal on 3/15/18.
 */
public class RunLengthEncoding {

    public ArrayList<Integer> NumberToDigits (int number) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        int val = number;
        int digit = val;
        int R = 10;
        int factor = 1;

        while (val >= R){
            val = val/R;
            factor = factor * 10;
        }

        val = number;
        while (factor >= 1) {
            digit = val/factor;
            list.add(digit);
            val = val - (digit * factor);
            factor = factor/R;
        }

        Iterator<Integer> itr = list.iterator();
        System.out.println("INteger : " + number);
        while(itr.hasNext()) {
            System.out.println("Digit : " + itr.next());
        }

            return list;
    }


    public int solution(char[] chars) {
        int length = chars.length;
        int size;
        char prev = chars[0];
        ArrayList<String> list = new ArrayList<>();
        ArrayList<Integer> dlist;
        Iterator<Integer> itr;
        int count = 0;
        int digit;
        for (int i = 0; i < length; i++) {
            if (chars[i] == prev) {
                count++;
            } else {
                list.add(Character.toString(prev));
                if (count > 1) {
                    dlist = NumberToDigits(count);
                    itr = dlist.iterator();
                    while (itr.hasNext()) {
                        digit = itr.next();
                        list.add(Integer.toString(digit));
                    }
                }
                count = 1;
                prev = chars[i];
            }
        }


        list.add(Character.toString(prev));
        if (count > 1) {
            dlist = NumberToDigits(count);
            itr = dlist.iterator();
            while (itr.hasNext()) {
                digit = itr.next();
                System.out.println("Digit : " + digit);
                list.add(Integer.toString(digit));
            }
        }

        size = list.size();
        int index = 0;
        String str;


        System.out.println("Printing the output");
        Iterator<String> sitr = list.iterator();

        if (length > 1) {
            while (sitr.hasNext()) {
                str = sitr.next();
                chars[index] = str.charAt(0);
                index = index + 1;
                System.out.print(str + " ");
            }
            System.out.println();
        }

        System.out.println("Printing compress array ");

        if (length> 1) {
            for (int i = 0; i < size; i++) {
                System.out.print(chars[i] + " ");
            }
        }
        System.out.println();


        return size;
    }
}
