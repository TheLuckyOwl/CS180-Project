package theunderground.com.ucrmap;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;


/**
 * Created by Dharti on 5/26/2016.
 */
public class SplashActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_layout);



        Thread background = new Thread() {
            public void run() {
                try {
                    sleep(3500);

                    Intent i = new Intent(SplashActivity.this, LoginActivity.class);
                    startActivity(i);

                    finish();
                } catch (Exception e) {

                }
            }
        };

        background.start();
    }
}
