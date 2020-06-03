package com.prography.playeasy.match.service;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.google.gson.Gson;
import com.prography.playeasy.lib.RetrofitClientGenerator;
import com.prography.playeasy.match.api.RetrofitMatchApi;
import com.prography.playeasy.match.domain.Match;
import com.prography.playeasy.match.domain.MatchRequestVO;
import com.prography.playeasy.match.domain.MatchResponseVO;

import java.io.IOException;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MatchService {

    public void createMatch(MatchRequestVO request, Context context) {
        RetrofitMatchApi matchClient = RetrofitClientGenerator.getClient(RetrofitMatchApi.class);

        // Async
        Call<MatchResponseVO> call = matchClient.registerMatch("userAccessTokenValue", request);
        call.enqueue(new Callback<MatchResponseVO>() {
            @Override
            public void onResponse(Call<MatchResponseVO> call, Response<MatchResponseVO> response) {
                MatchResponseVO body = response.body();

                if (response.isSuccessful() == false || body.isSuccess() == false) {
                    Toast result = Toast.makeText(context, "Failed to register", Toast.LENGTH_SHORT);
                    result.show();
                    return;
                }

                Toast result = Toast.makeText(context, "Failed to register", Toast.LENGTH_SHORT);
                result.show();
            }

            @Override
            public void onFailure(Call<MatchResponseVO> call, Throwable t) {
                System.out.println("Failed to call API");
                System.out.println(t);
            }
        });
    }

}
