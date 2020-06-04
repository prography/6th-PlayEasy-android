package com.prography.playeasy.mypage;

import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.prography.playeasy.R;

public class MyPageMainActivity extends AppCompatActivity {
    TextView profileName;

    ImageView imageView;

    GradientDrawable drawable=(GradientDrawable) this.getDrawable(R.drawable.background_rounding);

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mypage_main);

        profileName=(TextView)findViewById(R.id.profileName);
        imageView=(ImageView)findViewById(R.id.account_setting);
        imageView.setBackground(drawable);
        imageView.setClipToOutline(true);


    }
}
