package com.prography.playeasy.match.service;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.prography.playeasy.lib.RetrofitClientFactory;
import com.prography.playeasy.lib.TokenManager;
import com.prography.playeasy.match.api.RetrofitMatchApi;
import com.prography.playeasy.match.domain.MatchDetail.Match;
import com.prography.playeasy.match.domain.MatchDetail.MatchDetailDAO;
import com.prography.playeasy.match.domain.MatchList.MatchListDAO;
import com.prography.playeasy.match.domain.MatchPost.MatchDto;
import com.prography.playeasy.match.domain.MatchPost.MatchPostRequestDAO;
import com.prography.playeasy.match.domain.MatchRequestVO;
import com.prography.playeasy.match.domain.MatchResponseVO;
import com.prography.playeasy.match.util.MatchResponseCallback;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MatchService {
    private RetrofitMatchApi matchClient;

    public MatchService() {

        this.matchClient = RetrofitClientFactory.getClient(RetrofitMatchApi.class);
    }

    public void createMatch(MatchPostRequestDAO request, Context context) {
        // Async
        Call<MatchDetailDAO> call = matchClient.postMatch(TokenManager.get(context), request);
        call.enqueue(new Callback<MatchDetailDAO>() {
            @Override
            public void onResponse(Call<MatchDetailDAO> call, Response<MatchDetailDAO> response) {
                MatchDetailDAO body = response.body();

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
            public void onFailure(Call<MatchDetailDAO> call, Throwable t) {
                Log.e("CREATE_FAIL", t.getMessage());
            }
        });
    }

    public void retrieveMatch(MatchResponseCallback callback) {
        Call<MatchListDAO> call = matchClient.getMatchList();
        call.enqueue(new Callback<MatchListDAO>() {
            // API 호출 성공시 실행
            @Override
            public void onResponse(Call<MatchListDAO> call, Response<MatchListDAO> response) {
                MatchListDAO body = response.body();
                if (!response.isSuccessful() || !body.isSuccess()) {
                    Log.d("RESPONSE", "Unsuccessful response");
                    return;
                }
                // API 실행이 성공적으로 응답했을 경우
                Log.d("retrieveMATCH", body.getMatchList().toString());
                // 전달받은 콜백 인터페이스 실행
                callback.onSuccess(body.getMatchList());
            }
            @Override
            public void onFailure(Call<MatchListDAO> call, Throwable t) {

            }
        });

    }

    public void detailMatch(int matchId, MatchResponseCallback callback) {
        Call<MatchDetailDAO> call = matchClient.getMatch(matchId);
        call.enqueue(new Callback<MatchDetailDAO>() {
            @Override
            public void onResponse(Call<MatchDetailDAO> call, Response<MatchDetailDAO> response) {
                MatchDetailDAO body = response.body();

                callback.onSuccess(body.getMatch());
            }

            @Override
            public void onFailure(Call<MatchDetailDAO> call, Throwable t) {
                Log.e("RETRIEVE_ONE_FAIL", t.getMessage());
            }
        });

    }
}
