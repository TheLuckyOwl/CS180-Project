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
                DBObject Friend1 = (DBObject) userObj.get("Friend1");
                DBObject Friend2 = (DBObject) userObj.get("Friend2");
                DBObject Friend3 = (DBObject) userObj.get("Friend3");
                DBObject Friend4 = (DBObject) userObj.get("Friend4");
                DBObject Friend5 = (DBObject) userObj.get("Friend5");
                DBObject Friend6 = (DBObject) userObj.get("Friend6");
                DBObject Friend7 = (DBObject) userObj.get("Friend7");
                DBObject Friend8 = (DBObject) userObj.get("Friend8");
                DBObject Friend9 = (DBObject) userObj.get("Friend9");
                DBObject Friend10 = (DBObject) userObj.get("Friend10");


                User temp = new User();
                //getting simple fields
                temp.setDoc_id(userObj.get("_id").toString());
                temp.setFirst_name(userObj.get("FirstName").toString());
                temp.setLast_name(userObj.get("LastName").toString());
                temp.setMiddle_initial(userObj.get("MiddleInitial").toString());
                temp.setUsername(userObj.get("UserName").toString());
                temp.setPassword(userObj.get("Password").toString());
                temp.setIlearnUser(userObj.get("ilearnUser").toString());
                temp.setIlearnPass(userObj.get("ilearnPass").toString());
                temp.setEmail(userObj.get("Email").toString());
                //getting embeded classes fields
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
                //getting embedded friends fields
                temp.setFriend1Name(Friend1.get("Name").toString());
                temp.setFriend1Accesss(Friend1.get("Access").toString());
                temp.setFriend2Name(Friend2.get("Name").toString());
                temp.setFriend2Accesss(Friend2.get("Access").toString());
                temp.setFriend3Name(Friend3.get("Name").toString());
                temp.setFriend3Accesss(Friend3.get("Access").toString());
                temp.setFriend4Name(Friend4.get("Name").toString());
                temp.setFriend4Accesss(Friend4.get("Access").toString());
                temp.setFriend5Name(Friend5.get("Name").toString());
                temp.setFriend5Accesss(Friend5.get("Access").toString());
                temp.setFriend6Name(Friend6.get("Name").toString());
                temp.setFriend6Accesss(Friend6.get("Access").toString());
                temp.setFriend7Name(Friend7.get("Name").toString());
                temp.setFriend7Accesss(Friend7.get("Access").toString());
                temp.setFriend8Name(Friend8.get("Name").toString());
                temp.setFriend8Accesss(Friend8.get("Access").toString());
                temp.setFriend9Name(Friend9.get("Name").toString());
                temp.setFriend9Accesss(Friend9.get("Access").toString());
                temp.setFriend10Name(Friend10.get("Name").toString());
                temp.setFriend10Accesss(Friend10.get("Access").toString());

                //strings for getting pending Requests
                temp.setPendingRequest1(userObj.get("PendingRequest1").toString());
                temp.setPendingRequest2(userObj.get("PendingRequest2").toString());
                temp.setPendingRequest3(userObj.get("PendingRequest3").toString());
                temp.setPendingRequest4(userObj.get("PendingRequest4").toString());
                temp.setPendingRequest5(userObj.get("PendingRequest5").toString());
                Users.add(temp);
            }

        }catch (Exception e) {
            e.getMessage();
        }

        return Users;
    }
}
