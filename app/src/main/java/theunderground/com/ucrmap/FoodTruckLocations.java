package theunderground.com.ucrmap;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;


/**
 * Created by Sara on 5/19/16.
 */
public class FoodTruckLocations extends Activity{
    private ImageButton mBackButton = null;
    private TextView mTitle = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dinning_hall_activity_layout);
        RecyclerView recyclerView = (RecyclerView) this.findViewById(R.id.recyclerViewTab);
        TabWizardAdapter mAdapter;
        mTitle = (TextView)findViewById(R.id.diningTitle);
        mTitle.setText("Food Truck Locations");
        mBackButton = (ImageButton)findViewById(R.id.backButton);
        mBackButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                back();
            }
        });

        TabsWizardModel dininghall_data[] = {new TabsWizardModel("Chameleon", R.drawable.chameleon),
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
        Intent i = new Intent(FoodTruckLocations.this, WebViewActivity.class);

        if (firstChoice == 0){
            i.putExtra("Path", "http://vcsaweb.ucr.edu/foodtruck-location/Home/GoogleMap?truckName=CulinaryChameleon");
            i.putExtra("Title", "Chameleon");
        }
        else if (firstChoice == 1){
            i.putExtra("Path", "http://vcsaweb.ucr.edu/foodtruck-location/Home/GoogleMap?truckName=moomoo");
            i.putExtra("Title","MooMoo");
        }
        else if (firstChoice == 2){
            i.putExtra("Path", "http://vcsaweb.ucr.edu/foodtruck-location/Home/GoogleMap?truckName=tartan");
            i.putExtra("Title","Tartan");
        }
        else if (firstChoice == 3){
            i.putExtra("Path", "http://vcsaweb.ucr.edu/foodtruck-location/Home/GoogleMap?truckName=BearTracks");
            i.putExtra("Title","Bear Tracks");
        }
        startActivity(i);
    }
    private void back(){
        Intent intent = new Intent(FoodTruckLocations.this, AccountActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
        finish();
    }

}
