package List;
import java.util.Scanner;

/**
 * Created by rajkamal on 12/5/16.
 */
public class CircularLinkedList_test {

    public static void display_usage() {
        System.out.println("Enter 0  for  Usage Details");
        System.out.println("Enter 1  for  Display");
        System.out.println("Enter 2  for  Insert At Begin");
        System.out.println("Enter 3  for  Insert At End");
        System.out.println("Enter 4  for  Remove At Begin");
        System.out.println("Enter 5  for  Remove At End");
        System.out.println("Enter 6  for  Remove Data");
        System.out.println("Enter 7  for  Search ");
        System.out.println("Enter 8 for  Length ");
        System.out.println("Enter 9 for  clearing the List");
        System.out.println("Enter 10 to end the program ");
    }

    public static void formatting() {
        System.out.println("<--------------------------------------------------------------------------------------->");
    }
    public static void main(String[] args) {
        int option, data, position;
        CircularLinkedList list = new CircularLinkedList();
        Scanner sc = new Scanner(System.in);
        CLLNode node;
        display_usage();
        do {
            option = sc.nextInt();
            switch(option) {
                case 0:
                    display_usage();
                    formatting();
                    break;
                case 1:
                    System.out.println("List : ");
                    System.out.println(list.toString());
                    formatting();
                    break;
                case 2:
                    System.out.println("Enter the data to Insert");
                    data = sc.nextInt();
                    list.add_to_head(data);
                    formatting();
                    break;
                case 3:
                    System.out.println("Enter the data to Insert");
                    data = sc.nextInt();
                    list.add_To_Tail(data);
                    formatting();
                    break;
                case 4:
                    data = list.remove_from_Head();
                    formatting();
                    break;
                case 5:
                    data = list.remove_from_Tail();
                    formatting();
                    break;
                case 6:
                    System.out.println("Enter the data to remove ");
                    data = sc.nextInt();
                    list.remove(data);
                    formatting();
                    break;
                case 7:
                    System.out.println("Enter the data to search ");
                    data = sc.nextInt();
                    System.out.println(list.contains(data));
                    formatting();
                    break;
                case 8:
                    System.out.println("Length of list : " + list.getSize());
                    formatting();
                    break;
                case 9:
                    list.clean();
                    formatting();
                    break;
                case 10:
                    formatting();
                    break;
                default:
                    System.out.println("Invalid Option ");
                    display_usage();
                    formatting();
                    break;
            }
        } while (option != 10);
    }
}
