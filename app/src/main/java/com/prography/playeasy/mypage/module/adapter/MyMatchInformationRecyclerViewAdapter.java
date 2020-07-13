package com.prography.playeasy.mypage.module.adapter;

import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.button.MaterialButton;
import com.prography.playeasy.R;
import com.prography.playeasy.main.activity.Main;
import com.prography.playeasy.mypage.domain.MyMatchVO;
import com.prography.playeasy.team.activity.TeamApplyCurrentStatus;

import java.util.ArrayList;

public class MyMatchInformationRecyclerViewAdapter extends RecyclerView.Adapter<MyMatchInformationRecyclerViewAdapter.MyViewHolder>{

    private ArrayList<MyMatchVO> myMatchRegisterArrayList = new ArrayList<>();


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.mypage_mymatchinformation_item,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.onBind(myMatchRegisterArrayList.get(position), position);
    }

    @Override
    public int getItemCount() {
        return myMatchRegisterArrayList.size();
    }

    public void addItems(ArrayList<MyMatchVO> Data) {
        myMatchRegisterArrayList = Data;
        notifyDataSetChanged();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView registerMatchTitle;
        private TextView registerMatchDay;
        private TextView registerMatchTime;
        private TextView registerWhere;
        private TextView registerPresentPeople;
        private TextView registerStatus;
        private MaterialButton registerDetailApply;
        private MaterialButton registerFinish;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            registerMatchTitle = itemView.findViewById(R.id.registerMatchTitle);
            registerMatchDay = itemView.findViewById(R.id.registerMatchDay);
            registerMatchTime = itemView.findViewById(R.id.registerMatchTime);
            registerWhere = itemView.findViewById(R.id.registerWhere);
            registerPresentPeople = itemView.findViewById(R.id.registerPresentPeople);
            registerStatus = itemView.findViewById(R.id.registerStatus);

            registerDetailApply = itemView.findViewById(R.id.registerDetailApply);
            registerFinish = itemView.findViewById(R.id.registerFinish);

        }

        public void onBind(MyMatchVO myMatchVO, int position) {
            registerDetailApply.setOnClickListener((v) -> {
                v.getContext().startActivity(new Intent(v.getContext(), TeamApplyCurrentStatus.class));
            });
        }
    }
}
