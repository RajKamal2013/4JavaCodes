

package List;

import java.util.Scanner;

/**
 * Created by rajkamal on 12/5/16.
 */
public class LinkedList_test {

        public static void display_usage() {
            System.out.println("Enter 0  for  Usage Details");
            System.out.println("Enter 1  for  Display");
            System.out.println("Enter 2  for  Insert At Begin");
            System.out.println("Enter 3  for  Insert At End");
            System.out.println("Enter 4  for  Insert At postion");
            System.out.println("Enter 5  for  Remove At Begin");
            System.out.println("Enter 6  for  Remove At End");
            System.out.println("Enter 7  for  Remove Data");
            System.out.println("Enter 8  for  Remove data at postion ");
            System.out.println("Enter 9  for  Search ");
            System.out.println("Enter 10 for  Length ");
            System.out.println("Enter 11 for  Postion of Data ");
            System.out.println("Enter 12 for  clearing the List");
            System.out.println("Enter 13 to end the program ");
        }
        public static void main(String[] args) {
            int option, data, position;
            LinkedList list = new LinkedList();
            Scanner sc = new Scanner(System.in);
            ListNode node;
            display_usage();
            do {
                option = sc.nextInt();
                switch(option) {
                    case 0:
                        display_usage();
                        break;
                    case 1:
                        System.out.println("List : ");
                        System.out.println(list.toString());
                        break;
                    case 2:
                        System.out.println("Enter the data to Insert");
                        data = sc.nextInt();
                        node = new ListNode(data);
                        list.insertAtBegin(node);
                        break;
                    case 3:
                        System.out.println("Enter the data to Insert");
                        data = sc.nextInt();
                        node = new ListNode(data);
                        list.insertAtEnd(node);
                        break;
                    case 4:
                        System.out.println("Enter the postion and data to Insert");
                        position = sc.nextInt();
                        data = sc.nextInt();
                        list.insert(data, position);
                        break;
                    case 5:
                        node = list.removeFromBegin();
                        break;
                    case 6:
                        node = list.removeFromEnd();
                        break;
                    case 7:
                        System.out.println("Enter the data to remove ");
                        data = sc.nextInt();
                        node = new ListNode(data);
                        list.removeMatched(node);
                        break;
                    case 8:
                        System.out.println("Enter the postion of data to remove ");
                        position = sc.nextInt();
                        list.remove(position);
                        break;
                    case 9:
                        System.out.println("Enter the data to search ");
                        data = sc.nextInt();
                        position = list.search(data);
                        if (position != -1) {
                            System.out.println("Data Found at position : " + position);
                        }else
                            System.out.println("Data not found");
                        break;
                    case 10:
                        System.out.println("Length of list : " + list.length());
                        break;
                    case 11:
                        System.out.println("Enter the data ");
                        data= sc.nextInt();
                        position = list.getPosition(data);
                        System.out.println("Position of the data is " + position);
                        break;
                    case 12:
                        list.clearList();
                        break;
                    case 13:
                        break;
                    default:
                        System.out.println("Invalid Option ");
                        display_usage();
                        break;
                }
            } while (option != 13);
        }
}


