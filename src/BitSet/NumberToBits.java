package BitSet;

import java.util.ArrayList;

/**
 * Created by rajkamal on 3/15/18.
 */
public class NumberToBits {
        int R = 2;
    public ArrayList<Integer> DecToBinary(int number) {
        int remainder;
        int val = number;

        ArrayList<Integer> list = new ArrayList<>();


        if (number == 0 | number == 1) {
            list.add(number);
            return list;
        }

        while (!(val == 0 | val == 1 )) {
            remainder = val % 2;
            val = val / 2;
            list.add(0, remainder);
        }
        list.add(0, val);

        return list;
    }

}
