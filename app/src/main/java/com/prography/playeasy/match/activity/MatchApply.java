package com.prography.playeasy.match.activity;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.prography.playeasy.R;
import com.prography.playeasy.lib.TokenManager;
import com.prography.playeasy.match.api.RetrofitMatchApi;
import com.prography.playeasy.match.domain.dtos.request.MatchApplySoloPostRequestDto;
import com.prography.playeasy.match.domain.dtos.request.MatchApplyTeamPostRequestDto;
import com.prography.playeasy.match.domain.dtos.response.MatchApplySoloPostResponseDto;
import com.prography.playeasy.match.domain.dtos.response.MatchApplyTeamPostResponseDto;
import com.prography.playeasy.match.module.view.MatchApplyViewPagerAdapter;
import com.prography.playeasy.match.service.MatchService;
import com.prography.playeasy.mypage.module.adapter.MyMatchInformationViewPagerAdapter;
import com.prography.playeasy.util.UIHelper;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MatchApply extends AppCompatActivity {
    private ViewPager matchApplyViewPager;
    private TabLayout tabLayout;
    private MatchApplyViewPagerAdapter matchApplyViewPagerAdapter;
    private Button matchApplyBtn;
    private int quotaSolo;
    private int quotaTeam;
    MatchService matchServiceObject;
    public static int tabPosition;
    private EditText editTextSoloApplyNumberDecimal;
    private EditText editTextTeamApplyNumberDecimal;
    private int matchId;
    private final int TAB_TEAM = 0;
    private final int TAB_SOLO = 1;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_match_apply);
        matchServiceObject = new MatchService();
        UIHelper.toolBarInitialize(this, findViewById(R.id.matchApplyToolbar));
        UIHelper.hideWindow(this);
        matchId = getIntent().getExtras().getInt("match_id");
        matchApplyBtn = findViewById(R.id.enterButton);
        initialize();
        initializeMatchApplyBtn();


        matchApplyViewPager.addOnPageChangeListener(
                new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {

            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                matchApplyViewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });


    }

    private void initialize() {

        //탭 레이아웃
        tabLayout = findViewById(R.id.matchApplyTabLayout);
        tabLayout.addTab(tabLayout.newTab().setCustomView(createTabView("  팀으로 신청  ")));
        tabLayout.addTab(tabLayout.newTab().setCustomView(createTabView("   용병 지원  ")));

        // 프래그먼트
        matchApplyViewPager = findViewById(R.id.matchApplyiewPager);
        matchApplyViewPagerAdapter = new MatchApplyViewPagerAdapter(getSupportFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        matchApplyViewPager.setAdapter(matchApplyViewPagerAdapter);

        // VIEWPAGER랑 탭 레이아웃 묶어주기
        matchApplyViewPagerAdapter = new MatchApplyViewPagerAdapter(getSupportFragmentManager(), tabLayout.getTabCount());
        matchApplyViewPager.setAdapter(matchApplyViewPagerAdapter);
    }

    private View createTabView(String tabName) {
        View tabView = LayoutInflater.from(getApplicationContext()).inflate(R.layout.tab_push_matchapply_custom, null);
        TextView tvName = tabView.findViewById(R.id.TabNameMatchApply);
        tvName.setText(tabName);
        return tabView;
    }

    private void initializeMatchApplyBtn() {
        matchApplyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = tabLayout.getSelectedTabPosition();
                Log.d("tab position ========> ", String.valueOf(position));
                switch (position) {
                    case TAB_TEAM:
                        applyMatchAsTeam();
                        break;
                    case TAB_SOLO:
                        applyMatchAsSolo();
                        break;
                }
            }
        });
    }
    private void applyMatchAsTeam() {
        editTextTeamApplyNumberDecimal = findViewById(R.id.editTextTeamApplyNumberDecimal);
        quotaTeam = Integer.parseInt(editTextTeamApplyNumberDecimal.getText().toString());
        Log.d("숫자 값 찍어보기", String.valueOf(quotaTeam));
        matchServiceObject.applyMatchTeam(new Callback<MatchApplyTeamPostResponseDto>() {
            @Override
            public void onResponse(Call<MatchApplyTeamPostResponseDto> call, Response<MatchApplyTeamPostResponseDto> response) {
                Log.d("check response data", String.valueOf(response.body()));
            }

            @Override
            public void onFailure(Call<MatchApplyTeamPostResponseDto> call, Throwable t) {
                Log.d("매치 신청 실패", " ");
            }
        }, getApplicationContext(), matchId, quotaTeam);
    }
    private void applyMatchAsSolo() {
        editTextSoloApplyNumberDecimal = findViewById(R.id.editTextSoloApplyNumberDecimal);
        quotaSolo = Integer.parseInt(editTextSoloApplyNumberDecimal.getText().toString());
        Log.d("숫자 값 찍어보기", String.valueOf(quotaSolo));
        matchServiceObject.applyMatchSolo(new Callback<MatchApplySoloPostResponseDto>() {
            @Override
            public void onResponse(Call<MatchApplySoloPostResponseDto> call, Response<MatchApplySoloPostResponseDto> response) {
                Log.d("check response data", String.valueOf(response.body()));

            }

            @Override
            public void onFailure(Call<MatchApplySoloPostResponseDto> call, Throwable t) {
                Log.d("매치 신청 실패", " ");
            }
        }, getApplicationContext(), matchId, quotaSolo);
    }


}
