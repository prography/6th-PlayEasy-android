package com.prography.playeasy.mypage.service;

import android.content.Context;

import com.prography.playeasy.lib.RetrofitClientFactory;
import com.prography.playeasy.lib.TokenManager;
import com.prography.playeasy.match.api.RetrofitMatchApi;
import com.prography.playeasy.match.domain.dtos.request.MatchApplySoloPostRequestDto;
import com.prography.playeasy.match.domain.dtos.response.MatchApplySoloPostResponseDto;
import com.prography.playeasy.mypage.api.RetrofitMyMatchRegisterApi;
import com.prography.playeasy.mypage.domain.dtos.MyMatchApplyStatusResponseDto;
import com.prography.playeasy.mypage.domain.dtos.register.MyMatchRegisterListDto;
import com.prography.playeasy.mypage.module.view.fragment.MyMatchApply;

import java.util.StringTokenizer;

import retrofit2.Call;
import retrofit2.Callback;

public class MyMatchService {

    RetrofitMyMatchRegisterApi retrofitMyMatchRegisterApi;

    public MyMatchService(){

        this.retrofitMyMatchRegisterApi= RetrofitClientFactory.getClient(RetrofitMyMatchRegisterApi.class);

    }

    public void getMyRegisterMatch(Context context,Callback<MyMatchRegisterListDto> callback){


        Call <MyMatchRegisterListDto> call=retrofitMyMatchRegisterApi.getMyRegisterMatchList(TokenManager.get(context));
        call.enqueue(callback);

    }

    public void getMyMatchApplyStatus(Context context, String type,Callback<MyMatchApplyStatusResponseDto> callback){

        Call <MyMatchApplyStatusResponseDto> call=retrofitMyMatchRegisterApi.getMyApplyStatus(TokenManager.get(context),type);

        call.enqueue(callback);

    }


}
