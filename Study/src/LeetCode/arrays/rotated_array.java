package LeetCode.arrays;

/**
 * Created by rajkamal on 4/29/17.
 */
public class rotated_array {


    static int find_rotated_index(int[] arr, int start, int end) {
        if (start < end) {
            int mid = (start + end )/2;
            if ((arr[mid - 1] < arr[mid]) && (arr[mid] > arr[mid + 1])) {  //we find the element
                return  mid + 1;
            } else if ((arr[start] < arr[mid]) & (arr[mid] > arr[end])) {//got to right
                    return find_rotated_index(arr, mid + 1, end);
            } else if  ((arr[start] > arr[mid]) && (arr[mid] < arr[end])) {  //go to left
                return find_rotated_index(arr, start, mid - 1);
            } else if ((arr[start] < arr[mid]) && (arr[mid] < arr[end])) { // ascending order
                return start;
            } else { //descending order ((arr[start] > arr[mid]) && (arr[mid] > arr[end]))
                return end;
            }
        } else {
            return start;
        }
    }

    static void print(int[] arr) {
        System.out.print("[ ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println(" ]");
    }

    public static void main(String[] args) {
        int[] arr1 = {6, 5, 4};
        int end = arr1.length - 1;
        int start = 0;

        print(arr1);
        int index = find_rotated_index(arr1, start, end);
        System.out.println("Array is rotated " + index + " times ");
        System.out.println("Current start index is:  " + index );
        System.out.println();

        int[] arr2 = {1, 2, 3};
        end = arr2.length - 1;
        start = 0;

        print(arr2);
        index = find_rotated_index(arr2, start, end);
        System.out.println("Array is rotated " + index + " times ");
        System.out.println("Current start index is:  " + index );
        System.out.println();


        int[] arr3 = {4, 5, 6, 7, 0, 1, 2, 3};
        end = arr3.length - 1;
        start = 0;

        print(arr3);
        index = find_rotated_index(arr3, start, end);
        System.out.println("Array is rotated " + index + " times ");
        System.out.println("Current start index is:  " + index );
        System.out.println();
    }

}
