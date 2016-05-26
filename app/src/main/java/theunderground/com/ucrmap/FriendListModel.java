package theunderground.com.ucrmap;

/**
 * Created by Roger on 5/26/2016.
 */
public class FriendListModel {
    private String First;
    private String Initial;
    private String Last;

    public FriendListModel(String first, String initial, String last)
    {
        this.First = first;
        this.Initial = initial;
        this.Last = last;
    }

    public CharSequence getFirst()
    {
        return First;
    }

    public void setFirst(String firstName)
    {
        this.First = firstName;
    }

    public CharSequence getInitial()
    {
        return Initial;
    }

    public void setInital(String initial)
    {
        this.Initial = initial;
    }

    public CharSequence getLast()
    {
        return Last;
    }

    public void setLast(String last)
    {
        this.Last = last;
    }
}
