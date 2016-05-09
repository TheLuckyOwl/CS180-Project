package theunderground.com.ucrmap;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

import android.os.AsyncTask;

import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
/**
 * Created by Roger on 5/2/2016.
 */
public class GetUsersAsyncTask extends AsyncTask<User, Void, ArrayList<User>>{
    static BasicDBObject user = null;
    static String OriginalObject = "";
    static String server_output = null;

            QueryBuilder qb = new QueryBuilder();
            static String temp_output = null;

            @Override
            protected ArrayList<User> doInBackground(User... arg0) {
            ArrayList<User> Users = new ArrayList<User>();
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
                DBObject Csub1 = (DBObject)userObj.get("Class1");

                User temp = new User();
                temp.setDoc_id(userObj.get("_id").toString());
                temp.setFirst_name(userObj.get("FirstName").toString());
                temp.setLast_name(userObj.get("LastName").toString());
                temp.setMiddle_initial(userObj.get("MiddleInitial").toString());
                temp.setUsername(userObj.get("UserName").toString());
                temp.setPassword(userObj.get("Password").toString());
                temp.setIlearnUser(userObj.get("ilearnUser").toString());
                temp.setIlearnPass(userObj.get("ilearnPass").toString());
                temp.setClass1Data(Csub1.get("Data").toString());
                temp.setClass1Day(Csub1.get("Day").toString());
                temp.setClass1Day(Csub1.get("Time").toString());
                Users.add(temp);
            }

        }catch (Exception e) {
            e.getMessage();
        }

        return Users;
    }
}
