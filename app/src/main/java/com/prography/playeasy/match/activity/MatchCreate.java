package com.prography.playeasy.match.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
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
import com.prography.playeasy.lib.TokenManager;
import com.prography.playeasy.main.activity.Main;
import com.prography.playeasy.match.domain.MatchDao;
import com.prography.playeasy.match.domain.dtos.LocationDto;
import com.prography.playeasy.match.domain.dtos.MatchDto;
import com.prography.playeasy.match.domain.dtos.request.MatchPostRequestDto;
import com.prography.playeasy.match.domain.dtos.response.MatchDetailDto;
import com.prography.playeasy.match.service.MatchService;
import com.prography.playeasy.util.PlayeasyServiceFactory;
import com.prography.playeasy.util.UIHelper;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import devs.mulham.horizontalcalendar.HorizontalCalendar;
import devs.mulham.horizontalcalendar.HorizontalCalendarView;
import devs.mulham.horizontalcalendar.utils.HorizontalCalendarListener;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MatchCreate extends AppCompatActivity {

    private TimePicker sTimePicker;
    private TimePicker eTimePicker;
    //private HorizontalCalendarManager calendarCreate;
    private HorizontalCalendar horizontalCalendar;
    LocationDto locationDto;
    MatchPostRequestDto matchSample;
    MatchDto matchDto;
    MatchDao match;
    Date date;
    String tempDateSend;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_match_create);
        match=new MatchDao(TokenManager.get(getApplicationContext()));
        UIHelper.hideWindow(this);
        UIHelper.toolBarInitialize(this, findViewById(R.id.matchCreateToolBar));
//calenderview 객체화하는 방식 Main.java와 동일
        HorizontalCalendarView horizontalCalendarView = (HorizontalCalendarView) findViewById(R.id.calendarViewMatchCreate);
        Calendar startDate = Calendar.getInstance();
        //set current day month year
        startDate.add(Calendar.MONTH, -1);
        /* ends after 1 month from now */
        Calendar endDate = Calendar.getInstance();
        endDate.add(Calendar.MONTH, 1);


        HorizontalCalendar horizontalCalendar = new HorizontalCalendar.Builder(this, R.id.calendarViewMatchCreate)
                .range(startDate, endDate).datesNumberOnScreen(5).build();
        horizontalCalendar.setCalendarListener(new HorizontalCalendarListener() {
            @Override
            public void onDateSelected(Calendar date, int position) {

                int day = date.get(Calendar.DAY_OF_MONTH);
                int month = date.get(Calendar.MONTH) + 1;
                int year = date.get(Calendar.YEAR);
                if (month <= 9) {
                    tempDateSend = year + "-0" + month + "-" + day;

                } else {
                    tempDateSend = year + "-" + month + "-" + day;
                }

            }
        });

        String dumstrDate = "2020-07-13T23:20:00.123Z";


//2020-07-12T20:00:00.000Z
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        try {
            date = sdf.parse(dumstrDate);
            Log.d("날짜 형식 보자", String.valueOf(date));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        MatchDto matchData = new MatchDto("SOCCER", "허", date, 180, 3000, "000-0000-0000", 11);
        LocationDto locationData = new LocationDto(3.14f, 7.77f, "리버", "서울특별시 강남구 ~~", "마루180 1경기장");

        matchSample = new MatchPostRequestDto(matchData, locationData);
//todo
        //        try {
//            match.create(matchSample);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        /*TimePicker*/
        sTimePicker = findViewById(R.id.timePickerStart);
        eTimePicker = findViewById(R.id.timePickerEnd);


        findViewById(R.id.matchMap).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), MapPopUp.class);
                startActivity(intent);

            }
        });

    }




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
                match.create(matchSample, new Callback<MatchDetailDto>() {
                    @Override
                    public void onResponse(Call<MatchDetailDto> call, Response<MatchDetailDto> response) {
                        //don't get any response
                        Log.d("checking response data ", String.valueOf(response.body()));

                    }

                    @Override
                    public void onFailure(Call<MatchDetailDto> call, Throwable t) {
                        Log.d("매치 생성 실패","");
                    }
                });
                Intent writeBack = new Intent(this, Main.class);

                startActivity(writeBack);


                return true;

        }
        return super.onOptionsItemSelected(item);
    }

}
