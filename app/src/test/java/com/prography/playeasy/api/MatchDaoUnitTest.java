package com.prography.playeasy.api;

import android.util.Log;

import com.prography.playeasy.match.domain.MatchDao;
import com.prography.playeasy.match.domain.dtos.request.MatchPostRequestDto;
import com.prography.playeasy.match.domain.models.Match;

import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class MatchDaoUnitTest extends BaseDaoUnitTest {

    @Test
    public void createMatchTest() {
        try {
            MatchPostRequestDto matchPostRequestDto = new MatchPostRequestDto();
            Match match = new MatchDao(FAKE_TOKEN).create(matchPostRequestDto);
            assertEquals(null, match);
        } catch (IOException e) {
            Log.d("Error", e.getMessage());
        }
    }

    @Test
    public void retrieveTest() {
        try {
            List<Match> matchList = new MatchDao(FAKE_TOKEN).retrieve();
            List<Match> compareList = new ArrayList<Match>(5);
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
