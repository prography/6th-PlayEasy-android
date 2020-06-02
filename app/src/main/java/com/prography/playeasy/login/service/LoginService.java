package com.prography.playeasy.login.service;

import com.prography.playeasy.lib.RetrofitClientGenerator;
import com.prography.playeasy.lib.auth.RetrofitLoginApi;
import com.prography.playeasy.login.domain.LoginRequestVO;
import com.prography.playeasy.login.domain.LoginResponseVO;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginService {
    public void userLogin(String accessToken) {
        RetrofitLoginApi client = RetrofitClientGenerator.getClient();
        Call<LoginResponseVO> call = client.register(new LoginRequestVO(accessToken));
        call.enqueue(new Callback<LoginResponseVO>() {
            @Override
            public void onResponse(Call<LoginResponseVO> call, Response<LoginResponseVO> response) {
                System.out.println("==== [onResponse()] ====");
                System.out.println("Code, Messsage: " + response.code() + " " + response.message());
                System.out.println("Body" + response.body().toString());
            }

            @Override
            public void onFailure(Call<LoginResponseVO> call, Throwable t) {
                System.out.println("Failed to call API");
                System.out.println(t);
            }
        });
    }
}
