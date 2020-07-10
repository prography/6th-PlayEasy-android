package com.prography.playeasy.match.activity;

import android.os.Bundle;
import android.telephony.PhoneNumberFormattingTextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.prography.playeasy.R;

import com.prography.playeasy.util.UIHelper;

public class TeamInformationActivity extends AppCompatActivity {


    ImageButton myProfileImage;
    //id
    TextView textViewEmail;
    EditText editTextEmail;
    //이름
    TextView textViewName;
    EditText editTextName;
    //소속
//    TextView textViewTeam;
//    EditText editTextTeam;
    //나이
    TextView textViewAge;
    EditText editTextAge;
    //phonenum verification
    TextView textViewPhoneNum;
    EditText editTextPhoneNum;

    Spinner teamLevelSpinner;
    TextView textViewLevel;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teaminfo);


        UIHelper.toolBarInitialize(this, findViewById(R.id.teaminfoToolBar));


//질문 1
//        myProfileImage=(ImageButton)findViewById(R.id.imageButton);
//        myProfileImage.setImageResource(R.drawable.shinja);

//getSupportActionBar의 반환형 ActionBar

//review
        Glide.with(this)
                .load(R.drawable.shinja)
                .placeholder(R.drawable.shinja)
                .centerCrop()
                .into(myProfileImage);
        myProfileImage=(ImageButton)findViewById(R.id.ib_my_profile);
//이메
        textViewEmail = (TextView) findViewById(R.id.team_TextViewEmail);

        editTextEmail= (EditText) findViewById(R.id.team_editTextEmail);
//이
        textViewName=(TextView)findViewById(R.id.team_TextViewName);
        editTextName=(EditText) findViewById(R.id.team_editTextName);
//나이
        textViewAge = (TextView) findViewById(R.id.team_TextViewAge);


        editTextAge = (EditText) findViewById(R.id.team_EditTextAge);

//소속
//        textViewTeam = (TextView) findViewById(R.id.TextViewTeam);
//        editTextTeam = (EditText) findViewById(R.id.EditTextTeam);


//실력
        textViewLevel=(TextView)findViewById(R.id.team_textViewLevel);
    teamLevelSpinner=(Spinner)findViewById(R.id.spinner_teamLevel);

//휴대폰 인증
        textViewPhoneNum= (TextView) findViewById(R.id.team_textViewPhoneNum);
        editTextPhoneNum=(EditText)findViewById(R.id.team_editTextPhoneNum);

//         editTextPhoneNum2 = (EditText) findViewById(R.id.editTextPhoneNum2);
//
//         editTextPhoneNum3 = (EditText) findViewById(R.id.editTextPhoneNum3);

        editTextPhoneNum.addTextChangedListener(new PhoneNumberFormattingTextWatcher());
        teamLevelSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

}
