package Sorting;

/**
 * Created by rajkamal on 12/6/16.
 */
import java.util.*;
import java.lang.*;

public class Quick_Sort {
    public static int partition(int []arr, int low, int high){
        int key = arr[high];
        int i = low - 1;
        int j;
        int temp, pivot;


        /**
         * Index i represent the last index at which data is
         * smaller then pivot.
         */
        for (j = low; j <= high - 1; j++) {
            if (arr[j] <= key) {
                i = i + 1;
                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        arr[high] = arr[i + 1];
        arr[i + 1] = key;
        pivot = i + 1;


        return (pivot);
    }

    public static void quick_sort(int []arr, int low, int high) {
        int pivot;
        if ( low < high) {
            pivot = partition(arr, low, high);
            quick_sort(arr, low, pivot - 1);
            quick_sort(arr, pivot + 1, high);
        }
    }

    public static void display(int[] arr, int len) {
        int i;
        for (i = 0; i < len - 1; i++) {
            System.out.print(arr[i] + ",");
        }
        System.out.println(arr[i]);

    }

    public static void main(String[]args) {
        Scanner sc = new Scanner(System.in);
        int num;
        System.out.println("Enter the length of array : ");
        num = sc.nextInt();

        int arr[] = new int[num];

        System.out.println("Enter the Elements one by one :");

        for(int i = 0; i < num; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println("Input Array :");
        display(arr, num);
        quick_sort(arr, 0, num - 1);
        System.out.println("Output Array :");
        display(arr, num);
    }
}

