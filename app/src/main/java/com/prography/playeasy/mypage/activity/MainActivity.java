package com.prography.playeasy.mypage.activity;

import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.prography.playeasy.R;

public class MainActivity extends AppCompatActivity {
    TextView profileName;

    ImageButton imageView;

    GradientDrawable drawable=(GradientDrawable) this.getDrawable(R.drawable.background_rounding);
    TextView myInformation;
    TextView alarmSetting;
    TextView matchInformation;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mypage_main);

        profileName=(TextView)findViewById(R.id.profileName);
        imageView=(ImageButton)findViewById(R.id.account_setting);
       myInformation=(TextView)findViewById(R.id.materialButton1);
        alarmSetting=(TextView)findViewById(R.id.materialButton2);
        matchInformation=(TextView)findViewById(R.id.materialButton3);
        imageView.setBackground(drawable);
        imageView.setClipToOutline(true);


    }
}
