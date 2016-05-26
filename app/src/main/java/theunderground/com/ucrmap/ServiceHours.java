package theunderground.com.ucrmap;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;


/**
 * Created by Sara on 5/19/16.
 */
public class ServiceHours extends Activity{
    private ImageButton mBackButton = null;
    private TextView mTitle = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dinning_hall_activity_layout);
        RecyclerView recyclerView = (RecyclerView) this.findViewById(R.id.recyclerViewTab);
        TabServiceAdapter mAdapter;
        mTitle = (TextView)findViewById(R.id.diningTitle);
        mTitle.setText("Building Hours");
        mBackButton = (ImageButton)findViewById(R.id.backButton);
        mBackButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                back();
            }
        });

        TabsServiceModel dininghall_data[] = {new TabsServiceModel("Orbach Library", "M-R: 7:30a-12a, F: 7:30a-6p, Sat: 9a-5p, Sun: 1p-12a"),
                new TabsServiceModel("Rivera Library", "M-R: 7:30a-12a, F: 7:30a-6p, Sat: 9a-5p, Sun: 1p-12a"),
                new TabsServiceModel("Student Recreation Center", "M-R: 6a-12a, F: 6a-9p, Sat: 9a-9p, Sun: 9a-12a"),
                new TabsServiceModel("Bookstore", "M-F: 8a-6p, Sat: 9a-3p, Sun: CLOSED"),
                new TabsServiceModel("Student Services", "M-F: 9a-5p"),
                new TabsServiceModel("Botanical Gardens", "Daily: 8a-5p"),
        };
        mAdapter = new TabServiceAdapter(dininghall_data);
        // 2. set layoutManger
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        // 4. set adapter
        recyclerView.setAdapter(mAdapter);
        // 5. set item animator to DefaultAnimator
        recyclerView.setItemAnimator(new DefaultItemAnimator());
    }
    private void back(){
        Intent intent = new Intent(ServiceHours.this, AccountActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
        finish();
    }
}
