package it.uniupo.sportapp.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import it.uniupo.sportapp.R;
import it.uniupo.sportapp.models.Season;

/**
 * Created by 20010562 on 11/3/17.
 */

public class SeasonsAdapter extends RecyclerView.Adapter<SeasonsAdapter.ViewHolder> {

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView nameTv, startTv;

        public ViewHolder(View itemView) {
            super(itemView);
            nameTv = itemView.findViewById(R.id.season_name_tv);
            startTv = itemView.findViewById(R.id.season_date);
        }
    }


    private List<Season> mSeasons;
    private Context mContext;

    public SeasonsAdapter(List<Season> mSeasons, Context mContext) {
        this.mSeasons = mSeasons;
        this.mContext = mContext;
    }

    private Context getContext() {
        return mContext;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View roomsView = inflater.inflate(R.layout.season_row, parent, false);
        return new ViewHolder(roomsView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Season tempSeason = mSeasons.get(position);

        TextView nameTextView = holder.nameTv;
        nameTextView.setText(tempSeason.getSeasonName());
        TextView playersTextView = holder.startTv;
        playersTextView.setText(tempSeason.getSeasonBeginningDate());
    }

    @Override
    public int getItemCount() {
        return mSeasons.size();
    }
}