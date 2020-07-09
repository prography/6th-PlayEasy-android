package com.prography.playeasy.match.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.google.android.material.button.MaterialButton;
import com.prography.playeasy.R;
import com.prography.playeasy.match.domain.MatchDetail.Match;
import com.prography.playeasy.match.service.MatchService;
import com.prography.playeasy.match.util.MatchResponseCallback;
import com.prography.playeasy.util.PlayeasyServiceFactory;
import com.prography.playeasy.util.UIHelper;

import net.daum.mf.map.api.MapView;

public class MatchDetail extends AppCompatActivity {

    private MaterialButton materialButton;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_match_detail);

        UIHelper.toolBarInitialize(this, findViewById(R.id.matchDetailToolBar));
        UIHelper.hideWindow(this);

        MapView mapView = new MapView(this);
        ViewGroup mapViewContainer = findViewById(R.id.matchDetailMap);
        mapViewContainer.addView(mapView);

        initialized();

    }

    private void initialized() {
        materialButton = findViewById(R.id.detailMatchApplyButton);

    }
}
