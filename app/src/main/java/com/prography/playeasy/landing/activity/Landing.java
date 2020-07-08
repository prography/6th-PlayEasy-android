package com.prography.playeasy.landing.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.prography.playeasy.R;
import com.prography.playeasy.login.activity.LoginActivity;
import com.prography.playeasy.util.UIHelper;

public class Landing extends AppCompatActivity {

    Handler handler = new Handler();

    Runnable run = new Runnable() {
        @Override
        public void run() {
            Intent intent  = new Intent(getApplicationContext(), LoginActivity.class);
            startActivity(intent);
            overridePendingTransition(R.anim.fade_in,R.anim.fade_out);
            finish();
        }
    };


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing);
        UIHelper.hideWindow(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        handler.postDelayed(run, 2500);
    }

    @Override
    protected void onPause() {
        super.onPause();
        handler.removeCallbacks(run);
    }
}
