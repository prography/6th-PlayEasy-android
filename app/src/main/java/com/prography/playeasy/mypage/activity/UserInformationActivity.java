package com.prography.playeasy.mypage.activity;

import android.content.Intent;
import android.os.Bundle;
import android.telephony.PhoneNumberFormattingTextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.prography.playeasy.R;
import com.prography.playeasy.util.UIHelper;

public class UserInformationActivity extends AppCompatActivity {

    ImageButton myProfileImage;
    //id
    TextView textViewEmail;
    EditText editTextEmail;
    //이름
    TextView textViewName;
    EditText editTextName;
    //소속
    TextView textViewTeam;
    EditText editTextTeam;
    //나이
    TextView textViewAge;
    EditText editTextAge;
    //실력
    TextView textViewLevel;
    Spinner levelSpinner;
    //phonenum verification
    TextView textViewPhoneNum;
    EditText editTextPhoneNum;

    Button editButton;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mypage_myinfo);


        UIHelper.toolBarInitialize(this, findViewById(R.id.mypagemyinfoToolBar));


//질문 1
//        myProfileImage=(ImageButton)findViewById(R.id.imageButton);
//        myProfileImage.setImageResource(R.drawable.shinja);

//getSupportActionBar의 반환형 ActionBar

////review todo
//        Glide.with(UserInformationActivity.this)
//                .load(R.drawable.shinja)
//                .placeholder(R.drawable.shinja)
//                .centerCrop()
//                .into(myProfileImage);
        myProfileImage=(ImageButton)findViewById(R.id.ib_my_profile);
//이메
        textViewEmail = (TextView) findViewById(R.id.TextViewEmail);

        editTextEmail= (EditText) findViewById(R.id.editTextEmail);
//이
        textViewName=(TextView)findViewById(R.id.TextViewName);
        editTextName=(EditText) findViewById(R.id.editTextName);
//나이
        textViewAge = (TextView) findViewById(R.id.TextViewAge);


        editTextAge = (EditText) findViewById(R.id.EditTextAge);

//소속
        textViewTeam = (TextView) findViewById(R.id.TextViewTeam);
        editTextTeam = (EditText) findViewById(R.id.EditTextTeam);


//실력
        levelSpinner=(Spinner)findViewById(R.id.spinnerLevel);
        textViewLevel = (TextView)findViewById(R.id.textViewLevel);


//휴대폰 인증
        textViewPhoneNum= (TextView) findViewById(R.id.textViewPhoneNum);
        editTextPhoneNum=(EditText)findViewById(R.id.editTextPhoneNum);

//         editTextPhoneNum2 = (EditText) findViewById(R.id.editTextPhoneNum2);
//
//         editTextPhoneNum3 = (EditText) findViewById(R.id.editTextPhoneNum3);

        editTextPhoneNum.addTextChangedListener(new PhoneNumberFormattingTextWatcher());
        ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource(this,R.array.실력,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        levelSpinner.setAdapter(adapter);
        levelSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //이 오버라이드 메소드에서 getItemAtPosition( position)으로 해당 값 받아온다
                parent.getItemAtPosition(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Toast.makeText(getApplicationContext(),"실력을 선택해주세요", Toast.LENGTH_SHORT);
            }
        });
    }
    public boolean onOptionsItemSelected(android.view.MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                // NavUtils.navigateUpFromSameTask(this);
                Intent userInfoBack = new Intent(this, Mypage.class);
                startActivity(userInfoBack);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
