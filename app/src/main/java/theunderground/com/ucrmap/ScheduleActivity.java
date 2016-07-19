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
