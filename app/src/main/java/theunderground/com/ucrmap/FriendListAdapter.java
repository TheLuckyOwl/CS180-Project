package theunderground.com.ucrmap;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Roger on 5/26/2016.
 */
public class FriendListAdapter extends RecyclerView.Adapter<FriendListAdapter.ViewHolder> {
    private FriendListModel[] itemsData;

    public FriendListAdapter(FriendListModel[] itemsData)
    {
        this.itemsData = itemsData;
    }

    @Override
    public  FriendListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemLayoutView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.friend_list_items, null);

        ViewHolder viewHolder = new ViewHolder(itemLayoutView);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {
        viewHolder.txtViewFirst.setText(itemsData[position].getFirst());
        viewHolder.txtViewInitial.setText(itemsData[position].getInitial());
        viewHolder.txtViewLast.setText(itemsData[position].getLast());

    }

    public static class ViewHolder extends RecyclerView.ViewHolder
    {
        public TextView txtViewFirst;
        public TextView txtViewInitial;
        public TextView txtViewLast;

        public ViewHolder(View itemLayoutView)
        {
            super(itemLayoutView);
            txtViewFirst = (TextView) itemLayoutView.findViewById(R.id.tvFirstitem);
            txtViewInitial = (TextView) itemLayoutView.findViewById(R.id.tvInitialitem);
            txtViewLast = (TextView) itemLayoutView.findViewById(R.id.tvLastitem);
        }
    }

    @Override
    public int getItemCount() {
        return itemsData.length;
    }
}


