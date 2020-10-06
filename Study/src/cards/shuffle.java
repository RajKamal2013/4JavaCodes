package cards;

/**
 * Created by rajkamal on 6/13/18.
 */
public class shuffle
{
        public void API(String str)
        {
            String arr[] = str.split(" ");
            int N = arr.length;
            String swp;

            for (int i = 0;i < N; i++) {
                System.out.print(arr[i] + " ");
            }

            for (int i = 0; i < N; i++ ) {
                int r = i + (int) (Math.random() * (N - i));
                swp = arr[i];
                arr[i] = arr[r];
                arr[r] = swp;
            }

            System.out.println();

            for (int i = 0;i < N; i++) {
                System.out.print(arr[i] + " ");
            }

        }

}
