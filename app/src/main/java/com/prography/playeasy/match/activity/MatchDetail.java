package com.prography.playeasy.match.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;
import com.prography.playeasy.R;
import com.prography.playeasy.lib.TokenManager;
import com.prography.playeasy.match.domain.MatchDao;
import com.prography.playeasy.match.domain.dtos.response.MatchDetailDto;
import com.prography.playeasy.match.domain.models.Match;
import com.prography.playeasy.match.util.DataHelper;
import com.prography.playeasy.team.activity.TeamInformation;
import com.prography.playeasy.util.UIHelper;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MatchDetail extends AppCompatActivity {

    private TextView detailHomeTeam;
    private MaterialButton homeTeamText;


    private TextView address;
    private TextView detailedAddress;

    private TextView time;
    private TextView detailMatchNeedPeople;

    private TextView detailMatchGameType;
    private TextView detailMatchFee;
    private TextView detailMatchTelePhone;

    private TextView addressText;
    private TextView detailedAddressText;

    private TextView etcText;

    private TextView timeText;

    private TextView detailMatchNeedPeopleText;
    private TextView detailMatchGameTypeText;
    private TextView detailMatchFeeText;
    private TextView detailMatchTelePhoneText;
    private TextView etcTextBox;
    MatchDao matchDao;
    private int matchId;
    Match match;

    private MaterialButton detailAppliedMatch;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_match_detail);

        UIHelper.toolBarInitialize(this, findViewById(R.id.matchDetailToolBar));
        UIHelper.hideWindow(this);

        //MapView mapView = new MapView(this);
       // ViewGroup mapViewContainer = findViewById(R.id.matchDetailMap);
//        mapViewContainer.addView(mapView);
        matchId = getIntent().getExtras().getInt("match_id");
        initialized();


    }

    private void initialized() {
        //기존의 두 컴포넌트는 놔두고
        detailHomeTeam = findViewById(R.id.detailHomeTeam);
        homeTeamText=findViewById(R.id.homeTeamText);

        //주소
        address=findViewById(R.id.matchWhere);
        addressText=findViewById(R.id.matchWhereText);
        //상세 주소
        detailedAddress=findViewById(R.id.detailMatchWhere);
        detailedAddressText=findViewById(R.id.detailMatchWhereText);
        //시간
        time=findViewById(R.id.time);
        timeText=findViewById(R.id.timeText);
        //인원수
        detailMatchNeedPeople= findViewById(R.id.detailMatchNeedPeople);
        detailMatchNeedPeopleText= findViewById(R.id.detailMatchNeedPeopleText);
        //진행방식
        detailMatchGameType=findViewById(R.id.detailMatchGameType);
        detailMatchGameTypeText=findViewById(R.id.detailMatchGameTypeText);
      //참가비
        detailMatchFee=findViewById(R.id.detailMatchFee);
        detailMatchFeeText=findViewById(R.id.detailMatchFeeText);
        //전화번호
        detailMatchTelePhone=findViewById(R.id.detailMatchTelephone);
        detailMatchTelePhoneText=findViewById(R.id.detailMatchTelephoneText);
        matchDao=new MatchDao(TokenManager.get(getApplicationContext()));
        //기타사항
        etcText=findViewById(R.id.etcText);
        //새롭게 추가된 2열의 textView 값들 대입
        etcTextBox=findViewById(R.id.etcTextBox);
        detailAppliedMatch = findViewById(R.id.detailMatchApplyButton);
        //matchId를 매치 상세보기에서도 활용하고 matchId는 매치 신청하기 버튼에서도 활용
        fetchDataOfMatchDetail();



        detailHomeTeam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), TeamInformation.class);
                startActivity(intent);
            }
        });

        detailAppliedMatch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Log.d("match_id", String.valueOf(matchId));
                Intent intent = new Intent(getApplicationContext(), MatchApply.class);

                intent.putExtra("match_id", matchId);
//                startActivity(intent);
                v.getContext().startActivity(intent);
            }
        });




    }

    private void fetchDataOfMatchDetail(){
        matchDao.findById(matchId,new Callback<MatchDetailDto>(){


            @Override
            public void onResponse(Call<MatchDetailDto> call, Response<MatchDetailDto> response) {

                assert response.body() != null;
                match=response.body().getMatch();
                addressText.setText(match.getLocation().getAddress());
                detailedAddressText.setText(match.getLocation().getDetail());
                timeText.setText(match.getStartAt().split("T")[0]);

                detailMatchNeedPeopleText.setText(Integer.toString(match.getTotalQuota()));
                detailMatchGameTypeText.setText(match.getType());
                detailMatchFeeText.setText(Integer.toString(match.getFee()));
                detailMatchTelePhoneText.setText(match.getPhone());

                etcTextBox.setText(match.getDescription());
            }

            @Override
            public void onFailure(Call<MatchDetailDto> call, Throwable t) {

            }
        });
    }
}
