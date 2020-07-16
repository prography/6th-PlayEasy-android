package com.prography.playeasy.match.activity;

import android.content.Context;
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
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.prography.playeasy.R;
import com.prography.playeasy.lib.HorizontalCalendarManager;
import com.prography.playeasy.lib.TokenManager;
import com.prography.playeasy.main.activity.Main;
import com.prography.playeasy.match.domain.MatchDao;
import com.prography.playeasy.match.domain.dtos.LocationDto;
import com.prography.playeasy.match.domain.dtos.MatchNoIdDto;
import com.prography.playeasy.match.domain.dtos.request.MatchPostRequestDto;
import com.prography.playeasy.match.domain.dtos.response.MapResponseDto;
import com.prography.playeasy.match.domain.dtos.response.MatchCreateMapResponseDto;
import com.prography.playeasy.match.domain.dtos.response.MatchCreateResponseDto;
import com.prography.playeasy.match.domain.dtos.response.MatchDetailDto;
import com.prography.playeasy.match.service.MatchService;
import com.prography.playeasy.util.PlayeasyServiceFactory;
import com.prography.playeasy.util.UIHelper;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

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
    MatchDao match;
    int duration;
    private int fee;
    int totalQuota;
    Date startAt;
    Calendar startDate;
    String tempDateSend;
    String timeStartHour;
    String timeStartMin;
    String timeEndHour;
    String timeEndMin;
    Spinner spinner;
    String matchType;
    //todo Map
    EditText matchMap;
    EditText matchDetailMap;
    private EditText matchFee;
    EditText needPeople;
    EditText matchPhoneNumber;

    EditText description;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_match_create);
        match = new MatchDao(TokenManager.get(getApplicationContext()));
        UIHelper.hideWindow(this);
        UIHelper.toolBarInitialize(this, findViewById(R.id.matchCreateToolBar));
//calenderview 객체화하는 방식 Main.java와 동일
        HorizontalCalendarView horizontalCalendarView = (HorizontalCalendarView) findViewById(R.id.calendarViewMatchCreate);
         startDate = Calendar.getInstance();
        //set current day month year
        startDate.add(Calendar.MONTH, -1);
        /* ends after 1 month from now */
        Calendar endDate = Calendar.getInstance();
        endDate.add(Calendar.MONTH, 1);
//Spinner findViewById
        spinner = findViewById(R.id.matchTypeSpinner);


      //  spinner.setAdapter(new ArrayAdapter(this,R.layout.support_simple_spinner_dropdown_item));
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                 //setItem=(String)spinner.getSelectedItem();
                matchType= (String) spinner.getItemAtPosition(position);
                Log.d("Spinner 아이템", matchType);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Toast.makeText(getApplicationContext(), "경기 방식을 선택해주세요", Toast.LENGTH_SHORT).show();
            }
        });


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

                Log.d("매치 작성 페이지",tempDateSend);
            }
        });

//        String dumstrDate = "2020-07-13T23:20:00.123Z";


//2020-07-12T20:00:00.000Z
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
//        try {
//            date = sdf.parse(dumstrDate);
//            Log.d("날짜 형식 보자", String.valueOf(date));
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//        MatchNoIdDto matchData = new MatchNoIdDto("SOCCER", "허", date, 180, 3000, "000-0000-0000", 11);
//        LocationDto locationData = new LocationDto(3.14f, 7.77f, "리버", "서울특별시 강남구 ~~", "마루180 1경기장");
//
//        matchSample = new MatchPostRequestDto(matchData, locationData);
//todo
        //        try {
