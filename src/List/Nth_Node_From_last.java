package List;

import List.LinkedList;
import List.ListNode;

import java.util.Scanner;

/**
 * Created by rajkamal on 12/5/16.
 */
public class Nth_Node_From_last {
    public static int find_node (LinkedList list, int n) {
        ListNode pTemp = list.getHead(), pNthNode=null;

        for (int i = 1; i < n; i++ ) {
            if (pTemp != null)
                pTemp = pTemp.getNext();
        }

        while(pTemp != null) {
            if(pNthNode == null)
                pNthNode = list.getHead();
            else
                pNthNode = pNthNode.getNext();

            pTemp = pTemp.getNext();
        }

        if(pNthNode != null)
            return pNthNode.getData();

        return Integer.MIN_VALUE;

    }

    public static void main (String[]args) {
        int count, n, data;
        Scanner sc = new Scanner(System.in);
        LinkedList list = new LinkedList();
        ListNode node;
        System.out.println("Enter the count");
        count = sc.nextInt();

        System.out.println("Enter the Digits :");
        for (int i = 0; i < count; i++) {
            data = sc.nextInt();
            list.insertAtEnd(new ListNode(data));
        }

        list.toString();

        System.out.println("Enter the nth count from end");
        n = sc.nextInt();

        data = find_node(list, n);

        System.out.println("Node from " + n +"th position is " + data);
    }
}