package com.prography.playeasy.team.module.view.adpater;

import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

import com.google.android.material.button.MaterialButton;
import de.hdodenhof.circleimageview.CircleImageView;

import com.prography.playeasy.R;
import com.prography.playeasy.mypage.domain.models.MyMatchTeamApplyStatus;
import com.prography.playeasy.team.service.TeamApplyService;


public class ApplyCurrentStatusRecyclerTeamViewAdapter extends RecyclerView.Adapter<ApplyCurrentStatusRecyclerTeamViewAdapter.MyViewHolder> {

    private ArrayList<MyMatchTeamApplyStatus> applyCurrentStatusList = new ArrayList<>();
    private TeamApplyService teamApplyService;

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.team_applycurrentstatus_item,parent,false);
//        return new ApplyCurrentStatusRecyclerTeamViewAdapter.MyViewHolder(view);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.onBind(applyCurrentStatusList.get(position), position);
    }

    @Override
    public int getItemCount() {
        return applyCurrentStatusList.size();
    }

    public void setItems(ArrayList<MyMatchTeamApplyStatus> Data) {
        applyCurrentStatusList = Data;
        this.notifyDataSetChanged();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView name;
        private TextView quota;
        private TextView level;
        private MaterialButton admit;
        private MaterialButton reject;
        private CircleImageView applyCurrentStatusImageView;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            quota = itemView.findViewById(R.id.quota);
            level = itemView.findViewById(R.id.level);
            admit = itemView.findViewById(R.id.admit);
            reject = itemView.findViewById(R.id.reject);
            applyCurrentStatusImageView = itemView.findViewById(R.id.applyCurrentStatusImageView);
        }

        public void onBind(MyMatchTeamApplyStatus myMatchVOTeamApplyStatus, int position) {
            name.setText(myMatchVOTeamApplyStatus.getName());
            quota.setText(Integer.toString(myMatchVOTeamApplyStatus.getQuota()));
            level.setText(Integer.toString(myMatchVOTeamApplyStatus.getLevel()));

            admit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
//                    int matchId = myMatchVO.getId();
//                    Log.d("매치 id",String.valueOf(matchId));
//                    tvMatchId.setText(Integer.toString(matchId));
//                    Intent intent = new Intent(v.getContext(), MatchDetail.class);
//                    intent.putExtra("match_id", matchId);
//                    v.getContext().startActivity(intent);
                }
            });

            reject.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
//                    int matchId = myMatchVO.getId();
//                    Log.d("매치 id",String.valueOf(matchId));
//                    tvMatchId.setText(Integer.toString(matchId));
//                    Intent intent = new Intent(v.getContext(), MatchDetail.class);
//                    intent.putExtra("match_id", matchId);
//                    v.getContext().startActivity(intent);
                }
            });
        }
    }
}
