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
 * Created by Roger on 5/23/2016.
 */
public class UpdateIlearnActivity extends Activity {
    private Button UpSubmit = null;
    private Button UpCancel = null;
    private EditText UIName = null;
    private EditText UIPass = null;
    private User CurrentUser = new User();
    private String LoggedinUser = LoginActivity.LoggedUser;
    ArrayList<User> returnValues = new ArrayList<User>();

    @Override
    protected void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.update_ilearn_activity_layout);

        UpSubmit = (Button) this.findViewById(R.id.bUSubmit);
        UpCancel = (Button) this.findViewById(R.id.bUCancel);
        UIName = (EditText) this.findViewById(R.id.etUpdateU);
        UIPass = (EditText) this.findViewById(R.id.etUpdateP);

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
                }
            }
        }


        UpSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String UName = UIName.getText().toString();
                final String UPword = UIPass.getText().toString();

                if(!UName.equals("") && !UPword.equals(""))
                {
                    CurrentUser.setIlearnUser(UName);
                    CurrentUser.setIlearnPass(UPword);
                    UpdateUser tsk = new UpdateUser();
                    tsk.execute(CurrentUser);

                    Toast.makeText(UpdateIlearnActivity.this, "Updated Successfully", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(UpdateIlearnActivity.this, ContactUsActivity.class);
                    UpdateIlearnActivity.this.startActivity(i);
                }
                else
                {
                    Toast.makeText(UpdateIlearnActivity.this, "Please Enter Correct Information", Toast.LENGTH_SHORT).show();
                }

            }

        });

        UpCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(UpdateIlearnActivity.this, ContactUsActivity.class);
                UpdateIlearnActivity.this.startActivity(i);
            }
        });

    }

}
