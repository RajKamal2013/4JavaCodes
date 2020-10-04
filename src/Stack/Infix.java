package Stack;

/**
 * Created by rajkamal on 6/13/18.
 */

import DS.Stack;

/** letter or digit -> stack
 *  operator -> pop the stack and do the manipulation and push to the stack
 */
public class Infix
{
    Stack<String> stack;
    public Infix()
    {
        stack = new Stack<>();
    }
    public String getInfix(String exp)
    {
        System.out.println("String to be converted :" + exp);
        char ch;
        exp.trim();
        for (int i = 0; i < exp.length(); i++) {
            ch = exp.charAt(i);
            if (Character.isWhitespace(ch)) {
                continue;
            }
            System.out.println("Character is : " + ch);
            if (Character.isLetterOrDigit(ch)) {
                stack.push(Character.toString(ch));
            } else {
                String op1 = stack.pop();
                String op2 = stack.pop();
                stack.push("(" + op1 + ch + op2 + ")");
            }
        }
        String res = stack.pop();

        return res;
    }
}
