package theunderground.com.ucrmap;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by Dharti on 5/2/2016.
 */
public class AddClassActivity extends Activity {
    private Button mAdd = null;
    private Button mCancel = null;
    @Override
    protected void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.add_class_layout);

        mAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showScheduleActivity();
            }
        });

        mCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showCancelActivity();
            }
        });
    }

    private void showScheduleActivity() {
        Intent i = new Intent(this, ScheduleActivity.class);
        startActivity(i);
    }

    private void showCancelActivity() {
        Intent i = new Intent(this, ScheduleActivity.class);
        startActivity(i);
    }
}
