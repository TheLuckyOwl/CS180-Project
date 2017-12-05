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

import com.amazonaws.ClientConfiguration;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.CognitoUser;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.CognitoUserAttributes;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.CognitoUserDetails;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.CognitoUserPool;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.handlers.GetDetailsHandler;

import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.ExecutionException;

/**
 * Created by Larry Parsons on 4/14/2016.
 */
public class ForgotLogin extends Activity {

    private Button SubmitRequest = null;
    private Button BackLogin = null;
    private EditText userId = null;
    private EditText sId = null;
    private String password = null;



    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.forgot_login_layout);
        SubmitRequest = (Button) findViewById(R.id.bRecover);
        BackLogin = (Button) findViewById(R.id.bBacRec);
        userId = (EditText) findViewById(R.id.etUserRec);
        sId = (EditText) findViewById(R.id.etSIdRec);


        SubmitRequest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userID = userId.getText().toString();
                String studentId = sId.getText().toString();

                //TODO Need to implement recovery.

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
