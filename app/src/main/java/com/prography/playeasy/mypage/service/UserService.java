package com.prography.playeasy.mypage.service;

import android.content.Context;
import android.util.Log;

import com.kakao.network.callback.ResponseCallback;
import com.prography.playeasy.lib.RetrofitClientFactory;
import com.prography.playeasy.lib.TokenManager;
import com.prography.playeasy.mypage.api.RetrofitUserApi;
import com.prography.playeasy.mypage.domain.User;
import com.prography.playeasy.mypage.dto.UserRequestDto;
import com.prography.playeasy.mypage.dto.UserResponseDto;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserService {

    private RetrofitUserApi userClient;
    private static final String TAG = "MyInfo_SERVICE";


    public UserService() {
        this.userClient = RetrofitClientFactory.getClient(RetrofitUserApi.class);
    }

    public void retrieveUser(ResponseCallback callback, Context context){
        Call<UserResponseDto> call = userClient.getUser(TokenManager.get(context));
        call.enqueue(new Callback<UserResponseDto>() {
            @Override
            public void onResponse(Call<UserResponseDto> call, Response<UserResponseDto> response) {
                System.out.println(response.body());
                callback.onSuccess(response.body().user());
            }

            @Override
            public void onFailure(Call<UserResponseDto> call, Throwable t) {
                Log.d(TAG, t.getMessage());
            }
        });
    }

    public void modifyUser(User user, ResponseCallback callback, Context context){
        UserRequestDto userRequestDto = new UserRequestDto();
        userRequestDto.put("userData", user);

        Call<UserResponseDto> call = userClient.updateUser(TokenManager.get(context), userRequestDto);
        call.enqueue(new Callback<UserResponseDto>() {
            @Override
            public void onResponse(Call<UserResponseDto> call, Response<UserResponseDto> response) {
                System.out.println(response.body());
                callback.onSuccess(response.body().user());
            }

            @Override
            public void onFailure(Call<UserResponseDto> call, Throwable t) {
                Log.d(TAG, t.getMessage());
            }
        });

    }
}
