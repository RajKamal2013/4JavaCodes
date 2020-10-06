
/**
 * Created by rajkamal on 12/6/16.
 */
package Sorting;
import java.util.*;
import java.lang.*;

public class Merge_Sort {

    public static void merge(int[] arr, int start, int mid, int end) {
        int lsize = mid - start + 1;
        int rsize = end - mid;
        int k = 0;
        int rindex, lindex;


        int []larr = new int[lsize];
        int []rarr = new int[rsize];

        for(int i = 0; i < lsize; i++)
            larr[i] = arr[start + i];

        for(int i = 0; i < rsize; i++)
            rarr[i] = arr[mid + i + 1];


        rindex = lindex = 0;
        k = start;

        while ((lindex < lsize) & (rindex < rsize)) {
            if (larr[lindex] < rarr[rindex]) {
                arr[k] = larr[lindex];
                lindex++;
            } else {
                arr[k] = rarr[rindex];
                rindex++;
            }
            k++;
        }
        while(lindex < lsize) {
            arr[k] = larr[lindex];
            k++;
            lindex++;
        }
        while(rindex < rsize) {
            arr[k] = rarr[rindex];
            k++;
            rindex++;
        }

    }

    public static void merge_sort(int[] arr, int start, int end) {
        int mid;
        if (end > start) {
            mid = (start + end)/2;
            merge_sort(arr, start, mid);
            merge_sort(arr, mid + 1, end);
            merge(arr, start, mid, end);
        }
    }

    public static void display(int[] arr, int size) {
        int i;
        for (i = 0 ;i < size - 1 ; i++)
            System.out.print(arr[i] + ",");

        System.out.println(arr[i]);
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num;

        System.out.println("Enter the number: ");
        num = sc.nextInt();

        int[]arr = new int[num];

        System.out.println("Enter the elements of the array ");

        for (int i = 0; i < num; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println("Input Array: ");

        display(arr, num);
        merge_sort(arr, 0, num - 1 );
        System.out.println("Output Array: ");
        display(arr, num);
    }
}









