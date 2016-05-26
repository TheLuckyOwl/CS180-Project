package theunderground.com.ucrmap;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

/**
 * Created by Roger on 5/26/2016.
 */
public class ViewFriendSchedule extends Activity {
    private Button mSearch = null;
    private Button mList = null;
    private User FriendUser = new User();
    ArrayList<User> returnValues = new ArrayList<User>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_friend_schedule_activity_class);
        Bundle bundle = getIntent().getExtras();
        String Friend = bundle.getString("FriendUserName");
        mSearch = (Button)findViewById(R.id.bBTSearch);
        mList = (Button)findViewById(R.id.bFriendList);

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
                if(x.getUsername().equals(Friend))
                {
                    FriendUser.setClass1Data(x.getClass1Data());
                    FriendUser.setClass1Day(x.getClass1Day());
                    FriendUser.setClass1Time(x.getClass1Time());
                    FriendUser.setClass2Data(x.getClass2Data());
                    FriendUser.setClass2Day(x.getClass2Day());
                    FriendUser.setClass2Time(x.getClass2Time());
                    FriendUser.setClass3Data(x.getClass3Data());
                    FriendUser.setClass3Day(x.getClass3Day());
                    FriendUser.setClass3Time(x.getClass3Time());
                    FriendUser.setClass4Data(x.getClass4Data());
                    FriendUser.setClass4Day(x.getClass4Day());
                    FriendUser.setClass4Time(x.getClass4Time());
                    FriendUser.setClass5Data(x.getClass5Data());
                    FriendUser.setClass5Day(x.getClass5Day());
                    FriendUser.setClass5Time(x.getClass5Time());
                    FriendUser.setClass6Data(x.getClass6Data());
                    FriendUser.setClass6Day(x.getClass6Day());
                    FriendUser.setClass6Time(x.getClass6Time());
                    FriendUser.setClass7Data(x.getClass7Data());
                    FriendUser.setClass7Day(x.getClass7Day());
                    FriendUser.setClass7Time(x.getClass7Time());
                    FriendUser.setClass8Data(x.getClass8Data());
                    FriendUser.setClass8Day(x.getClass8Day());
                    FriendUser.setClass8Time(x.getClass8Time());
                    FriendUser.setClass9Data(x.getClass9Data());
                    FriendUser.setClass9Day(x.getClass9Day());
                    FriendUser.setClass9Time(x.getClass9Time());
                    FriendUser.setClass10Data(x.getClass10Data());
                    FriendUser.setClass10Day(x.getClass10Day());
                    FriendUser.setClass10Time(x.getClass10Time());
                }
            }
        }

        ScheduleAdapter mAdapter;
        ScheduleModel dummyData[] = {new ScheduleModel(FriendUser.getClass1Data(), FriendUser.getClass1Day() , FriendUser.getClass1Time()),
                new ScheduleModel(FriendUser.getClass2Data(), FriendUser.getClass2Day() , FriendUser.getClass2Time()),
                new ScheduleModel(FriendUser.getClass3Data(), FriendUser.getClass3Day() , FriendUser.getClass3Time()),
                new ScheduleModel(FriendUser.getClass4Data(), FriendUser.getClass4Day() , FriendUser.getClass4Time()),
                new ScheduleModel(FriendUser.getClass5Data(), FriendUser.getClass5Day() , FriendUser.getClass5Time()),
                new ScheduleModel(FriendUser.getClass6Data(), FriendUser.getClass6Day() , FriendUser.getClass6Time()),
                new ScheduleModel(FriendUser.getClass7Data(), FriendUser.getClass7Day() , FriendUser.getClass7Time()),
                new ScheduleModel(FriendUser.getClass8Data(), FriendUser.getClass8Day() , FriendUser.getClass8Time()),
                new ScheduleModel(FriendUser.getClass9Data(), FriendUser.getClass9Day() , FriendUser.getClass9Time()),
                new ScheduleModel(FriendUser.getClass10Data(), FriendUser.getClass10Day() , FriendUser.getClass10Time())
        };

        mAdapter = new ScheduleAdapter(dummyData);

        // 2. set layoutManger
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        // 4. set adapter
        recyclerView.setAdapter(mAdapter);
        // 5. set item animator to DefaultAnimator
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        mSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ViewFriendSchedule.this, FriendSearchActivity.class));
            }
        });

        mList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ViewFriendSchedule.this, FriendListActivity.class));
            }
        });
    }
}
