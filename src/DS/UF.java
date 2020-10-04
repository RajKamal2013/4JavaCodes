package DS;

/**
 * Created by rajkamal on 6/15/18.
 */
public class UF
{
    private int[] id;
    private int[] size;
    private int count;


    public UF(int N)
    {
        count = N;
        id = new int[N];
        size = new int[N];

        for (int i = 0 ;i < N; i++) {
            id[i] = i;
            size[i] = 1;
        }
    }

    public int find(int p)
    {
        while (p!=id[p]) {
            p = id[p];
        }
        return p;
    }

    public boolean connected(int p, int q)
    {
        return (id[p] == id[q]);
    }

    public int count()
    {
        return count;
    }

    public void union(int p, int q)
    {
        int i = find(p);
        int j = find(q);

        if (i == j) return;

        if (size[i] > size[j])
        {
            id[j] = id[i];
            size[i] = size[i] + size[j];
        } else {
            id[i] = id[j];
            size[j] = size[j] + size[i];
        }
        count--;
    }

}
