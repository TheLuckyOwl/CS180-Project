package theunderground.com.ucrmap;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by Sara on 5/19/16.
 */
public class ServiceHours extends Activity{
    String[] serviceArray = {"Orbach Library","Rivera Library","Student Services", "Bookstore","SRC","Botanical Gardens"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.service_hours_layout);

        ArrayAdapter adapter = new ArrayAdapter<String>(this, R.layout.hours_list_item_layout, serviceArray);

        ListView listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(adapter);
    }
}
