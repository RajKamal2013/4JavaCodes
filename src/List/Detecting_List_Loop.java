package List;

/**
 * Created by rajkamal on 12/6/16.
 */
public class Detecting_List_Loop {

    public static boolean Floyd_Cycle(ListNode head) {
        ListNode fast_ptr, slow_ptr;
        fast_ptr = head;
        slow_ptr = head;

        while((fast_ptr != null) && (fast_ptr.getNext()!= null)) {
            fast_ptr = fast_ptr.getNext().getNext();
            slow_ptr = slow_ptr.getNext();
            if (fast_ptr == slow_ptr)
                return true;
        }

        return false;
    }

    public static ListNode find_Begin_Loop(ListNode head) {
        boolean loop_exist = false;
        ListNode fast_ptr, slow_ptr;
        fast_ptr = head;
        slow_ptr = head;

        while((fast_ptr != null) && (fast_ptr.getNext()!= null)) {
            fast_ptr = fast_ptr.getNext().getNext();
            slow_ptr = slow_ptr.getNext();
            if (fast_ptr == slow_ptr) {
                loop_exist = true;
                break;
            }
        }
        if (loop_exist) {
           slow_ptr = head;
            while (slow_ptr != fast_ptr) {
                slow_ptr = slow_ptr.getNext();
                fast_ptr = fast_ptr.getNext();
            }
            return fast_ptr;
        } else
            return null;
    }

    public static int Length_of_the_loop(ListNode head ) {
        ListNode fast_ptr, slow_ptr;
        fast_ptr = head;
        slow_ptr = head;
        boolean loop_exist = false;

        while ((fast_ptr != null) && (fast_ptr.getNext() != null)) {
            fast_ptr = fast_ptr.getNext().getNext();
            slow_ptr = slow_ptr.getNext();
            if (fast_ptr == slow_ptr) {
                loop_exist = true;
                break;
            }
        }

        if (loop_exist) {
            int length = 0;
            fast_ptr = fast_ptr.getNext();
            length++;

            while (fast_ptr != slow_ptr) {
                fast_ptr = fast_ptr.getNext();
                length++;
            }
            return length;
        } else return (Integer.MIN_VALUE);

    }

    public static void main(String [] args) {
        LinkedList list = new LinkedList();
        ListNode node, node1, node2;
        int []arr = {23, 34, 56, 78, 99, 67, 88, 100, 45, 68};
        for(int i = 0; i < arr.length; i++) {
            node = new ListNode(arr[i]);
            list.insertAtEnd(node);
        }

        System.out.println(list.toString());


        System.out.println("Joining 99 and 67 to create loop");
        node1 = list.getNode(99);
        node2 = list.getNode(68);

        if ((node1 != null) && (node2 != null)) {
            node2.setNext(node1);
        }
        // enter the elements and call the API
        if ( Floyd_Cycle(list.getHead()))
            System.out.println("yes");
        else
            System.out.println("No");


        if ((node = find_Begin_Loop(list.getHead())) != null) {
            System.out.println("Beginning of the Loop :" + node.getData());
        } else {
            System.out.println("no Loop Exist");
        }

        System.out.println("Length of the Loop " + Length_of_the_loop(list.getHead()));
    }
}
