package theunderground.com.ucrmap;

/**
 * Created by Dharti on 5/2/2016.
 */
public class ScheduleModel {
    private String title;
    private String days;
    private String times;

    public ScheduleModel(String title, String days, String times) {

        this.title = title;
        this.days = days;
        this.times = times;
    }
    // getters & setters
    public CharSequence getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public CharSequence getdays() {
        return days;
    }

    public CharSequence getTimes() {
        return times;
    }
}
