package com.prography.playeasy.main.activity;

import androidx.appcompat.app.AppCompatActivity;
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
import com.prography.playeasy.match.domain.dtos.MatchDto;
import com.prography.playeasy.match.module.view.MatchRecyclerAdapter;
import com.prography.playeasy.mypage.activity.MyPage;
import com.prography.playeasy.util.UIHelper;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import devs.mulham.horizontalcalendar.HorizontalCalendar;
import devs.mulham.horizontalcalendar.HorizontalCalendarView;
import devs.mulham.horizontalcalendar.utils.HorizontalCalendarListener;




public class Main extends AppCompatActivity {

    private static final String TAG = "JWT_TOKEN";
    private HorizontalCalendar horizontalCalendar;

    List<MatchDto> matchList;
    MatchDao matchDao;
    //매치 화면 정보 받아오는 화면인데 아직 구현 안됨
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_custom);


//step 1
        BeforeLoginMain.getCurrentDayMatch();





        UIHelper.hideWindow(this);
        UIHelper.toolBarInitialize(this, findViewById(R.id.MainToolbar));
        UIHelper.bottomNavigationInitialize(this, findViewById(R.id.bottomNavigation));

        /* starts before 1 month from now */
        Calendar startDate = Calendar.getInstance();
        //set current day month year
        startDate.add(Calendar.MONTH, -1);
        HorizontalCalendarView calendarView=(HorizontalCalendarView)findViewById(R.id.calendarView);
        /* ends after 1 month from now */
        Calendar endDate = Calendar.getInstance();
        endDate.add(Calendar.MONTH, 1);

        HorizontalCalendar horizontalCalendar = new HorizontalCalendar.Builder(this, R.id.calendarView)
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

                    Log.d("temp",tempDateSend);


//                    SimpleDateFormat transFormat = new SimpleDateFormat("yyyy-MM-dd");
//
//                    Date to = transFormat.parse(tempDateSend);


                try {
                    matchList=  matchDao.retrieve(tempDateSend);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                adaptRecyclerView(matchList);


            }
        }     );










    }
    private void adaptRecyclerView(List<MatchDto> matchList) {
        RecyclerView recyclerView = findViewById(R.id.MainRecycler);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        MatchRecyclerAdapter adapter = new MatchRecyclerAdapter();
        recyclerView.setAdapter(adapter);

        for (MatchDto m : matchList) {
            adapter.addItems(m);
        }
    }



    @Override
    public boolean onOptionsItemSelected (MenuItem item)
    {
        switch(item.getItemId())
        {
            case R.id.myPageNavigatation:
                Intent movedMypage = new Intent(this, MyPage.class);
                startActivity(movedMypage);
                break;

        }
        return super.onOptionsItemSelected(item);
    }



}
