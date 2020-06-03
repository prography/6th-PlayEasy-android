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

public interface RetrofitMatchApi {

    @POST("/api/match")
    Call<MatchResponseVO> postMatch(@Header("authorization") String token,
                                        @Body MatchRequestVO requestVO);

    @GET("/api/match/list")
    //전부다 조회
    Call<MatchResponseVO> getMatch();
}
