package com.prography.playeasy.push.activity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.tabs.TabLayout;
import com.prography.playeasy.R;
import com.prography.playeasy.util.UIHelper;

public class MyMatchInformation extends AppCompatActivity {

    private TabLayout tabLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_push_mymatchinformation);
        UIHelper.hideWindow(this);
        UIHelper.toolBarInitialize(this, findViewById(R.id.pushMyMatchInf));
        initialize();
    }

    private void initialize() {

        //탭 레이아웃
        tabLayout = findViewById(R.id.pushTabLayout);
        tabLayout.addTab(tabLayout.newTab().setCustomView(createTabView("  내가 등록한 매치  ")));
        tabLayout.addTab(tabLayout.newTab().setCustomView(createTabView("   나의 신청 현황  ")));

    }

    private View createTabView(String tabName){
        View tabView = LayoutInflater.from(getApplicationContext()).inflate(R.layout.tab_push_mymatchinfo_custom, null);
        TextView tvName = tabView.findViewById(R.id.pushTabName);
        tvName.setText(tabName);
        return tabView;
    }
}
