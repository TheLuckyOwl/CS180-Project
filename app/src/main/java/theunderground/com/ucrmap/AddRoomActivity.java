package theunderground.com.ucrmap;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Toast;

/**
 * Created by Dharti on 5/20/2016.
 */
public class AddRoomActivity extends Activity implements OnItemSelectedListener{
    private Button mSubmitNew = null;
    private Button mBack = null;
    private Spinner mBuilding = null;
    private EditText mClassNum = null;
    private String selectedBuild = null;
    private boolean room = false;
    private boolean building = false;
    ArrayList<Classroom> returnValues = new ArrayList<>();
    String[] items = new String[]{"WCH", "MSE", "INTS", "INTN", "OLMH", "ANDHL", "BOYHL", "ARTS", "ATH", "BATCH", "HOUSE",
            "BRNHL", "SURGE", "CHEM", "ENTOM", "ENTMU", "GENOM", "GEOL", "WAT" , "CHPHL", "HUMN", "HMNSS", "LFSC", "PHY",
            "PRCE", "PSYCH", "SCLAB1", "SPTH", "SPR", "BARN", "UNLH", "UV", "CHUNG"};

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_room_activity_layout);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, items);
        mBuilding.setAdapter(adapter);
        mBuilding.setOnItemSelectedListener(this);
        mBack = (Button) this.findViewById(R.id.bBackToSearch);
        mSubmitNew = (Button) this.findViewById(R.id.bSubClass);
        mBuilding = (Spinner) this.findViewById(R.id.sBuilding);
        mClassNum = (EditText) this.findViewById(R.id.etClassNum);

        GetClassroomAsyncTask task = new GetClassroomAsyncTask();
        try {
            returnValues = task.execute().get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        mSubmitNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String classNum = mClassNum.getText().toString();

                if(classNum.equals("") || selectedBuild.equals(""))
                {
                    Toast.makeText(AddRoomActivity.this, "Please select a Room and Building", Toast.LENGTH_SHORT).show();
                }
                else if(!classNum.equals("") && !selectedBuild.equals(""))
                {
                    for(Classroom x: returnValues) {
                        //if (x.getBuilding_name() == )
                    }
                }


            }
        });

    }
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        selectedBuild = parent.getItemAtPosition(position).toString();
    }
    public void onNothingSelected(AdapterView<?> arg0) {
        selectedBuild = "";
    }
}
