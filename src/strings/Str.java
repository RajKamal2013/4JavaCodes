package strings;

import java.util.Scanner;

/**
 * Created by rajkamal on 6/13/18.
 */
public class Str {
    public static void main(String[] args) {
        String exp = "( 1 ( ( 2 3 + ) ( 4 5 * ) * ) + )";
        Scanner sc = new Scanner(exp);
        String res;
        res = "";
        while(sc.hasNext()) {
            System.out.println(res);
            exp = sc.next();
            res = res + exp;
        }
        System.out.println(res);
    }
}
