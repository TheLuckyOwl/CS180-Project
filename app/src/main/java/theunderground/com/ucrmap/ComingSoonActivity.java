package theunderground.com.ucrmap;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

/**
 * Created by lplar on 8/9/2017.
 */

public class ComingSoonActivity extends Activity {

    TextView mTextView = null;
    private ImageButton mBackButton = null;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.coming_soon_layout);
        mTextView = (TextView) findViewById(R.id.comingSoonTitle);
        Bundle bundle = getIntent().getExtras();
        String title = bundle.getString("Title");
        mTextView.setText(title);
        mBackButton = (ImageButton)findViewById(R.id.backButton);

        mBackButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                back();
            }
        });
    }

    private void back(){
        Intent intent = new Intent(ComingSoonActivity.this, AccountActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
        finish();
    }
}
