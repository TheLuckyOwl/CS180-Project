package theunderground.com.ucrmap;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Larry Parsons on 4/14/2016.
 */
public class ForgotLogin extends Activity {
    private TextView TopText = null;
    private TextView LoginText = null;
    private Button SubmitRequest = null;
    private Button BackLogin = null;
    private EditText Email = null;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.forgot_login_layout);
        TopText = (TextView) findViewById(R.id.tvTopBanner);
        LoginText = (TextView) findViewById(R.id.tvLoginRecovery);
        SubmitRequest = (Button) findViewById(R.id.bRecover);
        BackLogin = (Button) findViewById(R.id.bBacRec);
        Email = (EditText) findViewById(R.id.etEmail);

        SubmitRequest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ForgotLogin.this, "Email was received. You will receive an email shortly.", Toast.LENGTH_LONG).show();
                Intent i = new Intent(ForgotLogin.this, LoginActivity.class);
                i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                ForgotLogin.this.startActivity(i);
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
