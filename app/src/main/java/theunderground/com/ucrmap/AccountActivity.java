package theunderground.com.ucrmap;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;



/**
 * Created by Larry Parsons on 4/14/2016.
 */
public class AccountActivity extends Activity {


    SharedPreferences prefs = null;
    private ImageButton mFriendsButton = null;
    private ImageButton mMapButton = null;
    private ImageButton mScheduleButton = null;
    private ImageButton mLibraryButton = null;
    private ImageButton mRoomsButton = null;
    private ImageButton mILearnButton = null;
    private ImageButton mProfessorButton = null;
    private ImageButton mFoodMenuButton = null;
    private ImageButton mBuildingHoursButton = null;
    private ImageButton mFoodTruckButton = null;
    private ImageButton mAboutButton = null;
    private ImageButton mSafetyButton = null;
    private ImageButton mSignOutButton = null;
    @Override
    protected void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        prefs = this.getSharedPreferences("Login", Context.MODE_PRIVATE);
        setContentView(R.layout.account_activity_layout);

        mFriendsButton = (ImageButton)this.findViewById(R.id.friendsButton);
        mMapButton = (ImageButton)this.findViewById(R.id.mapButton);
        mScheduleButton = (ImageButton)this.findViewById(R.id.scheduleButton);

        mILearnButton = (ImageButton)this.findViewById(R.id.iLearnButton);
        mProfessorButton = (ImageButton)this.findViewById(R.id.professorButton);
        mRoomsButton = (ImageButton)this.findViewById(R.id.roomButton);

        mFoodMenuButton = (ImageButton)this.findViewById(R.id.menuButton);
        mBuildingHoursButton = (ImageButton)this.findViewById(R.id.hoursButton);
        mFoodTruckButton = (ImageButton)this.findViewById(R.id.foodTruckButton);

        mLibraryButton = (ImageButton)this.findViewById(R.id.libraryButton);
        mAboutButton = (ImageButton)this.findViewById(R.id.aboutButton);
        mSafetyButton = (ImageButton)this.findViewById(R.id.safetyButton);

        mSignOutButton = (ImageButton)this.findViewById(R.id.logoutButton);

        mFriendsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                //startActivity((new Intent(AccountActivity.this, )));
            }
        });
        mMapButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                startActivity((new Intent(AccountActivity.this, UCRMapActivity.class)));
            }
        });
        mScheduleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                startActivity((new Intent(AccountActivity.this, ScheduleActivity.class)));
            }
        });
        mILearnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                startActivity((new Intent(AccountActivity.this, ILearnActivity.class)));
            }
        });
        mProfessorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                startActivity((new Intent(AccountActivity.this, RateMyProfessor.class)));
            }
        });
        mRoomsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                //startActivity((new Intent(AccountActivity.this, RateRoomActivity.class)));
            }
        });
        mFoodMenuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                startActivity((new Intent(AccountActivity.this, DinningHallActivity.class)));
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
                startActivity((new Intent(AccountActivity.this, LibraryActivity.class)));
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