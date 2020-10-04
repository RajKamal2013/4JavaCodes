package LeetCode.arrays;

/**
 * Created by rajkamal on 4/30/17.
 */
public class find_median_of_2_sorted_arrays {

    public static int find_position(int[] arr, int elem) {

        return elem;

    }

    public static double find_combine_median(int[] arr1, int[] arr2, int start, int end, int median_pos) {

        int mid = (start + end)/2;
        int rel_median;
        int abs_median;
       // int median_elem;

        rel_median = find_position(arr1, arr2[mid]);

        abs_median = mid - 1 + rel_median;

        if (abs_median == median_pos) {    // we find the median
            if ((arr1.length + arr2.length % 2) == 0) { //even
                return arr2[mid] ;// error

            }else {                        // odd
                return arr2[mid];  //error
            }
        } else if (abs_median > median_pos) {  // go left in arr2
           return  find_combine_median(arr1, arr2, start, mid, median_pos);
        } else {                                // go right in arr2
           return find_combine_median(arr1, arr2, mid, end, median_pos);
        }


    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int median_pos = (nums1.length + nums2.length) / 2;
        int start2 = 0;
        int end2   = nums2.length - 1;
        double new_median = find_combine_median(nums1, nums2, start2, end2, median_pos);
        return new_median;
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 9, 8, 10};
        int[] arr2 = {16, 17, 18, 20};
        int[] arr3 = {8, 9, 16, 17, 18};
        int[] arr  = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};

    }
}
