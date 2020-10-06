package strings;

/**
 * Created by rajkamal on 2/13/17.
 */
public class pattern_matching {

    public  static Boolean isMatch(String S, String P) {
        int i = 0;
        int j = 0;
        char temp;
        boolean res = true;

        /* String is empty */
        if (S.isEmpty()) {
            while ((j < P.length()) && (P.charAt(j+1) == '*')) {
                j= j + 2;
            }

            if(j >= P.length()) {
                return true;
            } else {
                return false;
            }
        }

        while (i < S.length()) {
            if (j >= P.length()) {
                res = false ;
                break;
            }
            temp = S.charAt(i);
            /* string and pattern matches at this point */
            if (S.charAt(i) == P.charAt(j)) {
                i++;
                j++;

                /* next character in pattern is * */
                if ((j < P.length()) && (P.charAt(j) == '*')){
                      /* need to skip all the previous character in string */
                      /* need to make sure if any consecutive previous character in pattern
                       * and then count the same in string
                       */
                    j++;
                    /* count consecutive pervious character in Pattern */
                    //System.out.println("Pattern at index " + j + " is : " + P.charAt(j) + " and Character is:  " + temp);
                    while ((j < P.length()) && (P.charAt(j) == temp) ) {
                            j++;
                    }

                    while ((i < S.length()) && (S.charAt(i) == temp)){
                            i++;
                    }

                    /* String ended but not patten */
                    if (i >= S.length()) {
                        /* Skip all the a* */
                        while ((j < P.length()) && (P.charAt(j+1) == '*')) {
                            j = j + 2;
                        }
                    }


                    if ((i < S.length() && j>= P.length()) || (i>= S.length() && j < P.length())) {
                       // System.out.println("Either of string or pattern ended but not both");
                        //System.out.println("String Index : " + i  + " Pattern Index : " + j );
                        res = false;

                    }
                }

            } else {
                if (P.charAt(j) == '*') {
                    /* skip the * as the previous character does not matches string and its occurance is 0 in string */
                    j++;
                } else if (P.charAt( j + 1) == '*'){
                    /* b*c -> c */
                    j = j + 2;
                } else {
                    res = false;
                    break;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String S, P;
        boolean res;
/*
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the Pattern : ");
        P = sc.next();
        System.out.println();
        System.out.print("Enter the String : ");
        S = sc.next();
        System.out.println();

        System.out.println(" String : " + S + " -- Pattern : " + P );
        Boolean res = isMatch(S, P);
*/
        S = "c";
        P = "b*c";

        System.out.println("String : " + S + " -- Pattern : " + P );
        res = isMatch(S, P);

        if (res == true)
            System.out.println("String:  " + S + " matches Pattern: " + P);
        else
            System.out.println("String: " + S + " does not match Pattern: " + P);
    }

}
