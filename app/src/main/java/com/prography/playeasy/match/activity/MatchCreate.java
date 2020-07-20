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
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.kakao.network.ErrorResult;
import com.kakao.network.callback.ResponseCallback;
import com.prography.playeasy.R;
import com.prography.playeasy.lib.TokenManager;
import com.prography.playeasy.main.activity.Main;
import com.prography.playeasy.match.domain.MatchDao;
import com.prography.playeasy.match.domain.dtos.LocationDto;
import com.prography.playeasy.match.domain.dtos.MatchNoIdDto;
import com.prography.playeasy.match.domain.dtos.request.MatchPostRequestDto;
import com.prography.playeasy.match.domain.dtos.response.MapResponseDto;
import com.prography.playeasy.match.domain.dtos.response.MatchCreateMapResponseDto;
import com.prography.playeasy.match.domain.dtos.response.MatchCreateResponseDto;
import com.prography.playeasy.util.UIHelper;

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

public class MatchCreate extends AppCompatActivity {
    private static final String TAG = "MAP SERVICE";
    private ArrayList arrayList;

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
    String tempDateSend, timeStartMin, timeStartHour, timeEndHour, timeEndMin;
    Button button_search;
    Spinner spinner;
    String matchType;
    //todo Map
    AutoCompleteTextView textViewMap;
    EditText matchDetailMap;
    private EditText matchFee;
    EditText needPeople;
    EditText matchPhoneNumber;
    ListView lv;

    EditText description;
    String key;

    LocationDto locationData;
    private String[] mapLocation;

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
        button_search = findViewById(R.id.button_search);
        textViewMap = findViewById(R.id.matchLocationMap);

        //  spinner.setAdapter(new ArrayAdapter(this,R.layout.support_simple_spinner_dropdown_item));
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //setItem=(String)spinner.getSelectedItem();
                matchType = (String) spinner.getItemAtPosition(position);
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

                Log.d("매치 작성 페이지", tempDateSend);
            }
        });

//        String dumstrDate = "2020-07-13T23:20:00.123Z";


//2020-07-12T20:00:00.000Z
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");


        /*TimePicker Id*/
        sTimePicker = findViewById(R.id.timePickerStart);
        eTimePicker = findViewById(R.id.timePickerEnd);
        sTimePicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {

                                                 //AM Pm 값 넘어오지 않고 234시간 type으로 정보 넘어온
                                                 @Override
                                                 public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
//                timeStartHour=sTimePicker.getHour()+"";
//                timeStartMin=sTimePicker.getMinute()+"";
                                                     duration = hourOfDay;
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
                duration = hourOfDay - duration;
                if (hourOfDay < 10) {
                    timeEndHour = "0" + hourOfDay;
                } else {
                    timeEndHour = String.valueOf(hourOfDay);
                }


                if (minute >= 10) {
                    timeEndMin = minute + "";

                } else {
                    timeEndMin = "0" + minute;
                }

            }
        });
//concatenate
        tempDateSend = tempDateSend + "T" + timeStartHour + ":" + timeStartMin + "00.000Z";
        Log.d("시간 분  페이지", tempDateSend);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");

        try {
            startAt = format.parse(tempDateSend);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        matchFee = findViewById(R.id.matchFee);
        needPeople = (EditText) findViewById(R.id.needPeople);
//       totalQuota=Integer.parseInt(needPeople.getText().toString());
        matchPhoneNumber = (EditText) findViewById(R.id.matchPhoneNumber);
        description = (EditText) findViewById(R.id.matchEtc);

        arrayList = new ArrayList<>();
        button_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                arrayList.clear();
                match.getMapInfo(textViewMap.getText().toString(), new Callback<MapResponseDto>() {
                    @Override
                    public void onResponse(Call<MapResponseDto> call, Response<MapResponseDto> response) {
                        List<MatchCreateMapResponseDto> list = response.body().getReturnData();

                        for (int i = 0; i < list.size(); i++) {
                            arrayList.add(list.get(i).getAddress_name());
                        }
                    }

                    @Override
                    public void onFailure(Call<MapResponseDto> call, Throwable t) {
                        Log.d(TAG, t.getMessage());

                    }
                });
            }
        });

        System.out.println("!!!!!!!" + arrayList.size());
        for(int i = 0; i<arrayList.size(); i++){
            System.out.println("@@@@@@" + arrayList.get(i));
        }

        ArrayAdapter itemsAdapter =  new ArrayAdapter(getApplicationContext(), android.R.layout.simple_dropdown_item_1line,arrayList);
        textViewMap.setAdapter(itemsAdapter);
        textViewMap.setThreshold(1);
    }



    //Date가 아닌 String으로 처리중 규산 object->HashMap?
    public MatchNoIdDto makeJSONMatchData(String type, String description, Date startAt, int duration, int fee, String phone, int totalQuota) {
        //규산 hashMapMatch  자체가 JSONObject인건가 아니면 ㅎGSon().fromJSON()해야 나


        return new MatchNoIdDto(type, description, startAt, duration, fee, phone, totalQuota);


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
                totalQuota = Integer.parseInt(needPeople.getText().toString());
                fee = Integer.parseInt(matchFee.getText().toString());
                matchSample = new MatchPostRequestDto(makeJSONMatchData(matchType, description.getText().toString(), startAt, duration
                        , fee, matchPhoneNumber.getText().toString(), totalQuota), locationData);
//                matchSample.put("locationData",locationData);
//                matchSample.put("matchData");
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

        //    1step. server에 key 보내
        //2단계 LocationDto 5개 필드만

        //데이터 리스트 받아오고 그 중에 선택

        // 2step .

}
