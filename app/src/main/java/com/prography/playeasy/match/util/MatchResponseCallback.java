package com.prography.playeasy.match.util;

import com.prography.playeasy.match.domain.Match;

import java.util.List;

public interface MatchResponseCallback {
    void onSuccess(List<Match> matchList);
    void onError();
}
