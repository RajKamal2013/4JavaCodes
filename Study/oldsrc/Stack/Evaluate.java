package Stack;

import DS.Stack;

import java.util.Scanner;

/**
 * Created by rajkamal on 6/13/18.
 ** both postfix and infix expression works
 */
public class Evaluate {
    Stack<String> ops;
    Stack<Double> val;
    String s;

    public Double API(String str) {
        ops = new Stack<String>();
        val = new Stack<Double>();
        Scanner sc = new Scanner(str);
        while (sc.hasNext()) {
            s = sc.next();
            if (s.equals("(")) {
            } else if (s.equals("+")) {
                ops.push(s);
            } else if (s.equals("-")) {
                ops.push(s);
            } else if (s.equals("*")) {
                ops.push(s);
            } else if (s.equals("/")) {
                ops.push(s);
            } else if (s.equals("sqrt")) {
                ops.push(s);
            } else if (s.equals(")")) {
                String op = ops.pop();
                double v = val.pop();
                if (op.equals("+")) v = val.pop() + v;
                else if (op.equals("-")) v = val.pop() - v;
                else if (op.equals("*")) v = val.pop() * v;
                else if (op.equals("/")) v = val.pop() / v;
                else if (op.equals("sqrt")) v = Math.sqrt(v);
                val.push(v);
            } else {
                val.push(Double.parseDouble(s));
            }
        }
        return val.pop();
    }
}
