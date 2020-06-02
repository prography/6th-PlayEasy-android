package com.prography.playeasy.lib.auth;

import com.prography.playeasy.login.domain.LoginRequestVO;
import com.prography.playeasy.login.domain.LoginResponseVO;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface RetrofitLoginApi {
    @POST("/api/auth/login")
    Call<LoginResponseVO> register(
            @Body LoginRequestVO requestVO);
}