package theunderground.com.ucrmap;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
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
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ExecutionException;

import org.bson.Document;
import com.mongodb.Block;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

import static com.mongodb.client.model.Filters.*;
import static com.mongodb.client.model.Sorts.ascending;
import static java.util.Arrays.asList;

/**
 * Created by Larry Parsons on 4/14/2016.
 */
public class LoginActivity extends Activity {
    public static final String LOG_TAG = "LoginActivity";
    public static final String LOGGED_IN_PREF = "loggedIn";
    public static final String USER_ID_PREF = "user";

    private EditText mUserId = null;
    private EditText mPassword = null;
    private TextView mWelcome = null;
    private TextView mUser = null;
    private TextView mPass = null;
    private CheckBox mLog = null;
    private Button mLoginButton = null; //match with the ones made
    private Button mForgotId = null;
    private Button mRegister = null;
    private
    ArrayList<User> returnValues = new ArrayList<User>();
    public static String LoggedUser;
    public String Name;

    private boolean checkUserId(String userId, String userPass) {
        //User Ids must be at least 6 characters long add this to the register check before uncommenting it
        if (userId.length() < 6) {
            return false;
        }

        GetUsersAsyncTask task = new GetUsersAsyncTask();
        try {
            returnValues = task.execute().get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        boolean Exists = false;
        for(User x: returnValues)
        {
            if(x.getUsername().equals(userId))
            {
                if(x.getPassword().equals(userPass))
                {
                    LoggedUser = x.getUsername();
                    Name = x.getFirst_name();
                    return true;
                }
            }
        }

        return false;
    }

    public void save(String user, String pass)
    {
        SharedPreferences sharedPref = getSharedPreferences("LogData", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putBoolean("Logged", true);
        editor.putString("Username", user);
        editor.putString("Password", pass);
        editor.apply();
    }

    public Boolean load()
    {
        SharedPreferences sharedPref = getSharedPreferences("LogData", Context.MODE_PRIVATE);
        return sharedPref.getBoolean("Logged", false);
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity_layout);

        mUserId = (EditText)findViewById(R.id.etUsername);
        mPassword = (EditText)findViewById(R.id.etPassword);
        mUser = (TextView)findViewById(R.id.tvLogin_text);
        mPass = (TextView)findViewById(R.id.tvPassword_text);
        mForgotId = (Button)findViewById(R.id.bForgotLog);
        mLoginButton = (Button)findViewById(R.id.bLogin);
        mRegister = (Button)findViewById(R.id.bRegister);
        mLog = (CheckBox) findViewById(R.id.cbLog);
        if(load())
        {
            SharedPreferences sharedPref = getSharedPreferences("LogData", Context.MODE_PRIVATE);
            mUserId.setText(sharedPref.getString("Username", ""));
            mPassword.setText(sharedPref.getString("Password", ""));
        }


        mLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mUserId.getText() == null) {
                    Toast.makeText(LoginActivity.this, "Please enter a valid ID", Toast.LENGTH_LONG).show();
                } else if (checkUserId(mUserId.getText().toString(), mPassword.getText().toString()) && mLog.isChecked()) {
                    save(mUserId.getText().toString(),mPassword.getText().toString());
                    Toast.makeText(LoginActivity.this, "Welcome " + Name , Toast.LENGTH_LONG).show();
                    Intent i = new Intent(LoginActivity.this, AccountActivity.class);
                    i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(i);
                } else if (checkUserId(mUserId.getText().toString(), mPassword.getText().toString()) && !mLog.isChecked())
                {
                    SharedPreferences sharedPref = getSharedPreferences("LogData", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPref.edit();
                    editor.putBoolean("Logged", false);
                    editor.apply();
                    Toast.makeText(LoginActivity.this, "Welcome " + Name, Toast.LENGTH_LONG).show();
                    Intent i = new Intent(LoginActivity.this, AccountActivity.class);
                    i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(i);

                } else {
                    Toast.makeText(LoginActivity.this, "Invalid ID - Please try again", Toast.LENGTH_LONG).show();
                }
            }
        });
        mForgotId.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent i = new Intent(LoginActivity.this, ForgotLogin.class);
                LoginActivity.this.startActivity(i);
            }
        });

        mRegister.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent i = new Intent(LoginActivity.this, RegisterActivity.class);
                LoginActivity.this.startActivity(i);
            }
        });
    }

}
