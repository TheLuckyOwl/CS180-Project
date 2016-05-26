package theunderground.com.ucrmap;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

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
    private User FriendUser = new User();
    private String LoggedinUser = LoginActivity.LoggedUser;
    ArrayList<User> returnValues = new ArrayList<User>();
    ArrayList<User> returnValues2 = new ArrayList<User>();
    ArrayList<String> UsersToFind = new ArrayList<String>();
    ArrayList<String[]> Friends = new ArrayList<String[]>();

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.friend_list_activity_layout);
        mBackButton = (ImageButton) findViewById(R.id.backImage);
        mAddFriend = (Button) findViewById(R.id.bAddFriend);
        mSearch = (Button) findViewById(R.id.bBFLSearch);
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

        if (!CurrentUser.getPendingRequest1().equals(""))
        {
            new AlertDialog.Builder(FriendListActivity.this)
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .setTitle("Friend Request")
                    .setMessage(CurrentUser.getPendingRequest1() + " wants to add you")
                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            boolean isfull = false;
                            for (User x : returnValues)
                            {
                                if(x.getUsername().equals(CurrentUser.getPendingRequest1()))
                                {
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

                            if (CurrentUser.getFriend1Name().equals(""))
                            {
                                CurrentUser.setFriend1Name(CurrentUser.getPendingRequest1());
                                CurrentUser.setFriend1Accesss("YES");
                                CurrentUser.setPendingRequest1(CurrentUser.getPendingRequest2());
                                CurrentUser.setPendingRequest2(CurrentUser.getPendingRequest3());
                                CurrentUser.setPendingRequest3(CurrentUser.getPendingRequest4());
                                CurrentUser.setPendingRequest4(CurrentUser.getPendingRequest5());
                                CurrentUser.setPendingRequest5("");
                                UpdateUser tsk = new UpdateUser();
                                tsk.execute(CurrentUser);
                            }
                            else if (CurrentUser.getFriend2Name().equals(""))
                            {
                                CurrentUser.setFriend2Name(CurrentUser.getPendingRequest1());
                                CurrentUser.setFriend2Accesss("YES");
                                CurrentUser.setPendingRequest1(CurrentUser.getPendingRequest2());
                                CurrentUser.setPendingRequest2(CurrentUser.getPendingRequest3());
                                CurrentUser.setPendingRequest3(CurrentUser.getPendingRequest4());
                                CurrentUser.setPendingRequest4(CurrentUser.getPendingRequest5());
                                CurrentUser.setPendingRequest5("");
                                UpdateUser tsk = new UpdateUser();
                                tsk.execute(CurrentUser);
                            }
                            else if (CurrentUser.getFriend3Name().equals(""))
                            {
                                CurrentUser.setFriend3Name(CurrentUser.getPendingRequest1());
                                CurrentUser.setFriend3Accesss("YES");
                                CurrentUser.setPendingRequest1(CurrentUser.getPendingRequest2());
                                CurrentUser.setPendingRequest2(CurrentUser.getPendingRequest3());
                                CurrentUser.setPendingRequest3(CurrentUser.getPendingRequest4());
                                CurrentUser.setPendingRequest4(CurrentUser.getPendingRequest5());
                                CurrentUser.setPendingRequest5("");
                                UpdateUser tsk = new UpdateUser();
                                tsk.execute(CurrentUser);
                            }
                            else if (CurrentUser.getFriend4Name().equals(""))
                            {

                                CurrentUser.setFriend4Name(CurrentUser.getPendingRequest1());
                                CurrentUser.setFriend4Accesss("YES");
                                CurrentUser.setPendingRequest1(CurrentUser.getPendingRequest2());
                                CurrentUser.setPendingRequest2(CurrentUser.getPendingRequest3());
                                CurrentUser.setPendingRequest3(CurrentUser.getPendingRequest4());
                                CurrentUser.setPendingRequest4(CurrentUser.getPendingRequest5());
                                CurrentUser.setPendingRequest5("");
                                UpdateUser tsk = new UpdateUser();
                                tsk.execute(CurrentUser);
                            }
                            else if (CurrentUser.getFriend2Name().equals(""))
                            {
                                CurrentUser.setPendingRequest1(CurrentUser.getPendingRequest2());
                                CurrentUser.setPendingRequest2(CurrentUser.getPendingRequest3());
                                CurrentUser.setPendingRequest3(CurrentUser.getPendingRequest4());
                                CurrentUser.setPendingRequest4(CurrentUser.getPendingRequest5());
                                CurrentUser.setPendingRequest5("");
                                CurrentUser.setFriend5Name(CurrentUser.getPendingRequest1());
                                CurrentUser.setFriend5Accesss("YES");
                                UpdateUser tsk = new UpdateUser();
                                tsk.execute(CurrentUser);
                            }
                            else if (CurrentUser.getFriend6Name().equals(""))
                            {
                                CurrentUser.setFriend6Name(CurrentUser.getPendingRequest1());
                                CurrentUser.setFriend6Accesss("YES");
                                CurrentUser.setPendingRequest1(CurrentUser.getPendingRequest2());
                                CurrentUser.setPendingRequest2(CurrentUser.getPendingRequest3());
                                CurrentUser.setPendingRequest3(CurrentUser.getPendingRequest4());
                                CurrentUser.setPendingRequest4(CurrentUser.getPendingRequest5());
                                CurrentUser.setPendingRequest5("");
                                UpdateUser tsk = new UpdateUser();
                                tsk.execute(CurrentUser);
                            }
                            else if (CurrentUser.getFriend7Name().equals(""))
                            {
                                CurrentUser.setFriend7Name(CurrentUser.getPendingRequest1());
                                CurrentUser.setFriend7Accesss("YES");
                                CurrentUser.setPendingRequest1(CurrentUser.getPendingRequest2());
                                CurrentUser.setPendingRequest2(CurrentUser.getPendingRequest3());
                                CurrentUser.setPendingRequest3(CurrentUser.getPendingRequest4());
                                CurrentUser.setPendingRequest4(CurrentUser.getPendingRequest5());
                                CurrentUser.setPendingRequest5("");
                                UpdateUser tsk = new UpdateUser();
                                tsk.execute(CurrentUser);
                            }
                            else if (CurrentUser.getFriend8Name().equals(""))
                            {
                                CurrentUser.setFriend8Name(CurrentUser.getPendingRequest1());
                                CurrentUser.setFriend8Accesss("YES");
                                CurrentUser.setPendingRequest1(CurrentUser.getPendingRequest2());
                                CurrentUser.setPendingRequest2(CurrentUser.getPendingRequest3());
                                CurrentUser.setPendingRequest3(CurrentUser.getPendingRequest4());
                                CurrentUser.setPendingRequest4(CurrentUser.getPendingRequest5());
                                CurrentUser.setPendingRequest5("");
                                UpdateUser tsk = new UpdateUser();
                                tsk.execute(CurrentUser);
                            }
                            else if (CurrentUser.getFriend9Name().equals(""))
                            {
                                CurrentUser.setFriend9Name(CurrentUser.getPendingRequest1());
                                CurrentUser.setFriend9Accesss("YES");
                                CurrentUser.setPendingRequest1(CurrentUser.getPendingRequest2());
                                CurrentUser.setPendingRequest2(CurrentUser.getPendingRequest3());
                                CurrentUser.setPendingRequest3(CurrentUser.getPendingRequest4());
                                CurrentUser.setPendingRequest4(CurrentUser.getPendingRequest5());
                                CurrentUser.setPendingRequest5("");
                                UpdateUser tsk = new UpdateUser();
                                tsk.execute(CurrentUser);
                            }
                            else if (CurrentUser.getFriend10Name().equals(""))
                            {
                                CurrentUser.setFriend10Name(CurrentUser.getPendingRequest1());
                                CurrentUser.setFriend10Accesss("YES");
                                CurrentUser.setPendingRequest1(CurrentUser.getPendingRequest2());
                                CurrentUser.setPendingRequest2(CurrentUser.getPendingRequest3());
                                CurrentUser.setPendingRequest3(CurrentUser.getPendingRequest4());
                                CurrentUser.setPendingRequest4(CurrentUser.getPendingRequest5());
                                CurrentUser.setPendingRequest5("");
                                UpdateUser tsk = new UpdateUser();
                                tsk.execute(CurrentUser);
                            }
                            else
                            {
                                Toast.makeText(FriendListActivity.this, "Your list is full", Toast.LENGTH_LONG ).show();
                                isfull = true;
                            }


                            if(!isfull)
                            {
                                if (FriendUser.getFriend1Name().equals(""))
                                {
                                    FriendUser.setFriend1Name(LoggedinUser);
                                    FriendUser.setFriend1Accesss("YES");
                                    UpdateUser tsk = new UpdateUser();
                                    tsk.execute(FriendUser);
                                }
                                else if (FriendUser.getFriend2Name().equals(""))
                                {
                                    FriendUser.setFriend2Name(LoggedinUser);
                                    FriendUser.setFriend2Accesss("YES");
                                    UpdateUser tsk = new UpdateUser();
                                    tsk.execute(FriendUser);
                                }
                                else if (FriendUser.getFriend3Name().equals(""))
                                {
                                    FriendUser.setFriend3Name(LoggedinUser);
                                    FriendUser.setFriend3Accesss("YES");
                                    UpdateUser tsk = new UpdateUser();
                                    tsk.execute(FriendUser);
                                }
                                else if (FriendUser.getFriend4Name().equals(""))
                                {
                                    FriendUser.setFriend4Name(LoggedinUser);
                                    FriendUser.setFriend4Accesss("YES");
                                    UpdateUser tsk = new UpdateUser();
                                    tsk.execute(FriendUser);
                                }
                                else if (FriendUser.getFriend5Name().equals(""))
                                {
                                    FriendUser.setFriend5Name(LoggedinUser);
                                    FriendUser.setFriend5Accesss("YES");
                                    UpdateUser tsk = new UpdateUser();
                                    tsk.execute(FriendUser);
                                }
                                else if (FriendUser.getFriend6Name().equals(""))
                                {
                                    FriendUser.setFriend6Name(LoggedinUser);
                                    FriendUser.setFriend6Accesss("YES");
                                    UpdateUser tsk = new UpdateUser();
                                    tsk.execute(FriendUser);
                                }
                                else if (FriendUser.getFriend7Name().equals(""))
                                {
                                    FriendUser.setFriend7Name(LoggedinUser);
                                    FriendUser.setFriend7Accesss("YES");
                                    UpdateUser tsk = new UpdateUser();
                                    tsk.execute(FriendUser);
                                }
                                else if (FriendUser.getFriend8Name().equals(""))
                                {
                                    FriendUser.setFriend8Name(LoggedinUser);
                                    FriendUser.setFriend8Accesss("YES");
                                    UpdateUser tsk = new UpdateUser();
                                    tsk.execute(FriendUser);
                                }
                                else if (FriendUser.getFriend9Name().equals(""))
                                {
                                    FriendUser.setFriend9Name(LoggedinUser);
                                    FriendUser.setFriend9Accesss("YES");
                                    UpdateUser tsk = new UpdateUser();
                                    tsk.execute(FriendUser);
                                }
                                else if (FriendUser.getFriend10Name().equals(""))
                                {
                                    FriendUser.setFriend10Name(LoggedinUser);
                                    FriendUser.setFriend10Accesss("YES");
                                    UpdateUser tsk = new UpdateUser();
                                    tsk.execute(FriendUser);
                                }
                                else
                                {
                                    Toast.makeText(FriendListActivity.this, "Friend's friend list is full", Toast.LENGTH_LONG ).show();
                                }
                            }
                        }
                    })
                    .setNegativeButton("No", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            CurrentUser.setPendingRequest1(CurrentUser.getPendingRequest2());
                            CurrentUser.setPendingRequest2(CurrentUser.getPendingRequest3());
                            CurrentUser.setPendingRequest3(CurrentUser.getPendingRequest4());
                            CurrentUser.setPendingRequest4(CurrentUser.getPendingRequest5());
                            CurrentUser.setPendingRequest5("");
                            UpdateUser tsk = new UpdateUser();
                            tsk.execute(CurrentUser);
                        }
                    })
                    .show();
        }

        GetUsersAsyncTask task2 = new GetUsersAsyncTask();
        try {
            returnValues2 = task2.execute().get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        for (User x : returnValues2) {
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
                for (User x : returnValues2) {
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

        mBackButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FriendListActivity.this, AccountActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                finish();
            }
        });

        mSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(FriendListActivity.this, FriendSearchActivity.class));
            }
        });

        mAddFriend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(FriendListActivity.this, AddFriendActivity.class));
            }
        });
    }

    public void solutions(int firstChoice){
        Intent i = new Intent(FriendListActivity.this, ViewFriendSchedule.class);

        if(firstChoice == 0 && !Friends.get(0)[0].equals(""))
        {
            i.putExtra("FriendUserName", UsersToFind.get(0));
            startActivity(i);
        }
        else if (firstChoice == 1 && !Friends.get(1)[0].equals(""))
        {
            i.putExtra("FriendUserName", UsersToFind.get(1));
            startActivity(i);
        }
        else if (firstChoice == 2 && !Friends.get(2)[0].equals(""))
        {
            i.putExtra("FriendUserName", UsersToFind.get(2));
            startActivity(i);
        }
        else if (firstChoice == 3 && !Friends.get(3)[0].equals(""))
        {
            i.putExtra("FriendUserName", UsersToFind.get(3));
            startActivity(i);
        }
        else if (firstChoice == 4 && !Friends.get(4)[0].equals(""))
        {
            i.putExtra("FriendUserName", UsersToFind.get(4));
            startActivity(i);
        }
        else if (firstChoice == 5 && !Friends.get(5)[0].equals(""))
        {
            i.putExtra("FriendUserName", UsersToFind.get(5));
            startActivity(i);
        }
        else if (firstChoice == 6 && !Friends.get(6)[0].equals(""))
        {
            i.putExtra("FriendUserName", UsersToFind.get(6));
            startActivity(i);
        }
        else if (firstChoice == 7 && !Friends.get(7)[0].equals(""))
        {
            i.putExtra("FriendUserName", UsersToFind.get(7));
            startActivity(i);
        }
        else if (firstChoice == 8 && !Friends.get(8)[0].equals(""))
        {
            i.putExtra("FriendUserName", UsersToFind.get(8));
            startActivity(i);
        }
        else if (firstChoice == 9 && !Friends.get(9)[0].equals(""))
        {
            i.putExtra("FriendUserName", UsersToFind.get(9));
            startActivity(i);
        }
        else
        {
            i.putExtra("FriendUserName", "");
            startActivity(i);
        }
    }

}
