package com.prography.playeasy.match.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CalendarView;
import android.widget.Spinner;
import android.widget.TimePicker;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.prography.playeasy.R;
import com.prography.playeasy.lib.HorizontalCalendarManager;
import com.prography.playeasy.main.activity.Main;
import com.prography.playeasy.match.domain.MatchDao;
import com.prography.playeasy.match.domain.dtos.LocationDto;
import com.prography.playeasy.match.domain.dtos.MatchDto;
import com.prography.playeasy.match.domain.dtos.request.MatchPostRequestDto;
import com.prography.playeasy.match.service.MatchService;
import com.prography.playeasy.util.PlayeasyServiceFactory;
import com.prography.playeasy.util.UIHelper;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

import devs.mulham.horizontalcalendar.utils.HorizontalCalendarListener;

public class MatchCreate extends AppCompatActivity {

    private TimePicker sTimePicker;
    private TimePicker eTimePicker;
    private HorizontalCalendarManager calendarCreate;

    LocationDto locationDto;

    MatchDto matchDto;
    MatchDao match;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_match_create);

        UIHelper.hideWindow(this);
        UIHelper.toolBarInitialize(this, findViewById(R.id.matchCreateToolBar));

        calendarCreate.initialize(this, new HorizontalCalendarListener() {
            @Override
            public void onDateSelected(Calendar date, int position) {

            }

        });
        MatchDto matchData= new MatchDto("SOCCER", "축구뜨자", new Date("2020-07-12T20:00:00.000Z"), 180, 3000, "000-0000-0000", 11);
        LocationDto locationData=new LocationDto(3.14f,7.77f,"마루180","서울특별시 강남구 ~~","마루180 1경기장");

        MatchPostRequestDto matchSample=new MatchPostRequestDto(matchData,locationData);
        try {
            match.create(matchSample);
        } catch (IOException e) {
            e.printStackTrace();
        }

        /*TimePicker*/
        sTimePicker = findViewById(R.id.timePickerStart);
        eTimePicker = findViewById(R.id.timePickerEnd);




    }

//        findViewById(R.id.matchCreateConfirm).setOnClickListener((v) -> {
//            MatchRequestDto requestDto = new MatchRequestDto(
//                    ((EditText)findViewById(R.id.matchCreateTitle)).getText().toString(),
//                    ((EditText)findViewById(R.id.matchCreateType)).getText().toString(),
//                    ((EditText)findViewById(R.id.matchCreateDescription)).getText().toString(),
//                    ((EditText)findViewById(R.id.matchCreateLocation)).getText().toString(),
//                    Integer.valueOf(((EditText)findViewById(R.id.matchCreateFee)).getText().toString()),
//                    new Date(),
//                    new Date(),
//                    Integer.valueOf(((EditText)findViewById(R.id.matchCreateHomeQuota)).getText().toString())
//            );

//            MatchService service = PlayeasyServiceFactory.getInstance(MatchService.class);
//         //   service.createMatch(requestVO, this.getApplicationContext());
//        });
//    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.write_confirm, menu);
       // MatchPostRequestDto requestVO = new MatchPostRequestDto();

       // service.createMatch(requestVO, this.getApplicationContext());

        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.createMatch:
                Intent writeBack = new Intent(this, Main.class);
                startActivity(writeBack);


                return true;

        }
        return super.onOptionsItemSelected(item);
    }

}
