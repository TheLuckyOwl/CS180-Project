package theunderground.com.ucrmap;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

/**
 * Created by Dharti on 5/1/2016.
 */

public class ScheduleActivity extends Activity {
    private Button mAddButton = null;
    private Button mRemoveButton = null;
    private ImageButton mButton = null;
    //for the Navigation Drawer
    SharedPreferences prefs = null;
    private String[] mMenuTitles = null;
    private DrawerLayout mDrawerLayout = null;
    private ListView mDrawerList = null;
    private User CurrentUser = new User();
    private String LoggedinUser = LoginActivity.LoggedUser;
    ArrayList<User> returnValues = new ArrayList<User>();
    //==================================
    //TODO Disable Back button presseds from the Add class activity, this messes up the back stack
    @Override
    protected void onCreate(Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.schedule_activity_layout);
        Bundle extras = getIntent().getExtras();
        mAddButton = (Button)findViewById(R.id.addClass);
        mRemoveButton = (Button)findViewById(R.id.removeClass);
        prefs = this.getSharedPreferences("Login", Context.MODE_PRIVATE);

        RecyclerView recyclerView = (RecyclerView) this.findViewById(R.id.listView);

        GetUsersAsyncTask task = new GetUsersAsyncTask();
        try {
            returnValues = task.execute().get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        for(User x: returnValues)
        {
            {
                if(x.getUsername().equals(LoggedinUser))
                {
                    CurrentUser.setClass1Data(x.getClass1Data());
                    CurrentUser.setClass1Day(x.getClass1Day());
                    CurrentUser.setClass1Time(x.getClass1Time());
                }
            }
        }

        ScheduleAdapter mAdapter;
        ScheduleModel dummyData[] = {new ScheduleModel(CurrentUser.getClass1Data(), CurrentUser.getClass1Day() , CurrentUser.getClass1Time()),
                new ScheduleModel("yay", "yay2", "yay3"),
                new ScheduleModel("what's", "up", "larry!")
        };

        mAdapter = new ScheduleAdapter(dummyData);

        // 2. set layoutManger
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        // 4. set adapter
        recyclerView.setAdapter(mAdapter);
        // 5. set item animator to DefaultAnimator
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        mAddButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ScheduleActivity.this, AddClassActivity.class));
            }
        });

        mRemoveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ScheduleActivity.this, RemoveClassActivity.class));
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
