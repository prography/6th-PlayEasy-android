package com.prography.playeasy.team.module.view.adpater;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.button.MaterialButton;
import com.prography.playeasy.R;
import com.prography.playeasy.team.domain.Team;

import java.util.ArrayList;

public class SelectRecyclerViewAdapter extends RecyclerView.Adapter<SelectRecyclerViewAdapter.MyViewHolder> {

    private ArrayList<Team> teamArrayList = new ArrayList<>();

    @NonNull
    @Override
    public SelectRecyclerViewAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.team_select_item, parent, false);
        return new SelectRecyclerViewAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SelectRecyclerViewAdapter.MyViewHolder holder, int position) {
        holder.onBind(teamArrayList.get(position), position);
    }

    @Override
    public int getItemCount() {

        return teamArrayList.size();
    }

    public void addItems(Team data){
        teamArrayList.add(data);
        notifyDataSetChanged();
    }



    public class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView selectTeamName;
        private TextView selectTeamLeader;
        private MaterialButton selectTeamButton;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            selectTeamName = itemView.findViewById(R.id.selectTeamName);
            selectTeamLeader = itemView.findViewById(R.id.selectTeamLeader);
            selectTeamButton = itemView.findViewById(R.id.selectTeamButton);

        }

        public void onBind(Team team, int position) {

            selectTeamName.setText(team.name());
            selectTeamLeader.setText(team.leader());


        }
    }
}
