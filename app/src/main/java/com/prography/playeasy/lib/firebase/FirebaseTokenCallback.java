package com.prography.playeasy.lib.firebase;

public interface FirebaseTokenCallback {
    void onSuccess(String callbackData);
    void onError();
}
