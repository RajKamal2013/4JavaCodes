package Queue;

import List.LinkedQueue;
import Queue.FixedSizeQueue;

/**
 * Created by rajkamal on 12/8/16.
 */
public class Queue_Test {

    public static void test() {
        FixedSizeQueue queue = new FixedSizeQueue();
        int data = 0, peek = 0, size = 0;
        int []arr = {1, 2, 3,  4, 5, 6, 7};

        for (int i = 0; i < arr.length; i++) {
            try {
                queue.enQueue(arr[i]);
            } catch (IllegalStateException ex) {
                System.out.println("Queue Full");
            }
        }

        System.out.println("Fixed Size Queue ");
        System.out.println("Queue Representation ");
        System.out.println(queue.toString());

        try {
            data = queue.deQueue();
        }catch (IllegalStateException ex) {
            System.out.println("Queue is empty");
        }

        System.out.println("Queue Representation ");
        System.out.println(queue.toString());



        System.out.println("Linked Queue  ");
        LinkedQueue LQueue = new LinkedQueue();
        for (int i = 0; i < arr.length; i++) {

            LQueue.enqueue(arr[i]);
        }


        System.out.println("Queue Representation ");
        System.out.println(LQueue.toString());

        try {
            data = LQueue.dequeue();
        }catch (Exception ex) {
            System.out.println("Queue is empty");
        }

        System.out.println("Queue Representation ");
        System.out.println(LQueue.toString());


    }


    public static  void main(String[] args) {
        test();
    }
}