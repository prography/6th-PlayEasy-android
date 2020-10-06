package com.prography.playeasy.match.domain;

import android.annotation.SuppressLint;
import android.widget.Toast;

import com.kakao.network.callback.ResponseCallback;
import com.prography.playeasy.lib.RetrofitClientFactory;

import com.prography.playeasy.match.api.RetrofitMatchApi;
import com.prography.playeasy.match.domain.dtos.LocationDto;
import com.prography.playeasy.match.domain.dtos.MatchNoIdDto;
import com.prography.playeasy.match.domain.dtos.request.MatchPostRequestDto;
import com.prography.playeasy.match.domain.dtos.request.MatchUpdateRequestDto;
import com.prography.playeasy.match.domain.dtos.response.MapResponseDto;
import com.prography.playeasy.match.domain.dtos.response.MatchCreateResponseDto;
import com.prography.playeasy.match.domain.dtos.response.MatchDetailDto;
import com.prography.playeasy.match.domain.dtos.response.MatchListDto;
import com.prography.playeasy.match.domain.dtos.response.MatchUpdateResponseDto;
import com.prography.playeasy.match.domain.models.Match;
import com.prography.playeasy.mypage.domain.dtos.MatchCloseRequestDto;
import com.prography.playeasy.mypage.domain.dtos.MatchCloseResponseDto;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Match 에 대한 API에 접근하는 객체(보통은 DB에 접근할 때 쓰기 때문에, DAO가 올바른 표현은 아닐 수 있음.)
 * 웹 프로젝트에서는 ApiClient라는 이름으로 쓰기도 하지만, 이 DAO는 Match 관련된 데이터만 접근 할 것이므로 MatchDao로 명명함.
 //file 하나는 목적이 하나

 */
public class MatchDao {

    private RetrofitMatchApi matchClient;
    private String token;

    public MatchDao(String token) {
        this.matchClient = RetrofitClientFactory.getClient(RetrofitMatchApi.class);
        this.token = token;
    }

    public void create(MatchNoIdDto matchData,LocationDto locationData, Callback<MatchCreateResponseDto> callback) {
        MatchPostRequestDto matchPostRequestDto = new MatchPostRequestDto(matchData, locationData);
        Call<MatchCreateResponseDto> call = matchClient.postMatch(token, matchPostRequestDto);
        call.enqueue(callback);
    }

    public void retrieve(Date date, Callback<MatchListDto> callback) {
        @SuppressLint(value = "SimpleDateFormat")
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Call<MatchListDto> call = matchClient.getMatchList(formatter.format(date));
        call.enqueue(callback);
    }

    public void findById(int matchId, Callback<MatchDetailDto> callback) {
        Call<MatchDetailDto> call = matchClient.getMatch(token,matchId);
        call.enqueue(callback);
    }

    public void reviseMatch(MatchUpdateRequestDto matchReviseDto, Callback<MatchUpdateResponseDto> callback) {
        Call <MatchUpdateResponseDto> call=matchClient.reviseMatch(token,matchReviseDto);
        call.enqueue(callback);
    }


    public void closeMatch(int matchId, String status, Callback<MatchCloseResponseDto> callback) {
//        HashMap<String,Object> hashMap=new HashMap<>();
//        hashMap.put("matchId", matchId);
//        hashMap.put("status", "CANCEL");
        MatchCloseRequestDto matchCloseRequestDto = new MatchCloseRequestDto(matchId, status);
        Call<MatchCloseResponseDto> call = matchClient.closeMatch(token, matchCloseRequestDto);
        call.enqueue(callback);

    }

        //  String nestedJson="{"matchId"+":"+matchId+","+"statusType" +":"+ status+"}
//            JSONObject json = new JSONObject();
//            json.put("matchId", matchId);
//            json.put("status","CANCEL");
        //  String json = "{\"matchId\":"+matchId+",\"status\":\"CANCEL\"}";
        // TypedInput in = new TypedByteArray("application/json", json.getBytes("UTF-8"));
//    String nestedJson="{"+matchId+":"+matchId+","+"statusType" +":"+ status+"}";
//    Gson gson=new Gson();
//    Map<String,Object> result=gson.fromJson(nestedJson,Map.class);


    public void getMapInfo(String keyword, ResponseCallback callback){
        Call<MapResponseDto> call=matchClient.getMap(keyword);
        call.enqueue(new Callback<MapResponseDto>() {
            @Override
            public void onResponse(Call<MapResponseDto> call, Response<MapResponseDto> response) {
                if(response.isSuccessful() == false){

                }else{
                    callback.onSuccess(response.body().getReturnData());
                }
            }

            @Override
            public void onFailure(Call<MapResponseDto> call, Throwable t) {

            }
        });
    }
}