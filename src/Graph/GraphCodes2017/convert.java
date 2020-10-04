package Graph.GraphCodes2017;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

/**
 * Created by rajkamal on 12/18/16.
 */
public class convert {

    public static void main(String[] args) {

        String line;
        BufferedReader in;
        PrintWriter writer;
        double Lat1, Lon1, Lat2, Lon2;
        String Name;
        HashSet <GeographicPoint> set = new HashSet<GeographicPoint>();
        GeographicPoint cur;

        try {
            String dir = System.getProperty("user.dir");
            dir = dir + "/JavaPractice/src/Algorithms/src/com/rajkamal/Graph";
            in = new BufferedReader(new FileReader(dir + "/simpleTest.map"));

            writer = new PrintWriter(dir + "/simple.txt", "UTF-8");

            line = in.readLine();

            while (line != null) {
            //for (int i = 0; i < 5; i++ ) {
               // writer.println(line);

                //StringTokenizer st = new StringTokenizer(line);
                //System.out.println(line);
                    Scanner sc = new Scanner(line);
                    Lat1 = sc.nextDouble();
                    Lon1 = sc.nextDouble();
                    Lat2 = sc.nextDouble();
                    Lon2 = sc.nextDouble();
                    Name = sc.nextLine();
                    GeographicPoint g = new GeographicPoint(Lat1, Lon1, Name);
                    System.out.println("Geographic point " + Lat1 + " " + Lon1 + " "  + Lat2 + " " + Lon2 + " " + Name);

                    set.add(g);

                    line = in.readLine();

                 }

                 System.out.println();



                 System.out.println(line);
                 Iterator<GeographicPoint> itr = set.iterator();

                 while(itr.hasNext()) {
                     cur = itr.next();
                     String address = cur.getX() + " " +  cur.getY() +  " " +  cur.Name ;
                     writer.write(address);
                     writer.println();

                 }

                in.close();
                writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
