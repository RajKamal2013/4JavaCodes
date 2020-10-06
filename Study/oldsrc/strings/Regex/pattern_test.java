package strings.Regex;

/**
 * Created by rajkamal on 1/29/17.
 */
public class pattern_test {

    public static void main(String [] args) {
        //String regexp = "(" + args[0] + ")";
        //String txt = args[1];
        //String regexp = "((a*b|ac)d)";
        //String txt = "aabd";
        String regexp = "a*b*";
        String txt = "aabbbbbbbbbb";

        NFA nfa = new NFA(regexp);
        boolean result = nfa.recognizes(txt);
        System.out.println("Pattern  --> " + regexp);
        System.out.println("Text     --> " + txt);
        if (result == true)
            System.out.println("Text Matches the Pattern ");
        else
            System.out.println("Text does not Matches the Patten ");
    }
}
