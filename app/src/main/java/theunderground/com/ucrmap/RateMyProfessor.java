package theunderground.com.ucrmap;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;


/**
 * Created by Sara on 5/19/16.
 */
public class RateMyProfessor extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rate_my_professor_layout);
        String url = "http://www.ratemyprofessors.com/campusRatings.jsp?sid=1076";
        WebView view = (WebView) this.findViewById(R.id.webView);
        view.loadUrl(url);
    }

}
