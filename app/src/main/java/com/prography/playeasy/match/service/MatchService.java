package com.prography.playeasy.match.service;

import android.content.Context;
import android.media.session.MediaSession;
import android.util.Log;
import android.widget.Toast;

import com.prography.playeasy.lib.RetrofitClientFactory;
import com.prography.playeasy.lib.TokenManager;
import com.prography.playeasy.match.api.RetrofitMatchApi;
import com.prography.playeasy.match.domain.MatchDao;
import com.prography.playeasy.match.domain.dtos.MatchDto;
import com.prography.playeasy.match.domain.dtos.response.MatchDetailDto;
import com.prography.playeasy.match.domain.dtos.response.MatchListDto;
import com.prography.playeasy.match.domain.dtos.request.MatchPostRequestDto;
import com.prography.playeasy.match.domain.models.Match;
import com.prography.playeasy.match.util.MatchResponseCallback;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

//생성 수정 ㅣogic
public class MatchService {

    private MatchDao matchDao;

    public MatchService(Context context) {

        this.matchDao = new MatchDao(TokenManager.get(context));
    }

    public void createMatch(MatchPostRequestDto request) throws IOException {
        this.matchDao.create(request);
    }
    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");


    //매치 상세보기 아닌 날짜에 따른 리스트 가져오기 위함

    public List<MatchDto> retrieveMatch(Date date) throws IOException {
        Date currentTime = new Date();

        return this.matchDao.retrieve(date);
    }

//        try {
//            Response<List<MatchDto>> response = call.execute();
//            List<MatchDto> matchListDto = response.body();
//            assert matchListDto != null;
//            return matchListDto;
//        } catch (Throwable e) {
//            Log.e("RETRIEIVE_FAIL", Objects.requireNonNull(e.getMessage()));
//            throw e;
//        }



public void detailMatch(int MatchId) throws IOException {

        this.matchDao.findById(MatchId);
}





    //선택한 날짜의 매치 정보 가져오
//동기에서 Asnc 른 비동기를 호출하니 굳이 비동기식 코드를 짤 필요가 없다 callback을 쓰면 괜히 코드만 어려워
//    public Match retrieveMatch(MatchResponseCallback callback) {
//
//        Call<List<MatchDto>> call = matchClient.getMatchList(,"AVAILABLE");
//
//    }

//    public void detailMatch(int matchId, MatchResponseCallback callback) {
//
//
//        Call<MatchDetailDto> call = matchClient.getMatch(matchId);
//
//    call.enqueue(new Callback<MatchDetailDto>() {
//            @Override
//            public void onResponse(Call<MatchDetailDto> call, Response<MatchDetailDto> response) {
//                MatchDetailDto body = response.body();
//                callback.onSuccess(body.getMatch());
//            }
//            @Override
//            public void onFailure(Call<MatchDetailDto> call, Throwable t) {
//                Log.e("RETRIEVE_ONE_FAIL", t.getMessage());
//            }
//        });
//
//    }


//    public void reviseMatch()
}
