package com.prography.playeasy.push.module.view.adapter;

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

import java.util.ArrayList;

public class PushRecyclerViewAdapter extends RecyclerView.Adapter<PushRecyclerViewAdapter.MyViewHolder> {

    private ArrayList<MyMatchVO> myMatchRegisterArrayList = new ArrayList<>();


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.mypage_mymatchinformation_item, parent, false);
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

        private TextView myMatchNameTv;
        private TextView myMatchLocationTv;
        private TextView myMatchMemberTv;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

        }

        public void onBind(MyMatchVO myMatchVO, int position) {




        }
    }
}
