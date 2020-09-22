package com.prography.playeasy.match.activity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.prography.playeasy.R;
import com.prography.playeasy.match.module.view.MatchApplyViewPagerAdapter;
import com.prography.playeasy.mypage.module.adapter.MyMatchInformationViewPagerAdapter;
import com.prography.playeasy.util.UIHelper;

public class MatchApply extends AppCompatActivity {
    private ViewPager matchApplyViewPager;
    private TabLayout tabLayout;
    private MatchApplyViewPagerAdapter matchApplyViewPagerAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_match_apply);
        UIHelper.toolBarInitialize(this, findViewById(R.id.matchApplyToolbar));
        UIHelper.hideWindow(this);

        initialize();

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
        matchApplyViewPagerAdapter = new MatchApplyViewPagerAdapter(getSupportFragmentManager(),tabLayout.getTabCount());
        matchApplyViewPager.setAdapter(matchApplyViewPagerAdapter);


    }

    private View createTabView(String tabName){
        View tabView = LayoutInflater.from(getApplicationContext()).inflate(R.layout.tab_push_matchapply_custom, null);
        TextView tvName = tabView.findViewById(R.id.TabNameMatchApply);
        tvName.setText(tabName);
        return tabView;
    }

}
