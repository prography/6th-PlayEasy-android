package com.prography.playeasy.match.activity;

import android.app.Activity;
import android.content.Intent;
import android.icu.util.ULocale;
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
import android.widget.TextView;
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
import com.prography.playeasy.match.domain.dtos.response.MatchCreateMapResponseDto;
import com.prography.playeasy.match.domain.dtos.response.MatchCreateResponseDto;
import com.prography.playeasy.match.domain.models.Match;
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
import lombok.SneakyThrows;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MatchCreate extends AppCompatActivity {
    private static final String TAG = "MAP SERVICE";
    private Activity thisActivity = this;

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
    TextView locationY, locationX, locationPlaceName;
    ListView lv;

    EditText description;
    String key;

    LocationDto locationData;
    private ArrayAdapter<MatchCreateMapResponseDto> itemsAdapter;

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

        tempDateSend = "";
        HorizontalCalendar horizontalCalendar = new HorizontalCalendar.Builder(this, R.id.calendarViewMatchCreate)
                .range(startDate, endDate).datesNumberOnScreen(5).build();
        horizontalCalendar.setCalendarListener(new HorizontalCalendarListener() {
            @Override
            public void onDateSelected(Calendar date, int position) {

                int day = date.get(Calendar.DAY_OF_MONTH);
                int month = date.get(Calendar.MONTH) + 1;
                int year = date.get(Calendar.YEAR);
                if (month <= 9) {
                    tempDateSend = year+"-"+month+"-"+day+"T";

                } else {
                    tempDateSend = year+"-"+month+"-"+day+"T";
                }

                Log.d("매치 작성 페이지", tempDateSend);
            }
        });

//        String dumstrDate = "2020-07-13T23:20:00.123Z";

        /*TimePicker Id*/
        sTimePicker = findViewById(R.id.timePickerStart);
        eTimePicker = findViewById(R.id.timePickerEnd);
        matchFee = findViewById(R.id.matchFee);
        needPeople = (EditText) findViewById(R.id.needPeople);
//       totalQuota=Integer.parseInt(needPeople.getText().toString());
        matchPhoneNumber = (EditText) findViewById(R.id.matchPhoneNumber);
        matchDetailMap = findViewById(R.id.matchDetailMap);
        description =  findViewById(R.id.matchEtc);



        locationY = findViewById(R.id.locationY);
        locationX = findViewById(R.id.locationX);
        locationPlaceName = findViewById(R.id.locationPlaceName);
        button_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                match.getMapInfo(textViewMap.getText().toString(), new ResponseCallback() {
                    @Override
                    public void onFailure(ErrorResult errorResult) {

                    }

                    @Override
                    public void onSuccess(Object result) {
                        List<MatchCreateMapResponseDto> list = (List<MatchCreateMapResponseDto>) result;

                        int size = list.size();
                        String[] mapInfo = new String[size];
                        for(int i = 0; i<size; i++){
                            mapInfo[i] = list.get(i).getAddress_name();

                            System.out.println("=====> 1"+mapInfo[i]);
                            System.out.println("=====> 2"+list.get(i).getY());
                            System.out.println("=====> 3"+list.get(i).getX());
                            System.out.println("=====> 4"+list.get(i).getPlace_name());
                        }

                        ArrayAdapter<String> adapter = new ArrayAdapter<>(thisActivity,
                                android.R.layout.simple_dropdown_item_1line, mapInfo);

                        System.out.println("=====>"+textViewMap.getText());
                        textViewMap.setAdapter(adapter);
                        textViewMap.setDropDownAnchor(textViewMap.getId());
                        textViewMap.showDropDown();

                        final int[] now = new int[1];
                        textViewMap.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                textViewMap.setText(((TextView)view).getText().toString());
                                now[0] = position;
                            }
                        });
                        locationY.setText(String.valueOf(list.get(now[0]).getY()));
                        locationX.setText(String.valueOf(list.get(now[0]).getX()));
                        locationPlaceName.setText(list.get(now[0]).getPlace_name());
                    }
                });
            }
        });
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


    @SneakyThrows
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.createMatch:
                totalQuota = Integer.parseInt(needPeople.getText().toString());
                fee = Integer.parseInt(matchFee.getText().toString());

                int sHour = sTimePicker.getHour();
                timeStartHour = "";
                if(sHour < 10){
                    timeStartHour = timeStartHour + sHour ;
                }else{
                    timeStartHour = String.valueOf(sTimePicker.getHour());
                }

                int eHour = eTimePicker.getHour();
                timeEndHour = "";
                if(eHour < 10){
                    timeEndHour =  timeEndHour + eHour;
                }else{
                    timeEndHour = String.valueOf(eTimePicker.getHour());
                }

                duration = eHour - sHour;

                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
                tempDateSend = tempDateSend + timeStartHour+":"+"00:00.000Z";
                System.out.println("보내는시간" + tempDateSend);


                startAt = format.parse(tempDateSend);
                System.out.println("시작시간" + startAt);


                locationData = new LocationDto(Double.parseDouble(locationY.getText().toString()), Double.parseDouble(locationX.getText().toString()),
                        locationPlaceName.getText().toString(),
                        textViewMap.getText().toString(),matchDetailMap.getText().toString());

                MatchNoIdDto matchData = new MatchNoIdDto(matchType, description.getText().toString(),
                        startAt, duration, fee, matchPhoneNumber.getText().toString(), totalQuota);

                match.create(locationData, matchData, new Callback<MatchCreateResponseDto>() {
                    @Override
                    public void onResponse(Call<MatchCreateResponseDto> call, Response<MatchCreateResponseDto> response) {
                        //don't get any response
                        Log.d("checking response data ", String.valueOf(response.body()));

                        finish();

                    }

                    @Override
                    public void onFailure(Call<MatchCreateResponseDto> call, Throwable t) {
                        Log.d("매치 생성 실패", "");

                    }
                });
                return true;

        }
        return super.onOptionsItemSelected(item);
    }

    //    1step. server에 key 보내
    //2단계 LocationDto 5개 필드만

    //데이터 리스트 받아오고 그 중에 선택

    // 2step .

}