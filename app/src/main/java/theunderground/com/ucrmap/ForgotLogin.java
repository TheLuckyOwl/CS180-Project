package theunderground.com.ucrmap;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

/**
 * Created by Larry Parsons on 4/14/2016.
 */
public class ForgotLogin extends Activity {
    private TextView TopText = null;
    private TextView LoginText = null;
    private Button SubmitRequest = null;
    private Button BackLogin = null;
    private EditText Email = null;
    private EditText Username = null;
    private String CorrectEmail = null;
    private String CorrectUser = null;
    private String UsersName = null;
    ArrayList<User> returnValues = new ArrayList<User>();

    private boolean allCorrect(String email, String username) {

        GetUsersAsyncTask task = new GetUsersAsyncTask();
        try {
            returnValues = task.execute().get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        boolean Exists = false;
        for(User x: returnValues)
        {
            if(x.getUsername().equals(username))
            {
                if(x.getEmail().equals(email))
                {
                    CorrectEmail = x.getEmail();
                    CorrectUser = x.getUsername();
                    UsersName = x.getFirst_name();
                    return true;
                }
            }
        }

        return false;
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.forgot_login_layout);
        TopText = (TextView) findViewById(R.id.tvTopBanner);
        LoginText = (TextView) findViewById(R.id.tvLoginRecovery);
        SubmitRequest = (Button) findViewById(R.id.bRecover);
        BackLogin = (Button) findViewById(R.id.bBacRec);
        Email = (EditText) findViewById(R.id.etEmailRec);
        Username = (EditText) findViewById(R.id.etUserRec);


        SubmitRequest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = Email.getText().toString();
                String username = Username.getText().toString();


                if(allCorrect(email, username))
                {
                    Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts(
                            "mailto","theucrmap@gmail.com", null));
                    emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Login Credential Help");
                    emailIntent.putExtra(Intent.EXTRA_TEXT, "Hello, my name is " + UsersName + " and my Username is " +
                            CorrectUser + ". Please send my Login Information to " + CorrectEmail + ".");
                    startActivity(Intent.createChooser(emailIntent, "Send email..."));
                }
                else
                {
                    Toast.makeText(ForgotLogin.this, "The Email and Usernames do not match. Please try again", Toast.LENGTH_LONG).show();
                }

            }
        });

        BackLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ForgotLogin.this, LoginActivity.class);
                i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                ForgotLogin.this.startActivity(i);
            }
        });
    }
}
