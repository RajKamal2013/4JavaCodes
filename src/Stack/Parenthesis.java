package Stack;

import DS.Stack;

import java.util.Scanner;

/**
 * Created by rajkamal on 6/13/18.
 */
public class Parenthesis
{
    private static final char LEFT_PAREN = '(';
    private static final char RIGHT_PAREN = ')';
    private static final char LEFT_BRACE = '{';
    private static final char RIGHT_BRACE = '}';
    private static final char LEFT_BRACKET = '[';
    private static final char RIGHT_BRACKET = ']';

    public boolean isValid(String str) {
        Stack<Character> stk = new Stack<>();
        char ch;
        for (int i = 0;i < str.length(); i++) {
            ch = str.charAt(i);
            if (ch == LEFT_PAREN) stk.push(ch);
            if (ch == LEFT_BRACE) stk.push(ch);
            if (ch == LEFT_BRACKET) stk.push(ch);

            if (ch == RIGHT_PAREN) {
                if (stk.isEmpty()) return false;
                if (stk.pop() != LEFT_PAREN) return false;
            }

            if (ch == RIGHT_BRACE) {
                if (stk.isEmpty()) return false;
                if (stk.pop() != LEFT_BRACE) return false;
            }

            if (ch == RIGHT_BRACKET) {
                if (stk.isEmpty()) return false;
                if (stk.pop() != LEFT_BRACKET) return false;
            }
        }
        return stk.isEmpty();
    }
}
