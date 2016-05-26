package theunderground.com.ucrmap;

import android.app.Activity;
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
public class AddFriendActivity extends Activity {
    private EditText mAddUser = null;
    private Button mAddSubmit = null;
    private Button mBack = null;
    private String LoggedinUser = LoginActivity.LoggedUser;
    private User CurrentUser = new User();
    private User FriendUser = new User();
    ArrayList<User> returnValues = new ArrayList<User>();

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_friend_activity_layout);
        mAddUser = (EditText) findViewById(R.id.etFrAdd);
        mAddSubmit = (Button) findViewById(R.id.bAdd);
        mBack = (Button) findViewById(R.id.bBacAdd);

        GetUsersAsyncTask task = new GetUsersAsyncTask();
        try {
            returnValues = task.execute().get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        mAddSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String username = mAddUser.getText().toString();
                for (User x : returnValues) {
                    if(x.getUsername().equals(username)) {
                        FriendUser.setDoc_id(x.getDoc_id());
                        FriendUser.setFirst_name(x.getFirst_name());
                        FriendUser.setMiddle_initial(x.getMiddle_initial());
                        FriendUser.setLast_name(x.getLast_name());
                        FriendUser.setUsername(x.getUsername());
                        FriendUser.setPassword(x.getPassword());
                        FriendUser.setIlearnUser(x.getIlearnUser());
                        FriendUser.setIlearnPass(x.getIlearnPass());
                        FriendUser.setEmail(x.getEmail());
                        FriendUser.setPendingRequest1(x.getPendingRequest1());
                        FriendUser.setPendingRequest2(x.getPendingRequest2());
                        FriendUser.setPendingRequest3(x.getPendingRequest3());
                        FriendUser.setPendingRequest4(x.getPendingRequest4());
                        FriendUser.setPendingRequest5(x.getPendingRequest5());
                        FriendUser.setClass1Data(x.getClass1Data());
                        FriendUser.setClass1Day(x.getClass1Day());
                        FriendUser.setClass1Time(x.getClass1Time());
                        FriendUser.setClass2Data(x.getClass2Data());
                        FriendUser.setClass2Day(x.getClass2Day());
                        FriendUser.setClass2Time(x.getClass2Time());
                        FriendUser.setClass3Data(x.getClass3Data());
                        FriendUser.setClass3Day(x.getClass3Day());
                        FriendUser.setClass3Time(x.getClass3Time());
                        FriendUser.setClass4Data(x.getClass4Data());
                        FriendUser.setClass4Day(x.getClass4Day());
                        FriendUser.setClass4Time(x.getClass4Time());
                        FriendUser.setClass5Data(x.getClass5Data());
                        FriendUser.setClass5Day(x.getClass5Day());
                        FriendUser.setClass5Time(x.getClass5Time());
                        FriendUser.setClass6Data(x.getClass6Data());
                        FriendUser.setClass6Day(x.getClass6Day());
                        FriendUser.setClass6Time(x.getClass6Time());
                        FriendUser.setClass7Data(x.getClass7Data());
                        FriendUser.setClass7Day(x.getClass7Day());
                        FriendUser.setClass7Time(x.getClass7Time());
                        FriendUser.setClass8Data(x.getClass8Data());
                        FriendUser.setClass8Day(x.getClass8Day());
                        FriendUser.setClass8Time(x.getClass8Time());
                        FriendUser.setClass9Data(x.getClass9Data());
                        FriendUser.setClass9Day(x.getClass9Day());
                        FriendUser.setClass9Time(x.getClass9Time());
                        FriendUser.setClass10Data(x.getClass10Data());
                        FriendUser.setClass10Day(x.getClass10Day());
                        FriendUser.setClass10Time(x.getClass10Time());
                        FriendUser.setFriend1Name(x.getFriend1Name());
                        FriendUser.setFriend1Accesss(x.getFriend1Access());
                        FriendUser.setFriend2Name(x.getFriend2Name());
                        FriendUser.setFriend2Accesss(x.getFriend2Access());
                        FriendUser.setFriend3Name(x.getFriend3Name());
                        FriendUser.setFriend3Accesss(x.getFriend3Access());
                        FriendUser.setFriend4Name(x.getFriend4Name());
                        FriendUser.setFriend4Accesss(x.getFriend4Access());
                        FriendUser.setFriend5Name(x.getFriend5Name());
                        FriendUser.setFriend5Accesss(x.getFriend5Access());
                        FriendUser.setFriend6Name(x.getFriend6Name());
                        FriendUser.setFriend6Accesss(x.getFriend6Access());
                        FriendUser.setFriend7Name(x.getFriend7Name());
                        FriendUser.setFriend7Accesss(x.getFriend7Access());
                        FriendUser.setFriend8Name(x.getFriend8Name());
                        FriendUser.setFriend8Accesss(x.getFriend8Access());
                        FriendUser.setFriend9Name(x.getFriend9Name());
                        FriendUser.setFriend9Accesss(x.getFriend9Access());
                        FriendUser.setFriend10Name(x.getFriend10Name());
                        FriendUser.setFriend10Accesss(x.getFriend10Access());
                    }
                }

                if(FriendUser.getPendingRequest1().equals(""))
                {
                    FriendUser.setPendingRequest1(LoggedinUser);
                }
                else if (FriendUser.getPendingRequest2().equals(""))
                {
                    FriendUser.setPendingRequest2(LoggedinUser);
                }
                else if (FriendUser.getPendingRequest3().equals(""))
                {
                    FriendUser.setPendingRequest3(LoggedinUser);
                }
                else if (FriendUser.getPendingRequest4().equals(""))
                {
                    FriendUser.setPendingRequest4(LoggedinUser);
                }
                else if (FriendUser.getPendingRequest5().equals(""))
                {
                    FriendUser.setPendingRequest5(LoggedinUser);
                }

                UpdateUser tsk = new UpdateUser();
                tsk.execute(FriendUser);
                Toast.makeText(AddFriendActivity.this, "Sent Friend Request", Toast.LENGTH_LONG ).show();
            }
        });

        mBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AddFriendActivity.this, FriendListActivity.class);
                startActivity(intent);
            }
        });

    }

}
