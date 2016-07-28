package theunderground.com.ucrmap;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
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
 * Created by Larry Parsons on 4/14/2016.
 */
public class DiningHallActivity extends Activity {

    ExpandableListView expandableListView;
    ExpandableListAdapter expandableListAdapter;
    HashMap<String, List<String>> expandableListDetail;
    SharedPreferences prefs = null;
    private ImageButton mBackButton = null;
    private TextView mTitle = null;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        prefs = this.getSharedPreferences("Login", Context.MODE_PRIVATE);
        setContentView(R.layout.dining_hall_activity_layout);
        mTitle = (TextView)findViewById(R.id.diningTitle);
        mTitle.setText("Dining");
        mBackButton = (ImageButton)findViewById(R.id.backButton);
        mBackButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                back();
            }
        });
        expandableListView = (ExpandableListView) findViewById(R.id.expandableListView);
        expandableListDetail = DiningHoursList.getData();

        final TabsWizardModel dininghall_data[] = {
                new TabsWizardModel("AI", R.drawable.ai),
                new TabsWizardModel("Lothian", R.drawable.lothian),
                new TabsWizardModel("Spinelli's", R.drawable.spinelli),
                new TabsWizardModel("Glen Mor Market Shop", R.drawable.gmshop),
                new TabsWizardModel("Glen Mor Market Sizzle", R.drawable.gmsizzle),
                new TabsWizardModel("Glen Mor Market Savor", R.drawable.gmsavor),
                new TabsWizardModel("Glen Mor Market Starbucks", R.drawable.gmstarbucks),
                new TabsWizardModel("HUB Scotty's", R.drawable.scottys),
                new TabsWizardModel("AI Scotty's", R.drawable.scottys),
                new TabsWizardModel("Lothian Scotty's", R.drawable.scottys),
                new TabsWizardModel("Glen Mor Scotty's", R.drawable.scottys),
                new TabsWizardModel("School of Medicine Scotty's", R.drawable.scottys),
                new TabsWizardModel("The Barn", R.drawable.barn),
                new TabsWizardModel("Bytes", R.drawable.bytes),
                new TabsWizardModel("Ivan's", R.drawable.ivan),
                new TabsWizardModel("Subway", R.drawable.subway),
                new TabsWizardModel("Habanero's", R.drawable.habanero),
                new TabsWizardModel("HUB2GO", R.drawable.hub),
                new TabsWizardModel("Panda Express", R.drawable.panda),
                new TabsWizardModel("Panda Express Sushi", R.drawable.pandasushi),
                new TabsWizardModel("La Fiamma", R.drawable.fiamma),
                new TabsWizardModel("The Grill", R.drawable.grill),
                new TabsWizardModel("Coffee Bean", R.drawable.coffeebean),
                new TabsWizardModel("Chameleon", R.drawable.chameleon),
                new TabsWizardModel("Moo Moo", R.drawable.moomoo),
                new TabsWizardModel("Highlander", R.drawable.highlander),
                new TabsWizardModel("Bear Tracks", R.drawable.beartracks)
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
        Intent intent = new Intent(DiningHallActivity.this, AccountActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
        finish();
    }
}
