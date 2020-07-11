package com.prography.playeasy.match.service;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.prography.playeasy.lib.RetrofitClientFactory;
import com.prography.playeasy.lib.TokenManager;
import com.prography.playeasy.match.api.RetrofitMatchApi;
import com.prography.playeasy.match.domain.dtos.MatchDto;
import com.prography.playeasy.match.domain.dtos.response.MatchDetailDto;
import com.prography.playeasy.match.domain.dtos.response.MatchListDto;
import com.prography.playeasy.match.domain.dtos.request.MatchPostRequestDto;
import com.prography.playeasy.match.util.MatchResponseCallback;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MatchService {
    private RetrofitMatchApi matchClient;

    public MatchService() {

        this.matchClient = RetrofitClientFactory.getClient(RetrofitMatchApi.class);
    }

    public void createMatch(MatchPostRequestDto request, Context context) {
        // Async
        Call<MatchDetailDto> call = matchClient.postMatch(TokenManager.get(context), request);
        call.enqueue(new Callback<MatchDetailDto>() {
            @Override
            public void onResponse(Call<MatchDetailDto> call, Response<MatchDetailDto> response) {
                MatchDetailDto body = response.body();

                if (response.isSuccessful() == false ) {
                    Toast result = Toast.makeText(context, "Failed to register", Toast.LENGTH_SHORT);
                    result.show();
                    return;
                }

                Toast result = Toast.makeText(context, "Success", Toast.LENGTH_SHORT);
                result.show();

                Log.d("MATCH", body.getMatch().toString());
            }

            @Override
            public void onFailure(Call<MatchDetailDto> call, Throwable t) {
                Log.e("CREATE_FAIL", t.getMessage());
            }
        });
    }
    //0711 잘 모르겠음
//
//    public void retrieveMatch(MatchResponseCallback callback) {
//        Call<List<MatchDto>> call = matchClient.getMatchList();
//        call.enqueue(new Callback<List<MatchDto>>() {
//            // API 호출 성공시 실행
//            @Override
//            public void onResponse(Call<List<MatchDto>> call, Response <List<MatchDto>> response) {
//                List<MatchDto> body = response.body();
//                if (!response.isSuccessful() ) {
//                    Log.d("RESPONSE", "Unsuccessful response");
//                    return;
//                }
//                // API 실행이 성공적으로 응답했을 경우
//                Log.d("retrieveMATCH", body.toString());
//                // 전달받은 콜백 인터페이스 실행
//                callback.onSuccess(body);
//            }
//            @Override
//            public void onFailure(Call<List<MatchDto>> call, Throwable t) {
//                Log.e("RETRIEVE_List_FAIL", t.getMessage());
//            }
//        });
//
//    }

    public void detailMatch(int matchId, MatchResponseCallback callback) {
        Call<MatchDetailDto> call = matchClient.getMatch(matchId);
        call.enqueue(new Callback<MatchDetailDto>() {
            @Override
            public void onResponse(Call<MatchDetailDto> call, Response<MatchDetailDto> response) {
                MatchDetailDto body = response.body();
                callback.onSuccess(body.getMatch());
            }
            @Override
            public void onFailure(Call<MatchDetailDto> call, Throwable t) {
                Log.e("RETRIEVE_ONE_FAIL", t.getMessage());
            }
        });

    }
}
