package com.prography.playeasy.match.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.prography.playeasy.R;
import com.prography.playeasy.match.domain.Match;
import com.prography.playeasy.match.service.MatchService;
import com.prography.playeasy.match.util.MatchResponseCallback;
import com.prography.playeasy.util.PlayeasyServiceManager;
import com.prography.playeasy.util.UIHelper;

public class MatchDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_match_detail);

        UIHelper.toolBarInitialize(this, findViewById(R.id.matchDetailToolBar));
        Intent intent = getIntent();
        int matchId = intent.getIntExtra("match_id",-1);


        MatchResponseCallback callback = new MatchResponseCallback() {
            @Override
            public void onSuccess(Object responseData) {
                //성공적으로 왔으면
                Match match = (Match)responseData;
                renderView(match);
            }

            @Override
            public void onError() {

            }
        };

        MatchService service = PlayeasyServiceManager.getInstance(MatchService.class);
        service.detailMatch(matchId, callback);
    }

    private void renderView(Match match) {
        // 뷰 세팅
        // TextView = View
        TextView tvTitle = findViewById(R.id.matchDetailTitle);
        TextView tvType = findViewById(R.id.matchDetailGameRule);
        TextView tvDescription = findViewById(R.id.matchDetailDescription);
        TextView tvLocation = findViewById(R.id.matchDetailWhere);
        TextView tvFee = findViewById(R.id.matchDetailFee);
        TextView tvStartAt = findViewById(R.id.matchDetailStartTime);
        TextView tvEndAt =findViewById(R.id.matchDetailEndTime);

        // 값 저장
        tvTitle.setText(match.getTitle());
        tvType.setText(match.getType());
        tvDescription.setText(match.getDescription());
        tvLocation.setText(match.getLocation());
        tvFee.setText(String.valueOf(match.getFee()));
        tvStartAt.setText(match.getStartAt().toString());
        tvEndAt.setText(match.getEndAt().toString());
    }

    @Override
    public boolean onOptionsItemSelected (MenuItem item)
    {
        switch(item.getItemId())
        {
            case android.R.id.home:
                Intent detailBack = new Intent(this, MatchListActivity.class);
                startActivity(detailBack);
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
