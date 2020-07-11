package com.prography.playeasy.team.module.view.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.prography.playeasy.R;
import com.prography.playeasy.mypage.domain.MyMatchVO;
import com.prography.playeasy.push.module.view.adapter.PushRecyclerViewAdapter;

import java.util.ArrayList;

public class ApplyCurrentStatusTeam extends Fragment {

    private ArrayList<MyMatchVO> test;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_team_applycurrentstatus_team, container, false);

        return rootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initialize(view);


    }

    private void initialize(View view) {
        RecyclerView recyclerView = view.findViewById(R.id.teamApplyCurrentStatusTeamRecyclerView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(view.getContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        final PushRecyclerViewAdapter adapter = new PushRecyclerViewAdapter();

        test = new ArrayList<>();
        test.add(new MyMatchVO("프로","안양",11));
        test.add(new MyMatchVO("그라","강남",6));
        test.add(new MyMatchVO("피","사당",5));

        adapter.addItems(test);
        recyclerView.setAdapter(adapter);

    }
}
