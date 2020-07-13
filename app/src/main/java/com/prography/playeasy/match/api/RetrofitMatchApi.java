package com.prography.playeasy.match.api;

import com.prography.playeasy.match.domain.dtos.MatchDto;
import com.prography.playeasy.match.domain.dtos.request.MatchUpdateRequestDto;
import com.prography.playeasy.match.domain.dtos.response.MatchDetailDto;
import com.prography.playeasy.match.domain.dtos.request.MatchPostRequestDto;
import com.prography.playeasy.match.domain.models.Match;


import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Query;

public interface RetrofitMatchApi {


//todo String 으로수정?
    @GET("/api/match/list")
    Call<List<MatchDto>> getMatchList(@Query("date") String date);
//
//    @GET("/api/match/list")
//    Call<List<MatchDto>> getMatchList(@Query("date") String date,@Query("status") String status);
//

    /**
     * 매치 상세 조회
     * @param matchId 클릭한 매치의 ID
     * @example /api/match?id={matchId}
     * @return MatchResponseDto-->Match로 수정
     */

    @GET("/api/match")
    Call<MatchDetailDto> getMatch(@Query("id")int matchId);

   //3번쨰 매치 수정
    @PUT("/api/match")
    Call <MatchDetailDto> reviseMatch(@Header("authorization") String token,
                                      @Body MatchUpdateRequestDto matchUpdaterequestDto);





    //매치 마감
    @PUT("/api/match/status")
   Call <MatchDetailDto> closeMatch(@Body HashMap<String,Object> body);

  // Call <MatchDetailDto> closeMatch( @Body  body);
//    int matchId = 0;
//    enum status{WAITING,CONFIRMED,CANCEL} status;
//    String nestedJson="{"+matchId+":"+matchId+","+"statusType" +":"+ status+"}";
//    Gson gson=new Gson();
//    Map<String,Object> result=gson.fromJson(nestedJson,Map.class);


    @POST("/api/match")
    Call<MatchDetailDto> postMatch(@Header("authorization") String token,
                                   @Body MatchPostRequestDto requestVO);

}
