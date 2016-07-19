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
    private Button mAddSubmit = null;
    private Button mBack = null;
    private String LoggedinUser = LoginActivity.LoggedUser;
    private User FriendUser = new User();
    ArrayList<User> returnValues = new ArrayList<User>();

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_friend_activity_layout);
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
                Intent intent = new Intent(AddFriendActivity.this, FriendListActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                finish();
            }
        });

        mBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AddFriendActivity.this, FriendListActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                finish();
            }
        });

    }

}
