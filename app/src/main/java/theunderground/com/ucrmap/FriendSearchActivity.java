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

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

/**
 * Created by Roger on 5/26/2016.
 */
public class FriendSearchActivity extends Activity {
    private Button mGo = null;
    private Button mBack = null;
    private EditText mSearch = null;
    private User CurrentUser = new User();
    private Boolean found = false;
    private String LoggedinUser = LoginActivity.LoggedUser;
    ArrayList<User> returnValues = new ArrayList<User>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.friend_search_activity_layout);

        mSearch = (EditText) findViewById(R.id.etFSearch);
        mGo = (Button) findViewById(R.id.bFSearch);
        mBack = (Button) findViewById(R.id.bFBack);

        GetUsersAsyncTask task = new GetUsersAsyncTask();
        try {
            returnValues = task.execute().get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        mGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String searchData = mSearch.getText().toString();

                for (User x : returnValues) {
                    if (x.getUsername().equals(searchData)) {
                        found = true;
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

                if(found)
                {
                    new AlertDialog.Builder(FriendSearchActivity.this)
                            .setIcon(android.R.drawable.ic_dialog_alert)
                            .setTitle("Adding a Friend")
                            .setMessage("Do you want to add this user?")
                            .setPositiveButton("Yes", new DialogInterface.OnClickListener()
                            {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    if (CurrentUser.getPendingRequest1().equals("")) {
                                        CurrentUser.setPendingRequest1(LoggedinUser);
                                        UpdateUser tsk = new UpdateUser();
                                        tsk.execute(CurrentUser);
                                        Toast.makeText(FriendSearchActivity.this, "Request sent", Toast.LENGTH_LONG).show();
                                    } else if (CurrentUser.getPendingRequest2().equals("")) {
                                        CurrentUser.setPendingRequest2(LoggedinUser);
                                        UpdateUser tsk = new UpdateUser();
                                        tsk.execute(CurrentUser);
                                        Toast.makeText(FriendSearchActivity.this, "Request sent", Toast.LENGTH_LONG).show();
                                    } else if (CurrentUser.getPendingRequest3().equals("")) {
                                        CurrentUser.setPendingRequest3(LoggedinUser);
                                        UpdateUser tsk = new UpdateUser();
                                        tsk.execute(CurrentUser);
                                        Toast.makeText(FriendSearchActivity.this, "Request sent", Toast.LENGTH_LONG).show();
                                    } else if (CurrentUser.getPendingRequest4().equals("")) {
                                        CurrentUser.setPendingRequest4(LoggedinUser);
                                        UpdateUser tsk = new UpdateUser();
                                        tsk.execute(CurrentUser);
                                        Toast.makeText(FriendSearchActivity.this, "Request sent", Toast.LENGTH_LONG).show();
                                    } else if (CurrentUser.getPendingRequest5().equals("")) {
                                        CurrentUser.setPendingRequest5(LoggedinUser);
                                        UpdateUser tsk = new UpdateUser();
                                        tsk.execute(CurrentUser);
                                        Toast.makeText(FriendSearchActivity.this, "Request sent", Toast.LENGTH_LONG).show();
                                    } else {
                                        Toast.makeText(FriendSearchActivity.this, "User has too many pending requests", Toast.LENGTH_LONG).show();
                                    }
                                }
                            })
                            .setNegativeButton("No", null)
                            .show();
                }
                else
                {
                    Toast.makeText(FriendSearchActivity.this, "User not found", Toast.LENGTH_LONG).show();
                }
            }
        });

        mBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FriendSearchActivity.this, FriendListActivity.class);
                startActivity(intent);
            }
        });
    }
}
