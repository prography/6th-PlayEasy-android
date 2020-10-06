package com.prography.playeasy.match.service;

import android.content.Context;
import android.util.Log;

import com.kakao.network.callback.ResponseCallback;
import com.prography.playeasy.lib.RetrofitClientFactory;
import com.prography.playeasy.lib.TokenManager;
import com.prography.playeasy.match.api.RetrofitMatchApi;
import com.prography.playeasy.match.domain.dtos.request.MatchApplySoloPostRequestDto;
import com.prography.playeasy.match.domain.dtos.request.MatchApplyTeamPostRequestDto;
import com.prography.playeasy.match.domain.dtos.request.MatchPostRequestDto;
import com.prography.playeasy.match.domain.dtos.response.MatchApplySoloPostResponseDto;
import com.prography.playeasy.match.domain.dtos.response.MatchApplyTeamPostResponseDto;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MatchService {
    private RetrofitMatchApi matchclient;
    private static final String TAG="match_SERVICE";
    public MatchService(){

        this.matchclient= RetrofitClientFactory.getClient(RetrofitMatchApi.class);

    }

    public void applyMatchSolo(Callback<MatchApplySoloPostResponseDto> callback, Context context,int matchId,int quotaSolo ){
        MatchApplySoloPostRequestDto matchApplySoloPostRequestDto=new MatchApplySoloPostRequestDto(matchId,quotaSolo);
        Call<MatchApplySoloPostResponseDto> call=matchclient.applyMatchSolo(TokenManager.get(context),matchApplySoloPostRequestDto);
        call.enqueue(callback);

    }

    public void applyMatchTeam(Callback<MatchApplyTeamPostResponseDto> callback, Context context, int matchId, int quotaTeam) {
        MatchApplyTeamPostRequestDto matchApplyTeamPostRequestDto=new MatchApplyTeamPostRequestDto(matchId,quotaTeam);

        Call <MatchApplyTeamPostResponseDto> call=matchclient.applyMatchTeam(TokenManager.get(context),matchApplyTeamPostRequestDto);
        call.enqueue(callback);

    }

}
