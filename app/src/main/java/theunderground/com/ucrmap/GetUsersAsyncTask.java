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
                DBObject Csub2 = (DBObject)userObj.get("Class2");
                DBObject Csub3 = (DBObject)userObj.get("Class3");
                DBObject Csub4 = (DBObject)userObj.get("Class4");
                DBObject Csub5 = (DBObject)userObj.get("Class5");
                DBObject Csub6 = (DBObject)userObj.get("Class6");
                DBObject Csub7 = (DBObject)userObj.get("Class7");
                DBObject Csub8 = (DBObject)userObj.get("Class8");
                DBObject Csub9 = (DBObject)userObj.get("Class9");
                DBObject Csub10 = (DBObject)userObj.get("Class10");

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
                temp.setClass1Time(Csub1.get("Time").toString());
                temp.setClass2Data(Csub2.get("Data").toString());
                temp.setClass2Day(Csub2.get("Day").toString());
                temp.setClass2Time(Csub2.get("Time").toString());
                temp.setClass3Data(Csub3.get("Data").toString());
                temp.setClass3Day(Csub3.get("Day").toString());
                temp.setClass3Time(Csub3.get("Time").toString());
                temp.setClass4Data(Csub4.get("Data").toString());
                temp.setClass4Day(Csub4.get("Day").toString());
                temp.setClass4Time(Csub4.get("Time").toString());
                temp.setClass5Data(Csub5.get("Data").toString());
                temp.setClass5Day(Csub5.get("Day").toString());
                temp.setClass5Time(Csub5.get("Time").toString());
                temp.setClass6Data(Csub6.get("Data").toString());
                temp.setClass6Day(Csub6.get("Day").toString());
                temp.setClass6Time(Csub6.get("Time").toString());
                temp.setClass7Data(Csub7.get("Data").toString());
                temp.setClass7Day(Csub7.get("Day").toString());
                temp.setClass7Time(Csub7.get("Time").toString());
                temp.setClass8Data(Csub8.get("Data").toString());
                temp.setClass8Day(Csub8.get("Day").toString());
                temp.setClass8Time(Csub8.get("Time").toString());
                temp.setClass9Data(Csub9.get("Data").toString());
                temp.setClass9Day(Csub9.get("Day").toString());
                temp.setClass9Time(Csub9.get("Time").toString());
                temp.setClass10Data(Csub10.get("Data").toString());
                temp.setClass10Day(Csub10.get("Day").toString());
                temp.setClass10Time(Csub10.get("Time").toString());
                Users.add(temp);
            }

        }catch (Exception e) {
            e.getMessage();
        }

        return Users;
    }
}
