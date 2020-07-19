package com.prography.playeasy.mypage.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.kakao.network.ErrorResult;
import com.kakao.network.callback.ResponseCallback;
import com.prography.playeasy.R;
import com.prography.playeasy.team.domain.Team;
import com.prography.playeasy.team.service.TeamService;
import com.prography.playeasy.util.PlayeasyServiceFactory;
import com.prography.playeasy.util.UIHelper;
import static com.prography.playeasy.login.activity.LoginActivity.myTeamId;
public class MyTeamManger extends AppCompatActivity {

    private EditText name;
    private EditText leader;
    private EditText age;
    private EditText phone;
    private EditText description;

    private String spinnerValue = "";


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mypage_myteammanger);

        UIHelper.toolBarInitialize(this, findViewById(R.id.myTeamMangerToolBar));
        UIHelper.hideWindow(this);

        initialized();

        Spinner level = findViewById(R.id.myPageMyTeamMangerAbilitySpinner);
        level.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                if(position == 1){
                    spinnerValue = "HIGH";
                }else if(position == 2){
                    spinnerValue = "MEDIUM";
                }else if(position == 3){
                    spinnerValue = "LOW";
                }else{
                    spinnerValue = "NULL";
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private void initialized() {


        name = findViewById(R.id.myPageMyTeamMangerName);
        leader = findViewById(R.id.myPageMyTeamMangerCapTinName);
        age = findViewById(R.id.myPageMyTeamMangerCapTinAge);
        phone = findViewById(R.id.myPageMyTeamMangerCapTinPhone);
        description = findViewById(R.id.myPageMyTeamMangerTeamInformation);


        findViewById(R.id.myPageMyteamMangerPlayerShowButton).setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MyTeamMemberManger.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.modify_cofirm, menu);

        return true;
    }



    @Override
    public boolean onOptionsItemSelected (MenuItem item)
    {
        switch(item.getItemId())
        {
            case R.id.modifyConfirm:
                AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.MyAlertDialogStyle);
                builder.setTitle("나의 팀관리 정보를 수정하시겠습니까?");

                builder.setPositiveButton("OK", new DialogInterface.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface dialog, int id)
                    {
                        TeamService service = PlayeasyServiceFactory.getInstance(TeamService.class);
                        service.modifyTeam(myTeamId, putInputTeam(), new ResponseCallback() {
                            @Override
                            public void onFailure(ErrorResult errorResult) {

                            }

                            @Override
                            public void onSuccess(Object result) {

                                //유저 아이디 하나당 팀 하나인가?
                               /* System.out.println("안들어오나?" + result);
                                name.setText(((Team) result).name());
                                leader.setText(((Team) result).leader());
                                age.setText(((Team) result).age());
                                spinnerValue.charAt(Integer.parseInt(((Team) result).level()));
                                phone.setText(((Team) result).phone());
                                description.setText(((Team) result).description());*/

                            }
                        },getApplicationContext());
                        Toast.makeText(getApplicationContext(), "OK Click", Toast.LENGTH_SHORT).show();
                    }
                });

                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface dialog, int id)
                    {
                        Toast.makeText(getApplicationContext(), "Cancel Click", Toast.LENGTH_SHORT).show();
                    }
                });

                AlertDialog alertDialog = builder.create();
                alertDialog.show();



                //Intent intent = new Intent(this, MyTeamManger.class);
                //intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                //startActivity(intent);
                return true;

        }
        return super.onOptionsItemSelected(item);
    }

    private Team putInputTeam(){

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
