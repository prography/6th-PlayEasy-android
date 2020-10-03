package com.prography.playeasy.api;

import android.util.Log;

import com.prography.playeasy.match.domain.MatchDao;
import com.prography.playeasy.match.domain.dtos.LocationDto;
import com.prography.playeasy.match.domain.dtos.MatchNoIdDto;
import com.prography.playeasy.match.domain.dtos.request.MatchPostRequestDto;
import com.prography.playeasy.match.domain.dtos.response.MatchCreateResponseDto;
import com.prography.playeasy.match.domain.dtos.response.MatchDetailDto;
import com.prography.playeasy.match.domain.dtos.response.MatchListDto;
import com.prography.playeasy.match.domain.models.Match;

import org.junit.Test;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class MatchDaoUnitTest extends BaseDaoUnitTest {

    @Test
    public void createMatchTest() {
        Date date = new Date();
        MatchNoIdDto matchData = new MatchNoIdDto("FOOTSAL6", "축구뜨자", date, 120, 3000, "010-9165-6918", 6);

       // LocationDto locationData = new LocationDto(37.5091105328378f, 127.04892851392f, "서울 선릉과 정릉", "서울 강남구 삼성동 131", "코엑스");
        LocationDto locationData = new LocationDto(3.14f, 7.77f, "마루 180", "강남구", "마루 경기장");
        //MatchPostRequestDto matchPostRequestDto = new MatchPostRequestDto(matchData, locationData);
        new MatchDao(FAKE_TOKEN).create(locationData,matchData, new Callback<MatchCreateResponseDto>() {
            @Override
            public void onResponse(Call<MatchCreateResponseDto> call, Response<MatchCreateResponseDto> response) {
                assertEquals(null, response.body());
                assertEquals(null, response.body().getMatch().getLocation());
                System.out.println(response.body().getMatch().getLocation());

        LocationDto locationData = new LocationDto(37.5091105328378f, 127.04892851392f, "서울 선릉과 정릉", "서울 강남구 삼성동 131", "코엑스");

        //MatchPostRequestDto matchPostRequestDto = new MatchPostRequestDto(matchData, locationData);
        new MatchDao(FAKE_TOKEN).create(matchData,locationData, new Callback<MatchCreateResponseDto>() {
            @Override
            public void onResponse(Call<MatchCreateResponseDto> call, Response<MatchCreateResponseDto> response) {
                assertEquals(null, response.body());
                assertEquals(null, response.body());
                System.out.println(response.body().toString());

                Log.d("Location ",locationData.getAddress());
            }

            @Override
            public void onFailure(Call<MatchCreateResponseDto> call, Throwable t) {
                Log.e("Error", t.getMessage());
            }
        });
    }

    @Test
    public void retrieveTest() {
        new MatchDao(FAKE_TOKEN).retrieve(new Date(), new Callback<MatchListDto>() {
            @Override
            public void onResponse(Call< MatchListDto> call, Response<MatchListDto> response) {
                    List<Match> compareList = new ArrayList<Match>(5);
                assertEquals(response.body().getMatchList(), compareList);
            }

            @Override
            public void onFailure(Call<MatchListDto> call, Throwable t) {
                Log.e("Error", t.getMessage());
            }
        });
    }

    @Test
    public void getMatchTest() {
        new MatchDao(FAKE_TOKEN).findById(1, new Callback<MatchDetailDto>() {
            @Override
            public void onResponse(Call<MatchDetailDto> call, Response<MatchDetailDto> response) {
                assertEquals(null, response.body());
            }

            @Override
            public void onFailure(Call<MatchDetailDto> call, Throwable t) {
                Log.e("Error", t.getMessage());
            }
        });
    }

}
