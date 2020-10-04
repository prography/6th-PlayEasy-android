package com.prography.playeasy.mypage.api;

import com.prography.playeasy.mypage.domain.dtos.MyMatchApplyStatusResponseDto;
import com.prography.playeasy.mypage.domain.dtos.register.MyMatchRegisterListDto;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

public interface RetrofitMyMatchRegisterApi {
    //내가 등록한 매치
    @GET("/api/users/matches")
    Call <MyMatchRegisterListDto> getMyRegisterMatchList(@Header("authorization")String token);

    //나의 신청 현황
    @GET("/api/users/applications")
    Call<MyMatchApplyStatusResponseDto> getMyApplyStatus(@Header("authorization") String token , @Query("type") String type);


}
