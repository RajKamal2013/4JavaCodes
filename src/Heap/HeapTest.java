package Heap;

public class HeapTest {

    public static void display(int []arr) {
        for (int data:arr) {
            System.out.print(data + " ");
        }
        System.out.println();
    }

    public static void HeapSort(int[] A, int n) {
        Heap h1 = new Heap(n, 1);

        int old_size, i, temp;
        old_size = n;

        h1 = h1.BuildHeap(h1, A, n);

        for (i = n-1; i > 0; i--) {
            temp= h1.Arr[0];
            h1.Arr[0] = h1.Arr[h1.Count - 1];
            h1.Arr[h1.Count - 1] = temp;
            h1.Count--;
            h1.Percolate_Down(0);
        }
        h1.Count = old_size;
        h1.display();


    }

    public static void test() {

        int []arr = {23, 45, 10, 5, 87, 90, 68, 54, 66,100};

        int []arr1 = {90, 34, 56, 78};


        display(arr);

        Heap h1 = new Heap(arr.length, 1);
        h1 = h1.BuildHeap(h1, arr, arr.length);
        Heap h2 = new Heap(arr.length, 0);
        h2 = h2.BuildHeap(h2, arr, arr.length);

        for (int i = 0; i < arr1.length; i++ ) {
            h1.insert(arr1[i]);
            h2.insert(arr1[i]);
        }


        System.out.println("Max heap");
        h1.display();
        System.out.println("Max " + h1.GetMaximum());
        System.out.println("Min Heap");
        h2.display();
        System.out.println("Min  " + h2.GetMinimum());

        System.out.println("heap Sort");
        HeapSort(arr, arr.length);


    }

    public  static  void main(String [] args) {

        test();
    }
}

