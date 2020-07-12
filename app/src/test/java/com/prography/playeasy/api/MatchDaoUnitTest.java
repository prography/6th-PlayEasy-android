package com.prography.playeasy.api;

import android.util.Log;
import com.prography.playeasy.match.domain.MatchDao;
import com.prography.playeasy.match.domain.dtos.LocationDto;
import com.prography.playeasy.match.domain.dtos.MatchDto;
import com.prography.playeasy.match.domain.dtos.request.MatchPostRequestDto;
import com.prography.playeasy.match.domain.dtos.request.MatchRequestDto;
import com.prography.playeasy.match.domain.models.Match;

import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class MatchDaoUnitTest extends BaseDaoUnitTest {

    @Test
    public void createMatchTest() {
        try {
            Date date=new Date();
            MatchRequestDto matchData=new MatchRequestDto("FOOTSAL6" ,"축구뜨자",date,120,3000,"010-9165-6918",6);
            LocationDto locationData=new LocationDto(3.14f,7.77f,"마루 180","강남구","마루 경기장");
            MatchPostRequestDto matchPostRequestDto = new MatchPostRequestDto(matchData,locationData);

//                        "type": "FUTSAL6",
//                        "description": "[수정] 6대6 풋살 하실 팀 구합니다!!",
//
//                        "duration": 240,
//                        "fee": 3500,
//                        "phone": "010-0000-0000",
//                        "totalQuota": 6
//            },
//            "locationData": {
//                "id": 1,
//                        "latitude": 3.14,
//                        "longitude": 1.5,
//                        "name": "마루180",
//                        "address": "서울특별시 강남구 ~~",
//                        "detail": "마루180 7경기장"
//            }
            Match match = new MatchDao(FAKE_TOKEN).create(matchPostRequestDto);
            assertEquals(null, match);
        } catch (IOException e) {
            Log.d("Error", e.getMessage());
        }
    }

    @Test
    public void retrieveTest() {
        try {
            List<MatchDto> matchList = new MatchDao(FAKE_TOKEN).retrieve(new Date());

            List<MatchDto> compareList = new ArrayList<MatchDto>(5);
            assertArrayEquals(matchList.toArray(), compareList.toArray());
        } catch (IOException e) {
            Log.d("Error", e.getMessage());
        }
    }

    @Test
    public void getMatchTest() {
        try {
            Match match = new MatchDao(FAKE_TOKEN).findById(1);
            assertEquals(null, match);
        } catch (IOException e) {
            Log.d("Error", e.getMessage());
        }
    }

}
