package theunderground.com.ucrmap;

/**
 * Created by sarahu on 7/21/16.
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DiningHoursList {
    public static HashMap<String, List<String>> getData() {
        HashMap<String, List<String>> expandableListDetail = new HashMap<String, List<String>>();

        List<String> ai = new ArrayList<String>();
        ai.add("Monday-Friday\n" +
                "Breakfast: 7:15AM-10:30AM\n" +
                "Lunch: 10:30AM-2:30PM\n" +
                "Dinner: 10:30AM-2:30PM \n\n" +
                "Closes at 8PM on Friday's\n\n" +
                "Saturday: CLOSED\n\n" +
                "Sunday\n" +
                "Brunch: 10AM-2:30PM\n" +
                "Dinner: 5PM-8:30PM");

        List<String> lothian = new ArrayList<>();
        lothian.add("Monday-Friday\n" +
                "Breakfast: 7:15AM-10:30AM\n" +
                "Lunch: 10:30AM-2:30PM\n" +
                "Dinner: 10:30AM-2:30PM\n\n" +
                "Closes at 8PM on Friday's\n\n" +
                "Sunday: CLOSED");

        List<String> spinelli = new ArrayList<>();
        spinelli.add("Serving up pizza, wings and " +
                "more for late-night dining at Lothian " +
                "Residence Hall.  Delivery, too!\n\n" +
                "Daily\n" +
                "9PM-MIDNIGHT");

        List<String> gmshop = new ArrayList<>();
        gmshop.add("Mercantile, convenience store plus grab 'n' go.\n\n" +
                "Daily\n" +
                "6AM-MIDNIGHT");

        List<String> gmsizzle = new ArrayList<>();
        gmsizzle.add("Burgers, sandwiches, quesadillas, fries, soups and salads.\n\n" +
                "Daily\n" +
                "10:30AM-MIDNIGHT");

        List<String> gmsavor = new ArrayList<>();
        gmsavor.add("Home-style meals and gourmet salads.\n\n" +
                "Monday-Friday\n" +
                "10:30AM-9PM\n\n" +
                "Sunday\n" +
                "4:30PM-9PM");

        List<String> gmstarbucks = new ArrayList<>();
        gmstarbucks.add("Gourmet coffees, espresso drinks, snacks and more. OPEN FOR BREAKFAST!\n\n" +
                "Daily\n" +
                "6AM-MIDNIGHT");

        List<String> hubscot = new ArrayList<>();
        hubscot.add("Campus convenience store.\n\n" +
                "Monday-Thursday\n" +
                "7AM-7PM\n\n" +
                "Friday\n" +
                "7AM-5PM");

        List<String> aiscot = new ArrayList<String>();
        aiscot.add("Campus convenience store.\n\n" +
                "Daily\n" +
                "11AM-2AM");

        List<String> lothianscot = new ArrayList<String>();
        lothianscot.add("Campus convenience store.\n\n" +
                "Daily\n" +
                "4:30PM-2AM");

        List<String> gmscot = new ArrayList<String>();
        gmscot.add("Campus convenience store.\n\n" +
                "Daily\n" +
                "10AM-2AM\n\n" +
                "Sunday\n" +
                "4:30AM-2AM");

        List<String> medscot = new ArrayList<String>();
        medscot.add("Campus convenience store.\n\n" +
                "Monday-Friday\n" +
                "8AM-5PM");

        List<String> barn = new ArrayList<String>();
        barn.add("OPEN FOR BREAKFAST!\n" +
                "Plus burgers, chicken strips, " +
                "chilli-cheese fries, and onion rings.\n\n" +
                "Monday-Thursday\n" +
                "8AM-8PM\n\n" +
                "Friday\n" +
                "8AM-5PM");

        List<String> bytes = new ArrayList<>();
        bytes.add("Coffee, expresso drinks, flatbread, " +
                "sandwiches, and more\n\n" +
                "Monday-Friday\n" +
                "8AM-5PM");

        List<String> ivan = new ArrayList<>();
        ivan.add("Coffee, pastries, expresso drinks, " +
                "salads, sandwiches, and snacks\n\n" +
                "Monday-Friday\n" +
                "7:30AM-54PM");

        List<String> subway = new ArrayList<>();
        subway.add("Hot and cold sandwiches, plus catering specials!\n\n" +
                "Monday-Thursday\n" +
                "7:30AM-10PM\n\n" +
                "Friday\n" +
                "7:30AM-7PM\n\n" +
                "Saturday\n" +
                "10AM-2PM\n\n" +
                "Sunday\n" +
                "11Am-8PM");

        List<String> habanero = new ArrayList<>();
        habanero.add("Fresh and healthy Mexican food.\n\n" +
                "Monday-Friday\n" +
                "10:30AM-3:30PM");

        List<String> hub = new ArrayList<>();
        hub.add("Perfect platters for office gatherings." +
                "  Order via HUB2Go.ucr.edu\n\n" +
                "Monday-Thursday\n" +
                "7:30AM-6PM\n\n" +
                "Friday\n" +
                "7:30AM-5PM");

        List<String> panda = new ArrayList<>();
        panda.add("Serving fresh and fast Chinese food.\n\n" +
                "Monday-Thursday\n" +
                "9:30AM-6PM\n\n" +
                "Friday\n" +
                "9:30AM-3:30PM");

        List<String> pandasushi = new ArrayList<>();
        pandasushi.add("Fresh gourmet sushi served daily.\n\n" +
                "Monday-Thursday\n" +
                "10AM-6PM\n\n" +
                "Friday\n" +
                "10AM-3:30PM");

        List<String> fiamma = new ArrayList<>();
        fiamma.add("Traditional hearth-baked style " +
                "pizza, freshly made pasta and entree salads.\n\n" +
                "Monday-Friday\n" +
                "10:30AM-3:30PM");

        List<String> grill = new ArrayList<String>();
        grill.add("OPEN FOR BREAKFAST!\n" +
                "Plus classic burgers, salads, and entrees " +
                "Indoor or on the patio\n\n" +
                "Monday-Friday\n" +
                "7:30AM-3PM");

        List<String> coffeebean = new ArrayList<>();
        coffeebean.add("Hand-crafted beverages from " +
                "espresso drinks to rich coffees.\n\n" +
                "Monday-Thursday\n" +
                "7AM-9PM\n\n" +
                "Friday\n" +
                "7AM-7PM");

        List<String> chameleon = new ArrayList<>();
        chameleon.add("Burritos, tacos, and more!\n\n" +
                "Monday, Wednesday, Friday\n" +
                "11AM-2PM\n" +
                "Location: Physics 2000\n\n" +
                "Tuesday, Thursday\n" +
                "11AM-2PM\n" +
                "Location: Olmstead Hall\n\n" +
                "Sunday-Thursday\n" +
                "2:30PM-11PM\n" +
                "Location: AI, Lot 22");

        List<String> moomoo = new ArrayList<>();
        moomoo.add("Soft-serve desserts!\n\n" +
                "Monday-Thursday\n" +
                "12PM-2PM\n" +
                "Location: Rivera Library\n" +
                "11AM-2PM\n" +
                "Location: Olmstead Hall\n\n" +
                "Friday\n" +
                "12PM-2PM\n" +
                "Location: Rivera Library");

        List<String> highlander = new ArrayList<>();
        highlander.add("Burgers, hot dogs, and more!\n\n" +
                "Monday, Wednesday, Friday\n" +
                "11:30AM-2PM\n" +
                "Location: Olmstead Hall\n\n" +
                "Tuesday, Thursday\n" +
                "11:30AM-2PM\n" +
                "Location: Physics 2000");

        List<String> beartracks = new ArrayList<>();
        beartracks.add("Hot coffee, expresso drinks, pastries, and more!\n\n" +
                "Monday-Thursday\n" +
                "8AM-2PM\n" +
                "Location: Physics 2000\n" +
                "3PM-5PM\n" +
                "Location: South Sproul Hall\n\n" +
                "Friday\n" +
                "8AM-2PM\n" +
                "Location: Physics 2000");

        expandableListDetail.put("AI", ai);
        expandableListDetail.put("Lothian", lothian);
        expandableListDetail.put("Spinelli's", spinelli);
        expandableListDetail.put("Glen Mor Market Shop", gmshop);
        expandableListDetail.put("Glen Mor Market Sizzle", gmsizzle);
        expandableListDetail.put("Glen Mor Market Savor", gmsavor);
        expandableListDetail.put("Glen Mor Market Starbucks", gmstarbucks);
        expandableListDetail.put("HUB Scotty's", hubscot);
        expandableListDetail.put("AI Scotty's", aiscot);
        expandableListDetail.put("Lothian Scotty's", lothianscot);
        expandableListDetail.put("Glen Mor Scotty's", gmscot);
        expandableListDetail.put("School of Medicine Scotty's", medscot);
        expandableListDetail.put("The Barn", barn);
        expandableListDetail.put("Bytes", bytes);
        expandableListDetail.put("Ivan's", ivan);
        expandableListDetail.put("Subway", subway);
        expandableListDetail.put("Habanero's", habanero);
        expandableListDetail.put("HUB2GO", hub);
        expandableListDetail.put("Panda Express", panda);
        expandableListDetail.put("Panda Express Sushi", pandasushi);
        expandableListDetail.put("La Fiamma", fiamma);
        expandableListDetail.put("The Grill", grill);
        expandableListDetail.put("Coffee Bean", coffeebean);
        expandableListDetail.put("Chameleon", chameleon);
        expandableListDetail.put("Moo Moo", moomoo);
        expandableListDetail.put("Highlander", highlander);
        expandableListDetail.put("Bear Tracks", beartracks);
        return expandableListDetail;
    }
}