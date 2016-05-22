package theunderground.com.ucrmap;

import android.os.AsyncTask;

import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

/**
 * Created by Roger on 5/18/2016.
 */
public class GetClassroomAsyncTask extends AsyncTask<Classroom, Void, ArrayList<Classroom>> {
    static BasicDBObject user = null;
    static String OriginalObject = "";
    static String server_output = null;

    ClassRoomQueryBuilder qb = new ClassRoomQueryBuilder();
    static String temp_output = null;

    @Override
    protected ArrayList<Classroom> doInBackground(Classroom ... arg0) {
        ArrayList<Classroom> Class = new ArrayList<Classroom>();
        try
        {
            URL url = new URL(qb.buildContactsGetURL());
            HttpURLConnection conn = (HttpURLConnection) url
                    .openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");

            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + conn.getResponseCode());
            }

            BufferedReader br = new BufferedReader(new InputStreamReader(
                    (conn.getInputStream())));

            while ((temp_output = br.readLine()) != null) {
                server_output = temp_output;
            }

            // create a basic db list
            String mongoarray = "{ artificial_basicdb_list: "+server_output+"}";
            Object o = com.mongodb.util.JSON.parse(mongoarray);


            DBObject dbObj = (DBObject) o;
            BasicDBList contacts = (BasicDBList) dbObj.get("artificial_basicdb_list");

            for (Object obj : contacts) {
                DBObject userObj = (DBObject) obj;
                Classroom temp = new Classroom();
                temp.setDoc_id(userObj.get("_id").toString());
                temp.setClassroom_name(userObj.get("Classroom").toString());
                temp.setComment1(userObj.get("Comment1").toString());
                temp.setComment2(userObj.get("Comment2").toString());
                temp.setComment3(userObj.get("Comment3").toString());
                temp.setComment4(userObj.get("Comment4").toString());
                temp.setComment5(userObj.get("Comment5").toString());
                temp.setComment6(userObj.get("Comment6").toString());
                temp.setComment7(userObj.get("Comment7").toString());
                temp.setComment8(userObj.get("Comment8").toString());
                temp.setComment9(userObj.get("Comment9").toString());
                temp.setComment10(userObj.get("Comment10").toString());
            }

        }catch (Exception e) {
            e.getMessage();
        }

        return Class;
    }
}
