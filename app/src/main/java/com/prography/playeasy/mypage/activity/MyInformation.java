package com.prography.playeasy.mypage.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.kakao.network.ErrorResult;
import com.kakao.network.callback.ResponseCallback;
import com.prography.playeasy.R;
import com.prography.playeasy.mypage.domain.User;
import com.prography.playeasy.mypage.service.UserService;
import com.prography.playeasy.team.activity.TeamSelect;
import com.prography.playeasy.util.PlayeasyServiceFactory;
import com.prography.playeasy.util.UIHelper;


public class MyInformation extends AppCompatActivity {

    private TextView myPageMyTeam;
    private TextView myPageEmail;
    private EditText myPageMyName;
    private EditText myPageMyAge;
    private EditText myPageMyPhone;
    private EditText myPageMyInformation;
    private Spinner myMyPageAbilitySpinner;
    private String myMyPageAbilitySpinnerValue;
    private  int position;


    public static int myId;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mypage_myinfo);

        UIHelper.toolBarInitialize(this, findViewById(R.id.myPageMyInfoToolBar));
        UIHelper.hideWindow(this);

        initialized();

        myPageMyTeam.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), TeamSelect.class);
                startActivity(intent);
            }
        });

        myMyPageAbilitySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                if(position == 1){
                    myMyPageAbilitySpinnerValue = "HIGH";
                }else if(position == 2){
                    myMyPageAbilitySpinnerValue = "MEDIUM";
                }else if(position == 3){
                    myMyPageAbilitySpinnerValue = "LOW";
                }else{
                    myMyPageAbilitySpinnerValue = "NULL";
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private void initialized() {

        myPageEmail = findViewById(R.id.myPageEmail);
        myPageMyName = findViewById(R.id.myPageMyName);
        myPageMyAge = findViewById(R.id.myPageMyAge);
        myPageMyTeam = findViewById(R.id.myPageMyTeam);
        myMyPageAbilitySpinner = findViewById(R.id.myMyPageAbilitySpinner);
        myPageMyPhone = findViewById(R.id.myPageMyPhone);
        myPageMyInformation = findViewById(R.id.myPageMyInformation);

        UserService service = PlayeasyServiceFactory.getInstance(UserService.class);
        service.retrieveUser(getCallback(), getApplicationContext());

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.modify_cofirm, menu);

        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.modifyConfirm:

                if(!getChecked()){
                    Toast.makeText(getApplicationContext(),"전부 입력해 주세요",Toast.LENGTH_LONG).show();
                }else{
                    UserService userService = PlayeasyServiceFactory.getInstance(UserService.class);
                    userService.modifyUser(putUpdateUser(), getCallback(), getApplicationContext());
                }
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public boolean getChecked(){
        if( myPageMyName.getText().toString() == null || myPageMyAge.getText().toString() == null||
            myPageMyPhone.getText().toString() == null || myMyPageAbilitySpinnerValue == null ||  myPageMyInformation.getText().toString() == null ){
            return false;
        }
        return true;
    }


    private User putUpdateUser() {
        return User.builder()
                .name(myPageMyName.getText().toString())
                .age(Integer.valueOf(myPageMyAge.getText().toString()))
                .phone(myPageMyPhone.getText().toString())
                .level(myMyPageAbilitySpinnerValue)
                .description(myPageMyInformation.getText().toString())
                .build();
    }

    private ResponseCallback getCallback() {
        return new ResponseCallback() {
            @Override
            public void onFailure(ErrorResult errorResult) {

            }

            @Override
            public void onSuccess(Object result) {
                User myInfo = (User) result;
                System.out.println("---> " + myInfo);
                myPageEmail.setText(myInfo.email());
                myPageMyName.setText(myInfo.name());
                myPageMyAge.setText(String.valueOf(myInfo.age()));

                if(myInfo.level() != null){
                    switch (myInfo.level()) {
                        case "HIGH":
                            position = 1;
                            break;
                        case "MEDIUM":
                            position = 2;
                            break;
                        case "LOW":
                            position = 3;
                            break;
                        default:
                            position = 0;
                            break;
                    }
                }
                System.out.println("LEVEL: " + position);

                myMyPageAbilitySpinner.setSelection(position, true);

                if(myInfo.teamId() != null){
                    myPageMyTeam.setText(myInfo.team().name());
                }else{
                    myPageMyTeam.setText(getResources().getString(R.string.activity_mypage_noTeam));
                }

                myPageMyPhone.setText(myInfo.phone());
                myPageMyInformation.setText(myInfo.description());

            }
        };
    }

}
