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
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

/**
 * Created by Dharti on 5/2/2016.
 */
public class AddClassActivity extends Activity {
    private Button mAdd = null;
    private Button mCancel = null;
    private EditText mClass1Data = null;
    private EditText mClass1Day = null;
    private EditText mClass1Time = null;
    private EditText mClass2Data = null;
    private EditText mClass2Day = null;
    private EditText mClass2Time = null;
    private EditText mClass3Data = null;
    private EditText mClass3Day = null;
    private EditText mClass3Time = null;
    private EditText mClass4Data = null;
    private EditText mClass4Day = null;
    private EditText mClass4Time = null;
    private boolean[] CL = new boolean[10];
    private boolean[] In = new boolean[4];
    private boolean AllFull = false;
    private User CurrentUser = new User();
    private String LoggedinUser = LoginActivity.LoggedUser;
    ArrayList<User> returnValues = new ArrayList<User>();
    private int EmptyCount = 0;
    private int InputCount = 0;

    protected void SearchForEmpty(User user)
    {
        if(user.getClass1Data().equals(""))
        {
            CL[0] = true;
            EmptyCount += 1;
        }
        if(user.getClass2Data().equals(""))
        {
            CL[1] = true;
            EmptyCount += 1;
        }
        if(user.getClass3Data().equals(""))
        {
            CL[2] = true;
            EmptyCount += 1;
        }
        if(user.getClass4Data().equals(""))
        {
            CL[3] = true;
            EmptyCount += 1;
        }
        if(user.getClass5Data().equals(""))
        {
            CL[4] = true;
            EmptyCount += 1;
        }
        if(user.getClass6Data().equals(""))
        {
            CL[5] = true;
            EmptyCount += 1;
        }
        if(user.getClass7Data().equals(""))
        {
            CL[6] = true;
            EmptyCount += 1;
        }
        if(user.getClass8Data().equals(""))
        {
            CL[7] = true;
            EmptyCount += 1;
        }
        if(user.getClass9Data().equals(""))
        {
            CL[8] = true;
            EmptyCount += 1;
        }
        if(user.getClass10Data().equals(""))
        {
            CL[9] = true;
            EmptyCount += 1;
        }
        if(EmptyCount == 0)
        {
            AllFull = true;
        }
    }


