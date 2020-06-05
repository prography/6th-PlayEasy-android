package com.prography.playeasy.mypage.activity;

import android.os.Bundle;
import android.widget.TabHost;

import androidx.appcompat.app.AppCompatActivity;

import com.prography.playeasy.R;

public class MyMatchActivity extends AppCompatActivity {

    private TabHost tabHost1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mypage_mymatch);


        tabInitalized();

        // 첫 번째 Tab. (탭 표시 텍스트:"TAB 1"), (페이지 뷰:"content1")
        TabHost.TabSpec ts1 = tabHost1.newTabSpec("Tab Spec 1") ;
        ts1.setContent(R.id.content1) ;
        ts1.setIndicator("내가 등록한 매치") ;
        tabHost1.addTab(ts1)  ;

        // 두 번째 Tab. (탭 표시 텍스트:"TAB 2"), (페이지 뷰:"content2")
        TabHost.TabSpec ts2 = tabHost1.newTabSpec("Tab Spec 2") ;
        ts2.setContent(R.id.content2) ;
        ts2.setIndicator("나의 용병 신청현황") ;
        tabHost1.addTab(ts2) ;
    }

    private void tabInitalized() {
        tabHost1 = (TabHost) findViewById(R.id.tabHost1) ;
        tabHost1.setup() ;
    }
}
