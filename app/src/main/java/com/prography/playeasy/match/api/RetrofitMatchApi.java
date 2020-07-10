package com.prography.playeasy.match.api;

import com.prography.playeasy.match.domain.dtos.response.MatchDetailDto;
import com.prography.playeasy.match.domain.dtos.response.MatchEndResponseDto;
import com.prography.playeasy.match.domain.dtos.response.MatchListDto;
import com.prography.playeasy.match.domain.dtos.request.MatchPostRequestDto;
import com.prography.playeasy.match.domain.dtos.request.MatchReviseRequestDto;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Query;

public interface RetrofitMatchApi {


    @POST("/api/match")
    Call<MatchDetailDto> postMatch(@Header("authorization") String token,
                                   @Body MatchPostRequestDto requestVO);

    @GET("/api/match/list")
    Call<MatchListDto> getMatchList();


    /**
     * 매치 상세 조회
     * @param matchId 클릭한 매치의 ID
     * @example /api/match?id={matchId}
     * @return MatchResponseDto-->Match로 수정
     */
    @GET("/api/match")
    Call<MatchDetailDto> getMatch(@Query("id")int matchId);
   //매치 수정
    @PUT("/api/match")
    Call <MatchDetailDto> reviseMatch(@Header("authorization") String token,
                                      @Body MatchReviseRequestDto requestVO);





    //매치 마감
    @PUT("/api/match/status")
    Call <MatchEndResponseDto> endMatch(@Body HashMap<String,Object> body);
//    int matchId = 0;
//    enum status{WAITING,CONFIRMED,CANCEL} status;
//    String nestedJson="{"+matchId+":"+matchId+","+"statusType" +":"+ status+"}";
//    Gson gson=new Gson();
//    Map<String,Object> result=gson.fromJson(nestedJson,Map.class);


}
