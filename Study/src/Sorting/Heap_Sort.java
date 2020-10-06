package Sorting;

/**
 * Created by rajkamal on 12/6/16.
 */
import java.util.*;
import java.lang.*;

public class Heap_Sort {
    public static void max_heapify(int[]arr, int i, int heap_size){
        int left, right;
        left = 2 * i + 1;
        right = 2 * i + 2;
        int largest, temp;

        if ((left < heap_size) && (arr[left] >= arr[i]))
            largest = left;
        else
            largest = i;

        if ((right < heap_size) && (arr[right] >= arr[largest]))
            largest = right;

        if (largest != i) {
            temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;
            max_heapify(arr, largest, heap_size);
        }
    }


    public static void build_max_heap(int[]arr, int length) {
        int heap_size = length;
        for(int i = (length/2); i >= 0; i--) {
            max_heapify(arr, i, heap_size);
        }
    }

    public static void heap_sort(int[] arr, int len) {
        int heap_size = len - 1;
        int temp;
        build_max_heap(arr, len);
        for (int i = len - 1; i >= 1; i--) {
            temp  = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            heap_size = heap_size - 1;
            max_heapify(arr, 0, heap_size);
        }
    }

    public static void display(int[]arr, int len) {
        int i;
        for (i = 0; i < len - 1; i++) {
            System.out.print(arr[i] + ",");
        }
        System.out.println(arr[i]);
    }



    public static void main(String[]args) {
        Scanner sc = new Scanner(System.in);
        int num;
        System.out.print("Enter the length : ");
        num = sc.nextInt();

        int []arr = new int[num];

        System.out.println("enter the elements of the array ");
        for (int i = 0; i < num; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println("Input : ");
        display(arr, num);
        System.out.println("Output : ");
        heap_sort(arr, num);
        display(arr, num);

    }
}

