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

    SharedPreferences prefs = null;

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
    }
}
