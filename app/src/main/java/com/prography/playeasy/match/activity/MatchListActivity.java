package com.prography.playeasy.match.activity;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.prography.playeasy.R;
import com.prography.playeasy.lib.RetrofitClientGenerator;
import com.prography.playeasy.match.domain.Match;
import com.prography.playeasy.match.domain.MatchResponseVO;
import com.prography.playeasy.match.module.view.MatchRecyclerAdapter;
import com.prography.playeasy.match.service.MatchService;
import com.prography.playeasy.match.util.MatchResponseCallback;
import com.prography.playeasy.util.playeasyServiceFactory.PlayeasyServiceFactory;

import java.util.ArrayList;
import java.util.List;


public class MatchListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_match_list);

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

        // 서비스 객체 받음
        MatchService service = PlayeasyServiceFactory.getService(MatchService.class);
        // 서비스 호출
        service.retrieveMatch(callback);

        // 변수 안만들고 바로 사용하는 버전
        // PlayeasyServiceFactory.getService(MatchService.class).retrieveMatch(callback);
    }

    private void adaptRecyclerView(List<Match> matchList) {
        RecyclerView recyclerView = findViewById(R.id.matchListRecyclerView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        MatchRecyclerAdapter adapter = new MatchRecyclerAdapter();
        recyclerView.setAdapter(adapter);

        for (Match m: matchList) {
            adapter.addItems(m);
        }

    }
}
