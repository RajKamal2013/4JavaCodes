package List;

/**
 * Created by rajkamal on 12/6/16.
 */
public class List_Middle {
    public static void main(String[] args) {
        LinkedList list1 = new LinkedList();
        LinkedList list2 = new LinkedList();
        ListNode node, node1, node2;
        int data;
        int[] arr1  = {23, 34, 56, 78, 99, 67, 88, 100, 45, 68};
        int[] arr2 = {23, 34, 56, 78, 99, 67, 88, 100, 45};
        for (int i = 0; i < arr1.length; i++) {
            node = new ListNode(arr1[i]);
            list1.insertAtEnd(node);
        }
        for (int i = 0; i < arr2.length; i++) {
            node = new ListNode(arr2[i]);
            list2.insertAtEnd(node);
        }

        System.out.println(list1.toString());
        System.out.println(list2.toString());

        System.out.println("Displaying both list from reverse");
        list1.print_list_from_end(list1.getHead());
        System.out.println();
        list2.print_list_from_end(list2.getHead());
        System.out.println();

        System.out.println("Finding Middle of the list 1");
        data = list1.Find_Middle(list1.getHead());
        System.out.println("Middle Element of the List 1 " + data);

        System.out.println("Finding Middle of the list 2");
        data = list2.Find_Middle(list2.getHead());
        System.out.println("Middle Element of the List 2 " + data);

        System.out.println("Checking for Even or odd ");
        System.out.println("List1 is " + list1.IsEven());
        System.out.println("List2 is " + list2.IsEven());


    }
}
