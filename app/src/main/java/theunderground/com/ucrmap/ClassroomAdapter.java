package theunderground.com.ucrmap;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Roger on 5/26/2016.
 */
public class ClassroomAdapter extends RecyclerView.Adapter<ClassroomAdapter.ViewHolder> {
    private ClassroomModel[] itemsData;

    public ClassroomAdapter(ClassroomModel[] itemData) { this.itemsData = itemData; }

    @Override
    public ClassroomAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemLayoutView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.classroom_list_items, null);

        ViewHolder viewHolder = new ViewHolder(itemLayoutView);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {
        viewHolder.txtViewComment.setText(itemsData[position].getComment());
    }

    public static class ViewHolder extends RecyclerView.ViewHolder
    {
        public TextView txtViewComment;

        public ViewHolder(View itemLayoutView)
        {
            super(itemLayoutView);
            txtViewComment = (TextView) itemLayoutView.findViewById(R.id.tvComment);
        }
    }
    @Override
    public int getItemCount() {
        return 1;
    }


}
