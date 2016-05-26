package theunderground.com.ucrmap;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageButton;
import android.widget.TextView;


/**
 * Created by Larry Parsons on 4/14/2016.
 */
public class DinningHallActivity extends Activity {

    SharedPreferences prefs = null;
    private ImageButton mBackButton = null;
    private TextView mTitle = null;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        prefs = this.getSharedPreferences("Login", Context.MODE_PRIVATE);
        setContentView(R.layout.dinning_hall_activity_layout);
        RecyclerView recyclerView = (RecyclerView) this.findViewById(R.id.recyclerViewTab);
        TabWizardAdapter mAdapter;
        mTitle = (TextView)findViewById(R.id.diningTitle);
        mTitle.setText("Dining Halls");
        mBackButton = (ImageButton)findViewById(R.id.backButton);
        mBackButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                back();
            }
        });

        TabsWizardModel dininghall_data[] = {new TabsWizardModel("AI", R.drawable.ai),
                new TabsWizardModel("Lothian", R.drawable.lothian),
                new TabsWizardModel("Spinelli's", R.drawable.spinelli),
                new TabsWizardModel("Glen Mor Market Shop", R.drawable.gmshop),
                new TabsWizardModel("Glen Mor Market Sizzle", R.drawable.gmsizzle),
                new TabsWizardModel("Glen Mor Market Savor", R.drawable.gmsavor),
                new TabsWizardModel("Glen Mor Market Starbucks", R.drawable.gmstarbucks),
                new TabsWizardModel("HUB Scotty's", R.drawable.hubscot),
                new TabsWizardModel("AI Scotty's", R.drawable.scottys),
                new TabsWizardModel("Lothian Scotty's", R.drawable.scottys),
                new TabsWizardModel("Glen Mor Scotty's", R.drawable.scottys),
                new TabsWizardModel("School of Medicine Scotty's", R.drawable.scottys),
                new TabsWizardModel("The Barn", R.drawable.barn),
                new TabsWizardModel("Bytes", R.drawable.bytes),
                new TabsWizardModel("Ivan's", R.drawable.ivan),
                new TabsWizardModel("Subway", R.drawable.subway),
                new TabsWizardModel("Habanero's", R.drawable.habanero),
                new TabsWizardModel("HUB2GO", R.drawable.hub),
                new TabsWizardModel("Panda Express", R.drawable.panda),
                new TabsWizardModel("Panda Express Sushi", R.drawable.pandasushi),
                new TabsWizardModel("La Fiamma", R.drawable.fiamma),
                new TabsWizardModel("The Grill", R.drawable.grill),
                new TabsWizardModel("Coffee Bean", R.drawable.coffeebean),
                new TabsWizardModel("Chameleon", R.drawable.chameleon),
                new TabsWizardModel("Moo Moo", R.drawable.moomoo),
                new TabsWizardModel("Highlander", R.drawable.highlander),
                new TabsWizardModel("Bear Tracks", R.drawable.beartracks),
        };
        mAdapter = new TabWizardAdapter(dininghall_data);
        // 2. set layoutManger
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        // 4. set adapter
        recyclerView.setAdapter(mAdapter);
        // 5. set item animator to DefaultAnimator
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(this, recyclerView, new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                int firstChoice = position;
                solutions(firstChoice);
            }

            @Override
            public void onItemLongClick(View view, int position) {
                // ...
            }
        }));

    }
    public void solutions(int firstChoice){
        Intent i = new Intent(DinningHallActivity.this, WebViewActivity.class);

        if (firstChoice == 0){
            i.putExtra("Path", "file:///android_asset/ai.html");
            i.putExtra("Title", "AI");
        }
        else if (firstChoice == 1){
            i.putExtra("Path", "file:///android_asset/lothian.html");
            i.putExtra("Title","Lothian");
        }
        else if (firstChoice == 2){
            i.putExtra("Path", "file:///android_asset/spinelli.html");
            i.putExtra("Title","Spinelli's");
        }
        else if (firstChoice == 3){
            i.putExtra("Path", "file:///android_asset/gmshop.html");
            i.putExtra("Title","Glen Mor Shop");
        }
        else if (firstChoice == 4){
            i.putExtra("Path", "file:///android_asset/gmsizzle.html");
            i.putExtra("Title","Glen Mor Sizzle");
        }
        else if (firstChoice == 5){
            i.putExtra("Path", "file:///android_asset/gmsavor.html");
            i.putExtra("Title","Glen Mor Savor");
        }
        else if (firstChoice == 6){
            i.putExtra("Path", "file:///android_asset/gmstarbucks.html");
            i.putExtra("Title","Glen Mor Starbucks");
        }
        else if (firstChoice == 7){
            i.putExtra("Path", "file:///android_asset/hubscot.html");
            i.putExtra("Title","HUB Scotty's");
        }
        else if (firstChoice == 8){
            i.putExtra("Path", "file:///android_asset/aiscot.html");
            i.putExtra("Title","AI Scotty's");
        }
        else if (firstChoice == 9){
            i.putExtra("Path", "file:///android_asset/lothianscot.html");
            i.putExtra("Title","Lothian Scotty's");
        }
        else if (firstChoice == 10){
            i.putExtra("Path", "file:///android_asset/gmscot.html");
            i.putExtra("Title","Glen Mor Scotty's");
        }
        else if (firstChoice == 11){
            i.putExtra("Path", "file:///android_asset/medscot.html");
            i.putExtra("Title","Medicine Scotty's");
        }
        else if (firstChoice == 12){
            i.putExtra("Path", "file:///android_asset/barn.html");
            i.putExtra("Title","The Barn");
        }
        else if (firstChoice == 13){
            i.putExtra("Path", "file:///android_asset/bytes.html");
            i.putExtra("Title","Bytes");
        }
        else if (firstChoice == 14){
            i.putExtra("Path", "file:///android_asset/ivan.html");
            i.putExtra("Title","Ivans");
        }
        else if (firstChoice == 15){
            i.putExtra("Path", "file:///android_asset/subway.html");
            i.putExtra("Title","Subway");
        }
        else if (firstChoice == 16){
            i.putExtra("Path", "file:///android_asset/habanero.html");
            i.putExtra("Title","Habanero");
        }
        else if (firstChoice == 17){
            i.putExtra("Path", "file:///android_asset/hub.html");
            i.putExtra("Title","HUB2GO");
        }
        else if (firstChoice == 18){
            i.putExtra("Path", "file:///android_asset/panda.html");
            i.putExtra("Title","Panda Express");
        }
        else if (firstChoice == 19){
            i.putExtra("Path", "file:///android_asset/pandasushi.html");
            i.putExtra("Title","Panda Sushi");
        }
        else if (firstChoice == 20){
            i.putExtra("Path", "file:///android_asset/fiamma.html");
            i.putExtra("Title","La Fiamma");
        }
        else if (firstChoice == 21){
            i.putExtra("Path", "file:///android_asset/grill.html");
            i.putExtra("Title","The Grill");
        }
        else if (firstChoice == 22){
            i.putExtra("Path", "file:///android_asset/coffeebean.html");
            i.putExtra("Title","Coffee Bean");
        }
        else if (firstChoice == 23){
            i.putExtra("Path", "file:///android_asset/chameleon.html");
            i.putExtra("Title","Chameleon");
        }
        else if (firstChoice == 24){
            i.putExtra("Path", "file:///android_asset/moomoo.html");
            i.putExtra("Title","MooMoo");
        }
        else if (firstChoice == 25){
            i.putExtra("Path", "file:///android_asset/highlander.html");
            i.putExtra("Title","Highlander");
        }
        else if (firstChoice == 26){
            i.putExtra("Path", "file:///android_asset/beartracks.html");
            i.putExtra("Title","Bear Tracks");
        }
        startActivity(i);
    }
    private void back(){
        Intent intent = new Intent(DinningHallActivity.this, AccountActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
        finish();
    }
}
