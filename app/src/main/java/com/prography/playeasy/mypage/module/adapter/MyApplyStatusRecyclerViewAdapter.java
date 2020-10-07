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
import com.prography.playeasy.match.activity.MatchModify;
import com.prography.playeasy.match.domain.MatchDao;
import com.prography.playeasy.match.util.DataHelper;
import com.prography.playeasy.mypage.activity.MatchDetailConfirm;
import com.prography.playeasy.mypage.domain.models.MyApplyStatusApplication;

import java.util.ArrayList;

public class MyApplyStatusRecyclerViewAdapter extends RecyclerView.Adapter<MyApplyStatusRecyclerViewAdapter.MyViewHolder> {

        private ArrayList<MyApplyStatusApplication> myMatchApplyArrayList =new ArrayList<MyApplyStatusApplication>();
        MatchDao matchDao;
        int matchId;
        String status;
        final static int REQUEST_CODE=2;
        String tempApplyStatus;


        public MyApplyStatusRecyclerViewAdapter(MatchDao matchDao) {


            this.matchDao = matchDao;
        }

        @NonNull
        @Override
        public MyApplyStatusRecyclerViewAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.mypage_myapplystatus_item, parent, false);
            return new MyApplyStatusRecyclerViewAdapter.MyViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull MyApplyStatusRecyclerViewAdapter.MyViewHolder holder, int position) {

            holder.onBind(myMatchApplyArrayList.get(position), position);
        }

        public void setItems(ArrayList<MyApplyStatusApplication> list) {
            myMatchApplyArrayList = list;
            notifyDataSetChanged();
        }

        @Override
        public int getItemCount() {

            return myMatchApplyArrayList.size();
        }


        public class MyViewHolder extends RecyclerView.ViewHolder {


            private TextView applyMatchTitle;
            private TextView applyMatchDay;
            private TextView applyMatchTime;
            private TextView applyStatus;

//            private MaterialButton registerDetailApply;
            private MaterialButton applyWithdrawal;


            public MyViewHolder(@NonNull View itemView) {
                super(itemView);
                applyMatchTitle = itemView.findViewById(R.id.applyMatchTitle);
                applyMatchDay = itemView.findViewById(R.id.applyMatchDay);
                applyMatchTime = itemView.findViewById(R.id.applyMatchTime);
                //매치 상태가 아닌 용병 지원의상태를 나타내는 변수
                applyStatus=itemView.findViewById(R.id.applyStatus);
//                registerWhere = itemView.findViewById(R.id.registerWhere);
//                registerPresentPeople = itemView.findViewById(R.id.applyPresentPeople);
//                applyStatus = itemView.findViewById(R.id.applyStatus);
//                //registerDetailApply = itemView.findViewById(R.id.registerDetailApply);
//                applyWithdrawal = itemView.findViewById(R.id.applyWithdrawal);

            }


            public void onBind(MyApplyStatusApplication myApplyStatusApplication, int position) {
//            registerMatchTitle.setText(myApplyStatusApplication.getLocation().getDetail());
               applyMatchDay.setText(DataHelper.transformDateToString(myApplyStatusApplication.getMatch().getStartAt()));
               applyMatchTime.setText(DataHelper.makeEndTime(myApplyStatusApplication.getMatch().getStartAt(), myApplyStatusApplication.getMatch().getDuration()));
               if(myApplyStatusApplication.getStatus()=="WAITING") {
                   tempApplyStatus = "승인 대기 중";
               }else if (myApplyStatusApplication.getStatus()=="CONFIRMED")
               {
                    tempApplyStatus="승인";
               }
                applyStatus.setText(tempApplyStatus);

//            myMatchVO.getStartAt().split("T")[1].substring(0,2)+
//                    DataHelper.makeEndTime(myMatchVO.getStartAt(),myMatchVO.getDuration())
                itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
//                        Intent intent = new Intent(v.getContext(), MatchDetailConfirm.class);
//
//                        matchId = myApplyStatusApplication.getMatch().getId();
//
//                        intent.putExtra("match_id",matchId);
//                        itemView.getContext().startActivity(intent);
                            Log.d("매치 id", String.valueOf(matchId));
                    }
                });






            }



        }
}
