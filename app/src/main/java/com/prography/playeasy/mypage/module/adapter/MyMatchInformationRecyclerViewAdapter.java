package com.prography.playeasy.mypage.module.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.button.MaterialButton;
import com.prography.playeasy.R;
import com.prography.playeasy.mypage.domain.MyMatchVO;

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

        private TextView RegisterMatchTitle;
        private TextView RegisterMatchDay;
        private TextView RegisterMatchTime;
        private TextView RegisterWhere;
        private TextView RegisterPresentPeople;
        private TextView RegisterStatus;
        private MaterialButton RegisterDetailApply;
        private MaterialButton RegisterFinish;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            RegisterMatchTitle = itemView.findViewById(R.id.RegisterMatchTitle);
            RegisterMatchDay = itemView.findViewById(R.id.RegisterMatchDay);
            RegisterMatchTime = itemView.findViewById(R.id.RegisterMatchTime);
            RegisterWhere = itemView.findViewById(R.id.RegisterWhere);
            RegisterPresentPeople = itemView.findViewById(R.id.RegisterMatchTime);
            RegisterStatus = itemView.findViewById(R.id.RegisterWhere);

            RegisterDetailApply = itemView.findViewById(R.id.RegisterDetailApply);
            RegisterFinish = itemView.findViewById(R.id.RegisterFinish);

        }

        public void onBind(MyMatchVO myMatchVO, int position) {


        }
    }
}
