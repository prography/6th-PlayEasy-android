package com.prography.playeasy.login.service;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import com.prography.playeasy.application.PlayeasyApplication;
import com.prography.playeasy.lib.RetrofitClientFactory;
import com.prography.playeasy.lib.TokenManager;
import com.prography.playeasy.login.api.RetrofitLoginApi;
import com.prography.playeasy.login.domain.LoginRequestVO;
import com.prography.playeasy.login.domain.LoginResponseVO;
import com.prography.playeasy.main.activity.Main;
import com.prography.playeasy.mypage.activity.MyInformation;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginService {
    private RetrofitLoginApi loginClient;

    public LoginService() {
        this.loginClient = RetrofitClientFactory.getClient(RetrofitLoginApi.class);
    }

    public void userLogin(String accessToken, Context context) {
        Toast.makeText(context, "userLogin() executed", Toast.LENGTH_SHORT).show();
        // Get firebase token
        Log.d("FIREBASE", "FB TOKEN: " + PlayeasyApplication.TOKEN);


        Call<LoginResponseVO> call = loginClient.register(new LoginRequestVO(accessToken));
        call.enqueue(new Callback<LoginResponseVO>() {
            @Override
            public void onResponse(Call<LoginResponseVO> call, Response<LoginResponseVO> response) {
                Toast.makeText(context, "onResponse() executed", Toast.LENGTH_SHORT).show();
                Log.d("LOGIN RESPONSE", response.code() + " " + response.message());

                if (response.isSuccessful() == false ) {
                    Toast result = Toast.makeText(context, "Failed to login", Toast.LENGTH_SHORT);
                    result.show();
                    return;
                }

                Toast.makeText(context, "Response OK", Toast.LENGTH_SHORT).show();
                Log.d("USER_TOKEN", response.body().getToken());
                TokenManager.set(context, response.body().getToken());

                Intent intent = new Intent();
                if (response.body().isNewMember()) {
                    intent.setClass(context, MyInformation.class);

                } else {
                    intent.setClass(context, Main.class);
                }
                Toast.makeText(context, "set Intent", Toast.LENGTH_SHORT).show();
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

                Toast.makeText(context, "before start activity", Toast.LENGTH_SHORT).show();
                context.startActivity(intent);
            }

            @Override
            public void onFailure(Call<LoginResponseVO> call, Throwable t) {
                Log.e("LOGIN_API_FAIL", t.getMessage());
            }
        });
    }

    public void userLogout(Context context) {
        TokenManager.remove(context);
    }
}
