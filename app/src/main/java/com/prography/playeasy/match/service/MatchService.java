package com.prography.playeasy.match.service;

import android.content.Context;
import android.util.Log;

import com.prography.playeasy.lib.TokenManager;
import com.prography.playeasy.match.domain.MatchDao;
import com.prography.playeasy.match.domain.dtos.request.MatchPostRequestDto;
import com.prography.playeasy.match.domain.dtos.response.MatchCreateResponseDto;
import com.prography.playeasy.match.domain.dtos.response.MatchDetailDto;
import com.prography.playeasy.match.domain.dtos.response.MatchListDto;
import com.prography.playeasy.match.domain.models.Match;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

//생성 수정 logic
public class MatchService {

    private MatchDao matchDao;
    List<Match> matchList;
    Match match;
    public MatchService(Context context) {

        this.matchDao = new MatchDao(TokenManager.get(context));
    }

    public void createMatch(MatchPostRequestDto request) throws IOException {
        this.matchDao.create(request, new Callback<MatchCreateResponseDto>() {
            @Override
            public void onResponse(Call<MatchCreateResponseDto> call, Response<MatchCreateResponseDto> response) {
                //아무것도 안함 저장 안하니까
                Log.d("매치 생성하기 정보", String.valueOf(response.body()));
            }

            @Override
            public void onFailure(Call<MatchCreateResponseDto> call, Throwable t) {

            }
        });
    }
    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
    //매치 상세보기 아닌 날짜에 따른 리스트 가져오기 위함
    public List<Match> retrieveMatch(Date date) throws IOException {


       this.matchDao.retrieve(date, new Callback<MatchListDto>() {
           @Override
           public void onResponse(Call<MatchListDto> call, Response<MatchListDto> response) {
               matchList=  response.body().getMatchList();
               Log.e("매치 리스트 response body 확인", String.valueOf(response.body()));
           }

           @Override
           public void onFailure(Call<MatchListDto> call, Throwable t) {

           }
       });
       return matchList;
    }






//반환형을 MatchDto가 아닌 Match
    //todo
    public Match detailMatch(int MatchId) throws IOException {

             this.matchDao.findById(MatchId, new Callback<MatchDetailDto>() {
                @Override
                public void onResponse(Call<MatchDetailDto> call, Response<MatchDetailDto> response) {
                    match=   response.body().getMatch();
                }

                @Override
                public void onFailure(Call<MatchDetailDto> call, Throwable t) {

                }
            });
             return match;
    }
//
//    public int closeMatch(int matchId){
//
//        return this.matchDao.closeMatch(matchId);
//    }

    //horizontal recyclerview에서 선택한 날짜의 매치 정보 가져오기
//동기에서 Asnc 른 비동기를 호출하니 굳이 비동기식 코드를 짤 필요가 없다 callback을 쓰면 괜히 코드만 어려워
//    public Match retrieveMatch(MatchResponseCallback callback) {
//
//        Call<List<MatchDto>> call = matchClient.getMatchList(,"AVAILABLE");
//
//    }






//    public void reviseMatch() 도 구현해야 함 규산's 컨펌 받
}
