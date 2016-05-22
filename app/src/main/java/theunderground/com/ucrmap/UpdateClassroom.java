package theunderground.com.ucrmap;

import android.os.AsyncTask;

import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Roger on 5/18/2016.
 */
public class UpdateClassroom extends AsyncTask<Object, Void, Boolean> {
    @Override
    protected Boolean doInBackground(Object... params) {
        Classroom contact = (Classroom) params[0];

        try {

            ClassRoomQueryBuilder qb = new ClassRoomQueryBuilder();
            URL url = new URL(qb.buildContactsUpdateURL(contact.getDoc_id()));
            HttpURLConnection connection = (HttpURLConnection) url
                    .openConnection();
            connection.setRequestMethod("PUT");
            connection.setDoOutput(true);
            connection.setRequestProperty("Content-Type",
                    "application/json");
            connection.setRequestProperty("Accept", "application/json");

            OutputStreamWriter osw = new OutputStreamWriter(
                    connection.getOutputStream());

            osw.write(qb.setUserData(contact));
            osw.flush();
            osw.close();
            if(connection.getResponseCode() <205)
            {

                return true;
            }
            else
            {
                return false;

            }

        } catch (Exception e) {
            e.getMessage();
            return false;

        }
    }
}

