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

    public CharSequence getInitial()
    {
        return Initial;
    }

    public CharSequence getLast()
    {
        return Last;
    }
}
