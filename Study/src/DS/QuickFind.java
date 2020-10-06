package DS;

/**
 * Created by rajkamal on 6/15/18.
 */
public class QuickFind {
    private int count;
    private int[] id;

    public QuickFind(int N)
    {
        count = N;
        id = new int[N];
    }

    public int count()
    {
        return count;
    }

    public int find(int p)
    {
        return id[p];
    }

    public boolean connected(int p, int q)
    {
        return (id[p] == id[q]);
    }
    public void union(int p, int q) {
        if (connected(p, p)) return;
        int pid = find(p);

        for (int i = 0; i < id.length; i++) {
            if (id[i] == pid) {
                id[i] = id[q];
            }
        }
        count--;
    }
}
