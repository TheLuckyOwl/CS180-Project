package theunderground.com.ucrmap;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.ads.doubleclick.CustomRenderedAd;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

/**
 * Created by Dharti on 5/2/2016.
 */
public class RemoveClassActivity extends Activity{
    private Button mErase = null;
    private Button mClearAll = null;
    private Button mCancel = null;
    private EditText mClassInd = null;
    private User CurrentUser = new User();
    private String LoggedinUser = LoginActivity.LoggedUser;
    ArrayList<User> returnValues = new ArrayList<User>();

    protected void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.remove_class_activity_layout);

        mErase = (Button) findViewById(R.id.bRemove);
        mCancel = (Button) findViewById(R.id.bCanRem);
        mClearAll = (Button)findViewById(R.id.bClearAll);
        mClassInd = (EditText) findViewById(R.id.etGrabClass);

        GetUsersAsyncTask task = new GetUsersAsyncTask();
        try {
            returnValues = task.execute().get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        mErase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String classString = mClassInd.getText().toString();
                final int classNum = Integer.parseInt(classString);

                if(classNum > 0 && classNum < 11)
                {
                    if(classNum == 1 && !CurrentUser.getClass1Data().equals(""))
                    {
                        CurrentUser.setClass1Data(CurrentUser.getClass2Data());
                        CurrentUser.setClass1Day(CurrentUser.getClass2Day());
                        CurrentUser.setClass1Time(CurrentUser.getClass2Time());
                        CurrentUser.setClass2Data(CurrentUser.getClass3Data());
                        CurrentUser.setClass2Day(CurrentUser.getClass3Day());
                        CurrentUser.setClass2Time(CurrentUser.getClass3Time());
                        CurrentUser.setClass3Data(CurrentUser.getClass4Data());
                        CurrentUser.setClass3Day(CurrentUser.getClass4Day());
                        CurrentUser.setClass3Time(CurrentUser.getClass4Time());
                        CurrentUser.setClass4Data(CurrentUser.getClass5Data());
                        CurrentUser.setClass4Day(CurrentUser.getClass5Day());
                        CurrentUser.setClass4Time(CurrentUser.getClass5Time());
                        CurrentUser.setClass5Data(CurrentUser.getClass6Data());
                        CurrentUser.setClass5Day(CurrentUser.getClass6Day());
                        CurrentUser.setClass5Time(CurrentUser.getClass6Time());
                        CurrentUser.setClass6Data(CurrentUser.getClass7Data());
                        CurrentUser.setClass6Day(CurrentUser.getClass7Day());
                        CurrentUser.setClass6Time(CurrentUser.getClass7Time());
                        CurrentUser.setClass7Data(CurrentUser.getClass8Data());
                        CurrentUser.setClass7Day(CurrentUser.getClass8Day());
                        CurrentUser.setClass7Time(CurrentUser.getClass8Time());
                        CurrentUser.setClass8Data(CurrentUser.getClass9Data());
                        CurrentUser.setClass8Day(CurrentUser.getClass9Day());
                        CurrentUser.setClass8Time(CurrentUser.getClass9Time());
                        CurrentUser.setClass9Data(CurrentUser.getClass10Data());
                        CurrentUser.setClass9Day(CurrentUser.getClass10Day());
                        CurrentUser.setClass9Time(CurrentUser.getClass10Time());
                        CurrentUser.setClass10Data("");
                        CurrentUser.setClass10Day("");
                        CurrentUser.setClass10Time("");
                        UpdateUser tsk = new UpdateUser();
                        tsk.execute(CurrentUser);

                    }
                    else if(classNum == 1 && CurrentUser.getClass1Data().equals(""))
                    {
                        Toast.makeText(RemoveClassActivity.this, "Class 1 is already empty", Toast.LENGTH_LONG).show();
                    }
                    else if(classNum == 2 && !CurrentUser.getClass2Data().equals(""))
                    {
                        CurrentUser.setClass2Data(CurrentUser.getClass3Data());
                        CurrentUser.setClass2Day(CurrentUser.getClass3Day());
                        CurrentUser.setClass2Time(CurrentUser.getClass3Time());
                        CurrentUser.setClass3Data(CurrentUser.getClass4Data());
                        CurrentUser.setClass3Day(CurrentUser.getClass4Day());
                        CurrentUser.setClass3Time(CurrentUser.getClass4Time());
                        CurrentUser.setClass4Data(CurrentUser.getClass5Data());
                        CurrentUser.setClass4Day(CurrentUser.getClass5Day());
                        CurrentUser.setClass4Time(CurrentUser.getClass5Time());
                        CurrentUser.setClass5Data(CurrentUser.getClass6Data());
                        CurrentUser.setClass5Day(CurrentUser.getClass6Day());
                        CurrentUser.setClass5Time(CurrentUser.getClass6Time());
                        CurrentUser.setClass6Data(CurrentUser.getClass7Data());
                        CurrentUser.setClass6Day(CurrentUser.getClass7Day());
                        CurrentUser.setClass6Time(CurrentUser.getClass7Time());
                        CurrentUser.setClass7Data(CurrentUser.getClass8Data());
                        CurrentUser.setClass7Day(CurrentUser.getClass8Day());
                        CurrentUser.setClass7Time(CurrentUser.getClass8Time());
                        CurrentUser.setClass8Data(CurrentUser.getClass9Data());
                        CurrentUser.setClass8Day(CurrentUser.getClass9Day());
                        CurrentUser.setClass8Time(CurrentUser.getClass9Time());
                        CurrentUser.setClass9Data(CurrentUser.getClass10Data());
                        CurrentUser.setClass9Day(CurrentUser.getClass10Day());
                        CurrentUser.setClass9Time(CurrentUser.getClass10Time());
                        CurrentUser.setClass10Data("");
                        CurrentUser.setClass10Day("");
                        CurrentUser.setClass10Time("");
                        UpdateUser tsk = new UpdateUser();
                        tsk.execute(CurrentUser);
                    }
                    else if(classNum == 2 && CurrentUser.getClass2Data().equals(""))
                    {
                        Toast.makeText(RemoveClassActivity.this, "Class 2 is already empty", Toast.LENGTH_LONG).show();
                    }
                    else if(classNum == 3 && !CurrentUser.getClass3Data().equals(""))
                    {
                        CurrentUser.setClass3Data(CurrentUser.getClass4Data());
                        CurrentUser.setClass3Day(CurrentUser.getClass4Day());
                        CurrentUser.setClass3Time(CurrentUser.getClass4Time());
                        CurrentUser.setClass4Data(CurrentUser.getClass5Data());
                        CurrentUser.setClass4Day(CurrentUser.getClass5Day());
                        CurrentUser.setClass4Time(CurrentUser.getClass5Time());
                        CurrentUser.setClass5Data(CurrentUser.getClass6Data());
                        CurrentUser.setClass5Day(CurrentUser.getClass6Day());
                        CurrentUser.setClass5Time(CurrentUser.getClass6Time());
                        CurrentUser.setClass6Data(CurrentUser.getClass7Data());
                        CurrentUser.setClass6Day(CurrentUser.getClass7Day());
                        CurrentUser.setClass6Time(CurrentUser.getClass7Time());
                        CurrentUser.setClass7Data(CurrentUser.getClass8Data());
                        CurrentUser.setClass7Day(CurrentUser.getClass8Day());
                        CurrentUser.setClass7Time(CurrentUser.getClass8Time());
                        CurrentUser.setClass8Data(CurrentUser.getClass9Data());
                        CurrentUser.setClass8Day(CurrentUser.getClass9Day());
                        CurrentUser.setClass8Time(CurrentUser.getClass9Time());
                        CurrentUser.setClass9Data(CurrentUser.getClass10Data());
                        CurrentUser.setClass9Day(CurrentUser.getClass10Day());
                        CurrentUser.setClass9Time(CurrentUser.getClass10Time());
                        CurrentUser.setClass10Data("");
                        CurrentUser.setClass10Day("");
                        CurrentUser.setClass10Time("");
                        UpdateUser tsk = new UpdateUser();
                        tsk.execute(CurrentUser);
                    }
                    else if(classNum == 3 && CurrentUser.getClass3Data().equals(""))
                    {
                        Toast.makeText(RemoveClassActivity.this, "Class 3 is already empty", Toast.LENGTH_LONG).show();
                    }
                    else if(classNum == 4 && !CurrentUser.getClass4Data().equals(""))
                    {
                        CurrentUser.setClass4Data(CurrentUser.getClass5Data());
                        CurrentUser.setClass4Day(CurrentUser.getClass5Day());
                        CurrentUser.setClass4Time(CurrentUser.getClass5Time());
                        CurrentUser.setClass5Data(CurrentUser.getClass6Data());
                        CurrentUser.setClass5Day(CurrentUser.getClass6Day());
                        CurrentUser.setClass5Time(CurrentUser.getClass6Time());
                        CurrentUser.setClass6Data(CurrentUser.getClass7Data());
                        CurrentUser.setClass6Day(CurrentUser.getClass7Day());
                        CurrentUser.setClass6Time(CurrentUser.getClass7Time());
                        CurrentUser.setClass7Data(CurrentUser.getClass8Data());
                        CurrentUser.setClass7Day(CurrentUser.getClass8Day());
                        CurrentUser.setClass7Time(CurrentUser.getClass8Time());
                        CurrentUser.setClass8Data(CurrentUser.getClass9Data());
                        CurrentUser.setClass8Day(CurrentUser.getClass9Day());
                        CurrentUser.setClass8Time(CurrentUser.getClass9Time());
                        CurrentUser.setClass9Data(CurrentUser.getClass10Data());
                        CurrentUser.setClass9Day(CurrentUser.getClass10Day());
                        CurrentUser.setClass9Time(CurrentUser.getClass10Time());
                        CurrentUser.setClass10Data("");
                        CurrentUser.setClass10Day("");
                        CurrentUser.setClass10Time("");
                        UpdateUser tsk = new UpdateUser();
                        tsk.execute(CurrentUser);
                    }
                    else if(classNum == 4 && CurrentUser.getClass4Data().equals(""))
                    {
                        Toast.makeText(RemoveClassActivity.this, "Class 4 is already empty", Toast.LENGTH_LONG).show();
                    }
                    else if(classNum == 5 && !CurrentUser.getClass5Data().equals(""))
                    {
                        CurrentUser.setClass5Data(CurrentUser.getClass6Data());
                        CurrentUser.setClass5Day(CurrentUser.getClass6Day());
                        CurrentUser.setClass5Time(CurrentUser.getClass6Time());
                        CurrentUser.setClass6Data(CurrentUser.getClass7Data());
                        CurrentUser.setClass6Day(CurrentUser.getClass7Day());
                        CurrentUser.setClass6Time(CurrentUser.getClass7Time());
                        CurrentUser.setClass7Data(CurrentUser.getClass8Data());
                        CurrentUser.setClass7Day(CurrentUser.getClass8Day());
                        CurrentUser.setClass7Time(CurrentUser.getClass8Time());
                        CurrentUser.setClass8Data(CurrentUser.getClass9Data());
                        CurrentUser.setClass8Day(CurrentUser.getClass9Day());
                        CurrentUser.setClass8Time(CurrentUser.getClass9Time());
                        CurrentUser.setClass9Data(CurrentUser.getClass10Data());
                        CurrentUser.setClass9Day(CurrentUser.getClass10Day());
                        CurrentUser.setClass9Time(CurrentUser.getClass10Time());
                        CurrentUser.setClass10Data("");
                        CurrentUser.setClass10Day("");
                        CurrentUser.setClass10Time("");
                        UpdateUser tsk = new UpdateUser();
                        tsk.execute(CurrentUser);
                    }
                    else if(classNum == 5 && CurrentUser.getClass5Data().equals(""))
                    {
                        Toast.makeText(RemoveClassActivity.this, "Class 5 is already empty", Toast.LENGTH_LONG).show();
                    }
                    else if(classNum == 6 && !CurrentUser.getClass6Data().equals(""))
                    {
                        CurrentUser.setClass6Data(CurrentUser.getClass7Data());
                        CurrentUser.setClass6Day(CurrentUser.getClass7Day());
                        CurrentUser.setClass6Time(CurrentUser.getClass7Time());
                        CurrentUser.setClass7Data(CurrentUser.getClass8Data());
                        CurrentUser.setClass7Day(CurrentUser.getClass8Day());
                        CurrentUser.setClass7Time(CurrentUser.getClass8Time());
                        CurrentUser.setClass8Data(CurrentUser.getClass9Data());
                        CurrentUser.setClass8Day(CurrentUser.getClass9Day());
                        CurrentUser.setClass8Time(CurrentUser.getClass9Time());
                        CurrentUser.setClass9Data(CurrentUser.getClass10Data());
                        CurrentUser.setClass9Day(CurrentUser.getClass10Day());
                        CurrentUser.setClass9Time(CurrentUser.getClass10Time());
                        CurrentUser.setClass10Data("");
                        CurrentUser.setClass10Day("");
                        CurrentUser.setClass10Time("");
                        UpdateUser tsk = new UpdateUser();
                        tsk.execute(CurrentUser);
                    }
                    else if(classNum == 6 && CurrentUser.getClass6Data().equals(""))
                    {
                        Toast.makeText(RemoveClassActivity.this, "Class 6 is already empty", Toast.LENGTH_LONG).show();
                    }
                    else if(classNum == 7 && !CurrentUser.getClass7Data().equals(""))
                    {
                        CurrentUser.setClass7Data(CurrentUser.getClass8Data());
                        CurrentUser.setClass7Day(CurrentUser.getClass8Day());
                        CurrentUser.setClass7Time(CurrentUser.getClass8Time());
                        CurrentUser.setClass8Data(CurrentUser.getClass9Data());
                        CurrentUser.setClass8Day(CurrentUser.getClass9Day());
                        CurrentUser.setClass8Time(CurrentUser.getClass9Time());
                        CurrentUser.setClass9Data(CurrentUser.getClass10Data());
                        CurrentUser.setClass9Day(CurrentUser.getClass10Day());
                        CurrentUser.setClass9Time(CurrentUser.getClass10Time());
                        CurrentUser.setClass10Data("");
                        CurrentUser.setClass10Day("");
                        CurrentUser.setClass10Time("");
                        UpdateUser tsk = new UpdateUser();
                        tsk.execute(CurrentUser);
                    }
                    else if(classNum == 7 && CurrentUser.getClass7Data().equals(""))
                    {
                        Toast.makeText(RemoveClassActivity.this, "Class 7 is already empty", Toast.LENGTH_LONG).show();
                    }
                    else if(classNum == 8 && !CurrentUser.getClass8Data().equals(""))
                    {
                        CurrentUser.setClass8Data(CurrentUser.getClass9Data());
                        CurrentUser.setClass8Day(CurrentUser.getClass9Day());
                        CurrentUser.setClass8Time(CurrentUser.getClass9Time());
                        CurrentUser.setClass9Data(CurrentUser.getClass10Data());
                        CurrentUser.setClass9Day(CurrentUser.getClass10Day());
                        CurrentUser.setClass9Time(CurrentUser.getClass10Time());
                        CurrentUser.setClass10Data("");
                        CurrentUser.setClass10Day("");
                        CurrentUser.setClass10Time("");
                        UpdateUser tsk = new UpdateUser();
                        tsk.execute(CurrentUser);
                    }
                    else if(classNum == 8 && CurrentUser.getClass8Data().equals(""))
                    {
                        Toast.makeText(RemoveClassActivity.this, "Class 8 is already empty", Toast.LENGTH_LONG).show();
                    }
                    else if(classNum == 9 && !CurrentUser.getClass9Data().equals(""))
                    {
                        CurrentUser.setClass9Data(CurrentUser.getClass10Data());
                        CurrentUser.setClass9Day(CurrentUser.getClass10Day());
                        CurrentUser.setClass9Time(CurrentUser.getClass10Time());
                        CurrentUser.setClass10Data("");
                        CurrentUser.setClass10Day("");
                        CurrentUser.setClass10Time("");
                        UpdateUser tsk = new UpdateUser();
                        tsk.execute(CurrentUser);
                    }
                    else if(classNum == 9 && CurrentUser.getClass9Data().equals(""))
                    {
                        Toast.makeText(RemoveClassActivity.this, "Class 9 is already empty", Toast.LENGTH_LONG).show();
                    }
                    else if(classNum == 10 && !CurrentUser.getClass10Data().equals(""))
                    {
                        CurrentUser.setClass10Data("");
                        CurrentUser.setClass10Day("");
                        CurrentUser.setClass10Time("");
                        UpdateUser tsk = new UpdateUser();
                        tsk.execute(CurrentUser);
                    }
                    else if(classNum == 10 && CurrentUser.getClass10Data().equals(""))
                    {
                        Toast.makeText(RemoveClassActivity.this, "Class 10 is already empty", Toast.LENGTH_LONG).show();
                    }
                }
                else
                {
                    Toast.makeText(RemoveClassActivity.this, "Please enter a valid class number", Toast.LENGTH_LONG).show();
                }

            }
        });

        mClearAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new AlertDialog.Builder(RemoveClassActivity.this)
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .setTitle("Clearing All Classes")
                        .setMessage("Are you sure you want to clear all your classes?")
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener()
                        {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                CurrentUser.setClass1Data("");
                                CurrentUser.setClass1Day("");
                                CurrentUser.setClass1Time("");
                                CurrentUser.setClass2Data("");
                                CurrentUser.setClass2Day("");
                                CurrentUser.setClass2Time("");
                                CurrentUser.setClass3Data("");
                                CurrentUser.setClass3Day("");
                                CurrentUser.setClass3Time("");
                                CurrentUser.setClass4Data("");
                                CurrentUser.setClass4Day("");
                                CurrentUser.setClass4Time("");
                                CurrentUser.setClass5Data("");
                                CurrentUser.setClass5Day("");
                                CurrentUser.setClass5Time("");
                                CurrentUser.setClass6Data("");
                                CurrentUser.setClass6Day("");
                                CurrentUser.setClass6Time("");
                                CurrentUser.setClass7Data("");
                                CurrentUser.setClass7Day("");
                                CurrentUser.setClass7Time("");
                                CurrentUser.setClass8Data("");
                                CurrentUser.setClass8Day("");
                                CurrentUser.setClass8Time("");
                                CurrentUser.setClass9Data("");
                                CurrentUser.setClass9Day("");
                                CurrentUser.setClass9Time("");
                                CurrentUser.setClass10Data("");
                                CurrentUser.setClass10Day("");
                                CurrentUser.setClass10Time("");
                                UpdateUser tsk = new UpdateUser();
                                tsk.execute(CurrentUser);
                                Toast.makeText(RemoveClassActivity.this, "Cleared all", Toast.LENGTH_SHORT).show();
                            }

                        })
                        .setNegativeButton("No", null)
                        .show();
            }
        });

        mCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(RemoveClassActivity.this, ScheduleActivity.class);
                i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                RemoveClassActivity.this.startActivity(i);
                finish();
            }
        });
    }

}
