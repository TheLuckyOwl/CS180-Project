package theunderground.com.ucrmap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by sarahu on 7/28/16.
 */
public class FriendList {
    public static HashMap<String, List<String>> getData() {
        HashMap<String, List<String>> expandableListDetail = new HashMap<String, List<String>>();

        List<String> orbach = new ArrayList<String>();
        orbach.add("Monday-Thursday:\n" +
                "7:30AM-12AM\n\n" +
                "Friday:\n" +
                "7:30AM-6PM\n\n" +
                "Saturday:\n" +
                "9AM-5PM\n\n" +
                "Sunday:\n" +
                "1PM-12AM");

        List<String> rivera = new ArrayList<>();
        rivera.add("Monday-Thursday:\n" +
                "7:30AM-12AM\n\n" +
                "Friday:\n" +
                "7:30AM-6PM\n\n" +
                "Saturday:\n" +
                "9AM-5PM\n\n" +
                "Sunday:\n" +
                "1PM-12AM");

        List<String> src = new ArrayList<>();
        src.add("Monday-Thursday:\n" +
                "6AM-12AM\n\n" +
                "Friday:\n" +
                "6AM-9PM\n\n" +
                "Saturday:\n" +
                "9AM-9PM\n\n" +
                "Sunday:\n" +
                "9AM-12AM");

        List<String> bookstore = new ArrayList<>();
        bookstore.add("Monday-Friday:\n" +
                "8AM-6AM\n\n" +
                "Saturday:\n" +
                "9AM-3PM\n\n" +
                "Sunday:\n" +
                "CLOSED");

        List<String> studentservices = new ArrayList<>();
        studentservices.add("Monday-Friday:\n" +
                "9AM-5PM");

        List<String> botanical = new ArrayList<>();
        botanical.add("Daily:\n" +
                "8AM-5PM");

        expandableListDetail.put("Orbach Library", orbach);
        expandableListDetail.put("Rivera Library", rivera);
        expandableListDetail.put("Student Recreation Center", src);
        expandableListDetail.put("Bookstore", bookstore);
        expandableListDetail.put("Student Services", studentservices);
        expandableListDetail.put("Botanical Gardens", botanical);
        return expandableListDetail;
    }
}
