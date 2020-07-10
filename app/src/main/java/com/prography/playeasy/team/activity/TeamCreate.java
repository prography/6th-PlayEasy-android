package com.prography.playeasy.team.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.prography.playeasy.R;
import com.prography.playeasy.mypage.activity.MyInformation;
import com.prography.playeasy.util.UIHelper;

public class TeamCreate extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team_createteam);

        UIHelper.toolBarInitialize(this,findViewById(R.id.teamCreateToolBar));
        UIHelper.hideWindow(this);

        initialized();
    }

    private void initialized() {

        findViewById(R.id.teamCreateCancelButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), TeamSelect.class);
                startActivity(intent);
            }
        });
        findViewById(R.id.teamCreateButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MyInformation.class);
                startActivity(intent);
            }
        });
    }
}
