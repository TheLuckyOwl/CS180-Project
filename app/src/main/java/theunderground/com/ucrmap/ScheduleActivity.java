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
    private ImageButton mBackButton = null;

    SharedPreferences prefs = null;
    private User CurrentUser = new User();
    private String LoggedinUser = LoginActivity.LoggedUser;
    ArrayList<User> returnValues = new ArrayList<User>();

    @Override
    protected void onCreate(Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.schedule_activity_layout);
        Bundle extras = getIntent().getExtras();
        mAddButton = (Button)findViewById(R.id.addClass);
        mRemoveButton = (Button)findViewById(R.id.removeClass);
        mBackButton = (ImageButton)findViewById(R.id.backButton);
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
                    CurrentUser.setClass2Data(x.getClass2Data());
                    CurrentUser.setClass2Day(x.getClass2Day());
                    CurrentUser.setClass2Time(x.getClass2Time());
                    CurrentUser.setClass3Data(x.getClass3Data());
                    CurrentUser.setClass3Day(x.getClass3Day());
                    CurrentUser.setClass3Time(x.getClass3Time());
                    CurrentUser.setClass4Data(x.getClass4Data());
                    CurrentUser.setClass4Day(x.getClass4Day());
                    CurrentUser.setClass4Time(x.getClass4Time());
                    CurrentUser.setClass5Data(x.getClass5Data());
                    CurrentUser.setClass5Day(x.getClass5Day());
                    CurrentUser.setClass5Time(x.getClass5Time());
                    CurrentUser.setClass6Data(x.getClass6Data());
                    CurrentUser.setClass6Day(x.getClass6Day());
                    CurrentUser.setClass6Time(x.getClass6Time());
                    CurrentUser.setClass7Data(x.getClass7Data());
                    CurrentUser.setClass7Day(x.getClass7Day());
                    CurrentUser.setClass7Time(x.getClass7Time());
                    CurrentUser.setClass8Data(x.getClass8Data());
                    CurrentUser.setClass8Day(x.getClass8Day());
                    CurrentUser.setClass8Time(x.getClass8Time());
                    CurrentUser.setClass9Data(x.getClass9Data());
                    CurrentUser.setClass9Day(x.getClass9Day());
                    CurrentUser.setClass9Time(x.getClass9Time());
                    CurrentUser.setClass10Data(x.getClass10Data());
                    CurrentUser.setClass10Day(x.getClass10Day());
                    CurrentUser.setClass10Time(x.getClass10Time());
                }
            }
        }

        ScheduleAdapter mAdapter;
        ScheduleModel dummyData[] = {new ScheduleModel(CurrentUser.getClass1Data(), CurrentUser.getClass1Day() , CurrentUser.getClass1Time()),
                new ScheduleModel(CurrentUser.getClass2Data(), CurrentUser.getClass2Day() , CurrentUser.getClass2Time()),
                new ScheduleModel(CurrentUser.getClass3Data(), CurrentUser.getClass3Day() , CurrentUser.getClass3Time()),
                new ScheduleModel(CurrentUser.getClass4Data(), CurrentUser.getClass4Day() , CurrentUser.getClass4Time()),
                new ScheduleModel(CurrentUser.getClass5Data(), CurrentUser.getClass5Day() , CurrentUser.getClass5Time()),
                new ScheduleModel(CurrentUser.getClass6Data(), CurrentUser.getClass6Day() , CurrentUser.getClass6Time()),
                new ScheduleModel(CurrentUser.getClass7Data(), CurrentUser.getClass7Day() , CurrentUser.getClass7Time()),
                new ScheduleModel(CurrentUser.getClass8Data(), CurrentUser.getClass8Day() , CurrentUser.getClass8Time()),
                new ScheduleModel(CurrentUser.getClass9Data(), CurrentUser.getClass9Day() , CurrentUser.getClass9Time()),
                new ScheduleModel(CurrentUser.getClass10Data(), CurrentUser.getClass10Day() , CurrentUser.getClass10Time())
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
        mBackButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                back();
            }
        });
    }
    private void back(){
        Intent intent = new Intent(ScheduleActivity.this, AccountActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
        finish();
    }
}
