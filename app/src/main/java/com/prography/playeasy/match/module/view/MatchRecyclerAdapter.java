package com.prography.playeasy.match.module.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.prography.playeasy.R;
import com.prography.playeasy.match.domain.MatchResponseVO;

import java.util.ArrayList;
import java.util.List;


public class MatchRecyclerAdapter extends RecyclerView.Adapter<MatchRecyclerAdapter.MyViewHolder>{
    private List<MatchResponseVO> matchResponse = new ArrayList<>();

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.match_activity_cardview,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.onBind(matchResponse.get(position));
    }

    @Override
    public int getItemCount() {
        return matchResponse.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView Title;
        private TextView Type;
        private TextView description;
        private TextView location;
        private TextView fee;
        private TextView startAt;
        private TextView endAt;
        private TextView homeQuota;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            Title = itemView.findViewById(R.id.matchTitle);
            Type = itemView.findViewById(R.id.matchType);
            description = itemView.findViewById(R.id.matchDescription);
            location = itemView.findViewById(R.id.matchLocation);
            fee = itemView.findViewById(R.id.matchFee);
            startAt = itemView.findViewById(R.id.matchStartAt);
            endAt = itemView.findViewById(R.id.matchEndAt);
            homeQuota = itemView.findViewById(R.id.matchHomeQuota);
        }

        public void onBind(MatchResponseVO matchResponseVO) {

        }
    }
}
