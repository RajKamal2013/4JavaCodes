package Interview;

/**
 * Created by rajkamal on 1/5/17.
 */
public class search_rotated_array {

    public static int search(int [] arr, int start, int end) {
        int mid = (start + end)/2;

        if ((arr[mid - 1] < arr[mid ]) && (arr[mid] > arr[mid + 1]))
            return mid + 1;
        else if ((arr[mid - 1] > arr[mid]) && (arr[mid] > arr[mid + 1]))
            return (search(arr, mid + 1, end));
        else if ((arr[mid -1] < arr[mid]) && arr[mid] < arr[mid + 1])
            return search(arr, start, mid - 1);
        else
            return -1;
    }


    public static void main(String[] args) {
        int arr[] = {18, 19, 20, 24, 27, 4, 5,  7, 9, 10};

        int pos = 0;


        for (int i = 0; i < arr.length; i++) {
            System.out.println("Array element " + arr[i] + " is at position " + i);
        }
/*
        System.out.println( "<---- Searching -->");
        for (int i = 0; i < arr.length; i++) {
            pos = search(arr, 0, arr.length - 1, arr[i]);
            System.out.println("Element " + arr[i] + " is found at postion " + pos);
        }
*/

        pos = search(arr, 0, arr.length - 1);

        System.out.println("Rotation is  found at postion " + pos + " and data is " + arr[pos]);
    }

}
