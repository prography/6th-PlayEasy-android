package com.prography.playeasy.team.api;

import com.prography.playeasy.team.dto.TeamRequestDto;
import com.prography.playeasy.team.dto.TeamResponseDto;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Query;

public interface RetrofitTeamApi {

    @GET("/api/team/info")
    Call<TeamResponseDto> getTeamDetail(@Header("authorization") String token,
                                        @Query("teamId") int teamId);

    @GET("/api/team/userList")
    Call<TeamResponseDto> getUserIncludeTeam(@Header("authorization") String token,
                                             @Query("teamId") int teamId);

    @GET("/api/team/searchList")
    Call<TeamResponseDto> searchTeam(@Header("authorization") String token,
                                     @Query("searchInfo") String query);

    @POST("/api/team")
    Call<TeamResponseDto> postTeam(@Header("authorization") String token,
                                   @Body TeamRequestDto requestBody);

    @PUT("/api/team")
    Call<TeamResponseDto> updateTeam(@Header("authorization") String token,
                                     @Body TeamRequestDto requestBody);

    @DELETE("/api/team/member")
    Call<TeamResponseDto> deleteUserFromTeam(@Header("authorization") String token,
                                             @Body TeamRequestDto requestBody);
}
