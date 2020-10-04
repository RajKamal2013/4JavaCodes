package List;
import java.util.Scanner;

/**
 * Created by rajkamal on 12/3/16.
 */
public class DoubleLinkedList_test
{

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
        DoubleLinkedList list = new DoubleLinkedList();
        Scanner sc = new Scanner(System.in);
        DLLNode node;
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
                    list.insert_head(data);
                    break;
                case 3:
                    System.out.println("Enter the data to Insert");
                    data = sc.nextInt();
                    list.insert_tail(data);
                    break;
                case 4:
                    System.out.println("Enter the postion and data to Insert");
                    position = sc.nextInt();
                    data = sc.nextInt();
                    list.insert(data, position);
                    break;
                case 5:
                    data = list.remove_head();
                    break;
                case 6:
                    data = list.remove_Tail();
                    break;
                case 7:
                    System.out.println("Enter the data to remove ");
                    data = sc.nextInt();
                    node = list.search(data);
                    if (node == null)
                        System.out.println("Data not present");
                    list.remove_Matched(node);
                    break;
                case 8:
                    System.out.println("Enter the postion of data to remove ");
                    position = sc.nextInt();
                    list.remove(position);
                    break;
                case 9:
                    System.out.println("Enter the data to search ");
                    data = sc.nextInt();
                    node = list.search(data);
                    if(node != null) {
                        System.out.println("Data Found" );
                    }else
                        System.out.println("Data not found");
                    break;
                case 10:
                    System.out.println("Length of list : " + list.length);
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
