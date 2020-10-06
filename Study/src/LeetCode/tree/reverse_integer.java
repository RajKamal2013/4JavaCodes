package LeetCode.tree;

import java.util.Scanner;

public class reverse_integer {

    public static int setBit(int x) {
        if (x > 0)
            return 0;
        else
            return -1;
    }

    public static int setCount(int x) {
        int temp = x;
        int count = 0;
        while (temp != 0) {
            count = count + 1;
            temp = temp / 10;
        }
        return count;
    }

    public static int[] createArray(int number, int count) {
        int []arr = new int[count];
        int temp = number;
        int rem = 0;
        int index;

        for (int i = 0; i < count; i++) {
            rem = temp % 10;
            arr[i] = rem;
            index = i;
            System.out.println("Array Element at " +  index +  " is " + arr[index]);
            temp = temp/10;
        }

        for (int i = 0; i < count; i++) {
            System.out.println("Array Element at " + i + " is " + arr[i]);
        }
        return arr;
    }

    public static int checkOverflow(int[] arr, int bit) {
        if (arr[0] >= 4)
            return -1;
        if (arr[1] >= 3)
            return -1;
        if (arr[2] >= 8)
            return -1;
        if (arr[3] >= 7)
            return -1;
        if ((bit == 1) && (arr[4] >= 9))
            return -1;
        if ((bit == 0) && (arr[4] >= 8))
            return -1;

        return 0;
    }


    public static int reverseNumber(int[] arr, int count, int bit) {
        int res = 0;
        for (int i = 0; i < count; i++) {
            System.out.println("Sum " + res);
            res =  (res * 10) + (arr[i]);
            System.out.println("Sum " + res );
        }

        if (bit == 1)
            return (res * -1);
        else
            return (res);
    }

    public static int reverse(int x) {
        int bit;
        int count;
        int []arr;
        int num;
        int ret = 0;

        bit = setBit(x);

        if (bit == 1)
           num =  x * (-1);
        else
            num = x;

        count = setCount(num);

        arr = createArray(num, count );

        if (count == 5)
            ret = checkOverflow(arr, bit);

        if (ret != -1)  {
            ret = reverseNumber(arr, count, bit);
        }

        return ret;
    }


    public static void main(String[] args) {
        int number ;
        Scanner sc = new Scanner(System.in);

        int res;
        System.out.println("Enter the number ");
        number = sc.nextInt();

        res = reverse(number);

        System.out.println("Reverse of " + number + " is " + res);
    }

}