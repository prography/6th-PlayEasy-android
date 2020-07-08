package com.prography.playeasy.push.activity;

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
import com.prography.playeasy.push.module.view.adapter.PushViewPagerAdapter;
import com.prography.playeasy.util.UIHelper;

public class MyMatchInformation extends AppCompatActivity {

    private ViewPager pushViewPager;
    private TabLayout tabLayout;
    private PushViewPagerAdapter pushViewPagerAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_push_mymatchinformation);
        UIHelper.hideWindow(this);
        UIHelper.toolBarInitialize(this, findViewById(R.id.pushMyMatchInf));

        initialize();

        pushViewPager.addOnPageChangeListener(
                new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {

            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                pushViewPager.setCurrentItem(tab.getPosition());
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
        tabLayout = findViewById(R.id.pushTabLayout);
        tabLayout.addTab(tabLayout.newTab().setCustomView(createTabView("  내가 등록한 매치  ")));
        tabLayout.addTab(tabLayout.newTab().setCustomView(createTabView("   나의 신청 현황  ")));

        // 프래그먼트
        pushViewPager = findViewById(R.id.pushViewPager);
        pushViewPagerAdapter = new PushViewPagerAdapter(getSupportFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        pushViewPager.setAdapter(pushViewPagerAdapter);

        // VIEWPAGER랑 탭 레이아웃 묶어주기
        pushViewPagerAdapter = new PushViewPagerAdapter(getSupportFragmentManager(),tabLayout.getTabCount());
        pushViewPager.setAdapter(pushViewPagerAdapter);


    }

    private View createTabView(String tabName){
        View tabView = LayoutInflater.from(getApplicationContext()).inflate(R.layout.tab_push_mymatchinfo_custom, null);
        TextView tvName = tabView.findViewById(R.id.pushTabName);
        tvName.setText(tabName);
        return tabView;
    }
}
