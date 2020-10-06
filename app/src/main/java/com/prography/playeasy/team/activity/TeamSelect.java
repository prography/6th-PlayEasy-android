package com.prography.playeasy.team.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.button.MaterialButton;
import com.kakao.network.ErrorResult;
import com.kakao.network.callback.ResponseCallback;
import com.prography.playeasy.R;
import com.prography.playeasy.mypage.activity.MyInformation;
import com.prography.playeasy.team.domain.Team;
import com.prography.playeasy.team.module.view.adpater.SelectRecyclerViewAdapter;
import com.prography.playeasy.team.service.TeamService;
import com.prography.playeasy.util.PlayeasyServiceFactory;
import com.prography.playeasy.util.UIHelper;

import java.util.ArrayList;
import java.util.List;

public class TeamSelect extends AppCompatActivity {

    private SelectRecyclerViewAdapter selectRecyclerViewAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team_teamselect);

        UIHelper.toolBarInitialize(this, findViewById(R.id.TeamSelectToolbar));
        UIHelper.hideWindow(this);

        initialized();

        findViewById(R.id.noTeamSelectButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MyInformation.class);
                startActivity(intent);
            }
        });

        findViewById(R.id.searchTeamIcon).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText searchTeam = findViewById(R.id.searchTeam);
                String searchInfo = searchTeam.getText().toString();
                System.out.println("====>" + searchInfo);

                TeamService service = PlayeasyServiceFactory.getInstance(TeamService.class);

                service.searchTeam(searchInfo, new ResponseCallback() {
                    @Override
                    public void onFailure(ErrorResult errorResult) {

                    }

                    @Override
                    public void onSuccess(Object result) {
                        List<Team> teamList = (List<Team>) result;

                        for (Team item: teamList) {
                            selectRecyclerViewAdapter.addItems(item);
                        }
                    }
                }, getApplicationContext());
            }
        });

    }

    private void initialized() {

        RecyclerView selectRecyclerView = findViewById(R.id.teamSelectRecyclerView);
        LinearLayoutManager selectLinearLayout = new LinearLayoutManager(getApplicationContext());
        selectRecyclerView.setLayoutManager(selectLinearLayout);
        selectRecyclerViewAdapter = new SelectRecyclerViewAdapter();
        selectRecyclerView.setAdapter(selectRecyclerViewAdapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.make_team, menu);

        return true;
    }



    @Override
    public boolean onOptionsItemSelected (MenuItem item)
    {
        switch(item.getItemId())
        {
            case R.id.makeTeamButton:
                Intent intent = new Intent(this, TeamCreate.class);
                startActivity(intent);
                return true;

        }
        return super.onOptionsItemSelected(item);
    }
}
