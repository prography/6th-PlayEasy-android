package com.prography.playeasy.mypage.api;

import com.prography.playeasy.match.domain.dtos.response.MatchListDto;
import com.prography.playeasy.mypage.domain.dtos.MyApplyStatusResponseDto;
import com.prography.playeasy.mypage.domain.models.MyApplyStatusApplication;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;

public interface RetrofitMyMatchRegisterApi {
    @GET("/api/users/matches")
    Call <MatchListDto> getmyRegisterMatchList(@Header("authorization")String token);
    @GET("/api/users/applications")
    Call<MyApplyStatusResponseDto> getMyApplyStatus(@Header("authorization") String token , @Body String type);






}
