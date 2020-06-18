package com.prography.playeasy.mypage.module.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.prography.playeasy.mypage.module.view.Fragment.MyMatchApply;
import com.prography.playeasy.mypage.module.view.Fragment.MyMatchRegister;

import java.util.ArrayList;

public class MyMatchViewPagerAdapter extends FragmentPagerAdapter {

    private ArrayList<Fragment> list = new ArrayList<>();
    public MyMatchViewPagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);

        list.add(new MyMatchRegister());
        list.add(new MyMatchApply());
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
