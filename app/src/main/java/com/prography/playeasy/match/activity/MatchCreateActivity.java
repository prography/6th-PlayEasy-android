package com.prography.playeasy.match.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

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
    private MenuInflater menuInflater;
    private Toolbar matchCreateToolBar;

    private ArrayList<MatchRequestVO> v;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_match_create);

        // f
        initialized();
        toolBarInitialize();


        matchCreateconfirm.setOnClickListener((v) -> {
            // UI 데이터 가져왔다 치고

            // String title, String type, String description, String location, int fee, Date startAt, Date endAt, int homeQuota
            /*MatchRequestVO requestVO = new MatchRequestVO(
                "sampleTitle",
                    "sampleType",
                    "sampleDesc",
                    "sampleLocation",
                    0,
                    new Date(),
                    new Date(),
                    0
            );*/
            MatchRequestVO requestVO = new MatchRequestVO(
                    ((EditText)findViewById(R.id.matchCreateTitle)).getText().toString(),
                    ((EditText)findViewById(R.id.matchCreateType)).getText().toString(),
                    ((EditText)findViewById(R.id.matchCreateDescription)).getText().toString(),
                    ((EditText)findViewById(R.id.matchCreateLocation)).getText().toString(),
                    Integer.valueOf(((EditText)findViewById(R.id.matchCreateFee)).getText().toString()),
                    new Date(),
                    new Date(),
                    Integer.valueOf(((EditText)findViewById(R.id.matchCreateHomeQuota)).getText().toString())
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

    private void toolBarInitialize() {
        matchCreateToolBar = findViewById(R.id.matchCreateToolBar);
        setSupportActionBar(matchCreateToolBar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true); // 뒤로가기 버튼, 디폴트로 true만 해도 백버튼이 생김
        //actionBar.setDisplayShowTitleEnabled(false); // 제목 없애기
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.match_create,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected (MenuItem item)
    {
        Toast toast = Toast.makeText(getApplicationContext(),"", Toast.LENGTH_LONG);

        switch(item.getItemId())
        {

            case android.R.id.home:
                Intent writeBack = new Intent(this, MatchListActivity.class);
                startActivity(writeBack);
                finish();
                return true;

            case R.id.matchRegister:
                Intent intent = new Intent(this, MatchListActivity.class);
                startActivity(intent);
                finish();
                break;
        }
        toast.show();
        return super.onOptionsItemSelected(item);
    }
}
