package com.prography.playeasy.main.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.menu.ListMenuItemView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.CalendarView;

import com.prography.playeasy.R;
import com.prography.playeasy.lib.TokenManager;
import com.prography.playeasy.match.domain.MatchDao;
import com.prography.playeasy.match.domain.dtos.LocationDto;
import com.prography.playeasy.match.domain.dtos.request.MatchPostRequestDto;
import com.prography.playeasy.match.domain.dtos.response.MatchListDto;
import com.prography.playeasy.match.domain.models.Match;
import com.prography.playeasy.match.module.view.MatchRecyclerAdapter;
import com.prography.playeasy.mypage.activity.MyPage;
import com.prography.playeasy.util.UIHelper;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import devs.mulham.horizontalcalendar.HorizontalCalendar;
import devs.mulham.horizontalcalendar.HorizontalCalendarView;
import devs.mulham.horizontalcalendar.utils.HorizontalCalendarListener;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class Main extends AppCompatActivity {

    private static final String TAG = "JWT_TOKEN";
    private HorizontalCalendar horizontalCalendar;

    List<Match> matchList;
    MatchDao matchDao;

    //매치 화면 정보 받아오는 화면인데 아직 구현 안됨
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_custom);
        matchList=new ArrayList<Match>();
        Log.d("jwt token",TokenManager.get(getApplicationContext()));
        matchDao=new MatchDao(TokenManager.get(getApplicationContext()));
//step 1
        BeforeLoginMain.getCurrentDayMatch();

        try {
            matchList = BeforeLoginMain.createSampleMatch();
        } catch (ParseException e) {
            e.printStackTrace();
        }


        UIHelper.hideWindow(this);
        UIHelper.toolBarInitialize(this, findViewById(R.id.MainToolbar));
        UIHelper.bottomNavigationInitialize(this, findViewById(R.id.bottomNavigation));

        /* starts before 1 month from now */
        Calendar startDate = Calendar.getInstance();
        //set current day month year
        startDate.add(Calendar.MONTH, -1);
        HorizontalCalendarView calendarView = (HorizontalCalendarView) findViewById(R.id.calendarViewMain);
        /* ends after 1 month from now */
        Calendar endDate = Calendar.getInstance();
        endDate.add(Calendar.MONTH, 1);

        HorizontalCalendar horizontalCalendar = new HorizontalCalendar.Builder(this, R.id.calendarViewMain)
                .range(startDate, endDate)
                .datesNumberOnScreen(5)
                .build();
//step 2


        horizontalCalendar.setCalendarListener(new HorizontalCalendarListener() {
            @Override
            public void onDateSelected(Calendar date, int position) {
                String tempDateSend;
                int day = date.get(Calendar.DAY_OF_MONTH);
                int month = date.get(Calendar.MONTH) + 1;
                int year = date.get(Calendar.YEAR);
                Log.d("day, month, year", String.valueOf(day) + String.valueOf(month) + String.valueOf(year));
                if (month <= 9) {
                    tempDateSend = year + "-0" + month + "-" + day;

                } else {
                    tempDateSend = year + "-" + month + "-" + day;
                }
                Log.d("temp", tempDateSend);


                String pattern = "yyyy-MM-dd";
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);


                try {
                    matchDao.retrieve(simpleDateFormat.parse(tempDateSend), new Callback<MatchListDto>() {
                        @Override
                        public void onResponse(Call<MatchListDto> call, Response<MatchListDto> response) {
                            matchList = response.body().getMatchList();;
                            Log.d("response",response.body().toString());
                            Log.d("list", String.valueOf(matchList));
                            Log.d("response",response.body().getMatchList().toString());
                            matchList = response.body().getMatchList();
                            adaptRecyclerView(matchList);
                        }

                        @Override
                        public void onFailure(Call<MatchListDto> call, Throwable t) {
                            Log.d("통신 실패","");
                        }
                    });
                } catch (ParseException e) {
                    e.printStackTrace();
                }
//todo



            }
        });


    }

    private void adaptRecyclerView(List<Match> matchList) {
        RecyclerView recyclerView = findViewById(R.id.MainRecycler);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        MatchRecyclerAdapter adapter = new MatchRecyclerAdapter();
        recyclerView.setAdapter(adapter);

        for (Match m : matchList) {
            adapter.addItems(m);
        }
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.myPageNavigatation:
                Intent movedMypage = new Intent(this, MyPage.class);
                startActivity(movedMypage);
                break;

        }
        return super.onOptionsItemSelected(item);
    }


}
