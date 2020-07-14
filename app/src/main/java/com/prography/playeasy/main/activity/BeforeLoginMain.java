package com.prography.playeasy.main.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.prography.playeasy.R;
import com.prography.playeasy.login.activity.LoginActivity;
import com.prography.playeasy.match.domain.MatchDao;
import com.prography.playeasy.match.domain.dtos.MatchDto;
import com.prography.playeasy.match.domain.models.Match;
import com.prography.playeasy.match.module.view.MatchRecyclerAdapter;
import com.prography.playeasy.match.util.MatchResponseCallback;
import com.prography.playeasy.util.UIHelper;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import devs.mulham.horizontalcalendar.HorizontalCalendar;
import devs.mulham.horizontalcalendar.utils.HorizontalCalendarListener;

public class BeforeLoginMain extends AppCompatActivity {

    private HorizontalCalendar horizontalCalendar;
    //매치 화면 정보 받아오는 화면인데 아직 구현 안됨

    Handler handler = new Handler();

    // API 응답이 성공으로 온 다음 렌더링을 실행할 콜백 인터페이스
    MatchResponseCallback callback = new MatchResponseCallback(){
        // API 실행이 성공일 때 실행
        @Override
        public void onSuccess(Object responseData) {
            // 응답 데이터 변환
            List<Match> matchList = (List<Match>)responseData;
            // 리사이클러뷰 렌더링
            adaptRecyclerView(matchList);
        }

        @Override
        public void onError() {

        }
    };
    Runnable run = new Runnable() {
        @Override
        public void run() {
            Intent intent  = new Intent(getApplicationContext(), LoginActivity.class);
            startActivity(intent);
            overridePendingTransition(R.anim.fade_in,R.anim.fade_out);
            finish();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_beforelogin);
        List<MatchDto> targetdateList = null;
        //현재 날짜 리스트 뿌리기

        //선택한 날짜 리스트 뿌리기

//       adaptRecyclerView(targetdateList);
        UIHelper.hideWindow(this);
        UIHelper.toolBarInitialize(this, findViewById(R.id.MainToolbar));

        /* starts before 1 month from now */
        Calendar startDate = Calendar.getInstance();
        startDate.add(Calendar.MONTH, -1);

        /* ends after 1 month from now */
        Calendar endDate = Calendar.getInstance();
        endDate.add(Calendar.MONTH, 1);

        HorizontalCalendar horizontalCalendar = new HorizontalCalendar.Builder(this, R.id.calendarView)
                .range(startDate, endDate)
                .datesNumberOnScreen(5)
                .build();

        horizontalCalendar.setCalendarListener(new HorizontalCalendarListener() {
            @Override
            public void onDateSelected(Calendar date, int position) {
                //do something
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        handler.postDelayed(run, 2500);
    }

    @Override
    protected void onPause() {
        super.onPause();
        handler.removeCallbacks(run);
    }

//카드뷰와 activity_main_custom에 Binding 의 대상이 있어야 함?
//chohee 에서 initReecyclerVIew() method의 역할을 한
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

    public static void getCurrentDayMatch(){
        Date currentDate=new Date();
        String pattern = "yyyy-MM-dd";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

        String date = simpleDateFormat.format(currentDate);

        Log.d("현재 날짜 ", date);


    }
    public static List<Match> createSampleMatch() throws ParseException {

        List<Match> matchArr = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//
//        matchArr.add(new Match(28,"SOCCER", "축구뜨자", sdf.parse("2020-07-11"), 180, 3000, "010-9165-6918", 11));
//        matchArr.add(new Match(1,"FOOTSAL5", "풋살 즐기", sdf.parse("2020-07-12"), 180, 5000, "010-916/5-6918", 5));
       return matchArr;
    }

}
