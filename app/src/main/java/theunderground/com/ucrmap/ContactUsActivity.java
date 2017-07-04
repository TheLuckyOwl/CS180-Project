package theunderground.com.ucrmap;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.concurrent.ExecutionException;

/**
 * Created by Larry Parsons on 4/14/2016.
 */
public class ContactUsActivity extends Activity {
    SharedPreferences prefs = null;
    TextView mEmail = null;
    TextView mLogOut = null;
    private Button Change = null;
    private Button BackButton = null;
    private Switch NotSwitch = null;
    private User CurrentUser = new User();
    private String LoggedinUser = LoginActivity.LoggedUser;
    AlarmManager alarm_manager = null;
    AlarmManager[]  amArray = new AlarmManager[30];
    ArrayList<PendingIntent> intentArray = new ArrayList<PendingIntent>();
    ArrayList<Calendar> CalArray = new ArrayList<Calendar>();
    ArrayList<User> returnValues = new ArrayList<User>();

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        prefs = this.getSharedPreferences("Login", Context.MODE_PRIVATE);
        setContentView(R.layout.contact_us_activity_layout);

        mEmail = (TextView)findViewById(R.id.emailLink);
        mLogOut = (TextView)findViewById(R.id.logOutText);
        Change = (Button) findViewById(R.id.bChange);
        BackButton = (Button) findViewById(R.id.bBackSet);


        BackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ContactUsActivity.this, AccountActivity.class);
                i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                ContactUsActivity.this.startActivity(i);
            }
        });

        Change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ContactUsActivity.this, UpdateIlearnActivity.class);
                ContactUsActivity.this.startActivity(i);
            }
        });

        mEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Something to do
                Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts(
                        "mailto",getString(R.string.support_email), null));
                startActivity(Intent.createChooser(emailIntent, "Send email..."));
            }
        });

        mLogOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Clear out the shared preferences.
                SharedPreferences.Editor editor = prefs.edit();
                editor.putString(LoginActivity.USER_ID_PREF, null);
                editor.putBoolean(LoginActivity.LOGGED_IN_PREF, false);
                editor.commit();

                Intent i = new Intent(ContactUsActivity.this, LoginActivity.class);
                i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(i);
            }
        });

    }
}

