package DS;

/**
 * Created by rajkamal on 6/12/18.
 */
public class player implements Comparable <player>
{
    private int rank;
    private String name;


    public player(int rank, String name)
    {
        this.rank = rank;
        this.name = name;
    }

    public int get_rank()
    {
        return this.rank;
    }
    public String getName() {
        return this.name;
    }

    public int compareTo(player play1)
    {
        return (this.rank  - play1.get_rank());
    }

}
