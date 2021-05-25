package DS.Sorting;

import DS.util.IntegerFileGenerator;

import javax.sound.midi.Soundbank;
import java.sql.SQLOutput;
import java.util.Vector;

public class SortingTest {

    public static void PrintArrayWithBanner(Vector<Integer> arr, String str) {
        String banner = "---------------";
        System.out.println(banner + str + banner);
        for (int i = 0; i < arr.size(); i++) {
            System.out.print(arr.get(i) + " ");
        }
        System.out.print(banner + banner);
        System.out.println();
    }

    public static void main(String[] args) {
        long start, end, duration;


        System.out.println("******************QSort Testing **********");
        IntegerFileGenerator Qgen = new IntegerFileGenerator(10000, 10000, "QsortInput.txt", "QsortOutput.txt");
        Qgen.generate();
        Vector<Integer> Qarr = Qgen.read();
        PrintArrayWithBanner(Qarr, "Input Data");

        start = System.nanoTime();
        Qsort.Sort(Qarr);
        end = System.nanoTime();

        duration = end - start;
        System.out.println("Time taken to sort in ns:"+  duration);
        PrintArrayWithBanner(Qarr, "Output Data");


        System.out.println("*******************Msort Testing ******************");
        IntegerFileGenerator Mgen = new IntegerFileGenerator(10000, 10000, "MSortInput.txt", "MsortOutput.txt");
        Mgen.generate();
        Vector<Integer> Marr = Mgen.read();
        PrintArrayWithBanner(Marr, "Input Data");

        start = System.nanoTime();
        MSort.Sort(Marr);
        end = System.nanoTime();

        duration = end - start;
        System.out.println("Time taken to sort in ns:"+  duration);
        PrintArrayWithBanner(Marr, "Output Data");

        System.out.println("*******************Hsort Testing ******************");
        IntegerFileGenerator Hgen = new IntegerFileGenerator(10000, 10000, "HSortInput.txt", "HsortOutput.txt");
        Hgen.generate();
        Vector<Integer> Harr = Hgen.read();
        PrintArrayWithBanner(Harr, "Input Data");

        start = System.nanoTime();
        HSort.Sort(Harr);
        end = System.nanoTime();
        duration = end - start;
        System.out.println("Time Taken to Sort in ns:" + duration);
        PrintArrayWithBanner(Harr, "Output Data");


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
