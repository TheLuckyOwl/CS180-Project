package theunderground.com.ucrmap;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Toast;

/**
 * Created by Dharti on 5/20/2016.
 */
public class AddRoomActivity extends Activity{
    private Button mSubmitNew = null;
    private Button mBackRem = null;
    private Spinner mBuilding;
    ArrayAdapter<CharSequence> adapter;
    private EditText mClassNum = null;
    private EditText mComment = null;
    private String selectedBuild = "";
    private boolean room = false;
    ArrayList<Classroom> returnValues = new ArrayList<>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_room_activity_layout);

        mBackRem = (Button) this.findViewById(R.id.bBackToSearch);
        mSubmitNew = (Button) this.findViewById(R.id.bSubClass);
        mBuilding = (Spinner) this.findViewById(R.id.sBuilding);
        mClassNum = (EditText) this.findViewById(R.id.etClassNum);
        mComment = (EditText) this.findViewById(R.id.etAddComment);
        adapter = ArrayAdapter.createFromResource(this,R.array.Building_Names,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mBuilding.setAdapter(adapter);
        mBuilding.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selectedBuild = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

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
                final String Comment1 = mComment.getText().toString();

                if(classNum.equals("") || selectedBuild.equals(""))
                {
                    Toast.makeText(AddRoomActivity.this, "Please select a Room and Building", Toast.LENGTH_SHORT).show();
                }
                else if(!classNum.equals("") && !selectedBuild.equals("")) {
                    for (Classroom x : returnValues) {
                        if (x.getBuilding_name().equals(selectedBuild)) {
                            if (x.getClassroom_name().equals(classNum)) {
                                room = true;
                            }
                        }
                    }

                    if (room) {
                        Toast.makeText(AddRoomActivity.this, "That room already exists", Toast.LENGTH_SHORT).show();
                    } else {
                        Classroom newClass = new Classroom();
                        newClass.Building_name = selectedBuild;
                        newClass.Classroom_name = classNum;
                        newClass.Comment1 = Comment1;

                        SaveClassAsyncTask tsk = new SaveClassAsyncTask();
                        tsk.execute(newClass);
                        Toast.makeText(AddRoomActivity.this, "Created the class Successfully", Toast.LENGTH_SHORT).show();
                        Intent i = new Intent(AddRoomActivity.this, RateRoomActivity.class);
                        startActivity(i);
                    }
                }
            }
        });

        mBackRem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(AddRoomActivity.this, RateRoomActivity.class);
                startActivity(i);
            }
        });

    }
}
