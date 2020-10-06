package Heap;
/**
 * Created by rajkamal on 12/17/16.
 */
public class Heap {
    public int[] Arr;
    public int Count;
    public int Capacity;
    public int Heap_type;

    // 0 -> Min Heap
    // 1 -> Max Heap

    public Heap(int Capacity, int Heap_type) {
        this.Capacity = Capacity;
        this.Count = 0;
        this.Heap_type = Heap_type;
        this.Arr = new int[Capacity];
    }

    public int Parent(int i) {
        if ( i <= 0 || i >= this.Count)
            return -1;

        return (i - 1)/2;
    }

    public int LeftChild(int i) {
        int left = 2 * i + 1;

        if (left >= this.Count)
            return  -1;

        return  left;
    }


    public int RightChild(int i ) {
        int right = 2 * i + 2;
        if (right >= this.Count)
            return  -1;
        return right;
    }

    public void Percolate_Down(int i) {
        int left, right, max, min, temp;
        left = LeftChild(i);
        right = RightChild(i);
        max = min = -1;

        // Max Heap
        if (this.Heap_type == 1) {
            if ((left != -1)&&(this.Arr[i] < this.Arr[left])){
                max = left;
            }
            else{
                max = i;
            }

            if ((right != -1) && (this.Arr[max] < this.Arr[right])) {
                max = right;
            }

            if (max != i) {
                temp = this.Arr[max];
                this.Arr[max] = this.Arr[i];
                this.Arr[i] = temp;
                Percolate_Down(max);
            }
        }



        if (this.Heap_type == 0) {
            if ((left != -1) && (this.Arr[i] > this.Arr[left])) {
                min = left;
            }else{
                min = i;
            }

            if ((right != -1) && (this.Arr[min] > this.Arr[right])) {
                min = right;
            }

            if (min != i) {
                temp = this.Arr[min];
                this.Arr[min] = this.Arr[i];
                this.Arr[i] = temp;
                Percolate_Down(min);
            }
        }
    }

    public int Delete_Max() {
        if (this.Count == 0)
            return  Integer.MIN_VALUE;

        int data = this.Arr[0];
        this.Arr[0] = this.Arr[this.Count - 1];
        this.Count = this.Count--;
        Percolate_Down(0);
        return  data;
    }

    public int Delete_Min() {
        if (this.Count == 0)
            return  Integer.MIN_VALUE;

        int data = this.Arr[0];
        this.Arr[0] = this.Arr[this.Count - 1];
        this.Count = this.Count--;
        Percolate_Down(0);
        return  data;

    }

    public int GetMaximum() {
        if(this.Count == 0)
            return Integer.MIN_VALUE;

        return this.Arr[0];
    }

    public int GetMinimum() {
        if(this.Count == 0)
            return Integer.MIN_VALUE;

        return this.Arr[0];
    }

    public void insert(int data) {
        int i;

        if (this.Count == this.Capacity)
            this.Resize();

        this.Count++;

        i = Count - 1;

        if (this.Heap_type == 1) {
            while (i >= 0 && data > this.Arr[(i-1)/2]) {
                this.Arr[i] = this.Arr[(i-1)/2];
                i = (i - 1)/2;
            }
            this.Arr[i] = data;
        }

        if (this.Heap_type == 0 ) {
            while (i >= 0 && data < this.Arr[(i-1)/2]) {
                this.Arr[i] = this.Arr[(i-1)/2];
                i = (i - 1)/2;
            }
            this.Arr[i] = data;
        }
    }

    public void Resize() {
        int []Arr_Old = new int[this.Capacity];

        for (int i = 0; i < this.Capacity; i++) {
            Arr_Old[i] = this.Arr[i];
        }

        //System.arraycopy(this.Arr, 0, Arr_Old, 0, this.Count - 1);
        this.Arr = new int[this.Capacity * 2];


        for (int i = 0; i < this.Capacity; i++) {
            this.Arr[i] = Arr_Old[i];
        }

        this.Capacity = this.Capacity * 2;
        Arr_Old = null;
    }

    public void DestroyHeap() {
        this.Count = 0;
        this.Arr = null;
    }

    public Heap BuildHeap(Heap h, int[]A, int n) {

        if (h == null) {
            return null;
        }

        while(n > this.Capacity)
            h.Resize();

        for (int i = 0; i < n; i++) {
            h.Arr[i] = A[i];
        }

        this.Capacity = n;
        this.Count = this.Count + n;

        for (int i = (n-1)/2; i >= 0; i--)
            h.Percolate_Down(i);

        return h;
    }

    public void display() {
        for (int i = 0; i < this.Count; i++) {
            System.out.print(this.Arr[i] + " ");
        }

        System.out.println();
    }

}


