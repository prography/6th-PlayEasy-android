package com.prography.playeasy.match.domain;

import android.util.Log;

import com.prography.playeasy.lib.RetrofitClientFactory;

import com.prography.playeasy.match.api.RetrofitMatchApi;
import com.prography.playeasy.match.domain.dtos.MatchDto;
import com.prography.playeasy.match.domain.dtos.request.MatchPostRequestDto;
import com.prography.playeasy.match.domain.dtos.request.MatchUpdateRequestDto;
import com.prography.playeasy.match.domain.dtos.response.MatchDetailDto;
import com.prography.playeasy.match.domain.models.Match;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

import retrofit2.Call;
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

    public Match create(MatchPostRequestDto requestDto) throws IOException {
        Call<MatchDetailDto> call = matchClient.postMatch(token, requestDto);
        try {
            Response<MatchDetailDto> response = call.execute();
            MatchDetailDto matchDetailDto = response.body();
            assert matchDetailDto != null;
            return matchDetailDto.getMatch();
        } catch (Throwable e) {
            Log.e("CREATE_FAIL", Objects.requireNonNull(e.getMessage()));
            throw e;
        }
    }

    public List<MatchDto> retrieve(Date date) throws IOException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Call<List<MatchDto>> call = matchClient.getMatchList(formatter.format(date));
        List<MatchDto> matchListDto;
        try {
            Response<List<MatchDto>> response = call.execute();
            matchListDto = response.body();
            assert matchListDto != null;
            return matchListDto;
        } catch (Throwable e) {
            Log.e("RETRIEIVE_FAIL", Objects.requireNonNull(e.getMessage()));
            throw e;
        }
    }

    public Match findById(int matchId) throws IOException {
        Call<MatchDetailDto> call = matchClient.getMatch(matchId);
        try {
            Response<MatchDetailDto> response = call.execute();
            MatchDetailDto matchDetailDto = response.body();
            assert matchDetailDto != null;
            return matchDetailDto.getMatch();
        } catch (Throwable e) {
            Log.e("FIND_FAIL", Objects.requireNonNull(e.getMessage()));
            throw e;
        }
    }


//규산 반환형을 Match로 해야 할지
    public Match reviseMatch(MatchUpdateRequestDto matchReviseDto) throws IOException {
        MatchDetailDto matchobj = null;

        Call <MatchDetailDto> call=matchClient.reviseMatch(token,matchReviseDto);
        try{

            Response<MatchDetailDto> response=call.execute();
            MatchDetailDto matchDetailDto =response.body();

            assert matchDetailDto!=null;
            return matchDetailDto.getMatch();

        }catch(Throwable e){
            Log.e("revise fail",Objects.requireNonNull(e.getMessage()));
            throw e;
        }


    }





    public int closeMatch(int matchId) {
//        Call <>=matchClient.closeMatch();

          //  String nestedJson="{"matchId"+":"+matchId+","+"statusType" +":"+ status+"}
//            JSONObject json = new JSONObject();
//            json.put("matchId", matchId);
//            json.put("status","CANCEL");
          //  String json = "{\"matchId\":"+matchId+",\"status\":\"CANCEL\"}";
           // TypedInput in = new TypedByteArray("application/json", json.getBytes("UTF-8"));
            HashMap<String,Object> hashMap=new HashMap<>();
            hashMap.put("matchId",28);
            hashMap.put("status","CANCEL");

            matchClient.closeMatch(hashMap);



//    String nestedJson="{"+matchId+":"+matchId+","+"statusType" +":"+ status+"}";
//    Gson gson=new Gson();
//    Map<String,Object> result=gson.fromJson(nestedJson,Map.class);
            return matchId;
    }
}