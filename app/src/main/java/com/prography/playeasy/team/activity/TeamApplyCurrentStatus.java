package com.prography.playeasy.team.activity;

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
import com.prography.playeasy.team.module.view.adpater.TeamApplyCurrentStatusViewPagerAdapter;
import com.prography.playeasy.util.UIHelper;

public class TeamApplyCurrentStatus extends AppCompatActivity {

    private ViewPager teamApplyCurrentStatusViewPager;
    private TeamApplyCurrentStatusViewPagerAdapter teamApplyCurrentStatusViewPagerAdapter;
    private TabLayout teamApplyCurrentStatusLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team_applycurrentstatus);

        UIHelper.hideWindow(this);
        UIHelper.toolBarInitialize(this, findViewById(R.id.teamApplyCurrentStatusToolbar));

        initialize();

        teamApplyCurrentStatusViewPager.addOnPageChangeListener(
                new TabLayout.TabLayoutOnPageChangeListener(teamApplyCurrentStatusLayout));

        teamApplyCurrentStatusLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {

            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                teamApplyCurrentStatusViewPager.setCurrentItem(tab.getPosition());
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

        teamApplyCurrentStatusLayout = findViewById(R.id.teamApplyCurrentStatusLayout);
        teamApplyCurrentStatusLayout.addTab(teamApplyCurrentStatusLayout.newTab().setCustomView(createTabView("  팀 지원 현황  ")));
        teamApplyCurrentStatusLayout.addTab(teamApplyCurrentStatusLayout.newTab().setCustomView(createTabView("   용병 지원 현황  ")));

        teamApplyCurrentStatusViewPager = findViewById(R.id.teamApplyCurrentStatusViewPager);
        teamApplyCurrentStatusViewPagerAdapter = new TeamApplyCurrentStatusViewPagerAdapter(
                getSupportFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        teamApplyCurrentStatusViewPager.setAdapter(teamApplyCurrentStatusViewPagerAdapter);

        teamApplyCurrentStatusViewPagerAdapter = new TeamApplyCurrentStatusViewPagerAdapter(
                getSupportFragmentManager(), teamApplyCurrentStatusLayout.getTabCount());
        teamApplyCurrentStatusViewPager.setAdapter(teamApplyCurrentStatusViewPagerAdapter);

    }

    private View createTabView(String s) {
        View tabView = LayoutInflater.from(getApplicationContext()).inflate(R.layout.tab_team_applycurrentstatus_custom, null);
        TextView tvName = tabView.findViewById(R.id.applyCurrentStatusTab);
        tvName.setText(s);
        return tabView;
    }

}
