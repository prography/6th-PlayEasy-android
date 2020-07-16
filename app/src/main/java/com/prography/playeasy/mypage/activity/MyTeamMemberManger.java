package com.prography.playeasy.mypage.activity;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.prography.playeasy.R;
import com.prography.playeasy.util.UIHelper;

public class MyTeamMemberManger extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mypage_myteammembermanger);

        UIHelper.toolBarInitialize(this, findViewById(R.id.TeamMemberToolbar));
        UIHelper.hideWindow(this);
    }
}
