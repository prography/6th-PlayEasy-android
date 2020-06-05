package com.prography.playeasy.match.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.prography.playeasy.R;
import com.prography.playeasy.match.domain.MatchRequestVO;
import com.prography.playeasy.match.service.MatchService;
import com.prography.playeasy.util.PlayeasyServiceManager;
import com.prography.playeasy.util.UIHelper;

import java.util.Date;

public class MatchCreateActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_match_create);

        UIHelper.toolBarInitialize(this, findViewById(R.id.matchCreateToolBar));

        findViewById(R.id.matchCreateConfirm).setOnClickListener((v) -> {
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

            MatchService service = PlayeasyServiceManager.getInstance(MatchService.class);
            service.createMatch(requestVO, this.getApplicationContext());
        });
    }

    @Override
    public boolean onOptionsItemSelected (MenuItem item)
    {
        switch(item.getItemId())
        {
            case android.R.id.home:
                Intent writeBack = new Intent(this, MatchListActivity.class);
                startActivity(writeBack);
                return true;

        }
        return super.onOptionsItemSelected(item);
    }
}
