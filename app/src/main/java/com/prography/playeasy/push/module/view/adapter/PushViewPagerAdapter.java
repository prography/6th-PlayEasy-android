package com.prography.playeasy.push.module.view.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.prography.playeasy.push.module.view.fragment.AppliedMatch;
import com.prography.playeasy.push.module.view.fragment.Registeredmatch;

import java.util.ArrayList;

public class PushViewPagerAdapter extends FragmentPagerAdapter {

    private ArrayList<Fragment> list = new ArrayList<>();

    public PushViewPagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);

        list.add(new AppliedMatch());
        list.add(new Registeredmatch());
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
