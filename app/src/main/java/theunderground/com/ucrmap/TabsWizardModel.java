package theunderground.com.ucrmap;

/**
 * Created by Sara on 5/1/16.
 */
public class TabsWizardModel {
    private String title;
    private int imageUrl;

    public TabsWizardModel(String title, int imageUrl) {

        this.title = title;
        this.imageUrl = imageUrl;
    }
    // getters & setters
    public CharSequence getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public int getImageUrl() {
        return imageUrl;
    }
    public void setImageUrl( int imageUrl) {
        this.imageUrl = imageUrl;
    }
}
