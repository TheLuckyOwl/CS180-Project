package theunderground.com.ucrmap;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import android.widget.TextView;
import android.widget.Toast;

import com.amazonaws.ClientConfiguration;
import com.amazonaws.mobile.auth.core.IdentityManager;
import com.amazonaws.mobile.auth.core.StartupAuthResult;
import com.amazonaws.mobile.auth.core.StartupAuthResultHandler;
import com.amazonaws.mobile.config.AWSConfiguration;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.CognitoUser;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.CognitoUserPool;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.CognitoUserSession;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.continuations.AuthenticationContinuation;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.continuations.AuthenticationDetails;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.continuations.MultiFactorAuthenticationContinuation;
import com.amazonaws.mobileconnectors.cognitoidentityprovider.handlers.AuthenticationHandler;



/**
 * Created by Larry Parsons on 4/14/2016.
 */
public class LoginActivity extends Activity {
    public static final String LOGGED_IN_PREF = "loggedIn";
    public static final String USER_ID_PREF = "user";

    private static CognitoUserSession currSession;

    private EditText mUserId = null;
    private EditText mPassword = null;
    private CheckBox mLog = null;
    private Button mLoginButton = null; //match with the ones made
    private Button mForgotId = null;
    private Button mRegister = null;
    public static String LoggedUser;


    private void checkUserId() {

        String poolId = getString(R.string.poolId);
        String clientId = getString(R.string.clientId);
        String clientSecret = getString(R.string.clientSecret);

//         May need this code.
//
//
//        Context appContext = getApplicationContext();
//        AWSConfiguration awsConfig = new AWSConfiguration(appContext);
//        IdentityManager identityManager = new IdentityManager(appContext, awsConfig);
//        IdentityManager.setDefaultIdentityManager(identityManager);
//        identityManager.doStartupAuth(this, new StartupAuthResultHandler() {
//            @Override
//            public void onComplete(StartupAuthResult startupAuthResult) {
//                // User identity is ready as unauthenticated user or previously signed-in user.
//            }
//        });
        ClientConfiguration clientConfiguration = new ClientConfiguration();

        // Create a CognitoUserPool object to refer to your user pool
        CognitoUserPool userPool = new CognitoUserPool(this, poolId, clientId, clientSecret, clientConfiguration);
        String userId = mUserId.getText().toString();
        userPool.getUser(userId).getSessionInBackground(handler);
    }

    public void save(String user, String pass)
    {
        SharedPreferences sharedPref = getSharedPreferences("LogData", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putBoolean("Logged", true);
        editor.putString("Username", user);
        editor.putString("Password", pass);
        editor.apply();
    }

    public Boolean load()
    {
        SharedPreferences sharedPref = getSharedPreferences("LogData", Context.MODE_PRIVATE);
        return sharedPref.getBoolean("Logged", false);
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity_layout);
        mUserId = (EditText)findViewById(R.id.etUsername);
        mPassword = (EditText)findViewById(R.id.etPassword);
        mForgotId = (Button)findViewById(R.id.bForgotLog);
        mLoginButton = (Button)findViewById(R.id.bLogin);
        mRegister = (Button)findViewById(R.id.bRegister);
        mLog = (CheckBox) findViewById(R.id.cbLog);


        if(load())
        {
            SharedPreferences sharedPref = getSharedPreferences("LogData", Context.MODE_PRIVATE);
            mUserId.setText(sharedPref.getString("Username", ""));
            mPassword.setText(sharedPref.getString("Password", ""));
        }


        mLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkUserId();
            }
        });
        mForgotId.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent i = new Intent(LoginActivity.this, ForgotLogin.class);
                LoginActivity.this.startActivity(i);
            }
        });

        mRegister.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent i = new Intent(LoginActivity.this, RegisterActivity.class);
                LoginActivity.this.startActivity(i);
            }
        });

    }
    public void loginFunction()
    {
        if (mLog.isChecked()) {
            save(mUserId.getText().toString(),mPassword.getText().toString());
            Toast.makeText(LoginActivity.this, "Welcome " + mUserId.getText().toString() , Toast.LENGTH_LONG).show();
            Intent i = new Intent(LoginActivity.this, AccountActivity.class);
            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(i);
        }
        else
        {
            SharedPreferences sharedPref = getSharedPreferences("LogData", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPref.edit();
            editor.putBoolean("Logged", false);
            editor.apply();
            Toast.makeText(LoginActivity.this, "Welcome " + mUserId.getText().toString(), Toast.LENGTH_LONG).show();
            Intent i = new Intent(LoginActivity.this, AccountActivity.class);
            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(i);
        }
    };
    AuthenticationHandler handler = new AuthenticationHandler() {
        @Override
        public void onSuccess(CognitoUserSession userSession) {
            currSession = userSession;
            loginFunction();
        }

        @Override
        public void getAuthenticationDetails(AuthenticationContinuation authenticationContinuation, String username) {

            String password = mPassword.getText().toString();
            // The API needs user sign-in credentials to continue
            AuthenticationDetails authenticationDetails = new AuthenticationDetails(username, password, null);

            // Pass the user sign-in credentials to the continuation
            authenticationContinuation.setAuthenticationDetails(authenticationDetails);

            // Allow the sign-in to continue
            authenticationContinuation.continueTask();
        }

        @Override
        public void getMFACode(MultiFactorAuthenticationContinuation continuation) {

        }

        @Override
        public void onFailure(Exception exception) {
            Toast.makeText(LoginActivity.this, "Invalid ID Or Password - Please try again", Toast.LENGTH_LONG).show();
        }
    };
}
