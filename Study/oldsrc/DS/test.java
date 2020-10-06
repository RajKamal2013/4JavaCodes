package DS;

import java.util.Iterator;

/**
 * Created by rajkamal on 6/12/18.
 */
public class test
{

    public static void main(String[] args) {

        player play1 = new player(5, "raj");
        player play2 = new player(2, "ab");
        player play3 = new player(3, "cd");
        player play4 = new player(1, "ef");
        player play5 = new player(6, "gh");
        player play6 = new player(0, "ij");

        Bag bag = new Bag();
        bag.add(play1);
        bag.add(play2);
        bag.add(play3);
        bag.add(play4);
        bag.add(play5);
        bag.add(play6);


        Iterator<player> itr = bag.iterator();
        while (itr.hasNext())
        {
            player pl = itr.next();
            System.out.println(pl.get_rank() + " name : -> " + pl.getName());
        }
    }
}
