package com.prography.playeasy.push.activity;

import android.os.Bundle;
import android.widget.Switch;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import com.prography.playeasy.R;
import com.prography.playeasy.lib.SettingManager;

import com.prography.playeasy.mypage.module.view.listener.SwitchListener;
import com.prography.playeasy.util.UIHelper;

import java.util.ArrayList;
import java.util.List;

public class Push extends AppCompatActivity {

    private Switch matchAlarm;
    private Switch scoutAlarm;

    private List<Switch> alarmSwitches;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mypage_push);
        UIHelper.toolBarInitialize(this,findViewById(R.id.pushToolbar));
        UIHelper.hideWindow(this);

        initialized();

        setSavedSetting();
    }

    private void setListenerAllSwitch() {
        alarmSwitches.forEach(s -> s.setOnCheckedChangeListener(new SwitchListener()));
    }

    private void setSavedSetting() {

        for (Switch s : alarmSwitches) {
            s.setChecked(SettingManager.get(getApplicationContext(),
                    getResources().getResourceName(s.getId())));
        }
    }

    private void initialized() {
        matchAlarm = findViewById(R.id.matchAlarm);
        scoutAlarm = findViewById(R.id.scoutAlarm);

        alarmSwitches = new ArrayList<>();

        alarmSwitches.add(matchAlarm);
        alarmSwitches.add(scoutAlarm);
    }
}


