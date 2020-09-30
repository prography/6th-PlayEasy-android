package com.prography.playeasy.mypage.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.lakue.lakuepopupactivity.PopupResult;
import com.prography.playeasy.R;
import com.prography.playeasy.mypage.module.adapter.MyMatchInformationRecyclerViewAdapter;
import com.prography.playeasy.mypage.module.adapter.MyMatchInformationViewPagerAdapter;
import com.prography.playeasy.push.module.view.adapter.PushViewPagerAdapter;
import com.prography.playeasy.util.UIHelper;

public class MyMatchInformation extends AppCompatActivity {

    private ViewPager MyMatchInformationViewPager;
    private TabLayout tabLayout;
    private MyMatchInformationViewPagerAdapter myMatchInformationViewPagerAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mypage_mymatchinformation);
        UIHelper.hideWindow(this);
        UIHelper.toolBarInitialize(this, findViewById(R.id.MyMatchInf));

        initialize();

        MyMatchInformationViewPager.addOnPageChangeListener(
                new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {

            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                MyMatchInformationViewPager.setCurrentItem(tab.getPosition());
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
        tabLayout = findViewById(R.id.myMatchTabLayout);
        tabLayout.addTab(tabLayout.newTab().setCustomView(createTabView("  내가 등록한 매치  ")));
        tabLayout.addTab(tabLayout.newTab().setCustomView(createTabView("   나의 신청 현황  ")));

        // 프래그먼트
        MyMatchInformationViewPager = findViewById(R.id.myMatchViewPager);
        myMatchInformationViewPagerAdapter = new MyMatchInformationViewPagerAdapter(getSupportFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        MyMatchInformationViewPager.setAdapter(myMatchInformationViewPagerAdapter);

        // VIEWPAGER랑 탭 레이아웃 묶어주기
        myMatchInformationViewPagerAdapter = new MyMatchInformationViewPagerAdapter(getSupportFragmentManager(),tabLayout.getTabCount());
        MyMatchInformationViewPager.setAdapter(myMatchInformationViewPagerAdapter);


    }

    private View createTabView(String tabName){
        View tabView = LayoutInflater.from(getApplicationContext()).inflate(R.layout.tab_push_mymatchinfo_custom, null);
        TextView tvName = tabView.findViewById(R.id.TabName);
        tvName.setText(tabName);
        return tabView;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK)
        if (requestCode == 1) {
            PopupResult result = (PopupResult) data.getSerializableExtra("result");
            if (result == PopupResult.LEFT) {
                // 작성 코드
                Toast.makeText(this, "최종 확정", Toast.LENGTH_SHORT).show();
                MyMatchInformationRecyclerViewAdapter.status="CONFIRMED";
            } else if (result == PopupResult.RIGHT) {
                // 작성 코드
                Toast.makeText(this, "경기 취소", Toast.LENGTH_SHORT).show();
                MyMatchInformationRecyclerViewAdapter.status="CANCEL";
            }
        }
    }



}
