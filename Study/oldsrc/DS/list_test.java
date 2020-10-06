package DS;

/**
 * Created by rajkamal on 6/13/18.
 */
public class list_test {
    public static void main(String[] args) {

        List<Integer> list = new List<>();
        for (int i = 0; i < 20; i++) {
            list.append(i);
        }
        System.out.println(list.toString());

        for (int in : list) {
            System.out.print(in + " ");
        }
        System.out.println();

        list.reverse();
        System.out.println(list.toString());
    }
}
