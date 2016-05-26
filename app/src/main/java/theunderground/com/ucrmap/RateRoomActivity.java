package theunderground.com.ucrmap;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

/**
 * Created by Dharti on 5/19/2016.
 */
public class RateRoomActivity extends Activity {
    ArrayList<Classroom> returnValues = new ArrayList<>();
    private Button mGo = null;
    private Button mAdd = null;
    private EditText mSearch = null;
    private String LoggedinUser = LoginActivity.LoggedUser;
    private boolean isFound = false;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rate_room_activity_layout);

        GetClassroomAsyncTask task = new GetClassroomAsyncTask();
        try {
            returnValues = task.execute().get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        mGo = (Button) findViewById(R.id.button3);
        mSearch = (EditText) findViewById(R.id.searchText);
        mAdd = (Button) findViewById(R.id.button2);

        mGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String searchData = mSearch.getText().toString();
                final String[] searchSplit = searchData.split(" ");

                for(Classroom x: returnValues) {
                    if (x.getBuilding_name().equals(searchSplit[0])) {
                        if (x.getClassroom_name().equals(searchSplit[1])) {
                            isFound = true;
                            Intent i = new Intent(RateRoomActivity.this, RoomPageActivity.class);
                            i.putExtra("BuildingName", searchSplit[0]);
                            i.putExtra("ClassroomName", searchSplit[1]);
                            startActivity(i);
                        }
                    }
                }

                if (!isFound) {
                    //Toast.makeText(getApplicationContext(), "Class not found. Try adding it!", Toast.LENGTH_LONG).show();
                    new AlertDialog.Builder(RateRoomActivity.this)
                            .setIcon(android.R.drawable.ic_dialog_alert)
                            .setTitle("Class not found.")
                            .setMessage("Try adding it!")
                            .setPositiveButton("Ok", null)
                            .show();
                }
            }
        });

        mAdd = (Button) findViewById(R.id.button2);
        mAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(RateRoomActivity.this, AddRoomActivity.class);
                startActivity(i);
            }
        });
    }
}
