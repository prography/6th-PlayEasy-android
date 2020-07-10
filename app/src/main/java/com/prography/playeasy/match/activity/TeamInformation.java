package com.prography.playeasy.match.activity;

import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.os.Bundle;
import android.telephony.PhoneNumberFormattingTextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.google.android.material.imageview.ShapeableImageView;
import com.prography.playeasy.R;

import com.prography.playeasy.util.UIHelper;

public class TeamInformation extends AppCompatActivity {

    private ImageView TeamProfile;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teaminfo);


        UIHelper.toolBarInitialize(this, findViewById(R.id.teamInfoToolBar));
        UIHelper.hideWindow(this);

        initialized();


    }

    private void initialized() {

    }

}
