package cards;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by rajkamal on 6/13/18.
 */
public class cardTostr
{
    public String API(String fileName)
    {
        String res = "";
     //   System.out.println("File Name :" + fileName );
        File file = new File("src/cards.txt");
        try {
            Scanner sc = new Scanner(file);
            while (sc.hasNext()) {
                res = res + " " + sc.next();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return res;
    }
}
