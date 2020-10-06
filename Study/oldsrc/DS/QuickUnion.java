package DS;

/**
 * Created by rajkamal on 6/15/18.
 */
public class QuickUnion {
    int count;
    int id[];

    public QuickUnion(int N)
    {
        count = N;
        id = new int[N];
        for (int i = 0; i < N; i++)
        {
            id[i] = i;
        }
    }

    public int count()
    {
        return count;
    }

    public int find(int p)
    {
        while(p!=id[p])
        {
            p = id[p];
        }
        return p;
    }

    public boolean connected(int p, int q)
    {
        return (find(p) == find(q));
    }

    public void union(int p, int q)
    {
        int pid = find(p);
        int qid = find(q);

        if (pid == qid)
            return;

        id[pid] = qid;
        count--;
    }

}