package com.prography.playeasy.match.api;

import com.prography.playeasy.match.domain.Match;
import com.prography.playeasy.match.domain.MatchRequestVO;
import com.prography.playeasy.match.domain.MatchResponseVO;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface RetrofitMatchApi {

    @POST("/api/match")
    Call<MatchResponseVO> postMatch(@Header("authorization") String token,
                                        @Body MatchRequestVO requestVO);

    @GET("/api/match/list")
    Call<MatchResponseVO> getMatchList();


    /**
     * 매치 상세 조회
     * @param matchId 클릭한 매치의 ID
     * @example /api/match?id={matchId}
     * @return MatchResponseVO
     */
    @GET("/api/match")
    Call<MatchResponseVO> getMatch(@Query("id")int matchId);
}
