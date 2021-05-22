package DS.Sorting;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Vector;

public class SortingTest {
    public static void main(String[] args) {

        System.out.println("******* QSort Testing **********");
        IntegerFileGenerator gen = new IntegerFileGenerator(100, 10000);
        gen.generate();
        Vector<Integer> arr = gen.read();
        System.out.println("-------------Input Data------------");
        for (int i = 0; i < arr.size(); i++) {
            System.out.print(arr.get(i) + " ");
        }
        System.out.println();
        System.out.println();
        Qsort qsort = new Qsort(arr, arr.size());
        long start = System.nanoTime();
        Vector <Integer> sort = qsort.run();
        long end = System.nanoTime();
        long duration = end - start;
        System.out.println("Time taken to sort in ns:"+  duration);
        System.out.println("-------------Output Data-------------");
        for (int i = 0; i < sort.size(); i++) {
            System.out.print(sort.get(i) + " ");
        }
        System.out.println();
        System.out.println();
        /*
        try {
            FileWriter sortedFile = new FileWriter(new File("Sorted.txt"));
            sortedFile.append(arr.size() + "\n");
            for (int i = 0; i < arr.size(); i++) {
                sortedFile.append(arr.get(i) + "\n");
            }
            sortedFile.flush();
            sortedFile.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        */
    }
}
