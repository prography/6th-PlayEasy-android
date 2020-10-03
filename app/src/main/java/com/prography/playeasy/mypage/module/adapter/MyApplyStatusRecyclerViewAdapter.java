package com.prography.playeasy.mypage.module.adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.button.MaterialButton;
import com.prography.playeasy.R;
import com.prography.playeasy.match.activity.MatchModify;
import com.prography.playeasy.match.domain.MatchDao;
import com.prography.playeasy.match.util.DataHelper;
import com.prography.playeasy.mypage.activity.MatchDetailConfirm;
import com.prography.playeasy.mypage.domain.models.MyApplyStatusApplication;

import java.util.ArrayList;

public class MyApplyStatusRecyclerViewAdapter extends RecyclerView.Adapter<MyApplyStatusRecyclerViewAdapter.MyViewHolder> {

        private ArrayList<MyApplyStatusApplication> myMatchApplyArrayList = new ArrayList<>();
        MatchDao matchDao;
        int matchId;
        String status;
        final static int REQUEST_CODE=2;


        public MyApplyStatusRecyclerViewAdapter(MatchDao matchDao) {


            this.matchDao = matchDao;
        }

        @NonNull
        @Override
        public MyApplyStatusRecyclerViewAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.mypage_mymatchinformation_item, parent, false);
            return new MyApplyStatusRecyclerViewAdapter.MyViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull MyApplyStatusRecyclerViewAdapter.MyViewHolder holder, int position) {

            holder.onBind(myMatchApplyArrayList.get(position), position);
        }

        public void setItems(ArrayList<MyApplyStatusApplication> list) {
            myMatchApplyArrayList = list;
            this.notifyDataSetChanged();
        }

        @Override
        public int getItemCount() {

            return myMatchApplyArrayList.size();
        }


        public class MyViewHolder extends RecyclerView.ViewHolder {

            private TextView registerMatchTitle;
            private TextView registerMatchDay;
            private TextView registerMatchTime;
            private TextView registerWhere;
            private TextView registerPresentPeople;
            private TextView applyStatus;
//            private MaterialButton registerDetailApply;
            private MaterialButton applyWithdrawal;


            public MyViewHolder(@NonNull View itemView) {
                super(itemView);
                registerMatchTitle = itemView.findViewById(R.id.registerMatchTitle);
                registerMatchDay = itemView.findViewById(R.id.registerMatchDay);
                registerMatchTime = itemView.findViewById(R.id.registerMatchTime);
                registerWhere = itemView.findViewById(R.id.registerWhere);
                registerPresentPeople = itemView.findViewById(R.id.applyPresentPeople);
                applyStatus = itemView.findViewById(R.id.applyStatus);
                //registerDetailApply = itemView.findViewById(R.id.registerDetailApply);
                applyWithdrawal = itemView.findViewById(R.id.applyWithdrawal);

            }


            public void onBind(MyApplyStatusApplication myMatchVO, int position) {
//            registerMatchTitle.setText(myMatchVO.getLocation().getDetail());
                registerMatchDay.setText(DataHelper.transformDateToString(myMatchVO.getMatch().getStartAt()));
                registerMatchTime.setText(DataHelper.makeEndTime(myMatchVO.getMatch().getStartAt(), myMatchVO.getMatch().getDuration()));
//            myMatchVO.getStartAt().split("T")[1].substring(0,2)+
//                    DataHelper.makeEndTime(myMatchVO.getStartAt(),myMatchVO.getDuration())
                itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(itemView.getContext(), MatchDetailConfirm.class);
                        itemView.getContext().startActivity(intent);
                    }
                });






            }
        }
}
