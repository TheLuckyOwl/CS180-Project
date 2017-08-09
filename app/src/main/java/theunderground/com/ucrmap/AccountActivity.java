package theunderground.com.ucrmap;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;


/**
 * Created by Larry Parsons on 4/14/2016.
 */
public class AccountActivity extends Activity {

    SharedPreferences prefs = null;

    private ImageButton mMapButton = null;
    private ImageButton mScheduleButton = null;
    private ImageButton mLibraryButton = null;
    private ImageButton mAdvisingButton = null;
    private ImageButton mILearnButton = null;
    private ImageButton mProfessorButton = null;
    private ImageButton mFoodMenuButton = null;
    private ImageButton mBuildingHoursButton = null;
    private ImageButton mFoodTruckButton = null;
    private ImageButton mAboutButton = null;
    private ImageButton mSafetyButton = null;
    private ImageButton mSignOutButton = null;
    private TextView mTitle = null;

    //private TextView mSignOutButton = null;
    @Override
    protected void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        prefs = this.getSharedPreferences("Login", Context.MODE_PRIVATE);
        setContentView(R.layout.account_activity_layout);

        mTitle = (TextView)findViewById(R.id.menuTitle);
        mTitle.setText("R'Mate");

        mMapButton = (ImageButton)this.findViewById(R.id.mapButton);
        mScheduleButton = (ImageButton)this.findViewById(R.id.scheduleButton);
        mAdvisingButton = (ImageButton) this.findViewById(R.id.friendsButton);

        mILearnButton = (ImageButton)this.findViewById(R.id.iLearnButton);
        mProfessorButton = (ImageButton)this.findViewById(R.id.professorButton);
        // mRoomsButton = (ImageButton)this.findViewById(R.id.roomButton);

        mFoodMenuButton = (ImageButton)this.findViewById(R.id.menuButton);
        mBuildingHoursButton = (ImageButton)this.findViewById(R.id.hoursButton);
        mFoodTruckButton = (ImageButton)this.findViewById(R.id.foodTruckButton);

        mLibraryButton = (ImageButton)this.findViewById(R.id.libraryButton);
        mAboutButton = (ImageButton)this.findViewById(R.id.aboutButton);
        mSafetyButton = (ImageButton)this.findViewById(R.id.safetyButton);

        //mSignOutButton = (TextView)this.findViewById(R.id.logoutButton);
        mSignOutButton = (ImageButton)this.findViewById(R.id.logoutButton);


        mMapButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                startActivity((new Intent(AccountActivity.this, UCRMapActivity.class)));
            }
        });
        //TODO Make class schedule
        mScheduleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                Intent i = new Intent(AccountActivity.this, ComingSoonActivity.class);
                i.putExtra("Title", "Schedule");
                startActivity(i);
            }
        });
        mAdvisingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                Intent i = new Intent(AccountActivity.this, ComingSoonActivity.class);
                i.putExtra("Title", "Advising");
                startActivity(i);
            }
        });
        mILearnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                User CurrentUser = new User();
                String LoggedinUser = LoginActivity.LoggedUser;
                ArrayList<User> returnValues = new ArrayList<User>();
                GetUsersAsyncTask task = new GetUsersAsyncTask();
                try {
                    returnValues = task.execute().get();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }
                for (User x : returnValues) {
                    {
                        if (x.getUsername().equals(LoggedinUser)) {
                            CurrentUser.setIlearnUser(x.getIlearnUser());
                            CurrentUser.setIlearnPass(x.getIlearnPass());
                        }
                    }
                }
                final String password = CurrentUser.getIlearnPass();
                final String uname = CurrentUser.getIlearnUser();
                Intent i = new Intent(AccountActivity.this, WebViewActivity.class);
                i.putExtra("Path", "https://ilearn.ucr.edu/webapps/bb-auth-provider-cas-bb_bb60/execute/casLogin?cmd=login&authProviderId=_102_1&redirectUrl=https%3A%2F%2Filearn.ucr.edu%2F\"");
                i.putExtra("Title", "ILearn");
                i.putExtra("JavaScript", "javascript: {" +
                        "document.getElementById('username').value = '" + uname + "';" +
                        "document.getElementById('password').value = '" + password + "';" +
                        "var frms = document.getElementsByName('loginForm');" +
                        "frms[0].submit(); };");
                startActivity(i);
            }
        });
        mProfessorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                Intent i = new Intent(AccountActivity.this, WebViewActivity.class);
                i.putExtra("Path", "http://www.ratemyprofessors.com/mobile/professor_search");
                i.putExtra("Title", "Rate My Professor");
                i.putExtra("JavaScript", "javascript: {" +
                        "var elements = document.getElementsByClassName('mobileAppPromo');" +
                        "    while(elements.length > 0){\n" +
                        "        elements[0].parentNode.removeChild(elements[0]);\n" +
                        "    }};");
                startActivity(i);
            }
        });

        mFoodMenuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                startActivity((new Intent(AccountActivity.this, DiningHallActivity.class)));
            }
        });
        mBuildingHoursButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                startActivity((new Intent(AccountActivity.this, ServiceHours.class)));
            }
        });
        mFoodTruckButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                startActivity((new Intent(AccountActivity.this, FoodTruckLocations.class)));
            }
        });
        mLibraryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                Intent i = new Intent(AccountActivity.this, WebViewActivity.class);
                i.putExtra("Path", "http://ucr.evanced.info/dibs/Login");
                i.putExtra("Title", "Library Reservation");
                startActivity(i);
            }
        });
        mAboutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                startActivity((new Intent(AccountActivity.this, ContactUsActivity.class)));
            }
        });
        mSafetyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                startActivity((new Intent(AccountActivity.this, CampusSafetyActivity.class)));
            }
        });
        mSignOutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                SharedPreferences.Editor editor = prefs.edit();
                editor.putString(LoginActivity.USER_ID_PREF, null);
                editor.putBoolean(LoginActivity.LOGGED_IN_PREF, false);
                editor.commit();

                Intent i = new Intent(AccountActivity.this, LoginActivity.class);
                i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(i);
            }
        });

    }
}