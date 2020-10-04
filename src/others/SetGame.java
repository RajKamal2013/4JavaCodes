package others;

/**
 * Created by rajkamal on 1/8/17.
 */

import java.util.*;

class Card {
    int num;
    char color;
    char shading;
    char symbol;

    public Card(String card) {
        num = Character.getNumericValue(card.charAt(0));
        color = card.charAt(1);
        shading = card.charAt(2);
        symbol = card.charAt(3);
    }
}

// Returns a string in the following format: <number><color><symbol><shading>
public class SetGame {
    private static ArrayList<ArrayList<String>> set=new ArrayList<ArrayList<String>>();
    private static ArrayList<ArrayList<String>> disjointsets=new ArrayList<ArrayList<String>>();
    private static int max_count=0;

    public static String converter(String card) {
        StringBuilder string=new StringBuilder();
        String delim="[ ]";
        String color=card.split(delim)[0];
        String symbol=card.split(delim)[1];
        int num=symbol.length();
        if ((num > 3) || (num < 1)){
            return "invalid";
        } else {
            string.append(num);
        }

        if (color.equals("blue")) {
            string.append("B");
        } else if (color.equals("green")) {
            string.append("G");
        } else if (color.equals("yellow")) {
            string.append("Y");
        } else {
            return "invalid";
        }

        // All characters in symbol should be same
        for (int i=1;i<symbol.length(); i++) {
            if (symbol.charAt(i) != symbol.charAt(0)) {
                return "invalid";
            }
        }

        if (symbol.charAt(0) == 'H' || symbol.charAt(0) == 'h' || symbol.charAt(0) == '#') {
            string.append("H");
        } else if (symbol.charAt(0) == 'S' || symbol.charAt(0) == 's' || symbol.charAt(0) == '$') {
            string.append("S");
        } else if (symbol.charAt(0) == 'A' || symbol.charAt(0) == 'a' || symbol.charAt(0) == '@') {
            string.append("A");
        } else {
            return "invalid";
        }

        char s=symbol.charAt(0);
        if (Character.isUpperCase(s)) {
            string.append("U");
        } else if (Character.isLowerCase(s)) {
            string.append("L");
        } else {
            string.append("S");
        }
        return string.toString();

    }

    static boolean isNotEqual(Object c1, Object c2,Object c3) {
        int flag = 0;
        if ((c1.equals(c2)) && (c2.equals(c3)) && (c3.equals(c1))) {
            flag = 1;
        } else if (!(c1.equals(c2)) && !(c2.equals(c3)) && !(c3.equals(c1))) {
            flag = 1;
        }

        if (flag == 1) {
            return false;
        }
        return true;
    }

    // Takes 3 cards as input and determines if they form a SET
    static boolean checkIfSet(Card c1, Card c2, Card c3) {
        if (isNotEqual(c1.num,c2.num,c3.num)) {
            //System.out.println("DEBUG: No match at line 81");
            return false;
        }
        if (isNotEqual(c1.color,c2.color,c3.color)) {
            return false;
        }
        if (isNotEqual(c1.symbol,c2.symbol,c3.symbol)) {
            return false;
        }
        if (isNotEqual(c1.shading,c2.shading,c3.shading)) {
            return false;
        }
        return true;
    }

    static boolean isDisjoint(ArrayList<String> set1, ArrayList<String> set2) {
        //List<String> commonlist=new ArrayList<String>(set1);
        //commonlist.retainAll(set2);
        //System.out.println("DEBUG: Printing common elements:"+commonlist);
        //if(commonlist.size()!=0){
        //	return false;
        //}
        //return true;

        for (String s1 : set1) {
            for (String s2 : set2) {
                if (s1.equals(s2)) {
                    return false;
                }
            }
        }

        return true;
    }
    // Takes 2 SETs and determines if they are disjoint
    static boolean checkIfDisjoint(ArrayList<String> set1, ArrayList<ArrayList<String>> disjoint) {
        for (ArrayList<String> set2 : disjoint) {
            if (!(isDisjoint(set1, set2))) {
                return false;
            }
        }
        return true;
    }

    // Check what would have happened if a particular set was considered and what would have happened if it was not
    // Then I pick the one with the maximum value from all the possible probabilities
    // private ArrayList<ArrayList<String>> disjointsets;
    static void findDisjoint(ArrayList<ArrayList<String>> set,ArrayList<ArrayList<String>> currset, int curr_idx) {
        System.out.println("DEBUG: curr_idx, set.size(): "+curr_idx+", "+set.size());
        //System.out.println("---DEBUG: Printing currset: "+currset);
        //System.out.println("**DEBUG: Printing allcards: "+allcards);
        //System.out.println("*****DEBUG Printing  disjointsets: "+disjointsets);
        if (curr_idx >= set.size()) {
            return;
        }

        if (currset.size() > disjointsets.size()) {
            disjointsets = currset;
        }

        // Now find probability if I had excluded the current set
        findDisjoint(set, currset, curr_idx+1);

        if (checkIfDisjoint(set.get(curr_idx), currset)) {
            System.out.println("DEBUG DISJOINT SET: curr_idx: "+curr_idx);
            currset.add(set.get(curr_idx));

            if (currset.size() > disjointsets.size()) {
                disjointsets = currset;
            }

            findDisjoint(set, currset, curr_idx+1);
        }
    }

    public static void printSets(ArrayList<ArrayList<String>> set1) {
        for(ArrayList<String> s:set1){
            for(String str:s){
                System.out.println(str);
            }
            System.out.println("");
        }
    }

    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        int n=scan.nextInt();
        HashMap<String,Card> map=new HashMap<String,Card>();
        String[] keys=new String[n];
        scan.nextLine();
        int i=0;
        while (i<n) {
            String line = scan.nextLine();
            String string=converter(line);
            if (string == "invalid") {
                System.out.println(line+" is an invalid input. Please try again!");
                continue;
            }
            Card card=new Card(string);
            map.put(line,card);
            keys[i]=line;
            i++;
        }
        scan.close();

        int sets=0;
        for (i=0;i<n-2;i++) {
            for (int j=i+1;j<n-1;j++) {
                for (int k=j+1;k<n;k++) {
                    if (checkIfSet(map.get(keys[i]),map.get(keys[j]),map.get(keys[k]))) {
                        ArrayList<String> arr=new ArrayList<String>();
                        arr.add(keys[i]);
                        arr.add(keys[j]);
                        arr.add(keys[k]);
                        sets=sets+1;
                        set.add(arr);
                    }
                }
            }
        }

        System.out.println("==============");
        ArrayList<ArrayList<String>> currset=new ArrayList<ArrayList<String>>();

        findDisjoint(set,currset, 0);

        System.out.println(sets);
        printSets(set);
        System.out.println(disjointsets.size());
        printSets(disjointsets);
    }
}


