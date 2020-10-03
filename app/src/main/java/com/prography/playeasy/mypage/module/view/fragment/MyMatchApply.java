package com.prography.playeasy.mypage.module.view.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.prography.playeasy.R;
import com.prography.playeasy.mypage.domain.models.MyApplyStatusApplication;
import com.prography.playeasy.mypage.service.MyMatchService;

import java.util.ArrayList;

public class MyMatchApply extends Fragment {
    ArrayList<MyApplyStatusApplication> myMatchApply;
    MyMatchService myMatchService;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_mypage_mymatchinformation_apply, container, false);

        return rootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initialize(view);
    }

    private void initialize(View view) {


    }
    //나의 신청 현황 정보 가져오는 함수
    public void fetchMyMatchApplyList(){

        myMatchService=new MyMatchService();


    }



}
