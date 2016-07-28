package theunderground.com.ucrmap;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Roger on 5/26/2016.
 */
public class FriendListActivity extends Activity {
    private ImageButton mBackButton = null;
    private Button mAddFriend = null;
    private Button mSearch = null;
    ExpandableListView expandableListView;
    ExpandableListAdapter expandableListAdapter;
    HashMap<String, List<String>> expandableListDetail;
    SharedPreferences prefs = null;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.friend_list_activity_layout);
        mBackButton = (ImageButton) findViewById(R.id.backImage);
        mAddFriend = (Button) findViewById(R.id.bAddFriend);
        mSearch = (Button) findViewById(R.id.bBFLSearch);
        prefs = this.getSharedPreferences("Login", Context.MODE_PRIVATE);
        expandableListView = (ExpandableListView) findViewById(R.id.expandableListView);
//        expandableListDetail = FriendList.getData();
        expandableListDetail = DiningHoursList.getData();

        mBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FriendListActivity.this, AccountActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                finish();
            }
        });

        mSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(FriendListActivity.this, FriendSearchActivity.class));
            }
        });

        mAddFriend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(FriendListActivity.this, AddFriendActivity.class));
            }
        });

        final TabsWizardModel friendList_data[] = {
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
                new TabsWizardModel("Bear Tracks", R.drawable.beartracks),
        };

        expandableListAdapter = new CustomExpandableListAdapter(this, friendList_data, expandableListDetail);
        expandableListView.setAdapter(expandableListAdapter);

        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v,
                                        int groupPosition, int childPosition, long id) {
                Toast.makeText(
                        getApplicationContext(),
                        friendList_data[groupPosition]
                                + " -> "
                                + expandableListDetail.get(
                                friendList_data[groupPosition]).get(
                                childPosition), Toast.LENGTH_SHORT
                ).show();
                return false;
            }
        });
    }

    private void back(){
        Intent intent = new Intent(FriendListActivity.this, AccountActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
        finish();
    }
}