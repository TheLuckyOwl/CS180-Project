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
                }
            }
        }

        ScheduleAdapter mAdapter;
        ScheduleModel dummyData[] = {new ScheduleModel(CurrentUser.getClass1Data(), CurrentUser.getClass1Day() , CurrentUser.getClass1Time()),
                new ScheduleModel(CurrentUser.getClass2Data(), CurrentUser.getClass2Day() , CurrentUser.getClass2Time()),
                new ScheduleModel(CurrentUser.getClass3Data(), CurrentUser.getClass3Day() , CurrentUser.getClass3Time())
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
    }
}
