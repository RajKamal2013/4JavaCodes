package Stack;

/**
 * Created by rajkamal on 6/13/18.
 */
public class test {
    public static void main(String[] args) {
        Postfix ps = new Postfix();
        String str = "a*b-c+d";
        String postfix = ps.Infix2Postfix(str);
        System.out.println("String Postfix: " + postfix);
        Infix in = new Infix();
        String infix = in.getInfix(postfix);
        System.out.println("String Infix :" + infix);
    }
}
