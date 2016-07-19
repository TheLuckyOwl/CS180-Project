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

                    Toast.makeText(UpdateIlearnActivity.this, "Updated Successfully", Toast.LENGTH_LONG).show();
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
