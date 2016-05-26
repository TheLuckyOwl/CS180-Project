package theunderground.com.ucrmap;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

/**
 * Created by Dharti on 5/20/2016.
 */
public class RoomPageActivity extends Activity {
    private Button mAddComm = null;
    private ImageButton mBackButton = null;
    ArrayList<Classroom> returnValues = new ArrayList<>();
    private Classroom CurrentClassroom = new Classroom();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.room_page_activity_layout);
        Bundle bundle = getIntent().getExtras();
        String Building_name = bundle.getString("BuildingName");
        String Classroom_name = bundle.getString("ClassroomName");
        RecyclerView recyclerView = (RecyclerView) this.findViewById(R.id.listView2);
        mBackButton = (ImageButton) this.findViewById(R.id.backButton);
        mAddComm = (Button)findViewById(R.id.addComment);

        GetClassroomAsyncTask task = new GetClassroomAsyncTask();
        try {
            returnValues = task.execute().get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        for (Classroom x : returnValues)
        {
            if(x.getBuilding_name().equals(Building_name))
            {
                if(x.getClassroom_name().equals(Classroom_name))
                {
                    CurrentClassroom.setDoc_id(x.getDoc_id());
                    CurrentClassroom.setClassroom_name(x.getClassroom_name());
                    CurrentClassroom.setBuilding_name(x.getBuilding_name());
                    CurrentClassroom.setComment1(x.getComment1());
                    CurrentClassroom.setComment2(x.getComment2());
                    CurrentClassroom.setComment3(x.getComment3());
                    CurrentClassroom.setComment4(x.getComment4());
                    CurrentClassroom.setComment5(x.getComment5());
                    CurrentClassroom.setComment6(x.getComment6());
                    CurrentClassroom.setComment7(x.getComment7());
                    CurrentClassroom.setComment8(x.getComment8());
                    CurrentClassroom.setComment9(x.getComment9());
                    CurrentClassroom.setComment10(x.getComment10());
                }
            }
        }

        ClassroomAdapter mAdapter;
        ClassroomModel Data[] = {new ClassroomModel(CurrentClassroom.getComment1()),
                new ClassroomModel(CurrentClassroom.getComment2()),
                new ClassroomModel(CurrentClassroom.getComment3()),
                new ClassroomModel(CurrentClassroom.getComment4()),
                new ClassroomModel(CurrentClassroom.getComment5()),
                new ClassroomModel(CurrentClassroom.getComment6()),
                new ClassroomModel(CurrentClassroom.getComment7()),
                new ClassroomModel(CurrentClassroom.getComment8()),
                new ClassroomModel(CurrentClassroom.getComment9()),
                new ClassroomModel(CurrentClassroom.getComment10())
        };

        mAdapter = new ClassroomAdapter(Data);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        // 4. set adapter
        recyclerView.setAdapter(mAdapter);
        // 5. set item animator to DefaultAnimator
        recyclerView.setItemAnimator(new DefaultItemAnimator());


        mAddComm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //startActivity(new Intent(RoomPageActivity.this, AddCommentActivity.class));
                showInputDialog();
            }
        });

        mBackButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                back();
            }
        });

    }

    // THANK YOU STACK OVERFLOW

    protected void showInputDialog() {
        LayoutInflater layoutInflater = LayoutInflater.from(RoomPageActivity.this);
        View promptView = layoutInflater.inflate(R.layout.add_comment_activity_layout, null);
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(RoomPageActivity.this);
        alertDialogBuilder.setView(promptView);

        final EditText inputTxt = (EditText) promptView.findViewById(R.id.editComm);
        // setup a dialog window
        alertDialogBuilder.setCancelable(false)
                .setPositiveButton("Post", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // THIS IS WHERE THE INPUT IS SAVED IN A TEXT VIEW
                        String comment  = inputTxt.getText().toString();
                        if(CurrentClassroom.getComment1().equals(""))
                        {
                            CurrentClassroom.setComment1(comment);
                            UpdateClassroom tsk = new UpdateClassroom();
                            tsk.execute(CurrentClassroom);
                        }
                        else if(CurrentClassroom.getComment2().equals(""))
                        {
                            CurrentClassroom.setComment2(comment);
                            UpdateClassroom tsk = new UpdateClassroom();
                            tsk.execute(CurrentClassroom);
                        }
                        else if(CurrentClassroom.getComment3().equals(""))
                        {
                            CurrentClassroom.setComment3(comment);
                            UpdateClassroom tsk = new UpdateClassroom();
                            tsk.execute(CurrentClassroom);
                        }
                        else if(CurrentClassroom.getComment4().equals(""))
                        {
                            CurrentClassroom.setComment4(comment);
                            UpdateClassroom tsk = new UpdateClassroom();
                            tsk.execute(CurrentClassroom);;
                        }
                        else if(CurrentClassroom.getComment5().equals(""))
                        {
                            CurrentClassroom.setComment5(comment);
                            UpdateClassroom tsk = new UpdateClassroom();
                            tsk.execute(CurrentClassroom);
                        }
                        else if(CurrentClassroom.getComment6().equals(""))
                        {
                            CurrentClassroom.setComment6(comment);
                            UpdateClassroom tsk = new UpdateClassroom();
                            tsk.execute(CurrentClassroom);
                        }
                        else if(CurrentClassroom.getComment7().equals(""))
                        {
                            CurrentClassroom.setComment7(comment);
                            UpdateClassroom tsk = new UpdateClassroom();
                            tsk.execute(CurrentClassroom);
                        }
                        else if(CurrentClassroom.getComment8().equals(""))
                        {
                            CurrentClassroom.setComment8(comment);
                            UpdateClassroom tsk = new UpdateClassroom();
                            tsk.execute(CurrentClassroom);
                        }
                        else if(CurrentClassroom.getComment9().equals(""))
                        {
                            CurrentClassroom.setComment9(comment);
                            UpdateClassroom tsk = new UpdateClassroom();
                            tsk.execute(CurrentClassroom);
                        }
                        else if(CurrentClassroom.getComment10().equals(""))
                        {
                            CurrentClassroom.setComment10(comment);
                            UpdateClassroom tsk = new UpdateClassroom();
                            tsk.execute(CurrentClassroom);
                        }
                        else
                        {
                            CurrentClassroom.setComment1(CurrentClassroom.getComment2());
                            CurrentClassroom.setComment2(CurrentClassroom.getComment3());
                            CurrentClassroom.setComment3(CurrentClassroom.getComment4());
                            CurrentClassroom.setComment4(CurrentClassroom.getComment5());
                            CurrentClassroom.setComment5(CurrentClassroom.getComment6());
                            CurrentClassroom.setComment6(CurrentClassroom.getComment7());
                            CurrentClassroom.setComment7(CurrentClassroom.getComment8());
                            CurrentClassroom.setComment8(CurrentClassroom.getComment9());
                            CurrentClassroom.setComment9(CurrentClassroom.getComment10());
                            CurrentClassroom.setComment10(comment);
                            UpdateClassroom tsk = new UpdateClassroom();
                            tsk.execute(CurrentClassroom);

                        }
                    }
                })
                .setNegativeButton("Cancel",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });

        // create an alert dialog
        AlertDialog alert = alertDialogBuilder.create();
        alert.show();

    }

    private void back(){
        Intent intent = new Intent(RoomPageActivity.this, RateRoomActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
        finish();
    }
}