//            match.create(matchSample);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        /*TimePicker Id*/
        sTimePicker = findViewById(R.id.timePickerStart);
        eTimePicker = findViewById(R.id.timePickerEnd);


        findViewById(R.id.matchMap).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), MapPopUp.class);
                startActivity(intent);

            }
        });

        sTimePicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {

                                                 //AM Pm 값 넘어오지 않고 234시간 type으로 정보 넘어온
                         @Override
                         public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
//                timeStartHour=sTimePicker.getHour()+"";
//                timeStartMin=sTimePicker.getMinute()+"";
                             duration=hourOfDay;
                             Log.d("시간", timeStartHour);
                             if (hourOfDay < 10)
                                 timeStartHour = "0" + hourOfDay;
                             else
                                 timeStartHour = String.valueOf(hourOfDay);
                             if (minute >= 10)
                                 timeStartMin = minute + "";
                             else
                                 timeStartMin = "0" + minute;


                         }
                     }
        );
        eTimePicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
                duration=hourOfDay-duration;
                if(hourOfDay<10){
                    timeEndHour="0"+hourOfDay;
                }else{
                    timeEndHour=String.valueOf(hourOfDay);
                }


                if(minute>=10){
                    timeEndMin=minute+"" ;

                }else{
                    timeEndMin="0"+minute;
                }

            }
        });
//concatenate
        tempDateSend=tempDateSend+"T"+timeStartHour+":"+timeStartMin+"00.000Z";
        Log.d("시간 분  페이지",tempDateSend);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        try {
            startAt=format.parse(tempDateSend);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        matchFee = findViewById(R.id.matchFee);

//         needPeople=(EditText)findViewById(R.id.needPeople);
//         totalQuota=Integer.parseInt(needPeople.getText().toString());
//         matchPhoneNumber=(EditText)findViewById(R.id.matchPhoneNumber);
//         description=(EditText)findViewById(R.id.matchEtc);


       //  HashMap<String,Object> matchCreateRequest=new HashMap<>();
//        makeJSONRequest(matchType,description.getText().toString(),startAt,duration,matchFee.getText().toString(),matchPhoneNumber.getText().toString(),needPeople.getText().toString());
//        matchCreateRequest.put("matchData",makeJSONMatchData(matchType,description.getText().toString(),startAt,duration,fee,matchPhoneNumber.getText().toString(),totalQuota));

//         obj =new MatchPostRequestDto(makeJSONMatchData(matchType,description.getText().toString(),startAt,duration,matchFee.getText().toString(),matchPhoneNumber.getText().toString(),needPeople.getText().toString()),makeJSONLocationData);
//
//        makeMatch(obj,getApplicationContext());

        //matchCreateRequest.put("locationData",makeJSONLocationData(latitude,longitude,name,address,detail));
    }

//Date가 아닌 String으로 처리중 규산 object->HashMap?
    public Object makeJSONMatchData(String type,String description,Date startAt,int duration,int fee,String phone,int totalQuota){


        HashMap<String,Object> hashMapMatch=new HashMap<>();
       //규산 hashMapMatch  자체가 JSONObject인건가 아니면 ㅎGSon().fromJSON()해야 나
        hashMapMatch.put("type",type);
        hashMapMatch.put("description",description);
        hashMapMatch.put("startAt",tempDateSend);
        hashMapMatch.put("duration",duration);
        hashMapMatch.put("fee",fee);
        hashMapMatch.put("phone",phone);
        hashMapMatch.put("totalQuota",totalQuota);

        return hashMapMatch;


    }
    public Object makeJSONLocationData(float latitude, float longitude,String name,String address,String detail) {

        HashMap<String, Object> hashMapLocation = new HashMap<>();
        hashMapLocation.put("latitude", latitude);
        hashMapLocation.put("longitude",longitude);
        hashMapLocation.put("name",name);
        hashMapLocation.put("address",address);
        hashMapLocation.put("detail",detail);
        return hashMapLocation;
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
                match.create(matchSample, new Callback<MatchCreateResponseDto>() {
                    @Override
                    public void onResponse(Call<MatchCreateResponseDto> call, Response<MatchCreateResponseDto> response) {
                        //don't get any response
                        Log.d("checking response data ", String.valueOf(response.body()));


                    }

                    @Override
                    public void onFailure(Call<MatchCreateResponseDto> call, Throwable t) {
                        Log.d("매치 생성 실패", "");

                    }
                });
                Intent writeBack = new Intent(this, Main.class);

                startActivity(writeBack);


                return true;

        }
        return super.onOptionsItemSelected(item);
    }

//    public void getLocationData(LocationDto obj, String key,  Response<MapResponseDto> response){
//        obj=response.
//
//
//        //    1step. server에 key 보내
//
//        //데이터 리스트 받아오고 그 중에 선택
//
//
//
//    }



}
