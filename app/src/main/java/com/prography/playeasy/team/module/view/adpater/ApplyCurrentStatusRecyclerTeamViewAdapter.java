package com.prography.playeasy.team.module.view.adpater;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.prography.playeasy.R;
import com.prography.playeasy.mypage.domain.MyMatchVO;

import java.util.ArrayList;

public class TeamApplyCurrentStuatusRecyclcerViewAdapter extends RecyclerView.Adapter<TeamApplyCurrentStuatusRecyclcerViewAdapter.MyViewHolder> {

    private ArrayList<MyMatchVO> applyCurrentStautsList = new ArrayList<>();

    @NonNull
    @Override
    public TeamApplyCurrentStuatusRecyclcerViewAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.mypage_mymatchinformation_item,parent,false);
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull TeamApplyCurrentStuatusRecyclcerViewAdapter.MyViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
