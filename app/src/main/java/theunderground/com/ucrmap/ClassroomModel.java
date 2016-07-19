package theunderground.com.ucrmap;

/**
 * Created by Roger on 5/26/2016.
 */
public class ClassroomModel {
    private String Comment;

    public ClassroomModel(String comment)
    {
        this.Comment = comment;
    }

    public CharSequence getComment()
    {
        return Comment;
    }

}
