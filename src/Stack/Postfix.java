package Stack;

/**
 * Created by rajkamal on 6/13/18.
 */

import DS.Stack;

/** Precedence :
  1. (
  2. ^
  3. *, /, %
  4. + -
 **/

/** Algorithm
 * 1. add the digit or character to ouput
 * 2. add the symbol to the stack
 * 3. when the symbol is ')' pop the output
 */

public class Postfix
{
    private int precedence(char ch)
    {
        switch (ch)
        {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
            case '%':
                return 2;
            case '^':
                return 3;
            case '(':
                return 4;
            default:
                return -1;
        }
    }

    public String Infix2Postfix(String exp)
    {
        String res = new String(" ");
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < exp.length(); i++) {
            char ch = exp.charAt(i);
            if (Character.isLetterOrDigit(ch)) {
                res += ch;
            } else if (ch == '(') {
                stack.push(ch);
            } else if (ch == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    res += stack.pop();
                }
                if (!stack.isEmpty() && stack.peek() != '(') {
                    return "INVALID";
                } else {
                    stack.pop();
                }
            } else {
                while((!stack.isEmpty()) && (precedence(ch) <= precedence(stack.peek()))) {
                    res += stack.pop();
                }
                stack.push(ch);
            }
        }

        while (!stack.isEmpty()) {
            res += stack.pop();
        }

        return res;
    }
}
