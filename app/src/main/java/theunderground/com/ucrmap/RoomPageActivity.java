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
    private TextView newComment = null;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.room_page_activity_layout);

        mAddComm = (Button)findViewById(R.id.addComment);

        //RecyclerView recyclerView = (RecyclerView) this.findViewById(R.id.listView2);

        // there was a shit ton of code n between over here (see ScheduleActivity.java
        // for reference)

        // COMMENTING OUT CODE THAT I DONT WANT TO DELETE BECAUSE IT SEEMS USEFUL

        //ScheduleAdapter mAdapter;

        //mAdapter = new ScheduleAdapter(dummyData);

        // 2. set layoutManger
        //recyclerView.setLayoutManager(new LinearLayoutManager(this));
        // 4. set adapter
        //recyclerView.setAdapter(mAdapter);
        // 5. set item animator to DefaultAnimator

        //recyclerView.setItemAnimator(new DefaultItemAnimator());

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
                        newComment.setText(inputTxt.getText());
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
