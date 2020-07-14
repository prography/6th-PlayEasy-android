package com.prography.playeasy.team.service;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.kakao.network.callback.ResponseCallback;
import com.prography.playeasy.lib.RetrofitClientFactory;
import com.prography.playeasy.lib.TokenManager;
import com.prography.playeasy.team.api.RetrofitTeamApi;
import com.prography.playeasy.team.domain.Team;
import com.prography.playeasy.team.dto.TeamRequestDto;
import com.prography.playeasy.team.dto.TeamResponseDto;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TeamService {

    private static final String TAG = "TEAM_SERVICE";

    private RetrofitTeamApi teamClient;

    public TeamService() {
        this.teamClient = RetrofitClientFactory.getClient(RetrofitTeamApi.class);
    }

    public void registerTeam(Team team, Context context) {
        TeamRequestDto requestDto = new TeamRequestDto();
        requestDto.put("team", team);

        Call<TeamResponseDto> call = teamClient.postTeam(TokenManager.get(context), requestDto);
        call.enqueue(new Callback<TeamResponseDto>() {
            @Override
            public void onResponse(Call<TeamResponseDto> call, Response<TeamResponseDto> response) {
                if (response.isSuccessful() == false) {
                    Toast.makeText(context, "Failed to register", Toast.LENGTH_SHORT).show();
                    return;
                }

                Toast.makeText(context, "Success", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<TeamResponseDto> call, Throwable t) {
                Log.d(TAG, t.getMessage());
            }
        });
    }

    public void retrieveTeamDetail(int teamId, ResponseCallback callback, Context context) {
        Call<TeamResponseDto> call = teamClient.getTeamDetail(TokenManager.get(context), teamId);
        call.enqueue(new Callback<TeamResponseDto>() {
            @Override
            public void onResponse(Call<TeamResponseDto> call, Response<TeamResponseDto> response) {
                // TODO: 응답 어떻게 받는지 알게되면 그때 처리
                // Team team = response.body().xxx();
                // callback.onSuccess(team);
            }

            @Override
            public void onFailure(Call<TeamResponseDto> call, Throwable t) {
                Log.d(TAG, t.getMessage());
            }
        });
    }

    public void retrieveUserIncludeTeam(int teamId, ResponseCallback callback, Context context) {
        Call<TeamResponseDto> call = teamClient.getUserIncludeTeam(TokenManager.get(context), teamId);
        call.enqueue(new Callback<TeamResponseDto>() {
            @Override
            public void onResponse(Call<TeamResponseDto> call, Response<TeamResponseDto> response) {
                callback.onSuccess(response.body().userList());
            }

            @Override
            public void onFailure(Call<TeamResponseDto> call, Throwable t) {
                Log.d(TAG, t.getMessage());
            }
        });
    }

    public void searchTeam(String query, ResponseCallback callback, Context context) {
        Call<TeamResponseDto> call = teamClient.searchTeam(TokenManager.get(context), query);
        call.enqueue(new Callback<TeamResponseDto>() {
            @Override
            public void onResponse(Call<TeamResponseDto> call, Response<TeamResponseDto> response) {
                callback.onSuccess(response.body().teamList());
            }

            @Override
            public void onFailure(Call<TeamResponseDto> call, Throwable t) {
                Log.d(TAG, t.getMessage());
            }
        });
    }

    public void removeUserFromTeam(int userId, int teamId, ResponseCallback callback, Context context) {
        TeamRequestDto requestBody = new TeamRequestDto();
        requestBody.put("userId", userId);
        requestBody.put("teamId", teamId);

        Call<TeamResponseDto> call = teamClient.deleteUserFromTeam(TokenManager.get(context), requestBody);
        call.enqueue(new Callback<TeamResponseDto>() {
            @Override
            public void onResponse(Call<TeamResponseDto> call, Response<TeamResponseDto> response) {
                callback.onSuccess(response.body().userList());
            }

            @Override
            public void onFailure(Call<TeamResponseDto> call, Throwable t) {
                Log.d(TAG, t.getMessage());
            }
        });
    }

    public void modifyTeam(int teamId, Team team, ResponseCallback callback, Context context) {
        TeamRequestDto requestDto = new TeamRequestDto();
        requestDto.put("team", team);
        requestDto.put("teamId", teamId);

        Call<TeamResponseDto> call = teamClient.postTeam(TokenManager.get(context), requestDto);
        call.enqueue(new Callback<TeamResponseDto>() {
            @Override
            public void onResponse(Call<TeamResponseDto> call, Response<TeamResponseDto> response) {
                callback.onSuccess(response.body().updateTeam());
            }

            @Override
            public void onFailure(Call<TeamResponseDto> call, Throwable t) {
                Log.d(TAG, t.getMessage());
            }
        });
    }

}
