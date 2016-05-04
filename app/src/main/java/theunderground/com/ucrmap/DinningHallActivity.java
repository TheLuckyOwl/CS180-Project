package theunderground.com.ucrmap;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ListView;


/**
 * Created by Larry Parsons on 4/14/2016.
 */
public class DinningHallActivity extends Activity {
    //for the Navigation Drawer
    SharedPreferences prefs = null;
    private String[] mMenuTitles = null;
    private DrawerLayout mDrawerLayout = null;
    private ListView mDrawerList = null;
    private ImageButton mButton = null;
    //==================================
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        prefs = this.getSharedPreferences("Login", Context.MODE_PRIVATE);
        setContentView(R.layout.dinning_hall_activity_layout);
        RecyclerView recyclerView = (RecyclerView) this.findViewById(R.id.recyclerViewTab);
        TabWizardAdapter mAdapter;
        TabsWizardModel dininghall_data[] = {new TabsWizardModel("AI", R.drawable.ai),
                new TabsWizardModel("Lothian", R.drawable.lothian),
                new TabsWizardModel("Spinelli's", R.drawable.spinelli),
                new TabsWizardModel("Glen Mor Market Shop", R.drawable.gmshop),
                new TabsWizardModel("Glen Mor Market Sizzle", R.drawable.gmsizzle),
                new TabsWizardModel("Glen Mor Market Savor", R.drawable.gmsavor),
                new TabsWizardModel("Glen Mor Market Starbucks", R.drawable.gmstarbucks),
                new TabsWizardModel("HUB Scotty's", R.drawable.hubscot),
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
        mAdapter = new TabWizardAdapter(dininghall_data);
        // 2. set layoutManger
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        // 4. set adapter
        recyclerView.setAdapter(mAdapter);
        // 5. set item animator to DefaultAnimator
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(this, recyclerView, new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                int firstChoice = position;
                solutions(firstChoice);
            }

            @Override
            public void onItemLongClick(View view, int position) {
                // ...
            }
        }));

        //Navigation Drawer Definitions
        mMenuTitles = getResources().getStringArray(R.array.menu_array);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerList = (ListView) findViewById(R.id.left_drawer);

        mButton = (ImageButton)this.findViewById(R.id.button);
        mButton = (ImageButton) this.findViewById(R.id.button);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mDrawerLayout.openDrawer(mDrawerList);
            }
        });

        // set a custom shadow that overlays the main content when the drawer opens
        mDrawerLayout.setDrawerShadow(R.drawable.drawer_shadow, GravityCompat.START);
        // set up the drawer's list view with items and click listener
        mDrawerList.setAdapter(new ArrayAdapter<String>(this,
                R.layout.drawer_list_item, mMenuTitles));
        mDrawerList.setOnItemClickListener(new DrawerItemClickListener());
        //================================================================================

    }
    //======================================================================================
    /* The click listener for ListView in the navigation drawer */
    private class DrawerItemClickListener implements ListView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            selectItem(position);
        }
    }

    private void selectItem(int position) {
        //Home
        if(position == 0){
            Intent i = new Intent(this, AccountActivity.class);
            startActivity(i);
        }
        //UCR Map
        else if(position == 1){
            Intent i = new Intent(this, UCRMapActivity.class);
            startActivity(i);
        }
        //Campus Safety
        else if(position == 2){
            Intent i = new Intent(this, CampusSafetyActivity.class);
            startActivity(i);
        }
        //ILearn
        if(position == 3){
            Intent i = new Intent(this, ILearnActivity.class);
            startActivity(i);
        }
        //Dining Hall
        else if(position == 4){
            Intent i = new Intent(this, DinningHallActivity.class);
            startActivity(i);
        }
        //Library Registration
        else if(position == 5){
            Intent i = new Intent(this, LibraryActivity.class);
            startActivity(i);
        }
        //Contact Us
        else if(position == 6){
            Intent i = new Intent(this, ContactUsActivity.class);
            startActivity(i);
        }
        //Sign Out
        else if(position == 7){
            // Clear out the shared preferences.
            SharedPreferences.Editor editor = prefs.edit();
            editor.putString(LoginActivity.USER_ID_PREF, null);
            editor.putBoolean(LoginActivity.LOGGED_IN_PREF, false);
            editor.commit();

            Intent i = new Intent(this, LoginActivity.class);
            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(i);
        }
        mDrawerLayout.closeDrawer(mDrawerList);
    }

    public void solutions(int firstChoice){
        Intent i = new Intent(DinningHallActivity.this, MenuDisplay.class);

        if (firstChoice == 0){
            i.putExtra("Path", "file:///android_asset/ai.html");
        }
        else if (firstChoice == 1){
            i.putExtra("Path", "file:///android_asset/lothian.html");
        }
        else if (firstChoice == 2){
            i.putExtra("Path", "file:///android_asset/spinelli.html");
        }
        else if (firstChoice == 3){
            i.putExtra("Path", "file:///android_asset/gmshop.html");
        }
        else if (firstChoice == 4){
            i.putExtra("Path", "file:///android_asset/gmsizzle.html");
        }
        else if (firstChoice == 5){
            i.putExtra("Path", "file:///android_asset/gmsavor.html");
        }
        else if (firstChoice == 6){
            i.putExtra("Path", "file:///android_asset/gmstarbucks.html");
        }
        else if (firstChoice == 7){
            i.putExtra("Path", "file:///android_asset/hubscot.html");
        }
        else if (firstChoice == 8){
            i.putExtra("Path", "file:///android_asset/aiscot.html");
        }
        else if (firstChoice == 9){
            i.putExtra("Path", "file:///android_asset/lothianscot.html");
        }
        else if (firstChoice == 10){
            i.putExtra("Path", "file:///android_asset/gmscot.html");
        }
        else if (firstChoice == 11){
            i.putExtra("Path", "file:///android_asset/medschot.html");
        }
        else if (firstChoice == 12){
            i.putExtra("Path", "file:///android_asset/barn.html");
        }
        else if (firstChoice == 13){
            i.putExtra("Path", "file:///android_asset/bytes.html");
        }
        else if (firstChoice == 14){
            i.putExtra("Path", "file:///android_asset/ivan.html");
        }
        else if (firstChoice == 15){
            i.putExtra("Path", "file:///android_asset/subway.html");
        }
        else if (firstChoice == 16){
            i.putExtra("Path", "file:///android_asset/habanero.html");
        }
        else if (firstChoice == 17){
            i.putExtra("Path", "file:///android_asset/hub.html");
        }
        else if (firstChoice == 18){
            i.putExtra("Path", "file:///android_asset/panda.html");
        }
        else if (firstChoice == 19){
            i.putExtra("Path", "file:///android_asset/pandasushi.html");
        }
        else if (firstChoice == 20){
            i.putExtra("Path", "file:///android_asset/fiamma.html");
        }
        else if (firstChoice == 21){
            i.putExtra("Path", "file:///android_asset/grill.html");
        }
        else if (firstChoice == 22){
            i.putExtra("Path", "file:///android_asset/coffeebean.html");
        }
        else if (firstChoice == 23){
            i.putExtra("Path", "file:///android_asset/chameleon.html");
        }
        else if (firstChoice == 24){
            i.putExtra("Path", "file:///android_asset/moomoo.html");
        }
        else if (firstChoice == 25){
            i.putExtra("Path", "file:///android_asset/highlander.html");
        }
        else if (firstChoice == 26){
            i.putExtra("Path", "file:///android_asset/beartracks.html");
        }
        startActivity(i);
    }
}
