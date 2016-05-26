package theunderground.com.ucrmap;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Larry Parsons on 6/27/2015.
 */
 public class TabServiceAdapter extends RecyclerView.Adapter<TabServiceAdapter.ViewHolder> {
        private TabsServiceModel[] itemsData;

        public TabServiceAdapter(TabsServiceModel[] itemsData) {
            this.itemsData = itemsData;
        }

        // Create new views (invoked by the layout manager)
        @Override
        public TabServiceAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                          int viewType) {
            // create a new view
            View itemLayoutView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.tabs_wizard_list_items, null);

            // create ViewHolder

            ViewHolder viewHolder = new ViewHolder(itemLayoutView);
            return viewHolder;
        }

        // Replace the contents of a view (invoked by the layout manager)
        @Override
        public void onBindViewHolder(ViewHolder viewHolder, int position) {

            // - get data from your itemsData at this position
            // - replace the contents of the view with that itemsData
            viewHolder.txtViewTitle.setText(itemsData[position].getTitle());
            viewHolder.txtViewDescription.setText(itemsData[position].getDescription());
        }

        // inner class to hold a reference to each item of RecyclerView
        public static class ViewHolder extends RecyclerView.ViewHolder {

            public TextView txtViewTitle;
            public TextView txtViewDescription;
            public ViewHolder(View itemLayoutView) {
                super(itemLayoutView);
                txtViewTitle = (TextView) itemLayoutView.findViewById(R.id.tabTitle);
                txtViewDescription = (TextView) itemLayoutView.findViewById(R.id.descriptionText);
            }
        }


        // Return the size of your itemsData (invoked by the layout manager)
        @Override
        public int getItemCount() {
            return itemsData.length;
        }
    }

