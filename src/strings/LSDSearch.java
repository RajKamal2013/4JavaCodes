package strings;

/**
 * Created by rajkamal on 3/17/18.
 */
public class LSDSearch {
    String []aux;
    int []count;
    int R = 256;

    public void sort(String[] data, int W) {
        int N = data.length;
        aux = new String[N];
        System.out.println("In Sort :");

        for (int d = W - 1; d >= 0; d-- ) {
            count = new int[R + 1];
            for (int i = 0; i < R; i++) {
                count[i] = 0;
            }
            for (int i = 0; i < N; i++) {
                count[data[i].charAt(d) + 1]++;
            }
            for (int r = 0; r < R ; r++) {
                count[r + 1] += count[r];
            }
            for (int i = 0 ; i < N; i++) {
                aux[count[data[i].charAt(d)]] = data[i];
                count[data[i].charAt(d)]++;
            }
            for (int i =0; i < N; i++ ) {
                data[i] = aux[i];
            }

        }
    }
}
