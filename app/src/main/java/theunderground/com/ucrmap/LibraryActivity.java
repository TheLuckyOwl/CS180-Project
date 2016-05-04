package theunderground.com.ucrmap;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.view.View;
import android.webkit.ValueCallback;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;

/**
 * Created by Larry Parsons on 4/14/2016.
 */
public class LibraryActivity extends Activity {
    //for the Navigation Drawer
    SharedPreferences prefs = null;

    private String[] mMenuTitles = null;
    private DrawerLayout mDrawerLayout = null;
    private ListView mDrawerList = null;
    private ImageButton mButton = null;
    //==================================

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        prefs = this.getSharedPreferences("Login", Context.MODE_PRIVATE);
        setContentView(R.layout.library_activity_layout);

        WebView view = (WebView) this.findViewById(R.id.libView);

        view.getSettings().setJavaScriptEnabled(true);
        view.getSettings().setDomStorageEnabled(true);

        view.loadUrl("http://ucr.evanced.info/dibs/Login");

        view.setWebViewClient(new WebViewClient() {

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);

                final String password = "password";
                final String username = "username";

                final String js = "javascript: function() {" +
                        "document.getElementById('username').value = '" + username + "';"  +
                        "document.getElementById('password').value = '" + password + "';"  +
                        "var ans = document.getElementsByName('loginForm');"                  +
                        "ans[0].submit(); };";

                view.loadUrl(js);

            }
        });

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

}
