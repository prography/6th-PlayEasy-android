package com.prography.playeasy.match.service;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.prography.playeasy.lib.RetrofitClientGenerator;
import com.prography.playeasy.lib.TokenManager;
import com.prography.playeasy.match.api.RetrofitMatchApi;
import com.prography.playeasy.match.domain.MatchRequestVO;
import com.prography.playeasy.match.domain.MatchResponseVO;
import com.prography.playeasy.match.util.MatchResponseCallback;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MatchService {
    private RetrofitMatchApi matchClient;

    public MatchService() {
        this.matchClient = RetrofitClientGenerator.getClient(RetrofitMatchApi.class);
    }

    public void createMatch(MatchRequestVO request, Context context) {
        // Async
        Call<MatchResponseVO> call = matchClient.postMatch(TokenManager.get(context), request);
        call.enqueue(new Callback<MatchResponseVO>() {
            @Override
            public void onResponse(Call<MatchResponseVO> call, Response<MatchResponseVO> response) {
                MatchResponseVO body = response.body();

                if (response.isSuccessful() == false || body.isSuccess() == false) {
                    Toast result = Toast.makeText(context, "Failed to register", Toast.LENGTH_SHORT);
                    result.show();
                    return;
                }

                Toast result = Toast.makeText(context, "Success", Toast.LENGTH_SHORT);
                result.show();

                Log.d("MATCH", body.getMatch().toString());
            }

            @Override
            public void onFailure(Call<MatchResponseVO> call, Throwable t) {
                Log.e("CREATE_FAIL", t.getMessage());
            }
        });
    }

    public void retrieveMatch(MatchResponseCallback callback) {
        Call<MatchResponseVO> call = matchClient.getMatch();
        call.enqueue(new Callback<MatchResponseVO>() {
            @Override
            public void onResponse(Call<MatchResponseVO> call, Response<MatchResponseVO> response) {
                MatchResponseVO body = response.body();

                if (!response.isSuccessful() || !body.isSuccess()) {
                    Log.d("RESPONSE", "Unsuccessful response");
                    return;
                }

                Log.d("retrieveMATCH", body.getMatchList().toString());
                callback.onSuccess(body.getMatchList());
            }

            @Override
            public void onFailure(Call<MatchResponseVO> call, Throwable t) {
                Log.e("RETRIEVE_FAIL", t.getMessage());
            }
        });

    }
}
