package Coding2022.List;

import java.util.ArrayList;

public class ListTest {
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 1; i < 10; i++) {
            arr.add(i);
        }
        LinkedList list = new LinkedList(arr);
        System.out.println(list.toString());
        list.reverse();
        System.out.println(list.toString());
    }
}
