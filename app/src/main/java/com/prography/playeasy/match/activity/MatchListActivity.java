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

import java.util.ArrayList;
import java.util.List;


public class MatchListActivity extends AppCompatActivity {
    private MatchService matchService;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_match_list);

        // 해야되는게 불러와서 리사이클러뷰에 넣어줘야지
        //retrofit 실행
        matchService = new MatchService();
        this.matchService.retrieveMatch(new MatchResponseCallback(){
            @Override
            public void onSuccess(List<Match> matchList) {
                adapteRecyclerView(matchList);
            }

            @Override
            public void onError() {

            }
        });




    }

    private void adapteRecyclerView(List<Match> matchList) {
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
