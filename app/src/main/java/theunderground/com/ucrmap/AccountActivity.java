package theunderground.com.ucrmap;

import android.app.Activity;
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
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Button;


/**
 * Created by Larry Parsons on 4/14/2016.
 */
public class AccountActivity extends Activity {


    //TODO Need to make the back presses null as well as clicking on the class your in, in the drawer layout
    //TODO Need to make navigation drawer a separate interface to be implemented.
    SharedPreferences prefs = null;
    //for the Navigation Drawer
    private String[] mMenuTitles = null;
    private DrawerLayout mDrawerLayout = null;
    private ListView mDrawerList = null;
    //==================================

    private ImageButton mButton = null;
    private Button mscheduleButton = null;
    private Button mLoginButton = null;
    @Override
    protected void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        prefs = this.getSharedPreferences("Login", Context.MODE_PRIVATE);
        setContentView(R.layout.account_activity_layout);
        mscheduleButton = (Button)this.findViewById(R.id.scheduleButton);
        mscheduleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(AccountActivity.this, ScheduleActivity.class));
            }
        });
        mLoginButton = (Button)this.findViewById(R.id.Bloginmain);
        mLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(AccountActivity.this, LoginActivity.class));
            }
        });

        //Navigation Drawer Definitions
        mMenuTitles = getResources().getStringArray(R.array.menu_array);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerList = (ListView) findViewById(R.id.left_drawer);

        mButton = (ImageButton)this.findViewById(R.id.button);
        mButton = (ImageButton) this.findViewById(R.id.button);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mDrawerLayout.openDrawer(mDrawerList);
            }
        });

        // set a custom shadow that overlays the main content when the drawer opens
        mDrawerLayout.setDrawerShadow(R.drawable.drawer_shadow, GravityCompat.START);
        // set up the drawer's list view with items and click listener
        mDrawerList.setAdapter(new ArrayAdapter<String>(this,
                R.layout.drawer_list_item, mMenuTitles));
        mDrawerList.setOnItemClickListener(new DrawerItemClickListener());
        //================================================================================

    }
    //======================================================================================
    /* The click listener for ListView in the navigation drawer */
    private class DrawerItemClickListener implements ListView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            selectItem(position);
        }
    }

    private void selectItem(int position) {
        //Home
        if(position == 0){
            Intent i = new Intent(this, AccountActivity.class);
            startActivity(i);
        }
        //UCR Map
        else if(position == 1){
            Intent i = new Intent(this, UCRMapActivity.class);
            startActivity(i);
        }
        //Campus Safety
        else if(position == 2){
            Intent i = new Intent(this, CampusSafetyActivity.class);
            startActivity(i);
        }
        //ILearn
        if(position == 3){
            Intent i = new Intent(this, ILearnActivity.class);
            startActivity(i);
        }
        //Dining Hall
        else if(position == 4){
            Intent i = new Intent(this, DinningHallActivity.class);
            startActivity(i);
        }
        //Library Registration
        else if(position == 5){
            Intent i = new Intent(this, LibraryActivity.class);
            startActivity(i);
        }
        //Contact Us
        else if(position == 6){
            Intent i = new Intent(this, ContactUsActivity.class);
            startActivity(i);
        }
        //Sign Out
        else if(position == 7){
            // Clear out the shared preferences.
            SharedPreferences.Editor editor = prefs.edit();
            editor.putString(LoginActivity.USER_ID_PREF, null);
            editor.putBoolean(LoginActivity.LOGGED_IN_PREF, false);
            editor.commit();

            Intent i = new Intent(this, LoginActivity.class);
            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(i);
        }
        mDrawerLayout.closeDrawer(mDrawerList);
    }


}