package com.prography.playeasy.team.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.prography.playeasy.R;
import com.prography.playeasy.mypage.activity.MyInformation;
import com.prography.playeasy.team.domain.Team;
import com.prography.playeasy.team.service.TeamService;
import com.prography.playeasy.util.PlayeasyServiceFactory;
import com.prography.playeasy.util.UIHelper;

public class TeamCreate extends AppCompatActivity {

    private String spinnerValue = "";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team_createteam);

        UIHelper.toolBarInitialize(this,findViewById(R.id.teamCreateToolBar));
        UIHelper.hideWindow(this);

        initialized();
    }

    private void initialized() {

        Spinner level = findViewById(R.id.teamCreateAbilitySpinner);
        level.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                if(position == 0){
                    spinnerValue = "HIGH";
                }else if(position == 1){
                    spinnerValue = "MEDIUM";
                }else{
                    spinnerValue = "LOW";
                }

                Toast.makeText(TeamCreate.this,"선택된 아이템 : "+level.getItemAtPosition(position),Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        findViewById(R.id.teamCreateCancelButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), TeamSelect.class);
                startActivity(intent);
            }
        });
        findViewById(R.id.teamCreateButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                TeamService service = PlayeasyServiceFactory.getInstance(TeamService.class);
                service.registerTeam(getInputtedTeam(), getApplicationContext());


                Intent intent = new Intent(getApplicationContext(), MyInformation.class);
                startActivity(intent);
            }
        });
    }

    private Team getInputtedTeam() {
        EditText name = findViewById(R.id.teamCreate);
        EditText leader = findViewById(R.id.teamCreateCapTinName);
        EditText age = findViewById(R.id.teamCreateCapTinAge);
        EditText phone = findViewById(R.id.teamCreateCapTinPhone);
        EditText description = findViewById(R.id.teamInformation);


        return Team.builder()
                .name(name.getText().toString())
                .leader(leader.getText().toString())
                .age(Integer.valueOf(age.getText().toString()))
                .level(spinnerValue)
                .phone(phone.getText().toString())
                .description(description.getText().toString())
                .build();

    }
}
