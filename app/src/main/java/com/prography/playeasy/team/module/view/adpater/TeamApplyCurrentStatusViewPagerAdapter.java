package com.prography.playeasy.team.module.view.adpater;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.prography.playeasy.team.module.view.fragment.ApplyCurrentStatusTeam;
import com.prography.playeasy.team.module.view.fragment.ApplyCurrentStatusUser;

import java.util.ArrayList;

public class TeamApplyCurrentStatusViewPagerAdapter extends FragmentPagerAdapter {

    private ArrayList<Fragment> fragmentsList= new ArrayList<>();
    public TeamApplyCurrentStatusViewPagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);

        fragmentsList.add(new ApplyCurrentStatusTeam());
        fragmentsList.add(new ApplyCurrentStatusUser());
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return fragmentsList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentsList.size();
    }
}
