package com.prography.playeasy.team.module.view.adpater;

import android.content.Intent;
import android.renderscript.Sampler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.button.MaterialButton;
import com.kakao.network.ErrorResult;
import com.kakao.network.callback.ResponseCallback;
import com.prography.playeasy.R;

import com.prography.playeasy.mypage.activity.MyInformation;
import com.prography.playeasy.team.domain.Team;
import com.prography.playeasy.team.service.TeamService;
import com.prography.playeasy.util.PlayeasyServiceFactory;

import java.util.ArrayList;

import static com.prography.playeasy.login.activity.LoginActivity.myTeamId;

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
        private TextView selectTeamId;
        private MaterialButton selectTeamButton;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);


            selectTeamName = itemView.findViewById(R.id.selectTeamName);
            selectTeamLeader = itemView.findViewById(R.id.selectTeamLeader);
            selectTeamButton = itemView.findViewById(R.id.selectTeamButton);
            selectTeamId = itemView.findViewById(R.id.teamSelectId);
        }

        public void onBind(Team team, int position) {

            selectTeamName.setText(team.name());
            selectTeamLeader.setText(team.leader());
            selectTeamId.setText(String.valueOf(team.id().toString()));

            selectTeamButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    myTeamId = Integer.parseInt(selectTeamId.getText().toString());
                    System.out.println("팀 아이디" + myTeamId);

                    TeamService service = PlayeasyServiceFactory.getInstance(TeamService.class);
                    service.selectTeam(myTeamId, new ResponseCallback() {
                        @Override
                        public void onFailure(ErrorResult errorResult) {

                        }

                        @Override
                        public void onSuccess(Object result) {
                            Intent intent = new Intent(itemView.getContext(), MyInformation.class);
                            v.getContext().startActivity(intent);
                        }
                    }, itemView.getContext());
                }
            });



            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }

            });

        }
    }
}
