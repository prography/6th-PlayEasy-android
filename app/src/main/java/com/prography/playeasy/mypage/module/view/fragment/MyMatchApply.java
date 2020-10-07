package com.prography.playeasy.mypage.module.view.fragment;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.prography.playeasy.R;
import com.prography.playeasy.lib.TokenManager;
import com.prography.playeasy.match.domain.MatchDao;
import com.prography.playeasy.mypage.domain.dtos.MyMatchApplyStatusResponseDto;
import com.prography.playeasy.mypage.domain.dtos.register.MyMatchRegisterResponseDto;
import com.prography.playeasy.mypage.domain.models.MyApplyStatusApplication;
import com.prography.playeasy.mypage.module.adapter.MyApplyStatusRecyclerViewAdapter;
import com.prography.playeasy.mypage.module.adapter.MyMatchInformationRecyclerViewAdapter;
import com.prography.playeasy.mypage.service.MyMatchService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MyMatchApply extends Fragment {
    //팀 지원과 용병 지원 분기 처리

    ArrayList<MyApplyStatusApplication> myMatchApplyList;
    MyMatchService myMatchService;
    Context context;
    Spinner checkTeamSolo;
    String type = "team";
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    MyApplyStatusRecyclerViewAdapter myApplyStatusRecyclerViewAdapter;
    ViewGroup rootView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = (ViewGroup) inflater.inflate(R.layout.fragment_mypage_mymatchinformation_apply, container, false);
        context=container.getContext();

        initialize();
        fetchMyMatchApplyList(type);

        checkTeamSolo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                int pos = position;

                if(pos == 0){
                    type = "team";
                }else if(pos == 1 ) {
                    type = "personal";
                }
                Log.d("신청 타입",type);
                fetchMyMatchApplyList(type);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Toast.makeText(getContext(), "지원 현황 볼 방식을 선택해주세요", Toast.LENGTH_SHORT).show();
            }

        });

        return rootView;
    }

    private void initialize() {
        checkTeamSolo = rootView.findViewById(R.id.checkTeamSolo);
        recyclerView = rootView.findViewById(R.id.myMatchApplyRecyclerView);
        layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);


        myApplyStatusRecyclerViewAdapter = new MyApplyStatusRecyclerViewAdapter(new MatchDao(TokenManager.get(context)));
//        fetchMyMatchApplyList(type);

        //   recyclerView.setAdapter(myApplyStatusRecyclerViewAdapter);

    }

    //나의 신청 현황 정보 가져오는 함수
    public void fetchMyMatchApplyList(String type){

        myMatchService=new MyMatchService();
//이 위치가 문제인가

        myMatchService.getMyMatchApplyStatus(context, type ,new Callback<MyMatchApplyStatusResponseDto>() {
            @Override
            public void onResponse(Call<MyMatchApplyStatusResponseDto> call, Response<MyMatchApplyStatusResponseDto> response) {
                Log.d("checking response data",String.valueOf(response.body()));
                // Log.d("선택한 신청 방",String.valueOf(response.body().getApplicationList()));
                if(response.isSuccessful() == false) {

                    Log.d("apply_match", "failed");
                }
                // myMatchApplyList=response.body().getApplicationList();

                myApplyStatusRecyclerViewAdapter.setItems(response.body().getApplicationList());
//                printData(response.body().getApplicationList());
                 recyclerView.setAdapter(myApplyStatusRecyclerViewAdapter);
            }

            @Override
            public void onFailure(Call<MyMatchApplyStatusResponseDto> call, Throwable t) {
                Log.d("checking response data",t.getMessage());

            }
        });
    }






}



