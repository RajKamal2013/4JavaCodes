package cards;

/**
 * Created by rajkamal on 6/13/18.
 */
public class test {

    public static void main(String[] args) {
        String FileName = "cards.txt";
        cardTostr f = new cardTostr();
        String cards = f.API(FileName);
      //  System.out.println(cards);
        shuffle s = new shuffle();
        s.API(cards);
    }
}
