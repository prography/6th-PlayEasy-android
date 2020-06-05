package com.prography.playeasy.match.util;

import com.prography.playeasy.match.domain.Match;

import java.util.List;

public interface MatchResponseCallback {
    void onSuccess(Object responseData);
    void onError();
}
