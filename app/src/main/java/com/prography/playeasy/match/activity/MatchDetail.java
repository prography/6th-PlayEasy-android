package com.prography.playeasy.match.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;
import com.prography.playeasy.R;
import com.prography.playeasy.team.activity.TeamInformation;
import com.prography.playeasy.util.UIHelper;

public class MatchDetail extends AppCompatActivity {
    private TextView homeTeam;
    private MaterialButton detailHomeTeam;
    private MaterialButton detailAppliedMatch;

    private TextView address;
    private TextView detailedAddress;

    private TextView time;
    private TextView detailMatchNeedPeople;
    private TextView detailMatchGameType;
    private TextView detailMatchFee;
    private TextView detailMatchTelePhone;
    private TextView etcText;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_match_detail);

        UIHelper.toolBarInitialize(this, findViewById(R.id.matchDetailToolBar));
        UIHelper.hideWindow(this);

        //MapView mapView = new MapView(this);
       // ViewGroup mapViewContainer = findViewById(R.id.matchDetailMap);
//        mapViewContainer.addView(mapView);

        initialized();


    }

    private void initialized() {
        //기존의 두 컴포넌트는 놔두고
        detailHomeTeam = findViewById(R.id.detailHomeTeam);
        detailAppliedMatch = findViewById(R.id.detailMatchApplyButton);

        address=findViewById(R.id.detailMatchWhere);
        detailedAddress=findViewById(R.id.detailMatchDetailedAddress);

        time=findViewById(R.id.detailMatchTime);
        detailMatchNeedPeople= findViewById(R.id.detailMatchNeedPeople);
        detailMatchGameType=findViewById(R.id.detailMatchGameType);
        detailMatchTelePhone=findViewById(R.id.detailMatchTelephone);
        detailMatchFee=findViewById(R.id.detailMatchFee);
        etcText=findViewById(R.id.textViewETC);



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
                int matchId;
                matchId=getIntent().getExtras().getInt("match_id");
                Log.d("match_id", String.valueOf(matchId));
                Intent intent = new Intent(getApplicationContext(), MatchApply.class);

                intent.putExtra("match_id", matchId);
//                startActivity(intent);
                v.getContext().startActivity(intent);
            }
        });

    }
}
