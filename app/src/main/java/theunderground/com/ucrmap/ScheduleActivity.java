package theunderground.com.ucrmap;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.Window;
import android.widget.Button;

/**
 * Created by Dharti on 5/1/2016.
 */

public class ScheduleActivity extends Activity {
    private Button mAddButton = null;
    private Button mRemoveButton = null;

    @Override
    protected void onCreate(Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.schedule_activity_layout);
        Bundle extras = getIntent().getExtras();
        mAddButton = (Button)findViewById(R.id.addClass);
        mRemoveButton = (Button)findViewById(R.id.removeClass);

        RecyclerView recyclerView = (RecyclerView) this.findViewById(R.id.listView);

        ScheduleAdapter mAdapter;
        ScheduleModel dummyData[] = {new ScheduleModel("Dummy Class Data", "Dummy Day", "Dummy Time"),
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
                showAddClassPage();
            }
        });

        mRemoveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showRemoveClassPage();
            }
        });
    }

    private void showAddClassPage() {
        Intent i = new Intent(this, AddClassActivity.class);
        startActivity(i);
    }

    private void showRemoveClassPage() {
        Intent i = new Intent(this, RemoveClassActivity.class);
        startActivity(i);
    }

}
