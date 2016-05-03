package theunderground.com.ucrmap;

import android.app.Activity;
import android.content.Intent;
import android.widget.Button;

/**
 * Created by Dharti on 5/2/2016.
 */
public class AddClassActivity extends Activity {
    private Button mAdd = null;
    private Button mCancel = null;

    mAdd.setOnClickListener(new OnClickListener() {
        @Override
        public void onClick(View view) {
            showScheduleActivity();
        }
    });

    mCancel.setOnClickListener(new OnClickListener() {
        @Override
        public void onClick(View view) {
            showCancelActivity();
        }
    });

    private void showScheduleActivity() {
        Intent i = new Intent(this, ScheduleActivity.class);
        i.putExtra("Class", );
        i.putExtra("Time", );
        i.putExtra("Day", );
        startActivity(i);
    }

    private void showCancelActivity() {
        Intent i = new Intent(this, ScheduleActivity.class);
        startActivity(i);
    }
}
