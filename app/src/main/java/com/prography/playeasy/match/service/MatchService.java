package com.prography.playeasy.match.service;

import android.content.Context;

import com.prography.playeasy.lib.TokenManager;
import com.prography.playeasy.match.domain.MatchDao;
import com.prography.playeasy.match.domain.dtos.MatchDto;
import com.prography.playeasy.match.domain.dtos.request.MatchPostRequestDto;
import com.prography.playeasy.match.domain.models.Match;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

//생성 수정 logic
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
    public List<MatchDto> retrieveMatch(String date) throws IOException {


        return this.matchDao.retrieve(date);
    }






//반환형을 MatchDto가 아닌 Match
    public Match detailMatch(int MatchId) throws IOException {

            return this.matchDao.findById(MatchId);
    }

    public int closeMatch(int matchId){

        return this.matchDao.closeMatch(matchId);

    }

    //horizontal recyclerview에서 선택한 날짜의 매치 정보 가져오기
//동기에서 Asnc 른 비동기를 호출하니 굳이 비동기식 코드를 짤 필요가 없다 callback을 쓰면 괜히 코드만 어려워
//    public Match retrieveMatch(MatchResponseCallback callback) {
//
//        Call<List<MatchDto>> call = matchClient.getMatchList(,"AVAILABLE");
//
//    }






//    public void reviseMatch() 도 구현해야 함 규산's 컨펌 받
}
