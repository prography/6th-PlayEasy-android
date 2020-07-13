package com.prography.playeasy.match.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.prography.playeasy.R;
import com.prography.playeasy.mypage.activity.MyMatchInformation;
import com.prography.playeasy.util.UIHelper;

public class MatchModify extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_match_modify);

        UIHelper.toolBarInitialize(this, findViewById(R.id.matchModifyToolBar));
        UIHelper.hideWindow(this);
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
                Intent intent = new Intent(this, MyMatchInformation.class);
                startActivity(intent);


                return true;

        }
        return super.onOptionsItemSelected(item);
    }

}
