package com.prography.playeasy.match.api;

import com.prography.playeasy.match.domain.MatchRequestVO;
import com.prography.playeasy.match.domain.MatchResponseVO;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface RetrofitMatchApi {
    @POST("/api/match")
    Call<Map<String, String>> register(@Header("authorization") String accessToken,
                                       @Body MatchRequestVO requestVO);

    @POST("/api/match")
    Call<MatchResponseVO> registerMatch(@Header("authorization") String accessToken,
                                        @Body MatchRequestVO requestVO);
}
