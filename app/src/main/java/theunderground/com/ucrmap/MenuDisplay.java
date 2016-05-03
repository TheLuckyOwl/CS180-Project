package theunderground.com.ucrmap;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;

/**
 * Created by Sara on 5/2/16.
 */
public class MenuDisplay extends Activity {
    WebView mWebView = null;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_display_layout);
        mWebView = (WebView) findViewById(R.id.webView);
        mWebView.setLayerType(View.LAYER_TYPE_SOFTWARE, null);
        Bundle bundle = getIntent().getExtras();
        String filePath = bundle.getString("Path");
        mWebView.loadUrl(filePath);

    }
}
