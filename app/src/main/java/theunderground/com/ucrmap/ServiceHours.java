package theunderground.com.ucrmap;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.Window;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;
import java.util.List;


/**
 * Created by Sara on 5/19/16.
 */
public class ServiceHours extends Activity{
    ExpandableListView expandableListView;
    ExpandableListAdapter expandableListAdapter;
    HashMap<String, List<String>> expandableListDetail;
    SharedPreferences prefs = null;
    private ImageButton mBackButton = null;
    private TextView mTitle = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        prefs = this.getSharedPreferences("Login", Context.MODE_PRIVATE);
        setContentView(R.layout.dining_hall_activity_layout);
        mTitle = (TextView)findViewById(R.id.diningTitle);
        mTitle.setText("Building Hours");
        mBackButton = (ImageButton)findViewById(R.id.backButton);
        mBackButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                back();
            }
        });
        expandableListView = (ExpandableListView) findViewById(R.id.expandableListView);
        expandableListDetail = ServiceHoursList.getData();

        final TabsWizardModel dininghall_data[] = {
                new TabsWizardModel("Orbach Library", R.drawable.library),
                new TabsWizardModel("Rivera Library", R.drawable.library),
                new TabsWizardModel("Student Recreation Center", R.drawable.gym),
                new TabsWizardModel("Bookstore", R.drawable.bookstore),
                new TabsWizardModel("Student Services", R.drawable.service),
                new TabsWizardModel("Botanical Gardens", R.drawable.garden),
        };
        expandableListAdapter = new CustomExpandableListAdapter(this, dininghall_data, expandableListDetail);
        expandableListView.setAdapter(expandableListAdapter);

        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v,
                                        int groupPosition, int childPosition, long id) {
                Toast.makeText(
                        getApplicationContext(),
                        dininghall_data[groupPosition]
                                + " -> "
                                + expandableListDetail.get(
                                dininghall_data[groupPosition]).get(
                                childPosition), Toast.LENGTH_SHORT
                ).show();
                return false;
            }
        });
    }

    private void back(){
        Intent intent = new Intent(ServiceHours.this, AccountActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
        finish();
    }
}