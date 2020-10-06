package com.prography.playeasy.application;

import android.app.Application;

import com.prography.playeasy.lib.firebase.FirebaseManager;
import com.prography.playeasy.lib.KakaoSdkManager;
import com.prography.playeasy.lib.firebase.FirebaseTokenCallback;

public class PlayeasyApplication extends Application {
    public static String TOKEN;

    @Override
    public void onCreate() {
        super.onCreate();

        KakaoSdkManager.initialize(this);
        FirebaseManager.initialize(this.getApplicationContext(), new FirebaseTokenCallback(){
            @Override
            public void onSuccess(String callbackData) {
                TOKEN = callbackData;
            }

            @Override
            public void onError() {

            }
        });
    }
}
