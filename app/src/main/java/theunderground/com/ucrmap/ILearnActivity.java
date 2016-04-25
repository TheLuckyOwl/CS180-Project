package theunderground.com.ucrmap;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * Created by Larry Parsons on 4/14/2016.
 */
public class ILearnActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ilearn_activity_layout);

        String url = "https://ilearn.ucr.edu";
        WebView view = (WebView) this.findViewById(R.id.webView);
        view.loadUrl(url);

        view.getSettings().setJavaScriptEnabled(true);
        view.getSettings().setDomStorageEnabled(true);
        //view.setInitialScale(1);
        view.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);

                final String password = "password";  //TODO replace from database
                final String uname = "username";       //TODO replace from database

                view.loadUrl("javascript: {" +
                        "document.getElementById('username').value = '"+ uname +"';" +
                        "document.getElementById('password').value = '"+password+"';" +
                        "var frms = document.getElementsByName('loginForm');" +
                        "frms[0].submit(); };");
            }
        });
    }
}