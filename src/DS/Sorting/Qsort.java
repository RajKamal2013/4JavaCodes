package DS.Sorting;

import java.util.Vector;

public class Qsort
{
    Vector<Integer> arr;
    int size;

    Qsort(Vector<Integer> arr, int k) {
        this.size = size;
        this.arr = arr;
    }

    void swap(int x, int y) {
        int temp = arr.get(x);
        arr.set(x, arr.get(y));
        arr.set(y, temp);
    }

    int partition(int start, int end) {
            int pivot = arr.get(end);
            int j = start - 1;
            int i = start;

            while(i < end) {
                if (arr.get(i) < pivot) {
                    j = j + 1;
                    swap(i, j);
                }
                i = i + 1;
            }
            j = j + 1;
            swap(j, end);
            return j;
    }

     Vector<Integer> run() {
        QuickSort(0, arr.size() - 1);
        return arr;
    }

    void QuickSort(int start, int end) {
        int pivot;
        if (start < end) {
            pivot = partition(start, end);
            QuickSort(start, pivot -1);
            QuickSort(pivot + 1, end);
        }
    }
}
