package theunderground.com.ucrmap;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;

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
        mAdd = (Button)findViewById(R.id.addClass);
        mCancel= (Button)findViewById(R.id.cancel);
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
    //======================================================================================

    private void showScheduleActivity() {
        Intent i = new Intent(this, ScheduleActivity.class);
        if (findViewById(R.id.addClassRow1).toString() != null) {
            i.putExtra("ClassRow1", findViewById(R.id.addClassRow1).toString());
        }
        if (findViewById(R.id.addTimeRow1).toString() != null) {
            i.putExtra("TimeRow1", findViewById(R.id.addTimeRow1).toString());
        }
        if (findViewById(R.id.addDayRow1).toString() != null) {
            i.putExtra("DayRow1", findViewById(R.id.addDayRow1).toString());
        }

        if (findViewById(R.id.addClassRow2).toString() != null) {
            i.putExtra("ClassRow2", findViewById(R.id.addClassRow2).toString());
        }
        if (findViewById(R.id.addTimeRow2).toString() != null) {
            i.putExtra("TimeRow2", findViewById(R.id.addTimeRow2).toString());
        }
        if (findViewById(R.id.addDayRow2).toString() != null) {
            i.putExtra("DayRow2", findViewById(R.id.addDayRow2).toString());
        }

        if (findViewById(R.id.addClassRow3).toString() != null) {
            i.putExtra("ClassRow3", findViewById(R.id.addClassRow3).toString());
        }
        if (findViewById(R.id.addTimeRow3).toString() != null) {
            i.putExtra("TimeRow3", findViewById(R.id.addTimeRow3).toString());
        }
        if (findViewById(R.id.addDayRow3).toString() != null) {
            i.putExtra("DayRow3", findViewById(R.id.addDayRow3).toString());
        }
        startActivity(i);
    }

    private void showCancelActivity() {
        Intent i = new Intent(this, ScheduleActivity.class);
        startActivity(i);
    }
}
