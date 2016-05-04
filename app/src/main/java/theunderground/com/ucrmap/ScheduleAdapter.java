package theunderground.com.ucrmap;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Dharti on 5/2/2016.
 */
public class ScheduleAdapter extends RecyclerView.Adapter<ScheduleAdapter.ViewHolder> {
    private ScheduleModel[] itemsData;

    public ScheduleAdapter(ScheduleModel[] itemsData) {
        this.itemsData = itemsData;
    }

    // Create new views (invoked by the layout manager)

    @Override
    public ScheduleAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                          int viewType) {
        // create a new view
        View itemLayoutView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.schedule_display_items, null);

        // create ViewHolder

        ViewHolder viewHolder = new ViewHolder(itemLayoutView);

        return viewHolder;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {

        // - get data from your itemsData at this position
        // - replace the contents of the view with that itemsData
        viewHolder.txtViewClass.setText(itemsData[position].getTitle());
        viewHolder.txtViewTime.setText(itemsData[position].getTimes());
        viewHolder.txtViewDay.setText(itemsData[position].getdays());
    }

    // inner class to hold a reference to each item of RecyclerView
    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView txtViewClass;
        public TextView txtViewDay;
        public TextView txtViewTime;

        public ViewHolder(View itemLayoutView) {
            super(itemLayoutView);
            txtViewClass = (TextView) itemLayoutView.findViewById(R.id.classs);
            txtViewDay = (TextView) itemLayoutView.findViewById(R.id.day);
            txtViewTime = (TextView) itemLayoutView.findViewById(R.id.time);
        }
    }


    // Return the size of your itemsData (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return itemsData.length;
    }
}


