package com.prography.playeasy.match.module.view;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.prography.playeasy.match.module.view.fragment.SoloApply;
import com.prography.playeasy.match.module.view.fragment.TeamApply;

import java.util.ArrayList;

public class MatchApplyViewPagerAdapter extends FragmentPagerAdapter {


    private ArrayList<Fragment> list = new ArrayList<>();


    public MatchApplyViewPagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);

        list.add(new TeamApply());
        list.add(new SoloApply());
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return list.get(position);
    }

    @Override
    public int getCount() {
        return list.size();
    }
}
