package theunderground.com.ucrmap;

/**
 * Created by Larry Parsons on 6/26/2015.
 */
public class TabsServiceModel {

    private String title;
    private String description;

    public TabsServiceModel(String title, String description) {

        this.title = title;
        this.description = description;
    }
    // getters & setters
    public CharSequence getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public CharSequence getDescription() {
        return description;
    }
    public void setDescription( String description) {
       this.description = description;
    }

}