    @Override
    protected void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.add_class_layout);
        mAdd = (Button)findViewById(R.id.addClass);
        mCancel= (Button)findViewById(R.id.cancel);
        mClass1Data = (EditText) findViewById(R.id.addClassRow1);
        mClass1Day = (EditText) findViewById(R.id.addDayRow1);
        mClass1Time = (EditText) findViewById(R.id.addTimeRow1);
        mClass2Data = (EditText) findViewById(R.id.addClassRow2);
        mClass2Day = (EditText) findViewById(R.id.addDayRow2);
        mClass2Time = (EditText) findViewById(R.id.addTimeRow2);
        mClass3Data = (EditText) findViewById(R.id.addClassRow3);
        mClass3Day = (EditText) findViewById(R.id.addDayRow3);
        mClass3Time = (EditText) findViewById(R.id.addTimeRow3);
        mClass4Data = (EditText) findViewById(R.id.addClassRow4);
        mClass4Day = (EditText) findViewById(R.id.addDayRow4);
        mClass4Time = (EditText) findViewById(R.id.addTimeRow4);

        GetUsersAsyncTask task = new GetUsersAsyncTask();
        try {
            returnValues = task.execute().get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        for(User x: returnValues)
        {
            {
                if(x.getUsername().equals(LoggedinUser))
                {
                    CurrentUser.setDoc_id(x.getDoc_id());
                    CurrentUser.setFirst_name(x.getFirst_name());
                    CurrentUser.setMiddle_initial(x.getMiddle_initial());
                    CurrentUser.setLast_name(x.getLast_name());
                    CurrentUser.setUsername(x.getUsername());
                    CurrentUser.setPassword(x.getPassword());
                    CurrentUser.setIlearnUser(x.getIlearnUser());
                    CurrentUser.setIlearnPass(x.getIlearnPass());
                    CurrentUser.setEmail(x.getEmail());
                    CurrentUser.setPendingRequest1(x.getPendingRequest1());
                    CurrentUser.setPendingRequest2(x.getPendingRequest2());
                    CurrentUser.setPendingRequest3(x.getPendingRequest3());
                    CurrentUser.setPendingRequest4(x.getPendingRequest4());
                    CurrentUser.setPendingRequest5(x.getPendingRequest5());
                    CurrentUser.setClass1Data(x.getClass1Data());
                    CurrentUser.setClass1Day(x.getClass1Day());
                    CurrentUser.setClass1Time(x.getClass1Time());
                    CurrentUser.setClass2Data(x.getClass2Data());
                    CurrentUser.setClass2Day(x.getClass2Day());
                    CurrentUser.setClass2Time(x.getClass2Time());
                    CurrentUser.setClass3Data(x.getClass3Data());
                    CurrentUser.setClass3Day(x.getClass3Day());
                    CurrentUser.setClass3Time(x.getClass3Time());
                    CurrentUser.setClass4Data(x.getClass4Data());
                    CurrentUser.setClass4Day(x.getClass4Day());
                    CurrentUser.setClass4Time(x.getClass4Time());
                    CurrentUser.setClass5Data(x.getClass5Data());
                    CurrentUser.setClass5Day(x.getClass5Day());
                    CurrentUser.setClass5Time(x.getClass5Time());
                    CurrentUser.setClass6Data(x.getClass6Data());
                    CurrentUser.setClass6Day(x.getClass6Day());
                    CurrentUser.setClass6Time(x.getClass6Time());
                    CurrentUser.setClass7Data(x.getClass7Data());
                    CurrentUser.setClass7Day(x.getClass7Day());
                    CurrentUser.setClass7Time(x.getClass7Time());
                    CurrentUser.setClass8Data(x.getClass8Data());
                    CurrentUser.setClass8Day(x.getClass8Day());
                    CurrentUser.setClass8Time(x.getClass8Time());
                    CurrentUser.setClass9Data(x.getClass9Data());
                    CurrentUser.setClass9Day(x.getClass9Day());
                    CurrentUser.setClass9Time(x.getClass9Time());
                    CurrentUser.setClass10Data(x.getClass10Data());
                    CurrentUser.setClass10Day(x.getClass10Day());
                    CurrentUser.setClass10Time(x.getClass10Time());
                    CurrentUser.setFriend1Name(x.getFriend1Name());
                    CurrentUser.setFriend1Accesss(x.getFriend1Access());
                    CurrentUser.setFriend2Name(x.getFriend2Name());
                    CurrentUser.setFriend2Accesss(x.getFriend2Access());
                    CurrentUser.setFriend3Name(x.getFriend3Name());
                    CurrentUser.setFriend3Accesss(x.getFriend3Access());
                    CurrentUser.setFriend4Name(x.getFriend4Name());
                    CurrentUser.setFriend4Accesss(x.getFriend4Access());
                    CurrentUser.setFriend5Name(x.getFriend5Name());
                    CurrentUser.setFriend5Accesss(x.getFriend5Access());
                    CurrentUser.setFriend6Name(x.getFriend6Name());
                    CurrentUser.setFriend6Accesss(x.getFriend6Access());
                    CurrentUser.setFriend7Name(x.getFriend7Name());
                    CurrentUser.setFriend7Accesss(x.getFriend7Access());
                    CurrentUser.setFriend8Name(x.getFriend8Name());
                    CurrentUser.setFriend8Accesss(x.getFriend8Access());
                    CurrentUser.setFriend9Name(x.getFriend9Name());
                    CurrentUser.setFriend9Accesss(x.getFriend9Access());
                    CurrentUser.setFriend10Name(x.getFriend10Name());
                    CurrentUser.setFriend10Accesss(x.getFriend10Access());
                }
            }
        }

        mAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String row1Data = mClass1Data.getText().toString();
                String row1Day = mClass1Day.getText().toString();
                String row1Time = mClass1Time.getText().toString();
                String row2Data = mClass2Data.getText().toString();
                String row2Day = mClass2Day.getText().toString();
                String row2Time = mClass2Time.getText().toString();
                String row3Data = mClass3Data.getText().toString();
                String row3Day = mClass3Day.getText().toString();
                String row3Time = mClass3Time.getText().toString();
                String row4Data = mClass4Data.getText().toString();
                String row4Day = mClass4Day.getText().toString();
                String row4Time = mClass4Time.getText().toString();
                if(!row1Data.equals(""))
                {
                    In[0] = true;
                    InputCount +=1;
                }
                if(!row2Data.equals(""))
                {
                    In[1] = true;
                    InputCount +=1;
                }
                if(!row3Data.equals(""))
                {
                    In[2] = true;
                    InputCount +=1;
                }
                if(!row4Data.equals(""))
                {
                    In[3] = true;
                    InputCount +=1;
                }
                SearchForEmpty(CurrentUser);
                if(AllFull)
                {
                    Toast.makeText(AddClassActivity.this, "Limit of classes has been reached", Toast.LENGTH_LONG).show();
                }
                else if(InputCount > EmptyCount)
                {
                    Toast.makeText(AddClassActivity.this, "Attempting to Add more classes than limit", Toast.LENGTH_LONG).show();
                }
                else
                {
                    if(EmptyCount == 10 && InputCount == 1)
                    {
                        CurrentUser.setClass1Data(row1Data);
                        CurrentUser.setClass1Day(row1Day);
                        CurrentUser.setClass1Time(row1Time);
                        UpdateUser tsk = new UpdateUser();
                        tsk.execute(CurrentUser);
                        showScheduleActivity();
                    }
                    else if(EmptyCount == 10 && InputCount == 2)
                    {
                        CurrentUser.setClass1Data(row1Data);
                        CurrentUser.setClass1Day(row1Day);
                        CurrentUser.setClass1Time(row1Time);
                        CurrentUser.setClass2Data(row2Data);
                        CurrentUser.setClass2Day(row2Day);
                        CurrentUser.setClass2Time(row2Time);
                        UpdateUser tsk = new UpdateUser();
                        tsk.execute(CurrentUser);
                        showScheduleActivity();
                    }
                    else if(EmptyCount == 10 && InputCount == 3)
                    {
                        CurrentUser.setClass1Data(row1Data);
                        CurrentUser.setClass1Day(row1Day);
                        CurrentUser.setClass1Time(row1Time);
                        CurrentUser.setClass2Data(row2Data);
                        CurrentUser.setClass2Day(row2Day);
                        CurrentUser.setClass2Time(row2Time);
                        CurrentUser.setClass3Data(row3Data);
                        CurrentUser.setClass3Day(row3Day);
                        CurrentUser.setClass3Time(row3Time);
                        UpdateUser tsk = new UpdateUser();
                        tsk.execute(CurrentUser);
                        showScheduleActivity();
                    }
                    else if(EmptyCount == 10 && InputCount == 4)
                    {
                        CurrentUser.setClass1Data(row1Data);
                        CurrentUser.setClass1Day(row1Day);
                        CurrentUser.setClass1Time(row1Time);
                        CurrentUser.setClass2Data(row2Data);
                        CurrentUser.setClass2Day(row2Day);
                        CurrentUser.setClass2Time(row2Time);
                        CurrentUser.setClass3Data(row3Data);
                        CurrentUser.setClass3Day(row3Day);
                        CurrentUser.setClass3Time(row3Time);
                        CurrentUser.setClass4Data(row4Data);
                        CurrentUser.setClass4Day(row4Day);
                        CurrentUser.setClass4Time(row4Time);
                        UpdateUser tsk = new UpdateUser();
                        tsk.execute(CurrentUser);
                        showScheduleActivity();
                    }
                    else
                    {
                        for(int i = 0; i < CL.length; ++i)
                        {
                            if(InputCount == 0)
                            {
                                break;
                            }
                            if (CL[i])
                            {
                                if(i == 1)
                                {
                                    if(InputCount == 1)
                                    {
                                        CurrentUser.setClass2Data(row1Data);
                                        CurrentUser.setClass2Day(row1Day);
                                        CurrentUser.setClass2Time(row1Time);
                                        UpdateUser tsk = new UpdateUser();
                                        tsk.execute(CurrentUser);
                                        InputCount = 0;
                                    }
                                    else if(InputCount == 2)
                                    {
                                        CurrentUser.setClass2Data(row1Data);
                                        CurrentUser.setClass2Day(row1Day);
                                        CurrentUser.setClass2Time(row1Time);
                                        CurrentUser.setClass3Data(row2Data);
                                        CurrentUser.setClass3Day(row2Day);
                                        CurrentUser.setClass3Time(row2Time);
                                        UpdateUser tsk = new UpdateUser();
                                        tsk.execute(CurrentUser);
                                        InputCount = 0;
                                    }
                                    else if(InputCount == 3)
                                    {
                                        CurrentUser.setClass2Data(row1Data);
                                        CurrentUser.setClass2Day(row1Day);
                                        CurrentUser.setClass2Time(row1Time);
                                        CurrentUser.setClass3Data(row2Data);
                                        CurrentUser.setClass3Day(row2Day);
                                        CurrentUser.setClass3Time(row2Time);
                                        CurrentUser.setClass4Data(row3Data);
                                        CurrentUser.setClass4Day(row3Day);
                                        CurrentUser.setClass4Time(row3Time);
                                        UpdateUser tsk = new UpdateUser();
                                        tsk.execute(CurrentUser);
                                        InputCount = 0;
                                    }
                                    else
                                    {
                                        CurrentUser.setClass2Data(row1Data);
                                        CurrentUser.setClass2Day(row1Day);
                                        CurrentUser.setClass2Time(row1Time);
                                        CurrentUser.setClass3Data(row2Data);
                                        CurrentUser.setClass3Day(row2Day);
                                        CurrentUser.setClass3Time(row2Time);
                                        CurrentUser.setClass4Data(row3Data);
                                        CurrentUser.setClass4Day(row3Day);
                                        CurrentUser.setClass4Time(row3Time);
                                        CurrentUser.setClass5Data(row4Data);
                                        CurrentUser.setClass5Day(row4Day);
                                        CurrentUser.setClass5Time(row4Time);
                                        UpdateUser tsk = new UpdateUser();
                                        tsk.execute(CurrentUser);
                                        InputCount = 0;
                                    }
                                }
                                else if(i == 2)
                                {
                                    if(InputCount == 1)
                                    {
                                        CurrentUser.setClass3Data(row1Data);
                                        CurrentUser.setClass3Day(row1Day);
                                        CurrentUser.setClass3Time(row1Time);
                                        UpdateUser tsk = new UpdateUser();
                                        tsk.execute(CurrentUser);
                                        InputCount = 0;
                                    }
                                    else if(InputCount == 2)
                                    {
                                        CurrentUser.setClass3Data(row1Data);
                                        CurrentUser.setClass3Day(row1Day);
                                        CurrentUser.setClass3Time(row1Time);
                                        CurrentUser.setClass4Data(row2Data);
                                        CurrentUser.setClass4Day(row2Day);
                                        CurrentUser.setClass4Time(row2Time);
                                        UpdateUser tsk = new UpdateUser();
                                        tsk.execute(CurrentUser);
                                        InputCount = 0;
                                    }
                                    else if(InputCount == 3)
                                    {
                                        CurrentUser.setClass3Data(row1Data);
                                        CurrentUser.setClass3Day(row1Day);
                                        CurrentUser.setClass3Time(row1Time);
                                        CurrentUser.setClass4Data(row2Data);
                                        CurrentUser.setClass4Day(row2Day);
                                        CurrentUser.setClass4Time(row2Time);
                                        CurrentUser.setClass5Data(row3Data);
                                        CurrentUser.setClass5Day(row3Day);
                                        CurrentUser.setClass5Time(row3Time);
                                        UpdateUser tsk = new UpdateUser();
                                        tsk.execute(CurrentUser);
                                        InputCount = 0;
                                    }
                                    else
                                    {
                                        CurrentUser.setClass3Data(row1Data);
                                        CurrentUser.setClass3Day(row1Day);
                                        CurrentUser.setClass3Time(row1Time);
                                        CurrentUser.setClass4Data(row2Data);
                                        CurrentUser.setClass4Day(row2Day);
                                        CurrentUser.setClass4Time(row2Time);
                                        CurrentUser.setClass5Data(row3Data);
                                        CurrentUser.setClass5Day(row3Day);
                                        CurrentUser.setClass5Time(row3Time);
                                        CurrentUser.setClass6Data(row4Data);
                                        CurrentUser.setClass6Day(row4Day);
                                        CurrentUser.setClass6Time(row4Time);
                                        UpdateUser tsk = new UpdateUser();
                                        tsk.execute(CurrentUser);
                                        InputCount = 0;
                                    }
                                }
                                else if(i == 3)
                                {
                                    if(InputCount == 1)
                                    {
                                        CurrentUser.setClass4Data(row1Data);
                                        CurrentUser.setClass4Day(row1Day);
                                        CurrentUser.setClass4Time(row1Time);
                                        UpdateUser tsk = new UpdateUser();
                                        tsk.execute(CurrentUser);
                                        InputCount = 0;
                                    }
                                    else if(InputCount == 2)
                                    {
                                        CurrentUser.setClass4Data(row1Data);
                                        CurrentUser.setClass4Day(row1Day);
                                        CurrentUser.setClass4Time(row1Time);
                                        CurrentUser.setClass5Data(row2Data);
                                        CurrentUser.setClass5Day(row2Day);
                                        CurrentUser.setClass5Time(row2Time);
                                        UpdateUser tsk = new UpdateUser();
                                        tsk.execute(CurrentUser);
                                        InputCount = 0;
                                    }
                                    else if(InputCount == 3)
                                    {
                                        CurrentUser.setClass4Data(row1Data);
                                        CurrentUser.setClass4Day(row1Day);
                                        CurrentUser.setClass4Time(row1Time);
                                        CurrentUser.setClass5Data(row2Data);
                                        CurrentUser.setClass5Day(row2Day);
                                        CurrentUser.setClass5Time(row2Time);
                                        CurrentUser.setClass6Data(row3Data);
                                        CurrentUser.setClass6Day(row3Day);
                                        CurrentUser.setClass6Time(row3Time);
                                        UpdateUser tsk = new UpdateUser();
                                        tsk.execute(CurrentUser);
                                        InputCount = 0;
                                    }
                                    else
                                    {
                                        CurrentUser.setClass4Data(row1Data);
                                        CurrentUser.setClass4Day(row1Day);
                                        CurrentUser.setClass4Time(row1Time);
                                        CurrentUser.setClass5Data(row2Data);
                                        CurrentUser.setClass5Day(row2Day);
                                        CurrentUser.setClass5Time(row2Time);
                                        CurrentUser.setClass6Data(row3Data);
                                        CurrentUser.setClass6Day(row3Day);
                                        CurrentUser.setClass6Time(row3Time);
                                        CurrentUser.setClass7Data(row4Data);
                                        CurrentUser.setClass7Day(row4Day);
                                        CurrentUser.setClass7Time(row4Time);
                                        UpdateUser tsk = new UpdateUser();
                                        tsk.execute(CurrentUser);
                                        InputCount = 0;
                                    }
                                }
                                else if(i == 4)
                                {
                                    if(InputCount == 1)
                                    {
                                        CurrentUser.setClass5Data(row1Data);
                                        CurrentUser.setClass5Day(row1Day);
                                        CurrentUser.setClass5Time(row1Time);
                                        UpdateUser tsk = new UpdateUser();
                                        tsk.execute(CurrentUser);
                                        InputCount = 0;
                                    }
                                    else if(InputCount == 2)
                                    {
                                        CurrentUser.setClass5Data(row1Data);
                                        CurrentUser.setClass5Day(row1Day);
                                        CurrentUser.setClass5Time(row1Time);
                                        CurrentUser.setClass6Data(row2Data);
                                        CurrentUser.setClass6Day(row2Day);
                                        CurrentUser.setClass6Time(row2Time);
                                        UpdateUser tsk = new UpdateUser();
                                        tsk.execute(CurrentUser);
                                        InputCount = 0;
                                    }
                                    else if(InputCount == 3)
                                    {
                                        CurrentUser.setClass5Data(row1Data);
                                        CurrentUser.setClass5Day(row1Day);
                                        CurrentUser.setClass5Time(row1Time);
                                        CurrentUser.setClass6Data(row2Data);
                                        CurrentUser.setClass6Day(row2Day);
                                        CurrentUser.setClass6Time(row2Time);
                                        CurrentUser.setClass7Data(row3Data);
                                        CurrentUser.setClass7Day(row3Day);
                                        CurrentUser.setClass7Time(row3Time);
                                        UpdateUser tsk = new UpdateUser();
                                        tsk.execute(CurrentUser);
                                        InputCount = 0;
                                    }
                                    else
                                    {
                                        CurrentUser.setClass5Data(row1Data);
                                        CurrentUser.setClass5Day(row1Day);
                                        CurrentUser.setClass5Time(row1Time);
                                        CurrentUser.setClass6Data(row2Data);
                                        CurrentUser.setClass6Day(row2Day);
                                        CurrentUser.setClass6Time(row2Time);
                                        CurrentUser.setClass7Data(row3Data);
                                        CurrentUser.setClass7Day(row3Day);
                                        CurrentUser.setClass7Time(row3Time);
                                        CurrentUser.setClass8Data(row4Data);
                                        CurrentUser.setClass8Day(row4Day);
                                        CurrentUser.setClass8Time(row4Time);
                                        UpdateUser tsk = new UpdateUser();
                                        tsk.execute(CurrentUser);
                                        InputCount = 0;
                                    }
                                }
                                else if(i == 5)
                                {
                                    if(InputCount == 1)
                                    {
                                        CurrentUser.setClass6Data(row1Data);
                                        CurrentUser.setClass6Day(row1Day);
                                        CurrentUser.setClass6Time(row1Time);
                                        UpdateUser tsk = new UpdateUser();
                                        tsk.execute(CurrentUser);
                                        InputCount = 0;
                                    }
                                    else if(InputCount == 2)
                                    {
                                        CurrentUser.setClass6Data(row1Data);
                                        CurrentUser.setClass6Day(row1Day);
                                        CurrentUser.setClass6Time(row1Time);
                                        CurrentUser.setClass7Data(row2Data);
                                        CurrentUser.setClass7Day(row2Day);
                                        CurrentUser.setClass7Time(row2Time);
                                        UpdateUser tsk = new UpdateUser();
                                        tsk.execute(CurrentUser);
                                        InputCount = 0;
                                    }
                                    else if(InputCount == 3)
                                    {
                                        CurrentUser.setClass6Data(row1Data);
                                        CurrentUser.setClass6Day(row1Day);
                                        CurrentUser.setClass6Time(row1Time);
                                        CurrentUser.setClass7Data(row2Data);
                                        CurrentUser.setClass7Day(row2Day);
                                        CurrentUser.setClass7Time(row2Time);
                                        CurrentUser.setClass8Data(row3Data);
                                        CurrentUser.setClass8Day(row3Day);
                                        CurrentUser.setClass8Time(row3Time);
                                        UpdateUser tsk = new UpdateUser();
                                        tsk.execute(CurrentUser);
                                        InputCount = 0;
                                    }
                                    else
                                    {
                                        CurrentUser.setClass6Data(row1Data);
                                        CurrentUser.setClass6Day(row1Day);
                                        CurrentUser.setClass6Time(row1Time);
                                        CurrentUser.setClass7Data(row2Data);
                                        CurrentUser.setClass7Day(row2Day);
                                        CurrentUser.setClass7Time(row2Time);
                                        CurrentUser.setClass8Data(row3Data);
                                        CurrentUser.setClass8Day(row3Day);
                                        CurrentUser.setClass8Time(row3Time);
                                        CurrentUser.setClass9Data(row4Data);
                                        CurrentUser.setClass9Day(row4Day);
                                        CurrentUser.setClass9Time(row4Time);
                                        UpdateUser tsk = new UpdateUser();
                                        tsk.execute(CurrentUser);
                                        InputCount = 0;
                                    }
                                }
                                else if(i == 6)
                                {
                                    if(InputCount == 1)
                                    {
                                        CurrentUser.setClass7Data(row1Data);
                                        CurrentUser.setClass7Day(row1Day);
                                        CurrentUser.setClass7Time(row1Time);
                                        UpdateUser tsk = new UpdateUser();
                                        tsk.execute(CurrentUser);
                                        InputCount = 0;
                                    }
                                    else if(InputCount == 2)
                                    {
                                        CurrentUser.setClass7Data(row1Data);
                                        CurrentUser.setClass7Day(row1Day);
                                        CurrentUser.setClass7Time(row1Time);
                                        CurrentUser.setClass8Data(row2Data);
                                        CurrentUser.setClass8Day(row2Day);
                                        CurrentUser.setClass8Time(row2Time);
                                        UpdateUser tsk = new UpdateUser();
                                        tsk.execute(CurrentUser);
                                        InputCount = 0;
                                    }
                                    else if(InputCount == 3)
                                    {
                                        CurrentUser.setClass7Data(row1Data);
                                        CurrentUser.setClass7Day(row1Day);
                                        CurrentUser.setClass7Time(row1Time);
                                        CurrentUser.setClass8Data(row2Data);
                                        CurrentUser.setClass8Day(row2Day);
                                        CurrentUser.setClass8Time(row2Time);
                                        CurrentUser.setClass9Data(row3Data);
                                        CurrentUser.setClass9Day(row3Day);
                                        CurrentUser.setClass9Time(row3Time);
                                        UpdateUser tsk = new UpdateUser();
                                        tsk.execute(CurrentUser);
                                        InputCount = 0;
                                    }
                                    else
                                    {
                                        CurrentUser.setClass7Data(row1Data);
                                        CurrentUser.setClass7Day(row1Day);
                                        CurrentUser.setClass7Time(row1Time);
                                        CurrentUser.setClass8Data(row2Data);
                                        CurrentUser.setClass8Day(row2Day);
                                        CurrentUser.setClass8Time(row2Time);
                                        CurrentUser.setClass9Data(row3Data);
                                        CurrentUser.setClass9Day(row3Day);
                                        CurrentUser.setClass9Time(row3Time);
                                        CurrentUser.setClass10Data(row4Data);
                                        CurrentUser.setClass10Day(row4Day);
                                        CurrentUser.setClass10Time(row4Time);
                                        UpdateUser tsk = new UpdateUser();
                                        tsk.execute(CurrentUser);
                                        InputCount = 0;
                                    }
                                }
                                else if(i == 7)
                                {
                                    if(InputCount == 1)
                                    {
                                        CurrentUser.setClass8Data(row1Data);
                                        CurrentUser.setClass8Day(row1Day);
                                        CurrentUser.setClass8Time(row1Time);
                                        UpdateUser tsk = new UpdateUser();
                                        tsk.execute(CurrentUser);
                                        showScheduleActivity();
                                        InputCount = 0;
                                    }
                                    else if(InputCount == 2)
                                    {
                                        CurrentUser.setClass8Data(row1Data);
                                        CurrentUser.setClass8Day(row1Day);
                                        CurrentUser.setClass8Time(row1Time);
                                        CurrentUser.setClass9Data(row2Data);
                                        CurrentUser.setClass9Day(row2Day);
                                        CurrentUser.setClass9Time(row2Time);
                                        UpdateUser tsk = new UpdateUser();
                                        tsk.execute(CurrentUser);
                                        InputCount = 0;
                                    }
                                    else if(InputCount == 3)
                                    {
                                        CurrentUser.setClass8Data(row1Data);
                                        CurrentUser.setClass8Day(row1Day);
                                        CurrentUser.setClass8Time(row1Time);
                                        CurrentUser.setClass9Data(row2Data);
                                        CurrentUser.setClass9Day(row2Day);
                                        CurrentUser.setClass9Time(row2Time);
                                        CurrentUser.setClass10Data(row3Data);
                                        CurrentUser.setClass10Day(row3Day);
                                        CurrentUser.setClass10Time(row3Time);
                                        UpdateUser tsk = new UpdateUser();
                                        tsk.execute(CurrentUser);
                                        InputCount = 0;
                                    }
                                }
                                else if(i == 8)
                                {
                                    if(InputCount == 1)
                                    {
                                        CurrentUser.setClass9Data(row1Data);
                                        CurrentUser.setClass9Day(row1Day);
                                        CurrentUser.setClass9Time(row1Time);
                                        UpdateUser tsk = new UpdateUser();
                                        tsk.execute(CurrentUser);
                                        InputCount = 0;
                                    }
                                    else if(InputCount == 2)
                                    {
                                        CurrentUser.setClass9Data(row1Data);
                                        CurrentUser.setClass9Day(row1Day);
                                        CurrentUser.setClass9Time(row1Time);
                                        CurrentUser.setClass10Data(row2Data);
                                        CurrentUser.setClass10Day(row2Day);
                                        CurrentUser.setClass10Time(row2Time);
                                        UpdateUser tsk = new UpdateUser();
                                        tsk.execute(CurrentUser);
                                        InputCount = 0;
                                    }
                                }
                                else if(i == 9)
                                {
                                    if(InputCount == 1)
                                    {
                                        CurrentUser.setClass10Data(row1Data);
                                        CurrentUser.setClass10Day(row1Day);
                                        CurrentUser.setClass10Time(row1Time);
                                        UpdateUser tsk = new UpdateUser();
                                        tsk.execute(CurrentUser);
                                        InputCount = 0;
                                    }
                                }
                            }
                        }
                    }
                    showScheduleActivity();
                }

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
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(i);
        finish();
    }

    private void showCancelActivity() {
        Intent intent = new Intent(this, ScheduleActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
        finish();
    }
}
