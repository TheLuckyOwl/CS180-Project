package theunderground.com.ucrmap;

import android.os.AsyncTask;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;

/**
 * Created by Roger on 5/18/2016.
 */
public class SaveClassAsyncTask extends AsyncTask<Classroom, Void, Boolean> { // change to classroom X

    @Override
    protected Boolean doInBackground(Classroom... arg0) {//change to class room X
        try
        {
            Classroom contact = arg0[0];//change to Classroom class X

            ClassRoomQueryBuilder qb = new ClassRoomQueryBuilder();  // make it a classroom query builder

            HttpClient httpClient = new DefaultHttpClient();
            HttpPost request = new HttpPost(qb.buildContactsSaveURL());

            StringEntity params =new StringEntity(qb.createContact(contact));
            request.addHeader("content-type", "application/json");
            request.setEntity(params);
            HttpResponse response = httpClient.execute(request);

            if(response.getStatusLine().getStatusCode()<205)
            {
                return true;
            }
            else
            {
                return false;
            }
        } catch (Exception e) {
            //e.getCause();
            String val = e.getMessage();
            String val2 = val;
            return false;
        }
    }

}

