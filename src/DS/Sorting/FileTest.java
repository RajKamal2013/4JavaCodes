package DS.Sorting;

import java.util.ArrayList;
import java.util.Vector;

public class FileTest {
    public static void main(String[] args) {
       IntegerFileGenerator gen = new IntegerFileGenerator();
       gen.write();
       Vector<Integer> arr = gen.read();
       System.out.println("Size of array : " + arr.size());
       for (int i = 0;i < arr.size(); i++) {
           System.out.println(arr.get(i));
       }
    }
}
