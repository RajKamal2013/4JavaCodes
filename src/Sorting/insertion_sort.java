package Sorting;

/**
 * Created by rajkamal on 12/6/16.
 */
import java.util.*;

public class insertion_sort{
    static void insertion_sort(int []arr, int num) {
        int temp, key;
        int i,j;
        for(i = 1; i < num; i++) {
            key = arr[i];
            j = i - 1;
            while ((j >= 0) & (arr[j] > key)) {
                arr[j+1] = arr[j];
                j--;
            }
            arr[j + 1] = key;

        }

    }

    static void display(int []arr, int num) {
        System.out.println("Array Given are : ");
        for (int i = 0; i < num - 1; i++)
            System.out.print(arr[i] + ",");
        System.out.println(arr[num - 1]);
    }

    public static void main(String args[]) {
        int num;
        Scanner sc = new Scanner(System.in);
        System.out.println("Number : ");
        num = sc.nextInt();

        int []arr = new int[num];

        System.out.println("Enter the digits :");
        for (int i = 0; i < num; i++) {
            arr[i] = sc.nextInt();
        }

        display(arr, num);
        insertion_sort(arr, num);
        display(arr, num);

    }


}

