package com.prography.playeasy.mypage.api;

import com.prography.playeasy.mypage.dto.UserRequestDto;
import com.prography.playeasy.mypage.dto.UserResponseDto;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.PUT;

public interface RetrofitUserApi {
    @GET("/api/users")
    Call<UserResponseDto> getUser(@Header("authorization") String token);

    @PUT("/api/users")
    Call<UserResponseDto> updateUser(@Header("authorization") String token,
                                     @Body UserRequestDto requestBody );

}
