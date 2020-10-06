package Stack;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created by rajkamal on 12/7/16.
 */
public class Valid_Pattern {

    public static boolean isValidSymbolPattern(String str) {
        Stack<Character> stk = new Stack<Character>();
        if (str == null || str.length() == 0) {
            return true;
        }
        for (int i = 0; i < str.length(); i++) {

       //     System.out.println("Considering the character : " + str.charAt(i));
            if ((str.charAt(i)) == ')') {
                if (!stk.isEmpty() && stk.peek() == '(') {
                   // System.out.println("Popping " + str.charAt(i) +" from stack");
                    stk.pop();
                } else
                    return false;
            } else if ((str.charAt(i)) == '}') {
                if (!stk.isEmpty() && stk.peek() == '{') {
                   // System.out.println("Popping " + str.charAt(i) +" from stack");
                    stk.pop();
                } else
                    return false;
            } else if ((str.charAt(i)) == ']') {
                if (!stk.isEmpty() && stk.peek() == '[') {
                    //System.out.println("Popping " + str.charAt(i) +" from stack");
                    stk.pop();
                } else
                    return false;
            } else {
                if (str.charAt(i) == '(' || str.charAt(i) == '{' || str.charAt(i) == '[') {
                   // System.out.println("Pushing " + str.charAt(i) +" to stack");
                    stk.push(str.charAt(i));
                }

            }
        }

        if (stk.isEmpty())
            return true;
        else
            return false;

    }

    public static  void main(String [] args){
        System.out.println("Enter the string ");
        String str;
        Scanner sc = new Scanner(System.in);
        str = sc.nextLine();

        System.out.println("Valid Pattern result " +  isValidSymbolPattern(str));

    }
}
