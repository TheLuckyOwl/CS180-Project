package theunderground.com.ucrmap;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;

/**
 * Created by Larry Parsons on 4/14/2016.
 */
public class LibraryActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.library_activity_layout);

        String url = "http://ucr.evanced.info/dibs/Login";
        WebView view = (WebView) this.findViewById(R.id.webView);
        view.loadUrl(url);


    }
}
