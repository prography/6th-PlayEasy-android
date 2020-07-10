package com.prography.playeasy.mypage.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.prography.playeasy.R;
import com.prography.playeasy.main.activity.Main;
import com.prography.playeasy.team.activity.TeamSelect;
import com.prography.playeasy.util.UIHelper;


public class MyInformation extends AppCompatActivity {

    private TextView myPageMyTeam;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mypage_myinfo);

        UIHelper.toolBarInitialize(this, findViewById(R.id.myPageMyInfoToolBar));
        UIHelper.hideWindow(this);

        initailzed();

        myPageMyTeam.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), TeamSelect.class);
                startActivity(intent);
            }
        });
    }

    private void initailzed() {
         myPageMyTeam = findViewById(R.id.myPageMyTeam);

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
                Intent intent = new Intent(this, MyInformation.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                return true;

        }
        return super.onOptionsItemSelected(item);
    }

}
