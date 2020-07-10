package com.prography.playeasy.mypage.activity;

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
import com.prography.playeasy.mypage.module.adapter.MyMatchViewPagerAdapter;

public class MyMatch extends AppCompatActivity {

    private ViewPager myMatchViewPager;
    private MyMatchViewPagerAdapter myMatchViewPagerAdapter;
    private TabLayout tabLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mypage_mymatch);

        initialize();

        myMatchViewPager.addOnPageChangeListener(
                new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {

            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                myMatchViewPager.setCurrentItem(tab.getPosition());
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
        tabLayout = findViewById(R.id.tabLayout);
        tabLayout.addTab(tabLayout.newTab().setCustomView(createTabView("내가 등록한 매치")));
        tabLayout.addTab(tabLayout.newTab().setCustomView(createTabView("나의 용병신청 현황")));

        // 프래그먼트
        myMatchViewPager = findViewById(R.id.pager);
        myMatchViewPagerAdapter = new MyMatchViewPagerAdapter(getSupportFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        myMatchViewPager.setAdapter(myMatchViewPagerAdapter);

              // VIEWPAGER랑 탭 레이아웃 묶어주기
        myMatchViewPagerAdapter = new MyMatchViewPagerAdapter(getSupportFragmentManager(),tabLayout.getTabCount());
        myMatchViewPager.setAdapter(myMatchViewPagerAdapter);



    }

    private View createTabView(String tabName){
        View tabView = LayoutInflater.from(getApplicationContext()).inflate(R.layout.tab_mypage_mymatch_custom, null);
        TextView tvName = tabView.findViewById(R.id.tabName);
        tvName.setText(tabName);
        return tabView;
    }

}
