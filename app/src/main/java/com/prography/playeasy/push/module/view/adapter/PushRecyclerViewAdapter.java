package com.prography.playeasy.push.module.view.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.prography.playeasy.R;
import com.prography.playeasy.mypage.domain.MyMatchVO;

import java.util.ArrayList;

public class PushRecyclerViewAdapter extends RecyclerView.Adapter<PushRecyclerViewAdapter.MyViewHolder>{

    private ArrayList<MyMatchVO> myMatchRegisterArrayList = new ArrayList<>();


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.mypage_mymatch_item,parent,false);
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

            myMatchNameTv = itemView.findViewById(R.id.myMatchMemberTv);
            myMatchLocationTv = itemView.findViewById(R.id.myMatchLocationTv);
            myMatchMemberTv = itemView.findViewById(R.id.myMatchMemberTv);

        }

        public void onBind(MyMatchVO myMatchVO, int position) {

            myMatchNameTv.setText(myMatchRegisterArrayList.get(position).getMyMatchName());
            myMatchLocationTv.setText(myMatchRegisterArrayList.get(position).getMyMatchLocation());
            myMatchMemberTv.setText("" + myMatchRegisterArrayList.get(position).getMyMatchPeople());
        }
    }
}
