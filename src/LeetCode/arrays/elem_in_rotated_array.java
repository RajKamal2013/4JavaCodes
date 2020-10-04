package LeetCode.arrays;

/**
 * Created by rajkamal on 4/29/17.
 */
public class elem_in_rotated_array {
        public static int find_start_index(int[] arr, int start, int end) {
            if (start < end) { // no_of_elem >= 3
                int mid = (start + end )/2;
                if (start < mid && mid < end) {
                    if ((arr[mid - 1] > arr[mid]) && (arr[mid] < arr[mid + 1])) {  //we find the rotated index
                        return  mid;
                    } else if ((arr[start] < arr[mid]) && (arr[mid] > arr[end])) { //got to right
                        return find_start_index(arr, mid + 1, end);
                    } else if  ((arr[start] > arr[mid]) && (arr[mid] < arr[end])) {//go to left
                        return find_start_index(arr, start, mid - 1);
                    } else if ((arr[start] < arr[mid]) && (arr[mid] < arr[end])) { // ascending order
                        return start;
                    } else { //descending order ((arr[start] > arr[mid]) && (arr[mid] > arr[end]))
                        return end;
                    }
                } else { // no_of_elem == 2
                    if (arr[start] <= arr[end]){
                        return start;
                    } else{
                        return end;
                    }
                }
            } else {  // no_of_elem == 1
                return start;
            }
        }

        public static int binary_search(int[] arr, int start, int end, int target) {
            if (start <= end) {
                int mid = (start + end) / 2;
                if (arr[mid] == target) {
                    return mid;
                } else if (arr[mid] > target) {
                    return binary_search(arr, start, mid - 1, target);
                } else {
                    return binary_search(arr, mid + 1, end, target);
                }
            } else {
                return -1;
            }
        }
        public static int search(int[] nums, int target) {
            int start = 0;
            int end = nums.length - 1;
            int start_index = -1;
            if (start <= end) {
                start_index = find_start_index(nums, 0, end);

                //System.out.println("Start Index " + start_index);
                if (nums[start_index] == target) {
                    return start_index;
                } else if (nums[end] < target) {
                  //  System.out.println("1. Searching from " + start + " to " + start_index);
                    return binary_search(nums, start, start_index, target);
                } else {
                  //  System.out.println("2. Searching from " + start_index + " to " +  end);
                    return binary_search(nums, start_index + 1, end, target);
                }
            } else {
                return -1;
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
        int index = find_start_index(arr1, start, end);
        System.out.println("Array is rotated " + index + " times ");
        System.out.println("Current start index is:  " + index );
        System.out.println();

        int[] arr2 = {1, 2, 3};
        end = arr2.length - 1;
        start = 0;

        print(arr2);
        index = find_start_index(arr2, start, end);
        System.out.println("Array is rotated " + index + " times ");
        System.out.println("Current start index is:  " + index );
        System.out.println();


        int[] arr3 = {4, 5, 6, 7, 0, 1, 2, 3};
        end = arr3.length - 1;
        start = 0;

        print(arr3);
        index = find_start_index(arr3, start, end);
        System.out.println("Array is rotated " + index + " times ");
        System.out.println("Current start index is:  " + index );
        System.out.println();


        int[] arr4 = {1, 3};
        end = arr4.length - 1;
        start = 0;
        int target = 3;
        print(arr4);
        index = find_start_index(arr4, start, end);
        System.out.println("Array is rotated " + index + " times ");
        System.out.println("Current start index is:  " + index );
        index = search(arr4, target);
        System.out.println("Element " + target + " is found at index " + index);

        System.out.println("---------------------------------------------------------------------------");
        int[] arr5 = {5, 6, 7, 8, 1, 2, 3, 4};
        end = arr5.length - 1;
        start = 0;
        print(arr5);
        index = find_start_index(arr5, start, end);
        System.out.println("Array is rotated " + index + " times ");
        System.out.println("Current start index is:  " + index );
        for (int i = 0; i < arr5.length; i++) {
            target = arr5[i];
            index = search(arr5, target);
            System.out.println("Element " + target + " is found at index " + index);
        }
        System.out.println("----------------------------------------------------------------------------");


        System.out.println("---------------------------------------------------------------------------");
        int[] arr6 = {8, 9, 2, 3, 4};
        end = arr6.length - 1;
        start = 0;
        print(arr6);
        index = find_start_index(arr6, start, end);
        System.out.println("Array is rotated " + index + " times ");
        System.out.println("Current start index is:  " + index );
        for (int i = 0; i < arr6.length; i++) {
            target = arr6[i];
            index = search(arr6, target);
            System.out.println("Element " + target + " is found at index " + index);
        }
        System.out.println("----------------------------------------------------------------------------");
    }
}
