package theunderground.com.ucrmap;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.amazonaws.ClientConfiguration;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.CognitoUser;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.CognitoUserAttributes;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.CognitoUserCodeDeliveryDetails;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.CognitoUserPool;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.handlers.SignUpHandler;
import com.amazonaws.services.cognitoidentityprovider.model.AdminConfirmSignUpRequest;


/**
 * Created by Larry on 10-16-17
 */
public class RegisterActivity extends Activity{
    Button bSubmit,bBack;
    EditText etUsername, etPassword, etIlearnUser, etIlearnPass, etEmail, etStudentIdNumber;

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_activity_layout);
        etUsername = (EditText) this.findViewById(R.id.etUsername);
        etPassword = (EditText) this.findViewById(R.id.etPassword);
        etIlearnUser = (EditText) this.findViewById(R.id.etIlearnUser);
        etIlearnPass = (EditText) this.findViewById(R.id.etIlearnPass);
        etEmail = (EditText) this.findViewById(R.id.etEmailReg);
        bSubmit = (Button) this.findViewById(R.id.bSubmit);
        bBack = (Button) this.findViewById(R.id.bBackReg);
        etStudentIdNumber = (EditText) this.findViewById(R.id.spinner);

        String poolId = getString(R.string.poolId);
        String clientId = getString(R.string.clientId);
        String clientSecret = getString(R.string.clientSecret);

        ClientConfiguration clientConfiguration = new ClientConfiguration();

        // Create a CognitoUserPool object to refer to your user pool
        final CognitoUserPool userPool = new CognitoUserPool(this, poolId, clientId, clientSecret, clientConfiguration);

        // Create a CognitoUserAttributes object and add user attributes
        final CognitoUserAttributes userAttributes = new CognitoUserAttributes();


        bSubmit.setOnClickListener (new View.OnClickListener(){
            public void onClick(View v){
                String userName = etUsername.getText().toString();
                String password = etPassword.getText().toString();
                String IlearnUserF = etIlearnUser.getText().toString();
                String IlearnPassF = etIlearnPass.getText().toString();
                String EmailF = etEmail.getText().toString();
                String studentIdNumber = etStudentIdNumber.getText().toString();


                int idNumber = Integer.parseInt(studentIdNumber);

                if(userName.isEmpty() || password.isEmpty() || EmailF.isEmpty() || studentIdNumber.isEmpty())
                {
                    Toast.makeText(RegisterActivity.this, "Please fill in all required fields", Toast.LENGTH_LONG).show();
                    return;
                }
                else if (password.length() < 6)
                {
                    Toast.makeText(RegisterActivity.this, "Length of password must be at least 6.", Toast.LENGTH_LONG).show();
                    return;
                }
                else if(idNumber <= 100000000)
                {
                    Toast.makeText(RegisterActivity.this, "Please fill in correct Student ID", Toast.LENGTH_LONG).show();
                    return;
                }
                else if(!EmailF.substring(EmailF.length() -3).equals("edu"))
                {
                    Toast.makeText(RegisterActivity.this, "Please Enter correct UCR Email", Toast.LENGTH_LONG).show();
                    return;
                }
                else
                {
                    userAttributes.addAttribute("custom:studentIdNumber", studentIdNumber);
                    userAttributes.addAttribute("email", EmailF);
                    if(!IlearnPassF.isEmpty())
                    {
                        userAttributes.addAttribute("custom:iLearnPassword", IlearnPassF);
                    }
                    if(!IlearnUserF.isEmpty())
                    {
                        userAttributes.addAttribute("custom:netId", IlearnUserF);
                    }
                    userPool.signUpInBackground(userName, password, userAttributes,null,signUpHandler);
                }
            }
        });

        bBack.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent i = new Intent(RegisterActivity.this, LoginActivity.class);
                i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                RegisterActivity.this.startActivity(i);
            }
        });
    }
    SignUpHandler signUpHandler = new SignUpHandler() {
        @Override
        public void onSuccess(CognitoUser user, boolean signUpConfirmationState,
                              CognitoUserCodeDeliveryDetails cognitoUserCodeDeliveryDetails) {

            Toast.makeText(RegisterActivity.this, "Registered Successfully. Returning to Login", Toast.LENGTH_LONG).show();


            Intent i = new Intent(RegisterActivity.this, LoginActivity.class);
            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            RegisterActivity.this.startActivity(i);
        }

        @Override
        public void onFailure(Exception exception) {
            Toast.makeText(RegisterActivity.this, "Sign up failed. Please try again.", Toast.LENGTH_LONG).show();
            Toast.makeText(RegisterActivity.this, exception.toString(), Toast.LENGTH_LONG).show();
        }
    };
}


