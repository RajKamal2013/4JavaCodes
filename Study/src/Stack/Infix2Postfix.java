package Stack;

/**
 * Created by rajkamal on 3/7/17.
 */


import java.util.Stack;

/**
 * Created by rajkamal on 3/7/17.
 */
public class Infix2Postfix {

    public static int getPriority(char c) {
        if (c == '*' || c == '/' )
            return 2;
        else if (c == '+' || c == '-')
            return 1;
        else
            return 0;
    }

    public static Boolean isOp(char c ) {
        if (c == '*' || c == '/' || c == '+' || c == '-'){
            return true;
        } else {
            return false;
        }
    }


    public static String InfixToPostfix(String Infix) {
        String Postfix = new String();
        Stack<Character> S = new Stack<Character>();
        char temp, c;
        Boolean b;

        for (int i = 0; i < Infix.length(); i++) {
            c = Infix.charAt(i);
            if (Character.isLetter(c)) {
                Postfix = Postfix + Character.toString(c);
            }

            else if (Character.isDigit(c)) {
                // temp = c;
                //while (Character.isDigit(temp)) {
                Postfix = Postfix + Character.toString(c);
                //  i++;
                // if (i < Infix.length()) {
                //   temp = Infix.charAt(i);
                //} else {
                //   break;
                //}
                //}
            }

            else if(c == '(') {
                S.push(c);
            }

            else if(c == ')') {
                temp = S.peek();
                while (temp != '(') {
                    Postfix = Postfix + Character.toString(temp);
                    S.pop();
                    temp = S.peek();
                }
                S.pop();
            }

            else if (isOp(c)){
                if (!S.isEmpty()) {
                    temp = S.peek();
                    while (getPriority(temp) >= getPriority(c)) {
                        Postfix = Postfix + Character.toString(S.pop());
                        if (S.isEmpty()) {
                            break;
                        } else {
                            temp = S.peek();
                        }
                    }
                }
                S.push(c);
            }

            else {

            }

        }

        while(!S.isEmpty()) {
            Postfix = Postfix + Character.toString(S.pop());
        }

        return Postfix;
    }

    public static void main(String[] args) {
        String Infix = "A*B-(C+D)-E";

        String Postfix = InfixToPostfix(Infix);
        System.out.println("Infix " + Infix);
        System.out.println("Postfix " + Postfix);

        Infix = "1*2-(3+4)-5";
        Postfix= InfixToPostfix(Infix);
        System.out.println("Infix " + Infix);
        System.out.println("Prefix " + Postfix);

        Infix = "11*12-(13+14)-15";
        Postfix = InfixToPostfix(Infix);
        System.out.println("Infix " + Infix);
        System.out.println("Prefix " + Postfix);

    }
}

