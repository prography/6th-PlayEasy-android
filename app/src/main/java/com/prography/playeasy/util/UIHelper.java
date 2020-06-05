package com.prography.playeasy.util.uiHelper;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.prography.playeasy.R;
import com.prography.playeasy.match.activity.MatchCreateActivity;
import com.prography.playeasy.match.activity.MatchListActivity;
import com.prography.playeasy.mypage.activity.UserInformationActivity;

public class UIHelper {
    public static void toolBarInitialize(AppCompatActivity activity, View view) {
        Toolbar toolBar = (Toolbar) view;
        activity.setSupportActionBar(toolBar);
        ActionBar actionBar = activity.getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true); // 뒤로가기 버튼, 디폴트로 true만 해도 백버튼이 생김
        actionBar.setDisplayShowTitleEnabled(false); // 제목 없애기
    }

    public static void bottomNavigationInitialize(AppCompatActivity activity, View view) {
        BottomNavigationView bottomNavigationView = (BottomNavigationView) view;
        Context context = activity.getApplicationContext();

        bottomNavigationView.setOnNavigationItemSelectedListener((item) -> {
            Class clazz = null;

            switch (item.getItemId()) {
                case R.id.match:
                    clazz = MatchListActivity.class;
                    break;
                case R.id.register:
                    clazz = MatchCreateActivity.class;
                    break;
                case R.id.hired:
                    break;
                case R.id.myPage:
                    clazz = UserInformationActivity.class;
                    break;
            }

            // 버튼 눌러서 이동할 곳 미구현 되었을 경우 방어 코드
            if (clazz == null) {
                Toast toast = Toast.makeText(context, "Not implementation", Toast.LENGTH_SHORT);
                toast.show();
                return false;
            }

            Intent intent = new Intent(context, clazz);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            activity.startActivity(intent);

            return true;
        });
    }
}
