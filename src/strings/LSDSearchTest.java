package strings;


import java.util.Scanner;

/**
 * Created by rajkamal on 3/19/18.
 */
public class LSDSearchTest {
    public static void test() {
       // String Data = "hell hull says toot Beui Pati andi shea sell seau shel byth seas";
        String Data = "bac cab abc";
        Scanner sc = new Scanner(Data);
        String []arr = Data.split(" ");
        System.out.println("Input : ");
        for (String var : arr) {
            System.out.print(var + " ");
        }
        System.out.println();

        LSDSearch API = new LSDSearch();
        API.sort(arr, 3);
        System.out.println("Sorted :");
        for (String var : arr) {
            System.out.print(var + " ");
        }
        System.out.println();

    }

    public static void main(String[] args) {
        test();
    }
}
