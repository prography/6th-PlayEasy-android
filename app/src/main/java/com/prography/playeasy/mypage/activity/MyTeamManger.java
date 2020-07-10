package com.prography.playeasy.mypage.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;
import com.prography.playeasy.R;
import com.prography.playeasy.util.UIHelper;

public class MyTeamManger extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mypage_myteammanger);

        UIHelper.toolBarInitialize(this, findViewById(R.id.myTeamMangerToolBar));
        UIHelper.hideWindow(this);

        initialized();
    }

    private void initialized() {
        findViewById(R.id.myPageTeamMangerModifyButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MyPage.class);
                startActivity(intent);
            }
        });
        findViewById(R.id.myPageTeamMangerCancelButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MyPage.class);
                startActivity(intent);
            }
        });

        findViewById(R.id.myPageMyteamMangerPlayerShowButton).setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MyTeamMemberManger.class);
                startActivity(intent);
            }
        });
    }
}
