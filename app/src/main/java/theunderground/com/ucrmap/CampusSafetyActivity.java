package theunderground.com.ucrmap;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Created by Larry Parsons on 4/14/2016.
 */
public class CampusSafetyActivity extends Activity{
    TextView mCallUCPD = null;
    TextView mCallCSES = null;
    TextView mCall911 = null;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.campus_safety_activity_layout);

        mCallUCPD = (TextView)findViewById(R.id.callUCPD);
        mCallCSES = (TextView)findViewById(R.id.callCSES);
        mCallCSES = (TextView)findViewById(R.id.call911);
    }
}
