package com.prography.playeasy.match.module.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.prography.playeasy.R;
import com.prography.playeasy.match.domain.Match;

import java.util.ArrayList;
import java.util.List;


public class MatchRecyclerAdapter extends RecyclerView.Adapter<MatchRecyclerAdapter.MyViewHolder>{
    private List<Match> matchList = new ArrayList<>();

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.match_activity_cardview,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.onBind(matchList.get(position));
    }

    @Override
    public int getItemCount() {
        return matchList.size();
    }

    public void addItems(Match match) {
        matchList.add(match);
        notifyDataSetChanged();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView title;
        private TextView type;
        private TextView description;
        private TextView location;
        private TextView fee;
        private TextView startAt;
        private TextView endAt;
        private TextView homeQuota;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.matchTitle);
            type = itemView.findViewById(R.id.matchType);
            description = itemView.findViewById(R.id.matchDescription);
            location = itemView.findViewById(R.id.matchLocation);
            fee = itemView.findViewById(R.id.matchFee);
            startAt = itemView.findViewById(R.id.matchStartAt);
            endAt = itemView.findViewById(R.id.matchEndAt);
            homeQuota = itemView.findViewById(R.id.matchHomeQuota);
        }

        public void onBind(Match match) {
            title.setText(match.getTitle());
            type.setText(match.getType());
            description.setText(match.getDescription());
            location.setText(match.getLocation());
            fee.setText(String.valueOf(match.getFee()));
            startAt.setText(match.getStartAt().toString());
            endAt.setText(match.getEndAt().toString());
            homeQuota.setText(String.valueOf(match.getHomeQuota()));
        }
    }
}
