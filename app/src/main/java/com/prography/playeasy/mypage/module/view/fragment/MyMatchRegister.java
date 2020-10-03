package com.prography.playeasy.mypage.module.view.fragment;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.prography.playeasy.R;
import com.prography.playeasy.lib.TokenManager;
import com.prography.playeasy.match.api.RetrofitMatchApi;
import com.prography.playeasy.match.domain.MatchDao;
import com.prography.playeasy.match.util.DataHelper;
import com.prography.playeasy.mypage.api.RetrofitMyMatchRegisterApi;
import com.prography.playeasy.mypage.domain.MyMatchVO;
import com.prography.playeasy.mypage.domain.dtos.register.MyMatchRegisterListDto;
import com.prography.playeasy.mypage.domain.dtos.register.MyMatchRegisterResponseDto;
import com.prography.playeasy.mypage.module.adapter.MyMatchInformationRecyclerViewAdapter;
import com.prography.playeasy.mypage.service.MyMatchService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MyMatchRegister extends Fragment {
    private String myMatchName;
    private String myMatchLocation;
    private int myMatchPeople;
    Context context;
    MyMatchService myMatchService;
    ArrayList<MyMatchRegisterResponseDto> myMatchRegisterList;
    MyMatchInformationRecyclerViewAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_mypage_mymatchinformation_register, container, false);
        context=getActivity().getApplicationContext();
        return rootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initialize(view);

    }

    private void initialize(View view) {
        RecyclerView recyclerView = view.findViewById(R.id.myMatchRegisterRecyclerView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(view.getContext());
        recyclerView.setLayoutManager(linearLayoutManager);

        adapter = new MyMatchInformationRecyclerViewAdapter(new MatchDao(TokenManager.get(context)));

        fetchMyMatchRegisterList();
        recyclerView.setAdapter(adapter);
    }

    public void fetchMyMatchRegisterList(){
        myMatchService=new MyMatchService();
        myMatchService.getMyRegisterMatch(context, new Callback<MyMatchRegisterListDto>(){

            @Override
            public void onResponse(Call<MyMatchRegisterListDto> call, Response<MyMatchRegisterListDto> response) {
                Log.d("check response data", String.valueOf(response.body()));
                myMatchRegisterList = response.body().getMatchList();
                adapter.setItems(myMatchRegisterList);
            }
            @Override
            public void onFailure(Call<MyMatchRegisterListDto> call, Throwable t) {
                Log.d("통신 실", "");

            }
        });
    }
}
