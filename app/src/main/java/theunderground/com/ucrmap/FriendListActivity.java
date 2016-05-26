package theunderground.com.ucrmap;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

/**
 * Created by Roger on 5/26/2016.
 */
public class FriendListActivity extends Activity{
    private ImageButton mBackButton = null;
    private Button mAddFriend = null;
    private Button mSearch = null;
    private User CurrentUser = new User();
    private String LoggedinUser = LoginActivity.LoggedUser;
    ArrayList<User> returnValues = new ArrayList<User>();
    ArrayList<String> UsersToFind;
    ArrayList<String[]> Friends;



    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBackButton = (ImageButton) findViewById(R.id.backImage);
        mAddFriend = (Button) findViewById(R.id.bAddFriend);
        mSearch = (Button) findViewById(R.id.bBFLSearch);
        setContentView(R.layout.friend_list_activity_layout);
        RecyclerView recyclerView = (RecyclerView) this.findViewById(R.id.FriendlistView);

        GetUsersAsyncTask task = new GetUsersAsyncTask();
        try {
            returnValues = task.execute().get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        for (User x : returnValues) {
            {
                if (x.getUsername().equals(LoggedinUser)) {
                    if (x.getFriend1Access().equals("YES")) {
                        String temp = x.getFriend1Name();
                        UsersToFind.add(temp);
                    }
                    if (x.getFriend2Access().equals("YES")) {
                        String temp = x.getFriend2Name();
                        UsersToFind.add(temp);
                    }
                    if (x.getFriend3Access().equals("YES")) {
                        String temp = x.getFriend3Name();
                        UsersToFind.add(temp);
                    }
                    if (x.getFriend4Access().equals("YES")) {
                        String temp = x.getFriend4Name();
                        UsersToFind.add(temp);
                    }
                    if (x.getFriend5Access().equals("YES")) {
                        String temp = x.getFriend5Name();
                        UsersToFind.add(temp);
                    }
                    if (x.getFriend6Access().equals("YES")) {
                        String temp = x.getFriend6Name();
                        UsersToFind.add(temp);
                    }
                    if (x.getFriend7Access().equals("YES")) {
                        String temp = x.getFriend7Name();
                        UsersToFind.add(temp);
                    }
                    if (x.getFriend8Access().equals("YES")) {
                        String temp = x.getFriend8Name();
                        UsersToFind.add(temp);
                    }
                    if (x.getFriend9Access().equals("YES")) {
                        String temp = x.getFriend9Name();
                        UsersToFind.add(temp);
                    }
                    if (x.getFriend10Access().equals("YES")) {
                        String temp = x.getFriend10Name();
                        UsersToFind.add(temp);
                    }
                }
            }
        }

        if (UsersToFind.size() > 0) {
            for (int i = 0; i < UsersToFind.size(); ++i) {
                for (User x : returnValues) {
                    String[] temp = {"", "", ""};
                    if (x.getUsername().equals(UsersToFind.get(i))) {
                        temp[0] = x.getFirst_name();
                        temp[1] = x.getMiddle_initial();
                        temp[2] = x.getLast_name();
                        Friends.add(temp);
                    }
                }
            }

        } else {
            for (int i = 0; i < 10; ++i) {
                String[] temp = {"", "", ""};
                Friends.add(temp);
            }
        }

        if (Friends.size() != 10) {
            for (int i = Friends.size(); i <= 10; ++i) {
                String[] temp = {"", "", ""};
                Friends.add(temp);
            }
        }

        FriendListAdapter mAdapter;
        FriendListModel Data[] = {new FriendListModel(Friends.get(0)[0], Friends.get(0)[1], Friends.get(0)[2]),
                new FriendListModel(Friends.get(1)[0], Friends.get(1)[1], Friends.get(1)[2]),
                new FriendListModel(Friends.get(2)[0], Friends.get(2)[1], Friends.get(2)[2]),
                new FriendListModel(Friends.get(3)[0], Friends.get(3)[1], Friends.get(3)[2]),
                new FriendListModel(Friends.get(5)[0], Friends.get(5)[1], Friends.get(5)[2]),
                new FriendListModel(Friends.get(6)[0], Friends.get(6)[1], Friends.get(6)[2]),
                new FriendListModel(Friends.get(7)[0], Friends.get(7)[1], Friends.get(7)[2]),
                new FriendListModel(Friends.get(8)[0], Friends.get(8)[1], Friends.get(8)[2]),
                new FriendListModel(Friends.get(9)[0], Friends.get(9)[1], Friends.get(9)[2])
        };

        mAdapter = new FriendListAdapter(Data);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        recyclerView.setAdapter(mAdapter);

        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(this, recyclerView, new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                int firstChoice = position;
                solutions(firstChoice);
            }

            @Override
            public void onItemLongClick(View view, int position) {
                // ...
            }
        }));
    }
    public void solutions(int firstChoice){
        Intent i = new Intent(FriendListActivity.this, FriendsScheduleActivity.class);

        if(firstChoice == 0 && !Friends.get(0)[0].equals(""))
        {
            i.putExtra("FriendUserName", UsersToFind.get(0));
        }
        else if (firstChoice == 1 && !Friends.get(1)[0].equals(""))
        {
            i.putExtra("FriendUserName", UsersToFind.get(1));
        }
        else if (firstChoice == 2 && !Friends.get(2)[0].equals(""))
        {
            i.putExtra("FriendUserName", UsersToFind.get(2));
        }
        else if (firstChoice == 3 && !Friends.get(3)[0].equals(""))
        {
            i.putExtra("FriendUserName", UsersToFind.get(3));
        }
        else if (firstChoice == 4 && !Friends.get(4)[0].equals(""))
        {
            i.putExtra("FriendUserName", UsersToFind.get(4));
        }
        else if (firstChoice == 5 && !Friends.get(5)[0].equals(""))
        {
            i.putExtra("FriendUserName", UsersToFind.get(5));
        }
        else if (firstChoice == 6 && !Friends.get(6)[0].equals(""))
        {
            i.putExtra("FriendUserName", UsersToFind.get(6));
        }
        else if (firstChoice == 7 && !Friends.get(7)[0].equals(""))
        {
            i.putExtra("FriendUserName", UsersToFind.get(7));
        }
        else if (firstChoice == 8 && !Friends.get(8)[0].equals(""))
        {
            i.putExtra("FriendUserName", UsersToFind.get(8));
        }
        else if (firstChoice == 9 && !Friends.get(9)[0].equals(""))
        {
            i.putExtra("FriendUserName", UsersToFind.get(9));
        }
        startActivity(i);
        mBackButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                back();
            }
        });
    }
    private void back(){
        Intent intent = new Intent(FriendListActivity.this, AccountActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
        finish();
    }

}
