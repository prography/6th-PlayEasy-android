package com.prography.playeasy.team.module.view.adpater;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.prography.playeasy.R;
import com.prography.playeasy.mypage.domain.MyMatchVO;

import java.util.ArrayList;

public class ApplyCurrentStatusRecyclerTeamViewAdapter extends RecyclerView.Adapter<ApplyCurrentStatusRecyclerTeamViewAdapter.MyViewHolder> {

    private ArrayList<MyMatchVO> applyCurrentStatusList = new ArrayList<>();
    TextView applyMatchDate;
    TextView applyMatchTime;

    TextView applyStatus;

    @NonNull
    @Override
    public ApplyCurrentStatusRecyclerTeamViewAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.mypage_myapplystatus_item,parent,false);
        return new ApplyCurrentStatusRecyclerTeamViewAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ApplyCurrentStatusRecyclerTeamViewAdapter.MyViewHolder holder, int position) {
        holder.onBind(applyCurrentStatusList.get(position), position);
    }


    @Override
    public int getItemCount() {

        return applyCurrentStatusList.size();
    }

    public void addItems(ArrayList<MyMatchVO> Data) {
        applyCurrentStatusList = Data;
        notifyDataSetChanged();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            applyMatchDate=itemView.findViewById(R.id.applyMatchDay);
            applyMatchTime=itemView.findViewById(R.id.applyMatchTime);
        }

        public void onBind(MyMatchVO myMatchVO, int position) {
            applyMatchDate.setText(myMatchVO.)

        }
    }
}
