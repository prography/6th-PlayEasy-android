package com.prography.playeasy.match.activity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.prography.playeasy.R;
import com.prography.playeasy.lib.HorizontalCalendarManger;
import com.prography.playeasy.main.activity.Main;
import com.prography.playeasy.match.domain.MatchRequestVO;
import com.prography.playeasy.match.service.MatchService;
import com.prography.playeasy.util.PlayeasyServiceFactory;
import com.prography.playeasy.util.UIHelper;

import java.util.Calendar;
import java.util.Date;

import devs.mulham.horizontalcalendar.HorizontalCalendar;
import devs.mulham.horizontalcalendar.utils.HorizontalCalendarListener;

public class MatchCreate extends AppCompatActivity {


    private TimePicker sTimePicker;
    private TimePicker eTimePicker;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_match_create);

        UIHelper.hideWindow(this);
        UIHelper.toolBarInitialize(this, findViewById(R.id.matchCreateToolBar));

        initialized();
        /*findViewById(R.id.matchCreateConfirm).setOnClickListener((v) -> {
            MatchRequestVO requestVO = new MatchRequestVO(
                    ((EditText)findViewById(R.id.matchCreateTitle)).getText().toString(),
                    ((EditText)findViewById(R.id.matchCreateType)).getText().toString(),
                    ((EditText)findViewById(R.id.matchCreateDescription)).getText().toString(),
                    ((EditText)findViewById(R.id.matchCreateLocation)).getText().toString(),
                    Integer.valueOf(((EditText)findViewById(R.id.matchCreateFee)).getText().toString()),
                    new Date(),
                    new Date(),
                    Integer.valueOf(((EditText)findViewById(R.id.matchCreateHomeQuota)).getText().toString())
            );

            MatchService service = PlayeasyServiceFactory.getInstance(MatchService.class);
            service.createMatch(requestVO, this.getApplicationContext());
        });*/
    }

    private void initialized() {
        // 도메인 시 날짜 받아오는거 매개변수로 넣어주라 ~
        HorizontalCalendarManger.initialize(this, new HorizontalCalendarListener() {
            @Override
            public void onDateSelected(Calendar date, int position) {
                //do something
            }
        });


        /*Timepicker*/
        sTimePicker = findViewById(R.id.timePickerStart);
        eTimePicker = findViewById(R.id.timePickerEnd);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.write_confirm, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected (MenuItem item)
    {
        switch(item.getItemId())
        {
            case R.id.toolbar_next_button:
                Intent writeBack = new Intent(this, Main.class);
                startActivity(writeBack);
                return true;

        }
        return super.onOptionsItemSelected(item);
    }
}
