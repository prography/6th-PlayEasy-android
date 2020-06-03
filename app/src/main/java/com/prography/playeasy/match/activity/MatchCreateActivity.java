package com.prography.playeasy.match.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.prography.playeasy.R;
import com.prography.playeasy.match.domain.MatchRequestVO;
import com.prography.playeasy.match.service.MatchService;

import java.util.ArrayList;
import java.util.Date;

public class MatchCreateActivity extends AppCompatActivity {
    private MatchService matchService;


    private EditText matchCreateTitle;
    private EditText matchCreateType;
    private EditText matchCreateDescription;
    private EditText matchCreateLocation;
    private EditText matchCreateFee;
    private EditText matchCreateStartAt;
    private EditText matchCreateEndAt;
    private EditText matchCreateHomeQuota;
    private Button matchCreateconfirm;
    private Button getMatchCreateCancel;

    private ArrayList<MatchRequestVO> v;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_match_create);

        // f
        initialized();

        findViewById(R.id.matchCreateConfirm).setOnClickListener((View v) -> {
            // UI 데이터 가져왔다 치고

            // String title, String type, String description, String location, int fee, Date startAt, Date endAt, int homeQuota
            MatchRequestVO requestVO = new MatchRequestVO(
                "sampleTitle",
                    "sampleType",
                    "sampleDesc",
                    "sampleLocation",
                    0,
                    new Date(),
                    new Date(),
                    0
            );


            this.matchService.createMatch(requestVO, this.getApplicationContext());


        });


    }

    private void initialized() {
        matchCreateTitle = findViewById(R.id.matchCreateTitle);
        matchCreateType = findViewById(R.id.matchCreateType);
        matchCreateDescription = findViewById(R.id.matchCreateDescription);
        matchCreateLocation = findViewById(R.id.matchCreateLocation);
        matchCreateFee = findViewById(R.id.matchCreateFee);
        matchCreateHomeQuota = findViewById(R.id.matchCreateHomeQuota);
        matchCreateconfirm = findViewById(R.id.matchCreateConfirm);
        getMatchCreateCancel = findViewById(R.id.matchCreateCancel);

        this.matchService = new MatchService();
    }
}
