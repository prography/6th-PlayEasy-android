package com.prography.playeasy.main.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.prography.playeasy.R;
import com.prography.playeasy.lib.HorizontalCalendarManger;
import com.prography.playeasy.match.activity.MatchCreate;
import com.prography.playeasy.mypage.activity.Mypage;
import com.prography.playeasy.util.UIHelper;

import java.util.Calendar;

import devs.mulham.horizontalcalendar.HorizontalCalendar;
import devs.mulham.horizontalcalendar.utils.HorizontalCalendarListener;


public class Main extends AppCompatActivity {

    private HorizontalCalendar horizontalCalendar;
    //매치 화면 정보 받아오는 화면인데 아직 구현 안됨
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_custom);

        UIHelper.hideWindow(this);
        UIHelper.toolBarInitialize(this, findViewById(R.id.MainToolbar));
        UIHelper.bottomNavigationInitialize(this, findViewById(R.id.bottomNavigation));

        HorizontalCalendarManger.initialize(this, new HorizontalCalendarListener() {
            @Override
            public void onDateSelected(Calendar date, int position) {

            }
        });
    }
}
