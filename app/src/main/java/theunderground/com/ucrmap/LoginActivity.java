package theunderground.com.ucrmap;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Iterator;
import com.mongodb.*;
import java.net.UnknownHostException;

/**
 * Created by Larry Parsons on 4/14/2016.
 */
public class LoginActivity extends Activity {
    public static final String LOG_TAG = "LoginActivity";
    public static final String LOGGED_IN_PREF = "loggedIn";
    public static final String USER_ID_PREF = "user";

    private EditText mUserId = null;
    private Button mLoginButton = null; //match with the ones made
    private TextView mForgotId = null;
    private JSONObject userObject = null;
    SharedPreferences prefs = null;


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // First, check to see if the user is already logged in.
        // If so, forward along to the main activity.
        prefs = getSharedPreferences("Login", Context.MODE_PRIVATE);

        // Download login credentials from the server
        ConnectivityManager connMgr = (ConnectivityManager)
                getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnected()) {
            //TODO Implement the data base to log in people
            //new UserDownloadTask(this).execute(getString(R.string.users_url));
            //if it connects --- look up
        } else {
            Toast.makeText(this, "Unable to connect to the network. Please try again later", Toast.LENGTH_LONG);
        }
    }

    private boolean checkUserId(String userId) {
        Iterator<String> it = userObject.keys();

        Log.d(LOG_TAG, "Entered User ID = " + userId);
        //User Ids must be at least 6 characters long
        if (userId.length() < 6) {
            return false;
        }

        while (it.hasNext()) {
            String keyString = it.next();
            boolean foundUser = keyString.contains(userId);
            if (foundUser) {
                Log.d(LOG_TAG, "User Found: " + keyString);
                SharedPreferences.Editor editor = prefs.edit();
                editor.putString(USER_ID_PREF, keyString);
                editor.putBoolean(LOGGED_IN_PREF, foundUser);
                editor.commit();
                return true;
            }
        }
        return false;
    }
    private class UserDownloadTask extends AsyncTask<String, Void, Void> {
        private Activity mActivity;

        public UserDownloadTask(Activity pActivity) {
            this.mActivity = pActivity;
        }

        @Override
        protected Void doInBackground(String... strings) {
            URLConnection urlConnection = null;
            StringBuffer userData = new StringBuffer();

            try {
                //TODO The users_url is to the database
                //URL url = new URL(getString(R.string.users_url));
                //urlConnection = url.openConnection();
                //MongoClientURI uri  = new MongoClientURI("mongodb://user:pass@host:port/db");
                //MongoClient client = new MongoClient(uri);
                //DB db = client.getDB(uri.getDatabase());

                InputStream in = new BufferedInputStream(urlConnection.getInputStream());
                BufferedReader r = new BufferedReader(new InputStreamReader(in));

                String line;
                while ((line = r.readLine()) != null) {
                    userData.append(line);
                }
                userObject = new JSONObject(userData.toString());
                return null;
            } catch (IOException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            Log.d(LOG_TAG, "Retrieved " + userObject.length() + " Users");
            if (prefs.getString(USER_ID_PREF, null) != null && prefs.getBoolean(LOGGED_IN_PREF, false) != false) {
                // If we already have user login information stored here.
                if (checkUserId(prefs.getString(USER_ID_PREF, null))) {
                    // Go to the main activity and remove this one from the back stack IF the user ID is valid.
                    Intent intent = new Intent(this.mActivity, AccountActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(intent);
                    return;
                } else {
                    // The previously working id must've died - log them out.
                    SharedPreferences.Editor editor = prefs.edit();
                    editor.remove(USER_ID_PREF);
                    editor.remove(LOGGED_IN_PREF);
                    editor.apply();
                }
            }

            // Render the login activity views.
            this.mActivity.setContentView(R.layout.login_activity_layout);
            //TODO These are the button declarations that need to be handled, Once buttons are made uncomment
            //mUserId = (EditText)this.mActivity.findViewById(R.id.enter_id);
            //mForgotId = (TextView)this.mActivity.findViewById(R.id.forgot_button);
            //mLoginButton = (Button)this.mActivity.findViewById(R.id.login);

            mLoginButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Log.d(LOG_TAG, "Clicked the login button");

                    if (mUserId.getText() == null) {
                        Toast.makeText(LoginActivity.this, "Please enter a valid ID", Toast.LENGTH_LONG).show();
                    } else if (checkUserId(mUserId.getText().toString())) {
                        Intent i = new Intent(LoginActivity.this, AccountActivity.class);
                        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                        startActivity(i);
                    } else {
                        Toast.makeText(LoginActivity.this, "Invalid ID - Please try again", Toast.LENGTH_LONG).show();
                    }
                }
            });

            // 025511
            mForgotId.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View view) {
                    Intent i = new Intent(LoginActivity.this, ForgotLogin.class);
                    LoginActivity.this.startActivity(i);
                }
            });

        }

    }
}
